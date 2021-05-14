package br.upf.ads.topicos.jsf;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.PrimeFaces;

/**
 * 
 * @author Jaqson
 *
 */
public class JsfUtil {
	
    public static void addMessage(String message) {
    	FacesMessage msg = new FacesMessage(message,message);
    	FacesContext.getCurrentInstance().addMessage(null, msg);
    }	
    
    public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }
    
    public static void addErrorMessages(List<String> messages) {
        for (String message : messages) {
            addErrorMessage(message);
        }
    }	    
    
	public static void mostrarErroEmDialog(String mensagem) {
		PrimeFaces.current().dialog().showMessageDynamic(new
				FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", mensagem), true);
	}    
    
}
