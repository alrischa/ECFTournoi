package clientServeur;
/**
 * Interface de manipulation des Tournois
 * Permet de declarer les Tournois termin�s ainsi que les Tournois pay�s
 * @author GuillaumeO
 *
 */
public interface IFonctionnalit�Tournoi {
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************

	/**
	 * indique que le Tournoi a �t� jou�
	 * @return true or false
	 */
	 boolean setTournoiTermine();
	
	/**
	 * indique le paiement d'un Tournoi effectu�
	 * @return true or false
	 */
	 boolean setTournoiPaye();
	
	
}
