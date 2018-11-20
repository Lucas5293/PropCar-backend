package br.gov.sp.fatec.web.controller;

import br.gov.sp.fatec.modelo.JsonBusca;
import br.gov.sp.fatec.modelo.PessoaFisica;
import br.gov.sp.fatec.service.PessoaFisicaService;
import br.gov.sp.fatec.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pessoa")
public class PessoaFisicaRestController {

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @RequestMapping(value = "/")
    public String hello() {
        return "Olá";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    @JsonView(View.PessoaComAutomovel.class)
    public ResponseEntity<PessoaFisica>  save(@RequestBody PessoaFisica pessoaFisica){
        try {
            pessoaFisica = this.pessoaFisicaService.salvar(pessoaFisica);
        } catch (Exception e) {
            return new ResponseEntity<PessoaFisica>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<PessoaFisica>(pessoaFisica, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @JsonView(View.PessoaSemId.class)
    public ResponseEntity<Collection<PessoaFisica>> buscarPorId(@PathVariable("id") Long id) {
        Collection<PessoaFisica> pessoaFisicas = this.pessoaFisicaService.buscarPorId(id);
        if (!pessoaFisicas.isEmpty()) {
            return new ResponseEntity<Collection<PessoaFisica>>(pessoaFisicas, HttpStatus.OK);
        }
        return new ResponseEntity<Collection<PessoaFisica>>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/getWithParams/", method = RequestMethod.POST)
    @JsonView(View.PessoaComId.class)
    public ResponseEntity<Collection<PessoaFisica>> buscarComParametros(@RequestBody JsonBusca jsonBusca) {
        Collection<PessoaFisica> pessoaFisicas = this.pessoaFisicaService.buscarComJsonBusca(jsonBusca);
        if (!pessoaFisicas.isEmpty()) {
            return new ResponseEntity<Collection<PessoaFisica>>(pessoaFisicas, HttpStatus.OK);
        }
        return new ResponseEntity<Collection<PessoaFisica>>(HttpStatus.NOT_FOUND);
    }
}
