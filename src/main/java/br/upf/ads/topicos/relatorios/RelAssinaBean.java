package br.upf.ads.topicos.relatorios;

import java.util.HashMap;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.StreamedContent;

import br.upf.ads.topicos.jsf.JsfUtil;

@Named
@ViewScoped
public class RelAssinaBean {
	public StreamedContent gerarPDF() {
		try {
		HashMap parameters = new HashMap();
		return RelatorioUtil.gerarStreamRelatorioPDF(
		"WEB-INF/relatorios/Assina/Assina.jasper",
		parameters, "Assina.pdf");
		} catch (Exception e) {
		e.printStackTrace();
		JsfUtil.addErrorMessage(e.getMessage());
		return null;
		}
		}


}
			