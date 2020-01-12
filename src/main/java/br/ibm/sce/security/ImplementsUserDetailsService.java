package br.ibm.sce.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

import br.ibm.sce.model.Usuario;
import br.ibm.sce.repository.UsuarioRepository;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository ur;
	
	//Configuraçao para o uso do spring security no frontend
	@Configuration
	public class LeafConfig {

	    @Bean
	    public SpringSecurityDialect springSecurityDialect(){
	        return new SpringSecurityDialect();
	    }
	}
	
	//ControllerAdvice para utilizar o thymeleaf com o th:value - frontend
	@ControllerAdvice
	public class CurrentUserControllerAdvice {
	    @ModelAttribute("currentUser")
	    public UserDetails getCurrentUser(Authentication authentication) {
	        return (authentication == null) ? null : (UserDetails) authentication.getPrincipal();
	    }
	}
	
	//Busca do login para o acesso
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = ur.findByLogin(login);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario nao encontrado!");
		}
		
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
	}
	
}