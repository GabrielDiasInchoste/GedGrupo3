package br.upf.ads.topicos.entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
public class SubEvento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "SubEventoId")
	@SequenceGenerator(name = "SubEventoId", allocationSize = 1, initialValue = 1)
	private Integer id;

	@Column(length = 100)
	private String titulo;
	
	@Column(length = 100)
	private String descricao;
	
	@Column(length = 50)
	private Date dataHoraInicio;

	@Column(length = 50)
	private Date dataHoraTermino;

	@NotNull(message = "A Total Horas deve ser informado!")
	@Column(length = 60, nullable = false)
	private Float totalHoras;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,mappedBy = "subEvento")
	private List<ModalidadeSubEvento> modalidadeSubEvento;

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Assina> assina;

	@ManyToOne
	private TipoEvento tipoEvento;

	@ManyToOne
	private Evento evento;

	public SubEvento() {
		super();
	}

	
	public SubEvento(Integer id, String titulo, String descricao, Date dataHoraInicio, Date dataHoraTermino,
			@NotNull(message = "A Total Horas deve ser informado!") Float totalHoras,
			List<ModalidadeSubEvento> modalidadeSubEvento, List<Assina> assina, TipoEvento tipoEvento, Evento evento) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraTermino = dataHoraTermino;
		this.totalHoras = totalHoras;
		this.modalidadeSubEvento = modalidadeSubEvento;
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(Date dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public Date getDataHoraTermino() {
		return dataHoraTermino;
	}

	public void setDataHoraTermino(Date dataHoraTermino) {
		this.dataHoraTermino = dataHoraTermino;
	}

	public Float getTotalHoras() {
		return totalHoras;
	}

	public void setTotalHoras(Float totalHoras) {
		this.totalHoras = totalHoras;
	}

	public List<ModalidadeSubEvento> getModalidadeSubEvento() {
		return modalidadeSubEvento;
	}

	public void setModalidadeSubEvento(List<ModalidadeSubEvento> modalidadeSubEvento) {
		this.modalidadeSubEvento = modalidadeSubEvento;
	}

	public List<Assina> getAssina() {
		return assina;
	}

	public void setAssina(List<Assina> assina) {
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
