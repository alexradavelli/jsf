package br.com.alexradavelli.javaeejsf.managedbean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class AbstractMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4767630846728179971L;

	protected void addInfoMessage(String message) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, message, null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
