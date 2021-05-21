package br.upf.ads.topicos.entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "EventoId")
	@SequenceGenerator(name = "EventoId", allocationSize = 1, initialValue = 1)
	private Integer id;

	@NotBlank(message = "A Titulo deve ser informado!")
	@Length(min = 4, max = 60, message = "A Titulo deve ter entre {min} e {max} caracteres.")
	@Column(length = 60, nullable = false)
	private String titulo;

	@NotBlank(message = "A Descrição deve ser informado!")
	@Length(min = 4, max = 60, message = "A Descrição deve ter entre {min} e {max} caracteres.")
	@Column(length = 60, nullable = false)
	private String descricao;

	@NotBlank(message = "A Data Inicio deve ser informado!")
	@Column(length = 60, nullable = false)
	private Date dataInicio;

	@NotBlank(message = "A Data Termino deve ser informado!")
	@Column(length = 60, nullable = false)
	private Date dataTermino;

	@NotBlank(message = "A Total Horas deve ser informado!")
	@Column(length = 60, nullable = false)
	private Float totalHoras;

	@OneToMany
	private List<SubEvento> subEvento;

	public Evento() {
		super();
	}

	public Evento(Integer id,
			@NotBlank(message = "A Titulo deve ser informado!") @Length(min = 4, max = 60, message = "A Titulo deve ter entre {min} e {max} caracteres.") String titulo,
			@NotBlank(message = "A Descrição deve ser informado!") @Length(min = 4, max = 60, message = "A Descrição deve ter entre {min} e {max} caracteres.") String descricao,
			@NotBlank(message = "A Data Inicio deve ser informado!") Date dataInicio,
			@NotBlank(message = "A Data Termino deve ser informado!") Date dataTermino,
			@NotBlank(message = "A Total Horas deve ser informado!") Float totalHoras, List<SubEvento> subEvento) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.totalHoras = totalHoras;
		this.subEvento = subEvento;
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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Float getTotalHoras() {
		return totalHoras;
	}

	public void setTotalHoras(Float totalHoras) {
		this.totalHoras = totalHoras;
	}

	public List<SubEvento> getSubEvento() {
		return subEvento;
	}

	public void setSubEvento(List<SubEvento> subEvento) {
		this.subEvento = subEvento;
	}

}
