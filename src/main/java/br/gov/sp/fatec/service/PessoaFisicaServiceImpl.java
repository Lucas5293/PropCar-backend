package br.gov.sp.fatec.service;

import br.gov.sp.fatec.modelo.JsonBusca;
import br.gov.sp.fatec.modelo.PessoaFisica;
import br.gov.sp.fatec.repository.AutomovelRepository;
import br.gov.sp.fatec.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

import static com.google.common.collect.Lists.newArrayList;

@Component
public class PessoaFisicaServiceImpl implements PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;
    @Autowired
    private AutomovelRepository automovelRepository;

    @Override
    public PessoaFisica salvar(PessoaFisica pessoaFisica) {
        this.automovelRepository.saveAll(pessoaFisica.getAutomoveis());
        return this.pessoaFisicaRepository.save(pessoaFisica);
    }

    @Override
    public Collection<PessoaFisica> buscarPorId(Long id) {
        Optional<PessoaFisica> result = this.pessoaFisicaRepository.findById(id);
         if (result.isPresent()) {
            return newArrayList(result.get());
        }
        return newArrayList();
    }

    @Override
    public Collection<PessoaFisica> buscarComJsonBusca(JsonBusca jsonBusca) {
        String nome = (jsonBusca != null && jsonBusca.getNome() != null) ? jsonBusca.getNome() : "";
        String cpf = (jsonBusca != null && jsonBusca.getCpf() != null) ? jsonBusca.getCpf() : "";
        return this.pessoaFisicaRepository.buscarPorNomeOuCPF(nome, cpf);
    }
}
