package br.com.alexradavelli.javaeejsf.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class AbstractMB {

	protected void addInfoMessage(String message) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, message, null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
