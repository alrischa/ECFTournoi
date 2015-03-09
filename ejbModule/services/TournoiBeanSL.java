package services;

import gestionTournoi.GestionTournoi;
import inscriptionTournoi.InscriptionTournoi;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import metier.Tournoi;
import metier.Utilisateur;
import cSGestionTournoi.ITournoiServices;
import consultationTournoi.ConsultationTournoi;
import dao.DaoException;

/**
 * Façade de la couche service de l'application Tournoi.
 * Reçoit les demandes en provenance de la couche client.
 * Dispatches ces demandes à 3 EJB différents en fonction du types de requete.
 * Implemente l'interface ITournoiServices
 * Est referencée dans l'annuaire des services JNDI via le même interface.
 * @author GuillaumeO
 *
 */

@Stateless
@Remote(ITournoiServices.class)
public class TournoiBeanSL implements ITournoiServices{
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	@EJB
	private ConsultationTournoi consultation;
	@EJB
	private InscriptionTournoi inscription;
	@EJB
	private GestionTournoi gestion;
	@EJB
	private FabriqueTournoi fabrique;

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 *  
	 */
	@Override
	public List<Tournoi> consulter() {
		return consultation.consulter();
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public List<Tournoi> consulterByNom() {
		return consultation.consulterByNom();
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public List<Tournoi> consulterByJeu() {
		return consultation.consulterByJeu();
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public List<Tournoi> consulterByDate() {
		return consultation.consulterByDate();
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public Tournoi rechercherById (int idTournoi) {
		return consultation.rechercherById(idTournoi);
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public Tournoi creerTournoi(int idCreateur,
			String nomTournoi, java.sql.Date datTournoi, java.sql.Date datLimInscrTournoi, String lieuTournoi) {
		return fabrique.fabriqueTournoi(idCreateur,nomTournoi, datTournoi,datLimInscrTournoi, lieuTournoi);
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public Tournoi ajouterTournoiDao(Tournoi tournoi) {
		//A N'UTILISER QUE DANS DAO!!!
		return null;
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public Tournoi modifierTournoi(Tournoi tournoi) {
		// TODO A FAIRE!!! CETTE METHODE DOIT FAIRE INTERVENIR LA FABRIQUE
		return gestion.modifierTournoi(tournoi);
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public void supprimerTournoi(Tournoi tournoi) {
		gestion.supprimerTournoi(tournoi);		
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public void inscrireTournoi(Tournoi tournoi, Utilisateur utilisateur) throws DaoException{
		inscription.inscrireTournoi(tournoi, utilisateur);		
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public void desinscrireTournoi(Tournoi tournoi, Utilisateur utilisateur) throws DaoException {
		inscription.desinscrireTournoi(tournoi, utilisateur);		
	}

}
