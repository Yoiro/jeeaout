package be.helha.groupe5.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import be.helha.groupe5.daos.DAOUserLocalBean;
import be.helha.groupe5.entities.UtilisateurEnregistre;

@ManagedBean
@SessionScoped
public class LoginController implements Serializable{
	private String uName;
	private String password;
	private UtilisateurEnregistre user;
	private List<UtilisateurEnregistre> users;
	
	public UtilisateurEnregistre getUser() {
		return user;
	}

	public void setUser(UtilisateurEnregistre user) {
		this.user = user;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@EJB
	private DAOUserLocalBean daoUserLocalBean;
	
	@PostConstruct
	public void init() {
		user = daoUserLocalBean.getUser();
		users = daoUserLocalBean.findAll();
	}

	public String login() {
		UtilisateurEnregistre res = daoUserLocalBean.findByName(uName);
		if (res != null) {
			if (res.getPassword().equals(password)) {
				return "success";
			}
			return "wrong-password";
		}
		return "wrong-log";
	}
}
