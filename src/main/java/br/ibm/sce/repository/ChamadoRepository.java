package br.ibm.sce.repository;

import org.springframework.data.repository.CrudRepository;

import br.ibm.sce.model.Chamado;
import br.ibm.sce.model.Estoque;

public interface ChamadoRepository extends CrudRepository<Chamado, String> {
	Iterable<Chamado> findByEstoque(Estoque estoques);
}
