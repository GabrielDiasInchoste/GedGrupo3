package br.upf.ads.topicos.named;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

@Named
@ViewScoped
public class HomeBean implements Serializable{

	public HomeBean() {
		super();
	}
	
	
	public void abrirPopup(String url, int altura, int largura, boolean modal) {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", modal);
		options.put("width", largura);
		options.put("height", altura);
		options.put("contentWidth", "100%");
		options.put("contentHeight", "100%");
		options.put("headerElement", "customheader");
		options.put("resizable", false);
		options.put("minimizable", true);
		options.put("maximizable", true);
		options.put("responsive", true);
		options.put("fitViewport", true);
        options.put("draggable", true);
		PrimeFaces.current().dialog().openDynamic(url, options, null); // a partir do Primefaces 6.2
	}	
	

}
