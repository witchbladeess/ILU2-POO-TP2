package controleur;

import villagegaulois.Village;
import personnages.Gaulois;


public class ControlVerifierIdentite {
	private Village village;

	public ControlVerifierIdentite(Village village) {
		this.village = village;
	}

	public boolean verifierIdentite(String nomVendeur) {
	Gaulois habitant = village.trouverHabitant(nomVendeur);
	if(habitant != null) {
		if(habitant.equals(village.getChef())) {
			return true;
		}
		return true;
		} else {
			return false;
		}
	}
}
