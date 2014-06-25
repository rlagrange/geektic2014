package com.ninja_squad.geektic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.ninja_squad.geektic.dao.CentreInteretDAO;
import com.ninja_squad.geektic.dao.UtilisateurDAO;
import com.ninja_squad.geektic.metier.CentreInteret;
import com.ninja_squad.geektic.metier.Utilisateur;

@RestController
@Transactional
@RequestMapping("/api/centre_interet")
public class CentreInteretService {
	
	@Autowired
	CentreInteretDAO cdao;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public List<CentreInteret> index() {
		return cdao.findAll();
	}
}
