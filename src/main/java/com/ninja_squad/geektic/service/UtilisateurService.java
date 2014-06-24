package com.ninja_squad.geektic.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;



import com.ninja_squad.geektic.dao.UtilisateurDAO;
import com.ninja_squad.geektic.metier.Utilisateur;

@RestController
@Transactional
@RequestMapping("/api/utilisateur")
public class UtilisateurService {
	
	private static EntityManagerFactory emFactory;
	private EntityManager em;
	
	public UtilisateurService() {
		emFactory = Persistence.createEntityManagerFactory("GEEKTIC");
		em = emFactory.createEntityManager();
	}
	
	@RequestMapping(value="/show/{id}", method = RequestMethod.GET)
	public Utilisateur show(@PathVariable("id") Integer id) {
		UtilisateurDAO udao = new UtilisateurDAO(em);
		return udao.find(id);
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public List<Utilisateur> index() {
		UtilisateurDAO udao = new UtilisateurDAO(em);
		return udao.findAll();
	}
}
