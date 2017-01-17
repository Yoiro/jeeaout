package be.helha.groupe3.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Panier implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private HashMap<Produit,Integer>mapProduit;
	private double prixTot = 0.0;
	
	
	
	//-----------------------Constructor-----------------------------
	public Panier(){}
	public Panier(double prixTot){
		mapProduit=new HashMap<>();
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
		for (Entry<Produit, Integer> e : mapProduit.entrySet()) {
				Produit p = e.getKey();
				
				prixTot += p.getPrix() * e.getValue();
				
			
			}
		return prixTot;
	}
	
	public void removeProduitPanier(Produit p,Integer quantite){
		if(mapProduit.containsKey(p)){
			
		}
	}
	
	
	
}
