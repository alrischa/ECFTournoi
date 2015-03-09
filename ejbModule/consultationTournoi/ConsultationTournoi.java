package consultationTournoi;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import metier.Tournoi;
import dao.DaoFacadeTournoi;

/**
 * Class GestionTournoi
 * implemente l'interface IConsultationTournoi
 * Transmet à la couche DAO les demandes relative à la consultation des Tournois de la couche de service 
 * @author GuillaumeO
 */

@Singleton
@LocalBean
public class ConsultationTournoi implements IConsultationTournoi{
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
	public List<Tournoi> consulter() {
		return dao.consulter();
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public List<Tournoi> consulterByNom() {
		return dao.consulterByNom();
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public List<Tournoi> consulterByJeu() {
		return dao.consulterByJeu();
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public List<Tournoi> consulterByDate() {
		return dao.consulterByDate();
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * 
	 */
	@Override
	public Tournoi rechercherById (int idTournoi) {
		return dao.rechercherById(idTournoi);
	}

}
