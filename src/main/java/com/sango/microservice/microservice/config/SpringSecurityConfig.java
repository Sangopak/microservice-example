package com.sango.microservice.microservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder passwordEncoder = new PasswordEncoder() {
			
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
			}
			
			@Override
			public String encode(CharSequence rawPassword) {
				return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(4));
			}
		};
	
		return passwordEncoder;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http
			.httpBasic()
			.and()
			.authorizeRequests()
				.antMatchers("/users/**").hasAnyRole("USER")
				.antMatchers("/**").hasAnyRole("ADMIN")
			.and()
			.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {		
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
				.withUser("user").password("$2a$04$7InhLUCC7G36qwKQusRig.Bu3VD94bMM9oByLdrRRf8mnNyQvjN1e").roles("USER")
				.and().withUser("admin").password("$2a$04$7InhLUCC7G36qwKQusRig.Bu3VD94bMM9oByLdrRRf8mnNyQvjN1e").roles("USER", "ADMIN");
	}
	
	public static void main(String args[]) {
		System.out.println(BCrypt.hashpw("enter the password", BCrypt.gensalt(4)));
	}
}
