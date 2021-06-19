package br.upf.ads.topicos.named;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;

import br.upf.ads.topicos.entities.ModalidadeSubEvento;
import br.upf.ads.topicos.entities.Participacao;
import br.upf.ads.topicos.entities.Pessoa;
import br.upf.ads.topicos.jpa.GenericDao;
import br.upf.ads.topicos.jpa.JpaUtil;
import br.upf.ads.topicos.jsf.JsfUtil;
import br.upf.ads.topicos.jsf.TrataException;

@Named
@ViewScoped
public class ParticipacaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Participacao selecionado; // atributo para vinculo com campos do formulário
	private List<Participacao> lista; // atributo para vinculo com o datatable da consulta
	private Boolean editando; // atributo para controlar o painel visível editar ou consultar
	private GenericDao<Participacao> dao = new GenericDao<Participacao>();
	private UploadedFile file;
	

	
	public List<Pessoa> completePessoa(String query) {
		EntityManager em = JpaUtil.getInstance().getEntityManager();
		 List<Pessoa> results = em.createQuery(
		 "from Pessoa where upper(nome) like "+
		"'"+query.trim().toUpperCase()+"%' "+
		 "order by nome").getResultList();
		 em.close();
		 return results;
		 }
	
	public List<ModalidadeSubEvento> completeModalidadeSubEvento(Integer query) {
		EntityManager em = JpaUtil.getInstance().getEntityManager();
		 List<ModalidadeSubEvento> results = em.createQuery(
			"from ModalidadeSubEvento order by id").getResultList();
			 em.close();
		 return results;
		 }
	

	public ParticipacaoBean() {
		super();
		setEditando(false);
		carregarLista();
	}

	public void incluir() {
		selecionado = new Participacao(); // cria novo produto
		setEditando(true);
	}

	public void alterar() {
		setEditando(true);
	}

	public void cancelar() {
		carregarLista();
		setSelecionado(null); // para desabilitar os botões alterar e excluir
		setEditando(false);
	}

	public void salvar() {
		try {
			setSelecionado(dao.merge(selecionado));
			JsfUtil.addSuccessMessage("Salvo com sucesso!");
			carregarLista(); // carregar produtos do BD quando salva algo
			setEditando(false);
		} catch (Exception e) {
			e.printStackTrace();
			JsfUtil.addErrorMessage(TrataException.getMensagem(e));
		}
	}

	public void excluir() {
		try {
			dao.remove(selecionado);
			JsfUtil.addSuccessMessage("Excluído com sucesso!");
			setSelecionado(null); // para desabilitar os botões alterar e excluir
			carregarLista(); // carregar produtos do BD quando salva algo
		} catch (Exception e) {
			e.printStackTrace();
			JsfUtil.addErrorMessage(TrataException.getMensagem(e));
		}
	}

	public void carregarLista() {
		try {
			lista = dao.createQuery("from Participacao order by id");
		} catch (Exception e) {
			e.printStackTrace();
			JsfUtil.addErrorMessage(TrataException.getMensagem(e));
		}
	}

	public List<Participacao> getLista() {
		return lista;
	}

	public void setLista(List<Participacao> lista) {
		this.lista = lista;
	}

	public Participacao getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Participacao selecionado) {
		this.selecionado = selecionado;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}

}
