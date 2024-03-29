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
public class TipoEvento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "TipoEventoId")
	@SequenceGenerator(name = "TipoEventoId", allocationSize = 1, initialValue = 1)	
	private Integer id;
	
	@NotBlank(message = "A Descrição deve ser informado!")
	@Length(min = 2, max = 60, message = "A Descrição deve ter entre {min} e {max} caracteres.")
	@Column(length = 60, nullable = false)	
	private String descricao;

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

	public TipoEvento() {
		super();
	}
}
