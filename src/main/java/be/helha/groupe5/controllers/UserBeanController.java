package be.helha.groupe5.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@SessionScoped
public class UserBeanController implements Serializable{
	private String userName = "visiteur";

	public String getUserName() {
		return userName;
	}
	
	
}
