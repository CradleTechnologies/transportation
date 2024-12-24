package com.cradletechnologies.transportation.api;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cradletechnologies.transportation.dto.RolesDTO;
import com.cradletechnologies.transportation.dto.UserDTO;
import com.cradletechnologies.transportation.model.Roles;
import com.cradletechnologies.transportation.model.Users;
import com.cradletechnologies.transportation.service.RolesService;
import com.cradletechnologies.transportation.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersApi {
	
    @Autowired
    private UserService usersService;

    @Autowired
	private RolesService rolesService;

    @GetMapping("/list")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<?> getUsers() {
        List<Users> users = usersService.getAllUsers();
        List<UserDTO> userDTOs = new ArrayList<>();

        System.out.println("Hi Sanky Back at it again!");
        for (Users user : users) {
            userDTOs.add(new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail(), user.getStatus(), user.getRoles()));
        }
        return ResponseEntity.ok(userDTOs);
    }
   
    @GetMapping("/roles")
//  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ResponseEntity<?> getRoles() {
	    List<Roles> roles = rolesService.getAllRoles();
	    List<RolesDTO> roleDTO = new ArrayList<>();
	
	    System.out.println("Hi Sanky Roles are the following!");
	    for (Roles role : roles) {
	        roleDTO.add(new RolesDTO(role.getId(), role.getName(), role.getDescription()));
	    }
	    return ResponseEntity.ok(roleDTO);
	  }
  


	@GetMapping("/token/refresh")
	public void refreshToken(HttpServletRequest request, HttpServletResponse response){
		
		String authorizationHeader = request.getHeader(AUTHORIZATION);
		
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			try {
				String refresh_token = authorizationHeader.substring("Bearer ".length());				
				Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
				JWTVerifier verifier = JWT.require(algorithm).build();
				DecodedJWT decodedJWT = verifier.verify(refresh_token);				
				String username = decodedJWT.getSubject();
				Users appUser = usersService.getUser(username);
				
				String access_token = JWT.create()
						.withSubject(appUser.getUsername())
						.withExpiresAt(new Date(System.currentTimeMillis()+10*60*1000))
						.withIssuer(request.getRequestURL().toString())
						.withClaim("roles", appUser.getRoles().stream().map(Roles::getName).collect(Collectors.toList()))
						.sign(algorithm);
				Map<String, String> tokens = new HashMap<>();
				tokens.put("access_token", access_token);
				tokens.put("refresh_token", refresh_token);
				
				response.setContentType("application/json");
				new ObjectMapper().writeValue(response.getOutputStream(), tokens);
			}
		
			catch (Exception exception) {
				
						response.setHeader("Error", exception.getMessage());
						response.setStatus(FORBIDDEN.value());
						//response.sendError(FORBIDDEN.value());
						
						Map<String, String> error = new HashMap<>();
						error.put("error_message", exception.getMessage());
						response.setContentType("application/json");
						try {
							new ObjectMapper().writeValue(response.getOutputStream(), error);
						}
						catch (IOException e) {							
							e.printStackTrace();
						}
			}
				
				}
		
		else {
				throw new RuntimeException("Refresh token is missing!!!");
			}
		}
		
}
