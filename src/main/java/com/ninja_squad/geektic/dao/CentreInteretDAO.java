package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.metier.CentreInteret;
import com.ninja_squad.geektic.metier.Utilisateur;

@Repository
public class CentreInteretDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<CentreInteret> findAll() {
		String jpql = "select c from CentreInteret as c"; 
		TypedQuery<CentreInteret> query = em.createQuery(jpql, CentreInteret.class); 
		List<CentreInteret> centreinterets = query.getResultList();
		return centreinterets;
	}
	
	public void persist(CentreInteret ci) {
		em.persist(ci);
	}	
}
