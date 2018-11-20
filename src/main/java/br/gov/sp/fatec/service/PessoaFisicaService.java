package br.gov.sp.fatec.service;

import br.gov.sp.fatec.modelo.JsonBusca;
import br.gov.sp.fatec.modelo.PessoaFisica;

import java.util.Collection;

public interface PessoaFisicaService {

    PessoaFisica salvar(PessoaFisica pessoaFisica);

    Collection<PessoaFisica> buscarPorId(Long id);

    Collection<PessoaFisica> buscarComJsonBusca(JsonBusca jsonBusca);
}
