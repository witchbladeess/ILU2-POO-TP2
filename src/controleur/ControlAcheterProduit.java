package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public boolean verifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
		
	}
	
	public boolean isVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur) !=null;
	}
	
	public String[] propositionsVendeur(String produit) {
        Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
        String[] nomVendeurs = new String[vendeurs.length];
        for (int i = 0; i < vendeurs.length; i++) {
            nomVendeurs[i] = vendeurs[i].getNom();
        }
        return nomVendeurs;
    }
	public int acheterProduit(String nomVendeur, int quantite) {
		Etal etalVendeur = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		int quantiteEtal = etalVendeur.getQuantite();
		if(quantiteEtal==0) {
			return 0;
		}else if(quantiteEtal<quantite) {
			int quantiteAchetee = quantite - quantiteEtal;
			etalVendeur.acheterProduit(quantiteAchetee);
			return quantiteAchetee;
		}else {
			etalVendeur.acheterProduit(quantite);
			return quantite;
		}
	}
}
