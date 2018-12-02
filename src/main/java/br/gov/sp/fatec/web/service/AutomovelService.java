package br.gov.sp.fatec.web.service;

import br.gov.sp.fatec.modelo.Automovel;
import br.gov.sp.fatec.modelo.AutomovelJson;
import br.gov.sp.fatec.modelo.PessoaFisica;

import javax.annotation.Nullable;
import java.util.List;

public interface AutomovelService {

    List<AutomovelJson> buscar(@Nullable PessoaFisica pessoaFisica, Boolean disponiveis);

    AutomovelJson salvar(Automovel automovel);

    Automovel salvar(AutomovelJson automovel);
}
