package be.helha.groupe3.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityTransaction;

import be.helha.groupe3.entities.Acheteur;
import be.helha.groupe3.entities.Distributeur;
import be.helha.groupe3.entities.Produit;

//cette classe va s'occuper de remplir chaque Table de la DB
public class DatabaseFiller {	
	public static void main(String[]args){
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("LocalGroupe3");
		EntityManager em=emf.createEntityManager();
		EntityTransaction transaction=em.getTransaction();
		
		//Classes d'utilisateurs:
		//Acheteur 1
		Acheteur acheteur1=new Acheteur("De Greve","Simon","degrevesim","test","simon@degreve.be","0499/999999",
				"122a","Chaussée de Waterloo","Bruxelles",1000);
		transaction.begin();
		em.persist(acheteur1);
		//Distributeur 1
		Distributeur distributeur1=new Distributeur("Clavie","Bryan","claviebra","test","bryan@clavie.be","0488/888888",
				"58a","Rue du jardin","Leernes",6142,"Petite entreprise familiale, existe depuis peu. Spécialisé dans la vente de primeurs");
		em.persist(distributeur1);
		
		//Produits
		//Produit 1
		Produit produit1=new Produit("Haricots Verts", 3.0, "Haricots verts cultivés à la ferme. Prix au KG.", distributeur1);
		em.persist(produit1);
		
		transaction.commit();
	}
}
