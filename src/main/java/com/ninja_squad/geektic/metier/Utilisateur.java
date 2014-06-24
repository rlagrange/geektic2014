package com.ninja_squad.geektic.metier;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="UTILISATEUR")
public class Utilisateur {
	
	@Id
	@Column(name="ID")
	private Integer id;
	
	private String nom;
	
	private String prenom;
	
	private String sexe;
	
	private String mail;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@ManyToMany
	@JoinTable(
      name="UTILISATEUR_A_CENTRE_INTERET",
      joinColumns=@JoinColumn(name="id_utilisateur", referencedColumnName="id"),
      inverseJoinColumns=@JoinColumn(name="id_centre_interet", referencedColumnName="id")
    )
	private List<CentreInteret> interets;

	public List<CentreInteret> getInterets() {
		return interets;
	}
	public void setInterets(List<CentreInteret> interets) {
		this.interets = interets;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
}
