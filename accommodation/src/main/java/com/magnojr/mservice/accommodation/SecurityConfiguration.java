package com.magnojr.mservice.accommodation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final String REALM = "MAGNUM";

	@Autowired
	private MyBasicAuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {

		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("user1").password(encoder.encode("123")).roles("USER");
		auth.inMemoryAuthentication().withUser("system").password(encoder.encode("123")).roles("SYSTEM");
		auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("123456")).roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().anyRequest().fullyAuthenticated().antMatchers("/actuator/**").hasRole("ADMIN").antMatchers(HttpMethod.POST).hasAnyRole("ADMIN", "SYSTEM")
		.and().httpBasic().realmName(REALM)
				.authenticationEntryPoint(authenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}

	/* To allow Pre-flight [OPTIONS] request from browser */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}

}
