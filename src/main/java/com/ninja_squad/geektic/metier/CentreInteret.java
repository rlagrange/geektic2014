package com.ninja_squad.geektic.metier;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="CENTRE_INTERET")
public class CentreInteret {
	
	@Id
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String libelle;
	
	public String getLibelle() {
		return libelle;
	}
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	private List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	private void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	@JsonIgnore
	@ManyToMany
	@JoinTable(
      name="UTILISATEUR_A_CENTRE_INTERET",
      joinColumns=@JoinColumn(name="id_centre_interet", referencedColumnName="id"),
      inverseJoinColumns=@JoinColumn(name="id_utilisateur", referencedColumnName="id")
    )
	private List<Utilisateur> utilisateurs;
}
