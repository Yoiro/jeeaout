package be.helha.groupe5.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries ({
	@NamedQuery(name="Panier.FindAll",
			query="SELECT p from Panier p"),
	@NamedQuery(name="Panier.FindOne",
			query="SELECT p from Panier p where p.id = :id"),
	@NamedQuery(name="Panier.RemoveFromTable",
			query="DELETE from Panier p where :id=p.id"),
})
public class Panier implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	private double prixTot;

	private HashMap<Produit,Integer>mapProduit;
	
	//-----------------------Constructor-----------------------------
	public Panier(){
		mapProduit = new HashMap<>();
		prixTot = 0.0;
	}
	public Panier(double prixTot){
		mapProduit = new HashMap<>();
		setPrixTot(prixTot);
	}
	
	
	//---------------------Getter & Setter --------------------------
	public HashMap<Produit, Integer> getMapProduit() {
		return mapProduit;
	}
	public void setMapProduit(HashMap<Produit, Integer> mapProduit) {
		this.mapProduit = mapProduit;
	}
	public double getPrixTot() {
		return prixTot;
	}
	public void setPrixTot(double prixTot) {
		this.prixTot = prixTot;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	//---------------------otherMethods()----------------------------
	
	
	@Override
	public String toString() {
		return "Panier [mapProduit=" + mapProduit + ", prixTot=" + prixTot + "]";
	}
	
	public void cleanPanier(){
		mapProduit.clear();
	}
	
	//Ajout d'un produit et d'une quantité
	public void ajouterProduitPanier(Produit p,Integer quantite){
		
		if(!mapProduit.containsKey(p)){
			mapProduit.put(p, quantite);
		}
		else{
			Produit recu=p;
			for(Entry<Produit,Integer>e:mapProduit.entrySet()){
				if(recu.equals(e)){
					int quantiteTot=quantite +e.getValue();
					e.setValue(quantiteTot);
				}
			}
		}
	}
	
	
	//Calcul du prix total du panier
	public double calculerPrixPanier(){
		prixTot = 0.0;
		for (Entry<Produit, Integer> e : mapProduit.entrySet()) {
				Produit p = e.getKey();
				prixTot += p.getPrix() * e.getValue();
			}
		System.out.println("CALCULERPRIXPANIER// "+prixTot);
		return prixTot;
	}
	
	public void removeProduitPanier(Produit p,Integer quantite){
		if(mapProduit.containsKey(p)){
			for(Entry<Produit,Integer> e : mapProduit.entrySet()){
				if(e.getKey().equals(p) && e.getValue()>=quantite){
					e.setValue(e.getValue()-quantite);
				}
			}
		}
	}
	
	
	
}
