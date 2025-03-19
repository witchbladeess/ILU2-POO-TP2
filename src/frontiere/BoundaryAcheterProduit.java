package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean nomAcheteurConnu = controlAcheterProduit.verifierIdentite(nomAcheteur);
		if (!nomAcheteurConnu) {
			System.out.println("Je suis desolee "+nomAcheteur+" mais il faut etre un habitant de notre village pour commercer ici.\n");
			return;
		}
		String produitAcheter = Clavier.entrerChaine("Quel produit voulez vous acheter ?");
		String [] propositionVendeurs = controlAcheterProduit.propositionsVendeur(produitAcheter);
		if (propositionVendeurs == null || propositionVendeurs.length == 0) {
	           System.out.println("Désolée, personne ne vend ce produit sur le marché.\n");
	           return; 
	       }
        System.out.println("Chez quel commerçant voulez-vous acheter des " + produitAcheter + " ?");
        for (int i = 0; i < propositionVendeurs.length; i++) {
            System.out.println((i + 1) + " - " + propositionVendeurs[i]);
        }

        int choixVendeur = Clavier.entrerEntier("Entrez le numéro du commerçant que vous avez choisi: ");
        while (choixVendeur < 1 || choixVendeur > propositionVendeurs.length) {
            System.out.println("Ce numéro n'est pas proposé.\n");
            choixVendeur = Clavier.entrerEntier("Entrez le numéro du commerçant que vous avez choisi: ");
        }
		String nomVendeur = propositionVendeurs[choixVendeur - 1];
		System.out.println(nomAcheteur+" se deplace jusqu'a l'etal du vendeur "+nomVendeur+".\n");
		int quantite = Clavier.entrerEntier("Bonjour "+nomAcheteur+"\nCombien de "+produitAcheter+" voulez-vous acheter ?\n");
		int resultatAchat = controlAcheterProduit.acheterProduit(nomVendeur,quantite);
		
		if(resultatAchat==0) {
			System.out.println(nomAcheteur+" veut acheter "+quantite+" "+produitAcheter+", malheureusement il n'y en a plus!\n");
		}else if(resultatAchat==quantite) {
			System.out.println(nomAcheteur+" achete "+quantite+" a "+nomVendeur+".\n"); 
		}else {
			System.out.println(nomAcheteur+" veut acheter "+quantite+" "+produitAcheter+" mais malheureusement, "+nomVendeur+ " n'en a plus que "+resultatAchat+". "+nomAcheteur+ "achete tout le stock de "+nomVendeur);
		}
		}
		
	}

