package be.helha.groupe3.daos;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import be.helha.groupe3.entities.Commande;
import be.helha.groupe3.entities.Panier;
import be.helha.groupe3.entities.Produit;

public class DAOPanierLocalBean extends DAOLocalBean<Panier> {

	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("LocalGroupe3");;
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction tr=em.getTransaction();
	
	private Panier panier;
	
	@Override
	public Panier create(Panier obj) {
		tr.begin();
		em.merge(obj);
		em.persist(obj);
		tr.commit();
		return obj;
	}
	
	@Override
	public List<Panier> findAll() {
		tr.begin();
		List<Panier> result = null;
		TypedQuery<Panier> query = em.createNamedQuery("Panier.FindAll",Panier.class);
		result = query.getResultList();
		tr.commit();
		return result;
	}


	@Override
	public Panier update(Panier obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Panier obj) {
		// TODO Auto-generated method stub
		tr.begin();
		Query query=em.createNamedQuery("Panier.RemoveFromTable",Panier.class).setParameter(":id", obj.getId());
		query.executeUpdate();
		em.flush();
		tr.commit();		
	}
	
	
	public double calculerPrixTot() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addPanier(Produit p,int qte) {
		// TODO Auto-generated method stub
		tr.begin();
		panier.getMapProduit().put(p, qte);
		em.persist(panier);
		em.flush();
		tr.commit();
	}

	public void removePanier(Produit p) {
		// TODO Auto-generated method stub
		tr.begin();
		panier.getMapProduit().remove(p);
		em.merge(panier);
		em.flush();
		tr.commit();
	}

	public Commande validatePanier() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object cleanPanier() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Panier find(long id) {
		tr.begin();
		Panier result = null;
		TypedQuery<Panier> query = em.createNamedQuery("Panier.FindOne",Panier.class).setParameter("id", id);
		result = query.getSingleResult();
		tr.commit();
		return result;
	}

	


	


}
