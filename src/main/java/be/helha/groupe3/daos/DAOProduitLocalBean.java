package be.helha.groupe3.daos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import be.helha.groupe3.entities.Produit;

@Stateless
@LocalBean
public class DAOProduitLocalBean extends DAOLocalBean<Produit>{	
	private EntityManagerFactory emf;
	private EntityManager em; 
	private EntityTransaction tr;
	
	@Override
	public Produit create(Produit p){
		emf=Persistence.createEntityManagerFactory("LocalGroupe3");
		em=emf.createEntityManager();
		tr=em.getTransaction();
		tr.begin();
		em.merge(p);
		em.persist(p);
		tr.commit();
		return p;
	}
	
	@Override
	public List<Produit> findAll(){
		emf=Persistence.createEntityManagerFactory("LocalGroupe3");
		em=emf.createEntityManager();
		tr=em.getTransaction();
		tr.begin();
		List<Produit> result=null;
		TypedQuery<Produit> query=em.createNamedQuery("Produit.FindAll",Produit.class);
		result=query.getResultList();
		tr.commit();
		return result;
	}

	@Override
	public Produit update(Produit obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Produit obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produit find(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
