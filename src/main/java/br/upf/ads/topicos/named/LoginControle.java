package br.upf.ads.topicos.named;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.upf.ads.topicos.entities.Usuario;
import br.upf.ads.topicos.jpa.GenericDao;

@Named
@SessionScoped
public class LoginControle implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String senha;
	private Usuario usuarioLogado;
	private GenericDao<Usuario> dao = new GenericDao<Usuario>();

	
	public String entrar() throws Exception {
		usuarioLogado = null;
		List<Usuario> usuarios = dao.createQuery("from Usuario");
		Optional<Usuario> usuario = usuarios.stream().filter(usu -> usu.getEmail().equals(email) && usu.getSenha().equals(senha)).findAny();
		if (usuario.isPresent()) {
			usuarioLogado = usuario.get();
			return "/faces/Privado/Home.xhtml?faces-redirect=true";
		} else {
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ou senha inválida!", "");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			return ""; 
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