package dao;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import metier.Tournoi;
import metier.Utilisateur;
import cSGestionTournoi.ITournoiServices;

/**
 * Façade DAO. Reçoit des demandes en provenances des LocalBean qui communiquent avec la façade TournoiBeanSL
 * Dispatche ces demandes aux bonnes couches DAO.
 * @author GuillaumeO
 *
 */

@Singleton
@LocalBean
public class DaoFacadeTournoi implements ITournoiServices{
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	@EJB
	private DaoConsultationTournoi daoConsultation;
	@EJB
	private DaoInscriptionTournoi daoInscription;
	@EJB
	private DaoGestionTournoi daoGestion;

	//I. TRANSMISSION A LA COUCHE DAOCONSULTATION
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public List<Tournoi> consulter() {
		return daoConsultation.consulter();
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public List<Tournoi> consulterByNom() {
		return daoConsultation.consulterByNom();
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public List<Tournoi> consulterByJeu() {
		return daoConsultation.consulterByJeu();
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public List<Tournoi> consulterByDate() {
		return daoConsultation.consulterByDate();
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public Tournoi rechercherById (int idTournoi) {
		return daoConsultation.rechercherById (idTournoi);
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 * @return
	 */
	public int rechercherMax () {
		return daoConsultation.rechercherMax ();
	}

	//II. TRANSMISSION A LA COUCHE DAOGESTION
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public void supprimerTournoi(Tournoi tournoi) {
		daoGestion.supprimerTournoi(tournoi);		
	}
	
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public Tournoi creerTournoi(int idCreateur,
			String nomTournoi, java.sql.Date datTournoi, java.sql.Date datLimInscrTournoi, String lieuTournoi) {
		//A NE PAS UTILISER DANS DAO
		return null;
	}
	
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public Tournoi ajouterTournoiDao(Tournoi tournoi) {
		return daoGestion.ajouterTournoiDao(tournoi);
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public Tournoi modifierTournoi(Tournoi tournoi) {
		// TODO Auto-generated method stub
		return daoGestion.modifierTournoi(tournoi);
	}
	
	//III. TRANSMISSION A LA COUCHE DAOINSCRIPTION
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public void inscrireTournoi(Tournoi tournoi, Utilisateur utilisateur)throws DaoException {
		daoInscription.inscrireTournoi(tournoi, utilisateur);
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public void desinscrireTournoi(Tournoi tournoi, Utilisateur utilisateur) throws DaoException{
		daoInscription.desinscrireTournoi(tournoi, utilisateur);
	}



}
