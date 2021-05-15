package br.upf.ads.topicos.entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
public class Assina implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "AssinaId")
	@SequenceGenerator(name = "AssinaId", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	@NotBlank(message = "O nome deve ser informado!")
	@Length(min = 2, max = 60, message = "O nome deve ter entre {min} e {max} caracteres.")
	@Column(length = 60, nullable = false)
	private String nome;
	
	@Column(length = 20)
	private String funcao;
	
	@Column(length = 50)
	private String imagem;
	
	@Column(length = 50)
	private Date dataInativo;
	

	public Assina() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getFuncao() {
		return funcao;
	}


	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}


	public String getImagem() {
		return imagem;
	}


	public void setImagem(String imagem) {
		this.imagem = imagem;
	}


	public Date getDataInativo() {
		return dataInativo;
	}


	public void setDataInativo(Date dataInativo) {
		this.dataInativo = dataInativo;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
