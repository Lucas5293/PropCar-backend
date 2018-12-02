package br.gov.sp.fatec.repository;

import br.gov.sp.fatec.modelo.Automovel;
import br.gov.sp.fatec.modelo.PessoaFisica;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AutomovelRepository extends CrudRepository<Automovel, Long> {

	public String queryBuscarPorNomeECor =
			"SELECT a from Automovel a WHERE UPPER(a.modelo) like UPPER(?1) "+
			"AND UPPER(a.cor) like UPPER(?2)";

	@Query(queryBuscarPorNomeECor)
	List<Automovel> buscarPorModeloECor(String nome, String cor);

	List<Automovel> findByCor(String cor);

	List<Automovel> findByPessoaFisica(PessoaFisica pessoaFisica);

}
