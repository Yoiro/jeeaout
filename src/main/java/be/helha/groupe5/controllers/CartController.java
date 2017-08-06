package be.helha.groupe5.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import be.helha.groupe5.daos.DAOPanierLocalBean;
import be.helha.groupe5.daos.DAOProduitLocalBean;
import be.helha.groupe5.entities.Panier;
import be.helha.groupe5.entities.Produit;
import be.helha.groupe5.patterns.DBObserver;

@ManagedBean
@SessionScoped
public class CartController implements Serializable, DBObserver{
	
	private Panier panier;
	private LinkedHashMap<Produit, Integer> hashProduits;
	private List<Entry<Produit, Integer>> entries;
	
	@EJB
	private DAOProduitLocalBean daoProduitLocalBean;
	@EJB
	private DAOPanierLocalBean daoPanierLocalBean;
	
	@PostConstruct
	public void init() {
		panier = daoPanierLocalBean.getPanier();
		hashProduits = panier.getMapProduit();
		entries = new ArrayList<>(hashProduits.entrySet());
		daoPanierLocalBean.ajouterObserver(this);
	}

	@Override
	public void onUpdate() {
		panier = daoPanierLocalBean.getPanier();
		System.out.println(panier);
		hashProduits = panier.getMapProduit();
		System.out.println(hashProduits);
		entries = new ArrayList<>(hashProduits.entrySet());
		System.out.println(entries);
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public LinkedHashMap<Produit, Integer> getHashProduits() {
		return hashProduits;
	}

	public void setHashProduits(LinkedHashMap<Produit, Integer> hashProduits) {
		this.hashProduits = hashProduits;
	}
	
	public List<Entry<Produit, Integer>> getEntries() {
		return entries;
	}

	public void retirerProduitPanier(Produit p) {
		System.out.println(p);
		daoPanierLocalBean.removeFromCart(p);
		System.out.println("cérétiré lol");
	}
}
