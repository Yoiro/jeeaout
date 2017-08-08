package be.helha.groupe5.controllers;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import be.helha.groupe5.daos.DAOUserLocalBean;

@ManagedBean
@RequestScoped
public class LogoutController {
	@EJB
	private DAOUserLocalBean daoUserLocalBean;
	
	public String logout() {
		daoUserLocalBean.update(null);
		System.out.println("logoutController.init: "+daoUserLocalBean.getUser());
		return "index.xhtml?faces-redirect=true";
	}
}
