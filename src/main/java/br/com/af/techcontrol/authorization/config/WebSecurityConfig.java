package br.com.af.techcontrol.authorization.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import br.com.af.techcontrol.authorization.service.UserDetailsAppService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsAppService userDetailsAppService;

	@Value("${security.encoding-strength}")
	private Integer encodingStrength;

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsAppService).passwordEncoder(new ShaPasswordEncoder(encodingStrength));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().httpBasic()
		.and().csrf().disable();
	}

}
