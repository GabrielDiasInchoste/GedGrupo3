package br.upf.ads.topicos.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ModalidadeSubEvento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
	@ManyToOne								
	private Modalidade modalidade;

	@ManyToOne
	private Template template;

	@ManyToOne
	private SubEvento subEvento;

	public ModalidadeSubEvento() {
		super();
	}


	public ModalidadeSubEvento(Integer id, Modalidade modalidade, Template template, SubEvento subEvento) {
		super();
		this.id = id;
		this.modalidade = modalidade;
		this.template = template;
		this.subEvento = subEvento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public SubEvento getSubEvento() {
		return subEvento;
	}

	public void setSubEvento(SubEvento subEvento) {
		this.subEvento = subEvento;
	}

}
