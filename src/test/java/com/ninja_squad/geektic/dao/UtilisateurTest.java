package com.ninja_squad.geektic.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.geektic.service.UtilisateurService;
import com.ninja_squad.geektic.metier.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UtilisateurTest {
	
	private UtilisateurDAO mockedutilisateurDao;
	private UtilisateurService utilisateurService;
	private List<Utilisateur> utils;
	
	private List<Utilisateur> pythonJavaInterests = new ArrayList<Utilisateur>();
	private List<Utilisateur> pythonInterests = new ArrayList<Utilisateur>();
	
	@Before
	public void setUp() {
	}
	
	@Test
	public void testRechercheParSexe() {
		List<CentreInteret> liste = new ArrayList<CentreInteret>();
		CentreInteret interet = new CentreInteret();
		interet.setId(1);
		interet.setLibelle("C#");
		liste.add(interet);
		
		mockedutilisateurDao = mock(UtilisateurDAO.class);
		utilisateurService = new UtilisateurService(mockedutilisateurDao);
		utils = new ArrayList<Utilisateur>();
		Utilisateur util1 = new Utilisateur(1, "Lagrange", "Romain", "homme", "r.lagrange@fazae.com");
		Utilisateur util2 = new Utilisateur(2, "Gautheron", "Thibaut", "femme", "t.gautheron@fazae.com");
		Utilisateur util3 = new Utilisateur(3, "Cavet", "Amaury", "homme", "acavet@fazae.com");
		util1.setInterets(liste);
		util2.setInterets(liste);
		util3.setInterets(liste);

		utils.add(util1);
		utils.add(util2);
		utils.add(util3);
		
		List<Integer> listeIdInteret = new ArrayList<>();
		listeIdInteret.add(1);
		
		List<Utilisateur> utilisateursFound = new ArrayList<Utilisateur>();
		when(mockedutilisateurDao.findAll()).thenReturn(utilisateursFound);
		assertEquals(utilisateurService.index().size(), 3);
		
		when(mockedutilisateurDao.findByInterestAndSexe(listeIdInteret, "homme")).thenReturn(utilisateursFound);
		assertEquals(utilisateurService.showByInterestAndSexe("1,2,3", "homme").size(), 2);
	}
	

}
