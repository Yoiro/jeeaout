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
	private String leftButton;
	private String rightButton;

	@EJB
	private DAOUserLocalBean daoUserLocalBean;
	
	@PostConstruct
	public void init() {
		user = daoUserLocalBean.getUser();
		headText = (user == null ? "visiteur": user.getPrenom());
		leftButton = (user == null? doConnexionButton() : doProfileButton());
		rightButton = (user == null? doInscriptionButton() : doLogoutButton());
		daoUserLocalBean.ajouterObserver(this);
	}

	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub
		user = daoUserLocalBean.getUser();
		headText = (user == null ? "visiteur": user.getPrenom());
		leftButton = (user == null? doConnexionButton() : doProfileButton());
		rightButton = (user == null? doInscriptionButton() : doLogoutButton());
	}
	
	//HTML RENDERING
	//--------------------------------------------------------------------------------------------------------
	public String doConnexionButton() {
		return "<a type=\"button\" class=\"navbar-btn btn btn-gradient-blue\"\r\n" + 
				"								href=\"connexion.xhtml\">Connexion</a>";
	}
	
	public String doProfileButton() {
		return "<a type=\"button\" class=\"navbar-btn btn btn-gradient-blue\"\r\n" + 
				"								href=\"profile.xhtml/#{user.getId()}\">Mon profil</a>";
	}
	
	public String doInscriptionButton() {
		return "<a type=\"button\" class=\"navbar-btn btn btn-gradient-blue\"\r\n" + 
				"								href=\"inscription.xhtml\">Inscription</a>";
	}
	
	public String doLogoutButton() {
		return "<a type=\"button\" class=\"navbar-btn btn btn-gradient-blue\"\r\n" + 
				"								href=\"logout.xhtml\">Déconnexion</a>";
	}
	//--------------------------------------------------------------------------------------------------------
	//GETTERS & SETTERS
	//--------------------------------------------------------------------------------------------------------
	public String getHeadText() {
		return headText;
	}

	public void setHeadText(String headText) {
		this.headText = headText;
	}

	public String getLeftButton() {
		return leftButton;
	}

	public void setLeftButton(String leftButton) {
		this.leftButton = leftButton;
	}

	public String getRightButton() {
		return rightButton;
	}

	public void setRightButton(String rightButton) {
		this.rightButton = rightButton;
	}
	//--------------------------------------------------------------------------------------------------------
}
