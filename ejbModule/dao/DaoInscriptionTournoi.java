package dao;

import inscriptionTournoi.IInscriptionTournoi;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import metier.Tournoi;
import metier.Utilisateur;

/**
 * Class DaoInscriptionTournoi
 * Re�oit les demandes dispatch�es de la fa�ade DAO.
 * Implemente l'interface IInscriptionTournoi.
 * S'occupe des demandes de persistence de la couche service.
 * @author GuillaumeO
 */

@Singleton
@LocalBean
public class DaoInscriptionTournoi implements IInscriptionTournoi{
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	@PersistenceContext(unitName="A1Persistence")
	private  EntityManager em;

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * Methode d'inscription � un Tournoi
	 */
	//Cette methode n'a pour but que de lever une exception systematiquement avec une condition forcement juste.
	@Override
	public void inscrireTournoi(Tournoi tournoi, Utilisateur utilisateur)throws DaoException{
		if (utilisateur!=null)
			throw new DaoException("Exception lev�e : Les inscriptions ne sont actuellement pas prise en charge", 1000);
		else System.out.println("exception non lev�e.");

		// TODO A IMPLEMENTER SI RESTE DU TEMPS
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * Methode de desinscription � un Tournoi
	 */
	@Override
	public void desinscrireTournoi(Tournoi tournoi, Utilisateur utilisateur) throws DaoException{
		// TODO A IMPLEMENTER SI RESTE DU TEMPS
	}

}
