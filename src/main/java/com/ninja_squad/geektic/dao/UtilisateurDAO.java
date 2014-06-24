package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ninja_squad.geektic.metier.Utilisateur;

public class UtilisateurDAO {

	private EntityManager entityManager;
	
	public UtilisateurDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public Utilisateur find(int id) {
		return entityManager.find(Utilisateur.class, id);
	}
	
	public List<Utilisateur> findAll() {
		String jpql = "select u from Utilisateur as u"; 
		TypedQuery<Utilisateur> query = entityManager.createQuery(jpql, Utilisateur.class); 
		List<Utilisateur> utilisateurs = query.getResultList();
		return utilisateurs;
	}
}
