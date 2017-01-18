package be.helha.groupe3.interfaces;

import java.util.List;

import javax.ejb.Remote;

import be.helha.groupe3.entities.Produit;
import be.helha.groupe3.entities.UtilisateurEnregistre;

@Remote
public interface RemoteSiteManager {
	public List<Produit> getProduits();
	
	public List<UtilisateurEnregistre> getUsers();
	public void setUsers(List<UtilisateurEnregistre> users);
	public void createUser(UtilisateurEnregistre user);
}
