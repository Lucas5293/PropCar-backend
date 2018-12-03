package br.gov.sp.fatec.repository;

import br.gov.sp.fatec.modelo.PessoaFisica;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PessoaFisicaRepository extends CrudRepository<PessoaFisica, Long> {

	String queryBuscarPorNomeOuCpf =
			"SELECT p from PessoaFisica p WHERE UPPER(p.nome) like UPPER(?1) "+
			"OR p.cpf = ?2";

	@Query(queryBuscarPorNomeOuCpf)
	List<PessoaFisica> buscarPorNomeOuCPF(String nome, String cpf);

}
