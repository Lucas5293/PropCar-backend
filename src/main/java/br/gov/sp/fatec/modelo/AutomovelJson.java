package br.gov.sp.fatec.modelo;

import br.gov.sp.fatec.view.View;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AutomovelJson {

	@JsonView(View.PessoaComAutomovel.class)
	private Long id;
	@JsonView(View.PessoaComAutomovel.class)
	private String modelo;
	@JsonView(View.PessoaComAutomovel.class)
	private String cor;
	@JsonView(View.PessoaComAutomovel.class)
	private String renavam;
	@JsonView(View.PessoaComAutomovel.class)
	private Long pessoaFisica;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public Long getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(Long pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
}
