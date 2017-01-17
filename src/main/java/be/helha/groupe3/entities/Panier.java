package be.helha.groupe3.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Panier implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private HashMap<Produit,Integer>mapProduit;
	private double prixTot = 0.0;
	
	
	
	//-----------------------Constructor-------------------
	public Panier(){}
	public Panier(double prixTot){
		mapProduit=new HashMap<>();
		setPrixTot(prixTot);
	}
	
	
	//---------------------Getter & Setter ------------------
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
	
	//---------------------otherMethods()----------------------
	
	
	@Override
	public String toString() {
		return "Panier [mapProduit=" + mapProduit + ", prixTot=" + prixTot + "]";
	}
	
	public void cleanPanier(){
		mapProduit.clear();
	}
	
	public void ajouterProduitPanier(Produit p,Integer quantite){
		mapProduit.put(p, quantite);
	}
	
	public double calculerPrixPanier(){
		for(int i = 0 ; i<=mapProduit.size();i++){
			
			prixTot+=mapProduit.get(i);
		}
		return prixTot;
	}
	
	
}
