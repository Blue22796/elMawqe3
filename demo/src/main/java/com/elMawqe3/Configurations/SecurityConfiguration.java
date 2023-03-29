package com.elMawqe3.Configurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.elMawqe3.Services.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.userService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http.cors().and().csrf().disable()
    	.authorizeHttpRequests().requestMatchers("/login").anonymous()
    	.and().authorizeHttpRequests().requestMatchers("/home").permitAll()
    	.and().authorizeHttpRequests().requestMatchers("/").permitAll()
    	.and().authorizeHttpRequests().requestMatchers("/public/**").permitAll()
    	.and().authorizeHttpRequests().requestMatchers("/update").hasRole("ADMIN")
    	.and().authorizeHttpRequests().requestMatchers("/news").hasRole("ADMIN")
    	.anyRequest().authenticated().and()
    	.formLogin().loginPage("/login").defaultSuccessUrl("/home")
    	.permitAll()
    	.and().logout().logoutSuccessUrl("/home").permitAll();
    	
        return http.build();
        }
    }