package com.ninja_squad.geektic.metier;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="UTILISATEUR")
@Inheritance(strategy = InheritanceType.JOINED)
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
	
	@ManyToMany(mappedBy = "utilisateurs")
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
	
	public Utilisateur() {
		
	}
	
	public Utilisateur(Integer id, String nom, String prenom, String sexe, String mail) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.mail = mail;
	}

}
