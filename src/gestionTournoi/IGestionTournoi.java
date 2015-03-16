package gestionTournoi;

import java.sql.Date;

import metier.Tournoi;
import metier.Utilisateur;

/**
 * 
 * @author GuillaumeO
 *
 */

public interface IGestionTournoi {
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	public Tournoi creerTournoi (Utilisateur createurTournoi,String nomTournoi,Date datTournoi,Date datLimInscrTournoi, String lieuTournoi);
	public Tournoi ajouterTournoiDao(Tournoi tournoi);
	public Tournoi modifierTournoi (Tournoi tournoi);
	public void supprimerTournoi (Tournoi tournoi);
	
}
