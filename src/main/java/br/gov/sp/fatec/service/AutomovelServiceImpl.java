package br.gov.sp.fatec.service;

import br.gov.sp.fatec.modelo.Automovel;
import br.gov.sp.fatec.modelo.AutomovelJson;
import br.gov.sp.fatec.modelo.PessoaFisica;
import br.gov.sp.fatec.repository.AutomovelRepository;
import br.gov.sp.fatec.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class AutomovelServiceImpl implements AutomovelService {

    @Autowired
    private AutomovelRepository repository;
    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Override
    public List<AutomovelJson> buscar(@Nullable PessoaFisica pessoaFisica, Boolean disponiveis) {
        if (disponiveis != null) {
            return this.converter(this.repository.findByPessoaFisica(null));
        }
        if (pessoaFisica != null) {
            return this.converter(this.repository.findByPessoaFisica(pessoaFisica));
        }
        return this.converter((List<Automovel>) this.repository.findAll());
    }

    @Override
    public AutomovelJson salvar(Automovel automovel) {
        return this.converter(this.repository.save(automovel));
    }

    private List<AutomovelJson> converter(List<Automovel> automoveis) {
        List<AutomovelJson> jsonList = new ArrayList<>();
        for (Automovel at : automoveis) {
            jsonList.add(this.converter(at));
        }
        return jsonList;
    }

    private AutomovelJson converter(Automovel automovel) {
        AutomovelJson automovelJson = new AutomovelJson();
        automovelJson.setId(automovel.getId());
        automovelJson.setCor(automovel.getCor());
        automovelJson.setModelo(automovel.getModelo());
        automovelJson.setRenavam(automovel.getRenavam());
        automovelJson.setPessoaFisica(automovel.getPessoaFisica() != null ? automovel.getPessoaFisica().getId() : null);
        return automovelJson;
    }

    @Override
    public Automovel salvar(AutomovelJson json) {
        Automovel automovel = new Automovel();
        automovel.setId(json.getId());
        automovel.setCor(json.getCor());
        automovel.setModelo(json.getModelo());
        automovel.setRenavam(json.getRenavam());
        if (json.getPessoaFisica() != null) {
            automovel.setPessoaFisica(this.pessoaFisicaRepository.findById(json.getPessoaFisica()).get());
        }
        return this.repository.save(automovel);
    }
}
