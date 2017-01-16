package daobe.helha.groupe3.daos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.helha.groupe3.entities.Produit;

@Stateless
@LocalBean
public class DAOProduitLocalBean {
	@PersistenceContext(unitName="groupe3")
	EntityManager em;
	
	public List<Produit> getAll(){
		List<Produit> result=null;
		TypedQuery<Produit> query=em.createNamedQuery("Produit.FindAll",Produit.class);
		result=query.getResultList();
		return result;
	}
	
}
