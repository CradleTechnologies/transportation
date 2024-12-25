package com.cradletechnologies.transportation.api;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cradletechnologies.transportation.dto.LoginDto;
import com.cradletechnologies.transportation.dto.UserDTO;
import com.cradletechnologies.transportation.model.AuditIdentifier;
import com.cradletechnologies.transportation.model.Roles;
import com.cradletechnologies.transportation.model.Users;
import com.cradletechnologies.transportation.repository.RolesRepository;
import com.cradletechnologies.transportation.repository.UserRepository;
import com.cradletechnologies.transportation.security.MyUserDetailsService;
import com.cradletechnologies.transportation.service.AuditEventsService;
import com.cradletechnologies.transportation.service.AuditIdentifierService;
import com.cradletechnologies.transportation.service.AuditTypesService;
import com.cradletechnologies.transportation.service.RequestService;
import com.cradletechnologies.transportation.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthApi {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuditIdentifierService auditIdentifierService;

    @Autowired
    private AuditEventsService auditEventsService;

    @Autowired
    private RequestService requestService;

    @Autowired
    private AuditTypesService auditTypesService;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;
    
    private MyUserDetailsService userDetailsService;
	
	public AuthApi(MyUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }
      
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody @Valid UserDTO userDTO, BindingResult bindingResult) {
        // Validate input first
        if (bindingResult.hasErrors()) {
            return ResponseEntity
                .badRequest()
                .body(bindingResult.getFieldErrors()
                    .stream()
                    .collect(Collectors.toMap(
                        FieldError::getField, 
                        FieldError::getDefaultMessage
                    ))
                );
        }

        // Check if Username or Email already exists
        if (userService.getUser(userDTO.getUsername()) != null) {
            return ResponseEntity
                .badRequest()
                .body(Map.of("error", "Username already exists"));
        }

        if (userService.getUserByEmail(userDTO.getEmail()) != null) {
            return ResponseEntity
                .badRequest()
                .body(Map.of("error", "Email already in use"));
        }

        // Validate role
        Roles role = roleRepository.findByName("USER");
        if (role == null) {
            return ResponseEntity
                .badRequest()
                .body(Map.of("error", "Default user role not found"));
        }

        // Create audit identifier
        AuditIdentifier auditIdentifier = new AuditIdentifier();
        auditIdentifierService.saveAuditIdentifier(auditIdentifier);

        // Create user object
        Users user = new Users();
        
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setStatus(userDTO.getStatus());
        user.setRemarks(userDTO.getRemarks());
        user.setRoles(Collections.singleton(role));
        user.setAuditIdentifier(auditIdentifier);            

        // Save user
        try {
            Users savedUser = userService.saveUser(user);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("error", "Registration failed: " + e.getMessage()));
        }
    }
    
    @PostMapping("/token/refresh")
    public ResponseEntity<?> refreshToken(HttpServletRequest request) {
        // Extract the refresh token from the request header
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                // Extract the refresh token
                String refreshToken = authorizationHeader.substring("Bearer ".length());
                
                // Verify the refresh token
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refreshToken);
                
                // Extract username from the refresh token
                String username = decodedJWT.getSubject();
                
                // Fetch user details
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                
                // Generate new access token
                String accessToken = JWT.create()
                    .withSubject(userDetails.getUsername())
                    .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000)) // 10 minutes
                    .withIssuer(request.getRequestURL().toString())
                    .withClaim("roles", userDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                    .sign(algorithm);
                
                // Prepare response
                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", accessToken);
                tokens.put("refresh_token", refreshToken);
                
                return ResponseEntity.ok(tokens);
            } catch (Exception e) {
                // Handle token verification errors
                Map<String, String> error = new HashMap<>();
                error.put("error_message", "Invalid refresh token");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
            }
        }
        
        return ResponseEntity.badRequest().build();
    }
}
