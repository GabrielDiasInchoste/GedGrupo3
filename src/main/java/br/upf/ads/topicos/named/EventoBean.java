package br.upf.ads.topicos.named;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.upf.ads.topicos.entities.Evento;
import br.upf.ads.topicos.jpa.GenericDao;
import br.upf.ads.topicos.jpa.JpaUtil;
import br.upf.ads.topicos.jsf.JsfUtil;
import br.upf.ads.topicos.jsf.TrataException;

@Named
@ViewScoped
public class EventoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Evento selecionado; // atributo para vinculo com campos do formulário
	private List<Evento> lista; // atributo para vinculo com o datatable da consulta
	private Boolean editando; // atributo para controlar o painel visível editar ou consultar
	private GenericDao<Evento> dao = new GenericDao<Evento>();

	public EventoBean() {
		super();
		setEditando(false);
		carregarLista();
	}

	public void incluir() {
		selecionado = new Evento(); // cria novo produto
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
			lista = dao.createQuery("from Evento order by id");
		} catch (Exception e) {
			e.printStackTrace();
			JsfUtil.addErrorMessage(TrataException.getMensagem(e));
		}
	}

	public List<Evento> completeSubEvento(String query) {
		EntityManager em = JpaUtil.getInstance().getEntityManager();
		List<Evento> results = em.createQuery("from Evento where upper(titulo) like '" + query.trim().toUpperCase() + "%' order by titulo").getResultList();
		em.close();
		return results;
	}

	public List<Evento> getLista() {
		return lista;
	}

	public void setLista(List<Evento> lista) {
		this.lista = lista;
	}

	public Evento getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Evento selecionado) {
		this.selecionado = selecionado;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}

}
