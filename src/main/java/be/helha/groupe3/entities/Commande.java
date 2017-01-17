package be.helha.groupe3.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
		@NamedQuery(name="CommandeFindAll.FindAll",
				query="SELECT c from Commande c")
})

public class Commande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String date;
	private double prixCommande;
	private Boolean isPaid;
	private Boolean isSend;
	private Integer identifiantAcheteur;

	@ManyToOne
	private Panier produitCommande;
	
	@ManyToOne
	private Acheteur acheteur;

	private String lieuLivraison;

	//----------------------------Constructor-----------------------------
	
	public Commande(){}
	//Constructeur avec ID pour la Commande
	public Commande(Integer id,String date,Panier produitCommande,Acheteur acheteur,String lieuLivraison){
		setId(id);
		setDate(date);
		setProduitCommande(produitCommande);
		setIdentifiantAcheteur(acheteur.getID());
		setLieuLivraison(lieuLivraison);
	}
	
	
	//Constructeur sans utilisation de l'ID pour la Commande
	public Commande(String date,Panier produitCommande,Acheteur acheteur,String lieuLivraison){
		setDate(date);
		setProduitCommande(produitCommande);
		setIdentifiantAcheteur(acheteur.getID());
		setLieuLivraison(lieuLivraison);
	}
	
	
	//--------------------------Getter & Setter --------------------------------
	
	public double getPrixCommande() {
		return prixCommande;
	}
	public void setPrixCommande(double prixCommande) {
		this.prixCommande = prixCommande;
	}
	public Boolean getIsPaid() {
		return isPaid;
	}
	public void setIsPaid(Boolean isPaid) {
		this.isPaid = isPaid;
	}
	public Boolean getIsSend() {
		return isSend;
	}
	public void setIsSend(Boolean isSend) {
		this.isSend = isSend;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Panier getProduitCommande() {
		return produitCommande;
	}
	public void setProduitCommande(Panier produitCommande) {
		this.produitCommande = produitCommande;
	}
	public Integer getIdentifiantAcheteur() {
		return identifiantAcheteur;
	}
	public void setIdentifiantAcheteur(Integer identifiantAcheteur) {
		this.identifiantAcheteur = identifiantAcheteur;
	}
	public String getLieuLivraison() {
		return lieuLivraison;
	}
	public void setLieuLivraison(String lieuLivraison) {
		this.lieuLivraison = lieuLivraison;
	}
	
	
	//-------------------------------otherMethods()----------------------------
	
	@Override
	public String toString() {
		return "Commande [id=" + id + ", date=" + date + ", produitCommande=" + produitCommande
				+ ", identifiantAcheteur=" + identifiantAcheteur+ ", lieuLivraison=" + lieuLivraison + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commande other = (Commande) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

		

	


}
