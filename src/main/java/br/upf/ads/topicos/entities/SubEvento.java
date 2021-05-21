package br.upf.ads.topicos.entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class SubEvento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "SubEventoId")
	@SequenceGenerator(name = "SubEventoId", allocationSize = 1, initialValue = 1)
	private Integer id;

//	@OneToMany
//	private ModalidadeSubEvento modalidadeSubEvento;

//	@ManyToMany
	private Assina assina;

	@ManyToOne
	private TipoEvento tipoEvento;

	@ManyToOne
	private Evento evento;

	public SubEvento() {
		super();
	}

	public SubEvento(Integer id, Assina assina, TipoEvento tipoEvento,
			Evento evento) {
		super();
		this.id = id;
		this.assina = assina;
		this.tipoEvento = tipoEvento;
		this.evento = evento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Assina getAssina() {
		return assina;
	}

	public void setAssina(Assina assina) {
		this.assina = assina;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
