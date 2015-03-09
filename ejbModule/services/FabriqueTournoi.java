package services;
import java.sql.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import metier.Tournoi;
import dao.DaoFacadeTournoi;


/**
 * Classe de fabrique de Tournoi
 * Reçoit des parametres en entrées afin d'utiliser le constructeur de l'entity Tournoi.
 * Genere un nouvel identifiant unique grace à la methode rechercherMax() de la couche DAO
 * et envoie le Tournoi a persister grace à la methode ajouterTournoiDAO
 */

@Singleton
@LocalBean
public class FabriqueTournoi {
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	@EJB
	DaoFacadeTournoi dao;

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * Methode de fabrication d'un nouveau tournoi.
	 * @param idCreateur
	 * @param nomTournoi
	 * @param datTournoi
	 * @param datLimInscrTournoi
	 * @param lieuTournoi
	 * @return
	 */
	public Tournoi fabriqueTournoi (int idCreateur, String nomTournoi,
			Date datTournoi, Date datLimInscrTournoi, String lieuTournoi) {

		Tournoi tournoi = new Tournoi (dao.rechercherMax(),idCreateur,nomTournoi,datTournoi,datLimInscrTournoi, lieuTournoi);
		dao.ajouterTournoiDao(tournoi);

		return tournoi;
	}
}