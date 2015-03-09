package cSGestionTournoi;

import gestionTournoi.IGestionTournoi;
import inscriptionTournoi.IInscriptionTournoi;

import java.sql.Date;
import java.util.List;

import metier.Tournoi;
import metier.Utilisateur;
import consultationTournoi.IConsultationTournoi;
import dao.DaoException;

/**
 * 
 * 
 * @author GuillaumeO
 *
 */

public interface ITournoiServices extends IConsultationTournoi, IGestionTournoi, IInscriptionTournoi {
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
		

	public Tournoi creerTournoi (int idCreateur,String nomTournoi,Date datTournoi,Date datLimInscrTournoi, String LieuTournoi);
	public Tournoi modifierTournoi (Tournoi tournoi);
	public void supprimerTournoi (Tournoi tournoi);
	
	public void inscrireTournoi (Tournoi tournoi, Utilisateur utilisateur) throws DaoException;
	public void desinscrireTournoi (Tournoi tournoi, Utilisateur utilisateur) throws DaoException;
	
	public List<Tournoi> consulter();
	public List<Tournoi> consulterByNom();
	public List<Tournoi> consulterByJeu();
	public List<Tournoi> consulterByDate();
	public Tournoi rechercherById (int idTournoi);
	 
}
