package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.metier.Utilisateur;

@Repository
public class UtilisateurDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Utilisateur find(int id) {
		Utilisateur utilisateur = em.find(Utilisateur.class, id);
		Hibernate.initialize(utilisateur.getInterets());
		return utilisateur;
	}
	
	public List<Utilisateur> findAll() {
		String jpql = "select distinct(u) from Utilisateur as u LEFT JOIN FETCH u.interets as i"; 
		TypedQuery<Utilisateur> query = em.createQuery(jpql, Utilisateur.class); 
		List<Utilisateur> utilisateurs = query.getResultList();
		return utilisateurs;
	}
	
	public List<Utilisateur> findByInterestAndSexe(List<Integer> interests, String sexe) {
		String jpql = "select distinct(u) from Utilisateur as u LEFT JOIN FETCH u.interets as i"
				+ " where u.sexe = :sexe and i.id in :i_id";
		TypedQuery<Utilisateur> query = em.createQuery(jpql, Utilisateur.class);
		query.setParameter("sexe", sexe);
		query.setParameter("i_id", interests);
		List<Utilisateur> utilisateurs = query.getResultList();
		return utilisateurs;
	}
	
	public void persist(Utilisateur util) {
		em.persist(util);
	}	
}
