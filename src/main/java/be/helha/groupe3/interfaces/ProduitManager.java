package be.helha.groupe3.interfaces;

import java.util.List;

import be.helha.groupe3.entities.Produit;

public interface ProduitManager {
	public List<Produit> getProduits();
	public void setProduits(List<Produit> produits);
}
