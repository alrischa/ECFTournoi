package inscriptionTournoi;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import metier.Tournoi;
import metier.Utilisateur;
import dao.DaoException;
import dao.DaoFacadeTournoi;

/**
 * Class InscriptionTournoi
 * implemente l'interface IInscriptionTournoi
 * Transmet à la couche DAO les demandes relative aux inscriptions aux Tournois de la couche de service 
 */

@Singleton
@LocalBean
public class InscriptionTournoi implements IInscriptionTournoi {
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	@EJB
	private DaoFacadeTournoi dao;

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * @Override
	 */
	public void inscrireTournoi(Tournoi tournoi, Utilisateur utilisateur) throws DaoException{
		dao.inscrireTournoi(tournoi, utilisateur);		
	}

	/**
	 * 
	 */
	@Override
	public void desinscrireTournoi(Tournoi tournoi, Utilisateur utilisateur) throws DaoException{
		dao.desinscrireTournoi(tournoi, utilisateur);
	}

}
