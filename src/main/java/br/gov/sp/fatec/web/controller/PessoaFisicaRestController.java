package br.gov.sp.fatec.web.controller;

import br.gov.sp.fatec.modelo.JsonBusca;
import br.gov.sp.fatec.modelo.PessoaFisica;
import br.gov.sp.fatec.service.PessoaFisicaService;
import br.gov.sp.fatec.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated() && (hasRole('ADMIN') || hasRole('CADASTRO_PESSOA'))")
public class PessoaFisicaRestController {

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @RequestMapping(value = "/pessoas", method = RequestMethod.POST)
    @JsonView(View.PessoaComAutomovel.class)
    public ResponseEntity<PessoaFisica>  save(@RequestBody PessoaFisica pessoaFisica){
        try {
            pessoaFisica = this.pessoaFisicaService.salvar(pessoaFisica);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(pessoaFisica, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/pessoas", method = RequestMethod.GET)
    @JsonView(View.PessoaComId.class)
    public ResponseEntity<Collection<PessoaFisica>> buscar() {
        Collection<PessoaFisica> pessoaFisicas = this.pessoaFisicaService.buscarComJsonBusca(new JsonBusca());
        return new ResponseEntity<>(pessoaFisicas, HttpStatus.OK);
    }
}
