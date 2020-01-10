package br.ibm.sce.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


//Tabela criada para o registro de usuarios de login

@Entity
@Table(name="TB_USUARIO")
public class Usuario implements UserDetails, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String login;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String senha;
	
	@ManyToMany
	@JoinTable(
		name="usuarios_roles",
		joinColumns = @JoinColumn(
		 name="idusuario", referencedColumnName = "login"),
		inverseJoinColumns = @JoinColumn(
		 name="idrole", referencedColumnName = "nRole"))
		
	private List<Role> tb_roles;			
		
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<Role> getTb_roles() {
		return tb_roles;
	}

	public void setTb_roles(List<Role> tb_roles) {
		this.tb_roles = tb_roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return (Collection<? extends GrantedAuthority>) this.tb_roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
