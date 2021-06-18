package br.upf.ads.topicos.entities;

import static javax.persistence.GenerationType.SEQUENCE;
import br.upf.ads.topicos.entities.Modalidade;
import br.upf.ads.topicos.entities.Template;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ModalidadeSubEvento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "ModalidadeSubEventoId")
	@SequenceGenerator(name = "ModalidadeSubEventoId", allocationSize = 1, initialValue = 1)
	private Integer id;

	@ManyToOne								
	private Modalidade modalidate;

	@ManyToOne
	private Template template;

	@ManyToOne
	private SubEvento subEvento;	

	public ModalidadeSubEvento() {
		super();
	}

	public ModalidadeSubEvento(Integer id, Modalidade modalidate, Template template, SubEvento subEvento) {
		super();
		this.id = id;
		this.modalidate = modalidate;
		this.template = template;
		this.subEvento = subEvento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Modalidade getModalidate() {
		return modalidate;
	}

	public void setModalidate(Modalidade modalidate) {
		this.modalidate = modalidate;
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
