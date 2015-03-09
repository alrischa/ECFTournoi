package gestionTournoi;

import java.sql.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import metier.Tournoi;
import dao.DaoFacadeTournoi;

/**
 * Class GestionTournoi
 * implemente l'interface IGestionTournoi
 * Transmet à la couche DAO les demandes relative à la gestion de Tournoi de la couche de service 
 * @author GuillaumeO
 *
 */

@Singleton
@LocalBean
public class GestionTournoi implements IGestionTournoi {
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	@EJB
	private DaoFacadeTournoi dao;

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public void supprimerTournoi(Tournoi tournoi) {
		dao.supprimerTournoi(tournoi);		
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public Tournoi creerTournoi(int idCreateur,
			String nomTournoi, Date datTournoi, Date datLimInscrTournoi, String lieuTournoi) {
		// A NE PAS UTILISER DANS DAO!!!
		return null;
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public Tournoi ajouterTournoiDao(Tournoi tournoi) {
		return dao.ajouterTournoiDao(tournoi);
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public Tournoi modifierTournoi(Tournoi tournoi) {
		return dao.modifierTournoi(tournoi);
	}

}
