package be.helha.groupe3.daos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import be.helha.groupe3.entities.UtilisateurEnregistre;

@Stateless
@LocalBean
public class DAOUserLocalBean {
	private EntityManagerFactory emf;
	private EntityManager em; 
	private EntityTransaction tr;
	
	public void inscription(UtilisateurEnregistre u){
		emf=Persistence.createEntityManagerFactory("LocalGroupe3");
		em=emf.createEntityManager();
		tr=em.getTransaction();
		tr.begin();
		em.merge(u);
		em.persist(u);
		tr.commit();
	}
}
