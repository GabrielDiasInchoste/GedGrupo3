package br.upf.ads.topicos.entities;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: Produto
 *
 */
@Entity
public class Produto implements Serializable {
	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "ProdutoId")
	@SequenceGenerator(name = "ProdutoId", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	@NotBlank(message = "O nome deve ser informado!")
	@Length(min = 2, max = 50, message = "O nome deve ter entre {min} e {max} caracteres.")
	@Column(length = 50, unique = true, nullable = true)
	private String nome;
	
	@NotNull(message = "O preço deve ser informado.")
	@DecimalMin(value = "0", inclusive = false, message = "O preço deve ser maior que zero.")
	private Float preco = 0f;
	
	
	private static final long serialVersionUID = 1L;

	public Produto() {
		super();
	}   
	
	public Produto(Integer id, String nome, Float preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public Float getPreco() {
		return this.preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + "]";
	}
	
	
   
}
