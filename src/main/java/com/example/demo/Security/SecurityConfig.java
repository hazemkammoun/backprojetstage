package com.example.demo.Security;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.nimbusds.jose.jwk.source.ImmutableSecret;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	@Bean
	
public InMemoryUserDetailsManager inMemoryUserDetailsManager () {
PasswordEncoder passwordEncoder=passwordEncoder();
	return new InMemoryUserDetailsManager(
			User.withUsername("Faouzi").password(passwordEncoder.encode("12345")).authorities("USER").build(),
			User.withUsername("Administrateur").password(passwordEncoder.encode("12345")).authorities("USER","ADMIN").build(),
			User.withUsername("Aziz").password(passwordEncoder.encode("123456")).authorities("USER","ADMIN").build(),
			User.withUsername("ahmed").password(passwordEncoder.encode("12345")).authorities("USER").build()
			
			);
	
}
@Bean
public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
}
@Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
	  return httpSecurity
			  .sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			  
			  .csrf(csrf->csrf.disable())
			  .authorizeHttpRequests(ar->ar.requestMatchers("/auth/login/**", "/users/register/**").permitAll())
			  .authorizeHttpRequests(ar->ar.anyRequest().authenticated())
			  //.httpBasic(Customize.withDefaults())
			  .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
			  .build();
  }
@Bean
JwtEncoder jwtEncoder() {
	String secretKey="hdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhgfd";
	return new NimbusJwtEncoder(new ImmutableSecret<>(secretKey.getBytes()));
}
@Bean
JwtDecoder jwtDecoder() {
	String secretKey="hdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhdhgfd";
	SecretKeySpec secretKeySpec=new SecretKeySpec(secretKey.getBytes(), "RSA");
	return NimbusJwtDecoder.withSecretKey(secretKeySpec).macAlgorithm(MacAlgorithm.HS512).build();
}
@Bean
public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
	
	DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
	daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
	daoAuthenticationProvider.setUserDetailsService(userDetailsService);
	return new ProviderManager(daoAuthenticationProvider);
	
}
  
		  
}
