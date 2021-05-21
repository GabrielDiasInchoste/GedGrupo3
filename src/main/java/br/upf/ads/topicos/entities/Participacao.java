package br.upf.ads.topicos.entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
public class Participacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "ParticipacaoId")
	@SequenceGenerator(name = "ParticipacaoId", allocationSize = 1, initialValue = 1)
	private Integer id;

	@NotBlank(message = "O Texto deve ser informada!")
	private Float horasParticipou;

	@NotBlank(message = "A Arquivo deve ser informado!")
	@Length(min = 5, max = 60, message = "A Arquivo deve ter entre {min} e {max} caracteres.")
	@Column(length = 60, nullable = false)
	private String arquivo;

	@ManyToOne
	private Pessoa pessoa;

	@ManyToOne
	private ModalidadeSubEvento modalidadeSubEvento;

	public Participacao() {
		super();
	}

	public Participacao(Integer id, @NotBlank(message = "O Texto deve ser informada!") Float horasParticipou,
			@NotBlank(message = "A Arquivo deve ser informado!") @Length(min = 5, max = 60, message = "A Arquivo deve ter entre {min} e {max} caracteres.") String arquivo,
			Pessoa pessoa, ModalidadeSubEvento modalidadeSubEvento) {
		super();
		this.id = id;
		this.horasParticipou = horasParticipou;
		this.arquivo = arquivo;
		this.pessoa = pessoa;
		this.modalidadeSubEvento = modalidadeSubEvento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getHorasParticipou() {
		return horasParticipou;
	}

	public void setHorasParticipou(Float horasParticipou) {
		this.horasParticipou = horasParticipou;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public ModalidadeSubEvento getModalidadeSubEvento() {
		return modalidadeSubEvento;
	}

	public void setModalidadeSubEvento(ModalidadeSubEvento modalidadeSubEvento) {
		this.modalidadeSubEvento = modalidadeSubEvento;
	}
}
