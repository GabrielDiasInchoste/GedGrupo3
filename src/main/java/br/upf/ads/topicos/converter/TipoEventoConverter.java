package br.upf.ads.topicos.converter;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import br.upf.ads.topicos.entities.SubEvento;
import br.upf.ads.topicos.entities.TipoEvento;
import br.upf.ads.topicos.jpa.JpaUtil;

@FacesConverter(value = "tipoEventoConverter")
public class TipoEventoConverter implements Converter{

	public TipoEvento getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				EntityManager em = JpaUtil.getInstance().getEntityManager();
				TipoEvento ret = em.find(TipoEvento.class, Integer.parseInt(value));
				em.close();
				return ret;
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro de Conversao da TipoEvento", "TipoEvento invalida."));
			}
		} else
			return null;
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			return String.valueOf(((SubEvento) object).getId());
		} else
			return null;
	}
}

