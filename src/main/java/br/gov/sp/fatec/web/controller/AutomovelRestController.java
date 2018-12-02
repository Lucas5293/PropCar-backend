package br.gov.sp.fatec.web.controller;

import br.gov.sp.fatec.modelo.Automovel;
import br.gov.sp.fatec.modelo.AutomovelJson;
import br.gov.sp.fatec.modelo.PessoaFisica;
import br.gov.sp.fatec.service.PessoaFisicaService;
import br.gov.sp.fatec.web.service.AutomovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin
public class AutomovelRestController {

    @Autowired
    private AutomovelService automovelService;
    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @RequestMapping(value = "/automoveis", method = RequestMethod.GET)
    public ResponseEntity<Collection<AutomovelJson>> buscar(@RequestParam(value = "pessoaFisica", required = false) Long pessoaFisicaId,
                                                        @RequestParam(value = "disponiveis", required = false) Boolean disponiveis) {
        PessoaFisica pessoaFisica = null;
        if (pessoaFisicaId != null) {
            Collection<PessoaFisica> result = this.pessoaFisicaService.buscarPorId(pessoaFisicaId);
            pessoaFisica = result.isEmpty() ? null : result.iterator().next();
        }
        List<AutomovelJson> busca = this.automovelService.buscar(pessoaFisica, disponiveis);
        return new ResponseEntity<>(busca, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/automovel", method = RequestMethod.POST)
    public ResponseEntity<AutomovelJson> salvar(@RequestBody Automovel automovel) {
        return new ResponseEntity<>(this.automovelService.salvar(automovel), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/automoveis", method = RequestMethod.POST)
    public ResponseEntity<List<Automovel>> salvar(@RequestBody List<AutomovelJson> automoveis) {
        List<Automovel> result = new ArrayList<>();
        for (AutomovelJson at : automoveis) {
            result.add(this.automovelService.salvar(at));
        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
