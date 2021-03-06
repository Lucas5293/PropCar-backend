package br.gov.sp.fatec.modelo;

import br.gov.sp.fatec.view.View;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="OBJ_AUTOMOVEL")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Automovel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AUT_ID")
	@JsonView(View.PessoaComAutomovel.class)
	private Long id;

	@Column(name = "AUT_MODELO")
	@JsonView(View.PessoaComAutomovel.class)
	private String modelo;

	@Column(name = "AUT_COR")
	@JsonView(View.PessoaComAutomovel.class)
	private String cor;

	@Column(name = "AUT_RENAVAM")
	@JsonView(View.PessoaComAutomovel.class)
	private String renavam;

	@ManyToOne
	@JoinColumn(name = "AUT_PESSOA")
	private PessoaFisica pessoaFisica;

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

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
}
