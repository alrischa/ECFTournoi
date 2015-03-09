package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import metier.Tournoi;
import clientServeur.ITournoi;
import consultationTournoi.IConsultationTournoi;

/**
 * Class DaoConsultationTournoi
 * Reçoit les demandes dispatchées de la façade DAO.
 * Implemente l'interface IConsultationTournoi.
 * S'occupe des demandes de persistence de la couche service.
 * @author GuillaumeO
 */

@Singleton
@LocalBean
public class DaoConsultationTournoi implements IConsultationTournoi{
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	@PersistenceContext(unitName="A1Persistence")
	private  EntityManager em;
	
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * Methode de listage de la liste des Tournois
	 * Effectue une requete dans la base Tournoi pour retourner une liste non triée.
	 */
	@Override
	public List<Tournoi> consulter() {
		
			
			@SuppressWarnings("unchecked")
			List <Tournoi> listTournoi = em.createQuery("select p from Tournoi p" ).getResultList();
			
			if(listTournoi.size()>0)System.out.println("Tournoi : " + (ITournoi)listTournoi.get(0));
			
			return listTournoi;
		}		

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * Methode de listage de la liste des Tournois par nom
	 * Effectue une requete dans la base Tournoi pour retourner une liste triée par nom
	 */
	@Override
	public List<Tournoi> consulterByNom() {
		@SuppressWarnings("unchecked")
		List <Tournoi> listTournoi = em.createQuery("select p from Tournoi p order by p.nomTournoi" ).getResultList();
		
		if(listTournoi.size()>0)System.out.println("Tournoi par nom: " + (ITournoi)listTournoi.get(0));
		
		return listTournoi;
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * Methode de listage de la liste des Tournois par jeu
	 * Effectue une requete dans la base Tournoi pour retourner une liste triée par jeu
	 */
	@Override
	public List<Tournoi> consulterByJeu() {
		@SuppressWarnings("unchecked")
		List <Tournoi> listTournoi = em.createQuery("select p from Tournoi p order by p.jeuxTournoi" ).getResultList();
		
		if(listTournoi.size()>0)System.out.println("Tournoi par jeu: " + (ITournoi)listTournoi.get(0));
		
		return listTournoi;
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * Methode de listage de la liste des Tournois par date
	 * Effectue une requete dans la base Tournoi pour retourner une liste triée par date
	 */
	@Override
	public List<Tournoi> consulterByDate() {
		@SuppressWarnings("unchecked")
		List <Tournoi> listTournoi = em.createQuery("select p from Tournoi p order by p.datTournoi" ).getResultList();
		
		if(listTournoi.size()>0)System.out.println("Tournoi par date: " + (ITournoi)listTournoi.get(0));
		
		return listTournoi;
	}
	
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * Methode de recherche d'un Tournoi par son identifiant.
	 * Retourne le Tournoi recherché
	 */
	@Override
	public Tournoi rechercherById (int idTournoi) {
		return em.find(Tournoi.class, idTournoi);
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * Methode de recherche de l'identifiant maximum de la base Tournoi
	 * @return l'identifiant + 1
	 */
	public int rechercherMax () { 
		 Integer idMax = (Integer) em.createQuery("select max(idTournoi) from Tournoi p").getSingleResult();
		 if (idMax == null) idMax = 0;
		return idMax + 1;
	}
	
	
}
