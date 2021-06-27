package br.upf.ads.topicos.relatorios;

import java.util.HashMap;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.StreamedContent;

import br.upf.ads.topicos.jsf.JsfUtil;

@Named
@ViewScoped
public class RelModalidadeSubEventoBean {
	public StreamedContent gerarPDF() {
		try {
		HashMap parameters = new HashMap();
		return RelatorioUtil.gerarStreamRelatorioPDF(
		"WEB-INF/relatorios/ModalidadeSubEvento/ModalidadeSubEvento.jasper",
		parameters, "ModalidadeSubEvento.pdf");
		} catch (Exception e) {
		e.printStackTrace();
		JsfUtil.addErrorMessage(e.getMessage());
		return null;
		}
		}


}
			