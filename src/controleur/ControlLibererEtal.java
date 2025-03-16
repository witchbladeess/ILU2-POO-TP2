package controleur;
import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	/**
	 * 
	 * @param nomVendeur
	 * @return donneesEtal est un tableau de chaine contenant
	 * 		[0] : un boolean indiquant si l'étal est occupé
	 * 		[1] : nom du vendeur
	 * 		[2] : produit vendu
	 * 		[3] : quantité de produit à vendre au début du marché
	 * 		[4] : quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		String[] donneesEtal = new String[5];
		donneesEtal[0] = "false";  
        donneesEtal[1] = nomVendeur;
        donneesEtal[2] = "N/A";  
        donneesEtal[3] = "0";   
        donneesEtal[4] = "0";    
		if(etal!=null) {
			donneesEtal[0] = etal.isEtalOccupe() ? "true" : "false";
			donneesEtal[1] = nomVendeur;
			donneesEtal[2] = etal.getProduit();
			donneesEtal[3] = String.valueOf(etal.getQuantiteDebutMarche());
			donneesEtal[4] = String.valueOf(etal.getQuantiteDebutMarche()- etal.getQuantite());
		}
		return donneesEtal;
	}

}
