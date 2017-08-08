package be.helha.groupe5.daos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import be.helha.groupe5.entities.UtilisateurEnregistre;
import be.helha.groupe5.patterns.DBObservable;
import be.helha.groupe5.patterns.DBObserver;

@Stateless
@LocalBean
public class DAOUserLocalBean extends DBObservable{
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("LocalGroupe5");
	private EntityManager em=emf.createEntityManager(); 
	private EntityTransaction tr=em.getTransaction();
	
	private static UtilisateurEnregistre user;
	
	public UtilisateurEnregistre getUser() {
		return user;
	}

	public List<UtilisateurEnregistre> findAll() {
		// TODO Auto-generated method stub
		if(!tr.isActive())tr.begin();
		TypedQuery<UtilisateurEnregistre> query = em.createNamedQuery("UtilisateurEnregistre.FindAll", UtilisateurEnregistre.class);
		List<UtilisateurEnregistre> res = query.getResultList();
		if(tr.isActive())tr.commit();
		return res;
	}

	public UtilisateurEnregistre findByName(String name) {
		if(!tr.isActive())tr.begin();
		TypedQuery<UtilisateurEnregistre> query=em.createNamedQuery("UtilisateurEnregistre.FindOne",UtilisateurEnregistre.class)
				.setParameter("nom", name);
		try{
			UtilisateurEnregistre user=query.getSingleResult();
			if (user.getPseudoUtilisateur().equals(name)) {
				if(tr.isActive())tr.commit();
				return user;
			}
			if(tr.isActive())tr.commit();
			return null;
		} catch (NoResultException e) {
			if(tr.isActive())tr.commit();
			return null;
		} 
	}

	public UtilisateurEnregistre update(UtilisateurEnregistre obj) {
		// TODO Auto-generated method stub
		if(!tr.isActive())tr.begin();
		user = obj;
		if(tr.isActive())tr.commit();
		notifyObservers();
		return user;
	}

	public void delete(UtilisateurEnregistre obj) {
		// TODO Auto-generated method stub
		if(!tr.isActive())tr.begin();
		Query query = em.createNamedQuery("UtilisateurEnregistre.RemoveFromTable");
		query.executeUpdate();
		em.flush();
		if(tr.isActive())tr.commit();
	}

	public UtilisateurEnregistre findById(long id) {
		// TODO Auto-generated method stub
		if(!tr.isActive())tr.begin();
		TypedQuery<UtilisateurEnregistre> query=em.createNamedQuery("UtilisateurEnregistre.FindById",UtilisateurEnregistre.class)
				.setParameter("id", id);
		UtilisateurEnregistre res = query.getSingleResult();
		if(tr.isActive())tr.commit();
		return res;
	}

	public UtilisateurEnregistre create(UtilisateurEnregistre obj) {
		// TODO Auto-generated method stub
		if(!tr.isActive())tr.begin();
		em.persist(obj);
		if(tr.isActive())tr.commit();
		return obj;
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (DBObserver o: observers) {
			o.onUpdate();
		}
	}
}
