package br.upf.ads.topicos.named;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.upf.ads.topicos.entities.Usuario;
import br.upf.ads.topicos.jpa.JpaUtil;

@Named
@SessionScoped
public class LoginControle implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String senha;
	private Usuario usuarioLogado;

	public String entrar() { 
		usuarioLogado = null;
		EntityManager em = JpaUtil.getInstance().getEntityManager();
		String oql = "from Usuario where email = :email and senha = :senha";
		Query qry = em.createQuery(oql);
		qry.setParameter("email", this.email);
		qry.setParameter("senha", this.senha);
		List<Usuario> ret = qry.getResultList();
		em.close();
		if (ret.size() > 0) {
			usuarioLogado = ret.get(0);
			return "/faces/Privado/Home.xhtml?faces-redirect=true";
			
		} else {
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ou senha inválida!" , "");
			FacesContext.getCurrentInstance().addMessage(null, mensagem); 			
			return ""; // Permanece na tela de login
		}
	}

	public String sair() {
		usuarioLogado = null;
		return "/faces/LoginForm.xhtml?faces-redirect=true";
	}

	public LoginControle() {
		super();
	}

	public LoginControle(String email, String senha, Usuario usuarioLogado) {
		super();
		this.email = email;
		this.senha = senha;
		this.usuarioLogado = usuarioLogado;
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

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
}