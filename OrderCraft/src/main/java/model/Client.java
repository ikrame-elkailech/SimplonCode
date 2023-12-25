package model;

import java.io.Serializable;

public class Client implements Serializable {
	private int id;
	private String  nom;
	private String adresse;
	private String telephone;
	public Client() {
		super();
	}
	public Client(String nom, String adresse, String telephone) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
