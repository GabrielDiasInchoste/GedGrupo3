package br.upf.ads.topicos.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "UsuarioId", allocationSize = 1, sequenceName = "UsuarioId")
	@GeneratedValue(generator = "UsuarioId", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@NotEmpty(message = "O nome deve ser informado!")
	@Length(max = 60, min = 3, message = "O nome deve ter entre 3 e 60 caracteres!")
	@Column(length = 60, nullable = false)
	private String nome;

	@NotEmpty(message = "O email deve ser informado!")
	@Email(message = "O email deve ser válido!")
	@Column(length = 20, nullable = false)
	private String email;

	@NotEmpty(message = "A senha deve ser informada!")
	@Length(max = 40, min = 6, message = "O nome deve ter entre 6 e 40 caracteres!")
	@Column(length = 40, nullable = false)
	private String senha;

	public Usuario() {
		super();
	}

	public Usuario(Integer id,
			@NotEmpty(message = "O nome deve ser informado!") @Length(max = 60, min = 3, message = "O nome deve ter entre 3 e 60 caracteres!") String nome,
			@NotEmpty(message = "O email deve ser informado!") @Email(message = "O email deve ser válido!") String email,
			@NotEmpty(message = "A senha deve ser informada!") @Length(max = 40, min = 6, message = "O nome deve ter entre 6 e 40 caracteres!") String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}