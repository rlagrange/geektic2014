package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ninja_squad.geektic.metier.CentreInteret;
import com.ninja_squad.geektic.metier.Utilisateur;

public class CentreInteretDAO {
	
	private EntityManager entityManager;
	
	public CentreInteretDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<CentreInteret> findAll() {
		String jpql = "select c from CentreInteret as c"; 
		TypedQuery<CentreInteret> query = entityManager.createQuery(jpql, CentreInteret.class); 
		List<CentreInteret> centreinterets = query.getResultList();
		return centreinterets;
	}
}
