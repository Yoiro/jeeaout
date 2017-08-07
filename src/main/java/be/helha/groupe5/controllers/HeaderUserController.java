package be.helha.groupe5.controllers;

import be.helha.groupe5.daos.DAOUserLocalBean;
import be.helha.groupe5.entities.UtilisateurEnregistre;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import be.helha.groupe5.patterns.DBObserver;

@ManagedBean
@SessionScoped
public class HeaderUserController implements DBObserver {
	private UtilisateurEnregistre user;
	private String headText;
	
	/*
	<!-- #{headerUserController.connectBtn}
	#{headerUserController.registerBtn}
	#{headerUserController.profileBtn} -->
	 */
	
	@EJB
	private DAOUserLocalBean daoUserLocalBean;
	
	public String getHeadText() {
		return headText;
	}

	public void setHeadText(String headText) {
		this.headText = headText;
	}

	@PostConstruct
	public void init() {
		user = daoUserLocalBean.getUser();
		headText = (user == null ? "visiteur": user.getPrenom());
	}

	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub
		user = daoUserLocalBean.getUser();
	}

}
