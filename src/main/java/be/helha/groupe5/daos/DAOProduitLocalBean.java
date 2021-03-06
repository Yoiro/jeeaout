package be.helha.groupe5.daos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import be.helha.groupe5.entities.Produit;

@Stateless
@LocalBean
public class DAOProduitLocalBean extends DAOLocalBean<Produit>{	
	
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("LocalGroupe5");
	private EntityManager em=emf.createEntityManager();
	private EntityTransaction tr=em.getTransaction();
	
	
	@Override
	public Produit create(Produit p){
		tr.begin();
		em.persist(p);
		tr.commit();
		return p;
	}
	
	@Override
	public List<Produit> findAll(){
		tr.begin();
		List<Produit> result=new ArrayList<>();
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
	public Produit findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit findById(long id) {
		// TODO Auto-generated method stub
		tr.begin();
		TypedQuery<Produit> query = em.createNamedQuery("Produit.FindOne", Produit.class);
		query.setParameter("id", id);
		Produit p = query.getSingleResult();
		tr.commit();
		return p;
	}
}
