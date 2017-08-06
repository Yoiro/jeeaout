package be.helha.groupe5.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import be.helha.groupe5.daos.DAOPanierLocalBean;
import be.helha.groupe5.entities.Panier;
import be.helha.groupe5.entities.Produit;
import be.helha.groupe5.patterns.DBObserver;

@ManagedBean
@SessionScoped
public class HeaderCartController implements Serializable, DBObserver{

	private Panier cart;
	private Double prixTot;
	private List<Produit> produits;
	private List<Integer> quantites;
	private Integer nbProduits;
	
	@EJB
	private DAOPanierLocalBean daoPanierLocalBean;
	
	//ANNOTATED METHODS
	//------------------------------------------------------

	@PostConstruct
	public void init() {
		if (cart == null) {
			cart = daoPanierLocalBean.getPanier();
		}
		produits = new ArrayList<>();
		quantites = new ArrayList<>();
		prixTot = 0.0;
		nbProduits = 0;
		daoPanierLocalBean.ajouterObserver(this);
	}
	
	@Override
	public void onUpdate() {
		// TODO Auto-generated method stub
		prixTot = cart.getPrixTot();
		produits = (List<Produit>)cart.getMapProduit().keySet().stream().collect(Collectors.toList());
		quantites = (List<Integer>)cart.getMapProduit().values().stream().collect(Collectors.toList());
		nbProduits = produits.size();
	}
	
	// GETTERS & SETTERS
	//------------------------------------------------------
	public Panier getCart() {
		return cart;
	}

	public void setCart(Panier cart) {
		this.cart = cart;
	}

	public Double getPrixTot() {
		return prixTot;
	}

	public void setPrixTot(Double prixTot) {
		this.prixTot = prixTot;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Integer getNbProduits() {
		return nbProduits;
	}
	public void setNbProduits(Integer nbProduits) {
		this.nbProduits = nbProduits;
	}
	public List<Integer> getQuantites() {
		return quantites;
	}

	public void setQuantites(List<Integer> quantites) {
		this.quantites = quantites;
	}

	// OTHER METHODS
	//------------------------------------------------------

}
