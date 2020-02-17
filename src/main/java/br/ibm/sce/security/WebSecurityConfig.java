package br.ibm.sce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private ImplementsUserDetailsService userDetailsService;
	
	//Permissoes dos usuarios na pagina
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/index").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.POST, "/add").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.GET, "/edit{id}").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.POST, "/edit{id}").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.GET, "/addasset{id}").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/addasset{id}").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").failureUrl("/login-Error").permitAll()
		.and().logout().logoutSuccessUrl("/login");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/css/**","/fonts/**","/img/**","/js/**");
	}

}