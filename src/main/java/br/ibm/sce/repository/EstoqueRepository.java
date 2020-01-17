package br.ibm.sce.repository;

import org.springframework.data.repository.CrudRepository;

import br.ibm.sce.model.Estoque;

public interface EstoqueRepository extends CrudRepository<Estoque, Long> {
	Estoque findById(long id);
	Estoque findBySerie(String serie);
}
