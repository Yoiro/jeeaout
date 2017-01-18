package be.helha.groupe3.managers;

import java.util.ArrayList;
import java.util.List;

import be.helha.groupe3.entities.Produit;
import be.helha.groupe3.interfaces.ProduitManager;

public class SimpleProduitManager implements ProduitManager{
	
	private SimpleProduitManager instance=null;
	private List<Produit> listProduits;

	private SimpleProduitManager(){
		listProduits=new ArrayList<>();
	}
	@Override
	public List<Produit> getProduits() {
		// TODO Auto-generated method stub
		return listProduits;
	}

	@Override
	public void setProduits(List<Produit> produits) {
		// TODO Auto-generated method stub
		listProduits=produits;
	}

}
