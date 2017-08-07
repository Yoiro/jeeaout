package be.helha.groupe5.daos;

import java.sql.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import be.helha.groupe5.entities.Acheteur;
import be.helha.groupe5.entities.Adresse;
import be.helha.groupe5.entities.Commande;
import be.helha.groupe5.entities.Panier;
import be.helha.groupe5.entities.Produit;
import be.helha.groupe5.entities.UtilisateurEnregistre;
import be.helha.groupe5.patterns.DBObservable;
import be.helha.groupe5.patterns.DBObserver;

@Stateless
@LocalBean
public class DAOPanierLocalBean extends DBObservable {
	
	/**
	 * Cette classe va implémenter une sorte de Singleton personnalisé afin de s'assurer qu'il n'y ait qu'un et un seul panier présent
	 * dans toute la session/application.
	 */

	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("LocalGroupe5");;
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction tr=em.getTransaction();
	
	private static Panier panier;
	
	private Acheteur acheteur;
	
	public Panier getPanier() {
		if(panier == null) {
			panier = create(new Panier());
		}
		return panier;
	}
	
	private Panier create(Panier obj) {
		tr.begin();
		panier = obj;
		em.persist(panier);
		if(tr.isActive()) tr.commit();;
		return panier;
	}
	
	public List<Panier> findAll() {
		if (!tr.isActive()) tr.begin();
		List<Panier> result = null;
		TypedQuery<Panier> query = em.createNamedQuery("Panier.FindAll",Panier.class);
		result = query.getResultList();
		if(tr.isActive()) tr.commit();
		return result;
	}

	public Panier update(Panier obj) {
		// TODO Auto-generated method stub
		panier = obj;
		panier.setPrixTot(calculerPrixTot());
		em.flush();
		notifyObservers();
		return panier;
	}
	public void delete(Panier obj) {
		// TODO Auto-generated method stub
		if (!tr.isActive()) tr.begin();
		Query query=em.createNamedQuery("Panier.RemoveFromTable",Panier.class).setParameter(":id", obj.getId());
		query.executeUpdate();
		em.flush();
		if(tr.isActive()) tr.commit();	
	}
	
	public double calculerPrixTot() {
		// TODO Auto-generated method stub
		return panier.calculerPrixPanier();
	}

	public void addToCart(Produit p,int qte) {
		// TODO Auto-generated method stub
		if (!tr.isActive()) tr.begin();
		if(panier.getMapProduit().containsKey(p)) {
			panier.getMapProduit().put(p, panier.getMapProduit().get(p) + qte);
			update(panier);
		}
		else { 
			panier.getMapProduit().put(p, qte);
			update(panier);
		}
		panier.setPrixTot(calculerPrixTot());
		if(tr.isActive()) tr.commit();
	}

	public void removeFromCart(Produit p) {
		// TODO Auto-generated method stub
		if (!tr.isActive()) tr.begin();
		panier.getMapProduit().remove(p, panier.getMapProduit().get(p));
		update(panier);
		if(tr.isActive()) tr.commit();
	}

	public Commande validatePanier() {
		// TODO Auto-generated method stub
		//Commande(String date,Panier produitCommande,Acheteur acheteur,String lieuLivraison)
		Date date = new Date(System.currentTimeMillis());
		System.out.println(date);
		Acheteur buyer = new Acheteur();
		Adresse lieuLivraison = buyer.getAdressePostale();
		Commande commande = new Commande(date, panier, buyer, lieuLivraison);
		return null;
	}

	public Panier cleanPanier() {
		// TODO Auto-generated method stub
		panier.getMapProduit().clear();
		update(panier);
		return panier;
	}

	public Panier findByName(String name){
		return null;
	}
	
	public Panier findById(long id) {
		if (!tr.isActive()) tr.begin();
		Panier result = null;
		TypedQuery<Panier> query = em.createNamedQuery("Panier.FindOne",Panier.class).setParameter("id", id);
		result = query.getSingleResult();
		if(tr.isActive()) tr.commit();
		return result;
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (DBObserver o: observers) {
			o.onUpdate();
		}
	}

	


	


}
