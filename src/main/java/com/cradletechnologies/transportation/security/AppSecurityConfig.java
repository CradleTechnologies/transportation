package com.cradletechnologies.transportation.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.cradletechnologies.transportation.exception.CustomAccessDeniedHandler;
import com.cradletechnologies.transportation.filter.CustomAuthenticationFilter;
import com.cradletechnologies.transportation.filter.CustomAuthorizationFilter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig { //extends WebSecurityConfigurerAdapter {


	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private AccessDeniedHandler accessDeniedHandler;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		//provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setPasswordEncoder(passwordEncoder());
		return provider;

	}
	
	
	@Bean
	public AccessDeniedHandler accessDeniedHandler(){
	    return new CustomAccessDeniedHandler();
	}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationManager authManager = authenticationManager(http.getSharedObject(AuthenticationConfiguration.class));
        
        CustomAuthenticationFilter customAuthFilter = new CustomAuthenticationFilter(authManager, userDetailsService);
        customAuthFilter.setFilterProcessesUrl("/api/auth/signin");

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login").permitAll()
                .requestMatchers("/dist/**", "/plugins/**").permitAll()
                .requestMatchers("/*/index", "/*/").hasAnyAuthority("ROLE_USER", "ROLE_CREATOR", "ROLE_EDITOR", "ROLE_ADMIN")
                .requestMatchers("/*/create").hasAnyAuthority("ROLE_ADMIN", "ROLE_CREATOR")
                .requestMatchers("/*/update/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_EDITOR")
                .requestMatchers("/*/delete/**").hasAuthority("ROLE_ADMIN")
                .requestMatchers("/api/*/list").permitAll()
                .requestMatchers("/profile-pictures/**").permitAll()
                .requestMatchers("/reports/**").hasAuthority("ROLE_ADMIN")
                .requestMatchers("/getBillingById/").hasAuthority("ROLE_ADMIN")
                .requestMatchers("/api/*/create").hasAuthority("ROLE_ADMIN")
                .requestMatchers("/dist/**", "/plugins/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error=true")
                .permitAll()
            )
            .logout(logout -> logout
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            )
            .exceptionHandling(ex -> ex
                .accessDeniedPage("/403")
            )
            .addFilter(customAuthFilter)
            .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
            .cors(cors -> {
                CorsConfigurationSource source = request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedOriginPatterns(Arrays.asList("*"));
                    config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                    config.setAllowedHeaders(Arrays.asList("*"));
                    return config;
                };
                cors.configurationSource(source);
            });

        return http.build();
    }

 
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
	
}