package br.upf.ads.topicos.entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
public class Template implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "TemplateId")
	@SequenceGenerator(name = "TemplateId", allocationSize = 1, initialValue = 1)	
	private Integer id;
	
	@NotBlank(message = "A Descrição deve ser informada!")
	@Length(min = 5, max = 60, message = "A Descrição deve ter entre {min} e {max} caracteres.")
	@Column(length = 60, nullable = false)	
	private String descricao;
	
	
	@NotBlank(message = "O Texto deve ser informada!")
	private String texto;


	public Template() {
		super();
	}


	public Template(Integer id,
			@NotBlank(message = "A Descrição deve ser informada!") @Length(min = 4, max = 60, message = "A Descrição deve ter entre {min} e {max} caracteres.") String descricao,
			@NotBlank(message = "O Texto deve ser informada!") String texto) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.texto = texto;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}

	
}
