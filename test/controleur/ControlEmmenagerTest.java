package controleur;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;

import personnages.Chef;
import villagegaulois.Village;
class ControlEmmenagerTest {
	private Village village;
	private Chef abraracourcix;
	private ControlEmmenager controlEmmenager;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("New Village", 20, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlEmmenager = new ControlEmmenager(village);
	}

	@Test
	void testControlEmmenager() {
		assertNotNull(controlEmmenager, "Constructeur ne renvoie pas null");
	}

	@Test
	void testIsHabitant() {
		assertTrue(controlEmmenager.isHabitant("Abraracourcix"));
		controlEmmenager.ajouterGaulois("BOnemine", 10);
		assertTrue(controlEmmenager.isHabitant("BOnemine"));
		assertTrue(controlEmmenager.isHabitant("Abraracourcix"));
		controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
		assertFalse(controlEmmenager.isHabitant("Existe pas"));
	}

	@Test
	void testAjouterDruide() {
		assertFalse(controlEmmenager.isHabitant("Druide"));
		controlEmmenager.ajouterDruide("Druide", 10, 1, 5);
		assertTrue(controlEmmenager.isHabitant("Druide"));
	}

	@Test
	void testAjouterGaulois() {
		assertFalse(controlEmmenager.isHabitant("Bonemine"));
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
		assertFalse(controlEmmenager.isHabitant("Existe pas"));
	}
	
	@Test
	void testTropDeHabitants() {
		for (int i = 0; i < 100; i++) {
			controlEmmenager.ajouterGaulois("GAULOIS_" + i, 10);
		}
		for (int i = 0; i < 100; i++) {
			if (i < 20) {
				assertTrue(controlEmmenager.isHabitant("GAULOIS_" + i));
			} else {
				assertFalse(controlEmmenager.isHabitant("GAULOIS_" + i));
			}
		}
	}
}
