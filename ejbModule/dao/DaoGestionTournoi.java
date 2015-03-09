package dao;

import gestionTournoi.IGestionTournoi;

import java.sql.Date;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import metier.Tournoi;

/**
 * Class DaoGestionTournoi
 * Reçoit les demandes dispatchées de la façade DAO.
 * Implemente l'interface IGestionTournoi.
 * S'occupe des demandes de persistence de la couche service.
 * @author GuillaumeO
 */

@Singleton
@LocalBean
public class DaoGestionTournoi implements IGestionTournoi{
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	@PersistenceContext(unitName="A1Persistence")
	private  EntityManager em;

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * Methode de suppression d'un Tournoi
	 * Supprimer un Tournoi de la base Tournoi
	 */
	@Override
	public void supprimerTournoi(Tournoi tournoi) {
		if (tournoi!=null)em.remove(em.merge(tournoi));

	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * Methode a ne pas utiliser dans DAO. Issue de l'implementation de l'interface IGestionTournoi
	 */
	@Override
	public Tournoi creerTournoi(int idCreateur,
			String nomTournoi, Date datTournoi, Date datLimInscrTournoi, String lieuTournoi) {
		//A NE PAS UTILISER DANS DAO!!!
		return null;
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * Methode de persistance d'un Tournoi
	 * Ajoute un Tournoi en base Tournoi.
	 * Retourne ce même Tournoi
	 */
	@Override
	public Tournoi ajouterTournoiDao(Tournoi tournoi) {
		em.persist(tournoi);
		return tournoi;
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * Methode de modification d'un Tournoi en base.
	 * Reçoit un Tournoi, le modifie et le retourne.
	 */
	@Override
	public Tournoi modifierTournoi(Tournoi tournoi) {
		em.createQuery("update Tournoi set nomTournoi = '" + tournoi.getNomTournoi() + "',lieuTournoi = '" + tournoi.getLieuTournoi() +  "',jeuxTournoi =  '" + tournoi.getJeuxTournoi() +  "',datTournoi =  '" + tournoi.getDatTournoi()  + "',datLimInscrTournoi =  '" + tournoi.getDatLimInscrTournoi()  + "' where IdTournoi = " + tournoi.getIdTournoi()).executeUpdate();
		System.out.println("update effectué");
		return tournoi;
	}

}
