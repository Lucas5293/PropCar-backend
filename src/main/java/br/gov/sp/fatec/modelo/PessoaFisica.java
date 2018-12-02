package br.gov.sp.fatec.modelo;

import br.gov.sp.fatec.view.View;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PE_PESSOAFISICA")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PessoaFisica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PSF_ID")
	@JsonView(View.PessoaComId.class)
	private Long id;

	@Column(name = "PSF_NOME")
	@JsonView(View.PessoaSemId.class)
	private String nome;

	@Column(name = "PSF_DATANASCIMENTO")
	@JsonView(View.PessoaSemId.class)
	private Date dataNascimento;

	@Column(name = "PSF_CPF", unique = true)
	@JsonView(View.PessoaSemId.class)
	private String cpf;

	@Column(name = "PSF_TELEFONE")
	@JsonView(View.PessoaSemId.class)
	private String telefone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}

