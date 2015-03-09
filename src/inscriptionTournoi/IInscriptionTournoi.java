package inscriptionTournoi;

import dao.DaoException;
import metier.Tournoi;
import metier.Utilisateur;

/**
 * 
 * @author GuillaumeO
 *
 */

public interface IInscriptionTournoi {
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************

	public void inscrireTournoi (Tournoi tournoi, Utilisateur utilisateur) throws DaoException;
	public void desinscrireTournoi (Tournoi tournoi, Utilisateur utilisateur) throws DaoException;
	
}
