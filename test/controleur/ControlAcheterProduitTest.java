package controleur;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;

import personnages.Chef;
import villagegaulois.Village;
import personnages.Gaulois;
import villagegaulois.Etal;
import controleur.ControlVerifierIdentite;
import controleur.ControlTrouverEtalVendeur;

	

class ControlAcheterProduitTest {
	private Village village;
	private Chef abraracourcix;
	private controleur.ControlAcheterProduit ControlAcheterProduit;
	private ControlVerifierIdentite controlVerifierIdentite;
    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
    private ControlEmmenager controlEmmenager;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("New Village", 20, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlVerifierIdentite  = new ControlVerifierIdentite(village);
        controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlEmmenager = new ControlEmmenager(village);
        ControlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);	}


	@Test
	void testControlAcheterProduit() {
		assertNotNull(ControlAcheterProduit, "Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(ControlAcheterProduit.verifierIdentite("Abraracourcix"));
        assertFalse(ControlAcheterProduit.verifierIdentite("NonExistant"));
        controlEmmenager.ajouterGaulois("BOnemine", 10);
		assertTrue(ControlAcheterProduit.verifierIdentite("BOnemine"));
	}

	@Test
	void testIsVendeur() {
		assertFalse(ControlAcheterProduit.isVendeur("Existe pas"));
	    assertFalse(ControlAcheterProduit.isVendeur("Abraracourcix"));

		
		Gaulois vendeur = new Gaulois("Vendeur1", 10);
		village.ajouterHabitant(vendeur);
	    village.installerVendeur(vendeur, "fleur", 5); 
	    assertTrue(ControlAcheterProduit.isVendeur("Vendeur1")); 		

	}

	@Test
	void testPropositionsVendeur() {
		fail("Not yet implemented");
	}

	@Test
	void testAcheterProduit() {
		etalVendeur.getQuantite() = 0;
		assertEquals(ControlAcheterProduit.acheterProduit("fleur", 10), 0);
		Gaulois vendeur = new Gaulois("Vendeur2", 10);
		village.ajouterHabitant(vendeur);
	    village.installerVendeur(vendeur, "viande", 5); 
	    assertEquals(ControlAcheterProduit.acheterProduit("viande", 5), 5);
	    Gaulois vendeur2 = new Gaulois("Vendeur3", 10);
		village.ajouterHabitant(vendeur2);
	    village.installerVendeur(vendeur2, "poisson", 5); 
	    assertEquals(ControlAcheterProduit.acheterProduit("poisson", 6), 5);


	    
    
	    
	}

}
