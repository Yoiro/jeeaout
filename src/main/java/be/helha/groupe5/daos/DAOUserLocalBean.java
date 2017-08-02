package be.helha.groupe5.daos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import be.helha.groupe5.entities.UtilisateurEnregistre;

@Stateless
@LocalBean
public class DAOUserLocalBean extends DAOLocalBean<UtilisateurEnregistre>{
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("LocalGroupe5");
	private EntityManager em=emf.createEntityManager(); 
	private EntityTransaction tr=em.getTransaction();
	
	public void inscription(UtilisateurEnregistre u){
		tr.begin();
		em.persist(u);
		tr.commit();
	}

	@Override
	public List<UtilisateurEnregistre> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UtilisateurEnregistre findByName(String name) {
		// TODO Auto-generated method stub
		tr.begin();
		TypedQuery<UtilisateurEnregistre> query=em.createNamedQuery("UtilisateurEnregistre.FindOne",UtilisateurEnregistre.class)
				.setParameter("nom", name);
		UtilisateurEnregistre user=query.getSingleResult();
//		em.persist(user);
//		em.flush();
//		tr.commit();
		return user;
	}

	@Override
	public UtilisateurEnregistre create(UtilisateurEnregistre obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UtilisateurEnregistre update(UtilisateurEnregistre obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UtilisateurEnregistre obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UtilisateurEnregistre findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
