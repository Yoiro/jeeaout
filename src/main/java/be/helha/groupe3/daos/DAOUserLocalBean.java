package be.helha.groupe3.daos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Stateless
@LocalBean
public class DAOUserLocalBean {
	private EntityManagerFactory emf;
	private EntityManager em; 
	private EntityTransaction tr;
	
	public void inscription(){
		
	}
}
