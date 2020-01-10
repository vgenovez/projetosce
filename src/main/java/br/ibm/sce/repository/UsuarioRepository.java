package br.ibm.sce.repository;

import org.springframework.data.repository.CrudRepository;

import br.ibm.sce.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
	
	Usuario findByLogin(String login);
}
