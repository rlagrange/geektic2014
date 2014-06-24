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

import com.ninja_squad.geektic.dao.CentreInteretDAO;
import com.ninja_squad.geektic.dao.UtilisateurDAO;
import com.ninja_squad.geektic.metier.CentreInteret;
import com.ninja_squad.geektic.metier.Utilisateur;

@RestController
@Transactional
@RequestMapping("/api/centre_interet")
public class CentreInteretService {
	
	private static EntityManagerFactory emFactory;
	private EntityManager em;
	
	public CentreInteretService() {
		emFactory = Persistence.createEntityManagerFactory("GEEKTIC");
		em = emFactory.createEntityManager();
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public List<CentreInteret> index() {
		CentreInteretDAO cdao = new CentreInteretDAO(em);
		return cdao.findAll();
	}
}
