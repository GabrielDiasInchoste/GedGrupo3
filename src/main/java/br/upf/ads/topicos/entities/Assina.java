package br.upf.ads.topicos.entities;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
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

	@Lob
	private byte[] imagem;

	@Column(length = 50)
	private Date dataInativo;


	public Assina() {
		super();
	}

	public Assina(Integer id,
			@NotBlank(message = "O nome deve ser informado!") @Length(min = 2, max = 60, message = "O nome deve ter entre {min} e {max} caracteres.") String nome,
			String funcao, byte[] imagem, Date dataInativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.funcao = funcao;
		this.imagem = imagem;
		this.dataInativo = dataInativo;
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

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Date getDataInativo() {
		return dataInativo;
	}

	public void setDataInativo(Date dataInativo) {
		this.dataInativo = dataInativo;
	}

}
