package consultationTournoi;

import java.util.List;

import metier.Tournoi;
import clientServeur.ITournoi;

/**
 * 
 * @author GuillaumeO
 *
 */

public interface IConsultationTournoi {
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	public List<Tournoi> consulter();
	public List<Tournoi> consulterByNom();
	public List<Tournoi> consulterByJeu();
	public List<Tournoi> consulterByDate();
	public Tournoi rechercherById (int idTournoi);
	
}
