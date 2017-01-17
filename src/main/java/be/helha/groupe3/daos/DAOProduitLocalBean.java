package be.helha.groupe3.daos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.helha.groupe3.entities.Produit;

@Stateless
@LocalBean
public class DAOProduitLocalBean {	
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("LocalGroupe3");
	private EntityManager em=emf.createEntityManager(); 
	private EntityTransaction tr;
	
	public void create(Produit p){
		tr=em.getTransaction();
		tr.begin();
		em.persist(p);
		tr.commit();
	}
	
	public List<Produit> getAll(){
		tr=em.getTransaction();
		tr.begin();
		List<Produit> result=null;
		TypedQuery<Produit> query=em.createNamedQuery("Produit.FindAll",Produit.class);
		result=query.getResultList();
		tr.commit();
		return result;
	}
}
