package com.ninja_squad.geektic.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@Autowired
	private UtilisateurDAO udao;
	
	public UtilisateurService() {
	}
	
	@RequestMapping(value="/show/{id}", method = RequestMethod.GET)
	public Utilisateur show(@PathVariable("id") Integer id) {
		return udao.find(id);
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public List<Utilisateur> index() {
		return udao.findAll();
	}
	
	@RequestMapping(value="/showByInterestAndSexe", method = RequestMethod.GET)
	public List<Utilisateur> showByInterestAndSexe(
			@RequestParam("interests") String interests, @RequestParam("sexe") String sexe	
			) {
		List<Integer> ints = new ArrayList<Integer>();
		String[] temp = interests.split(",");
		for (String i : temp) {
			ints.add(Integer.parseInt(i));
		}
		return udao.findByInterestAndSexe(ints, sexe);
	}
}
