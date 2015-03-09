package clientServeur;
/**
 * Interface de manipulation des Tournois
 * Permet de declarer les Tournois terminés ainsi que les Tournois payés
 * @author GuillaumeO
 *
 */
public interface IFonctionnalitéTournoi {
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************

	/**
	 * indique que le Tournoi a été joué
	 * @return true or false
	 */
	 boolean setTournoiTermine();
	
	/**
	 * indique le paiement d'un Tournoi effectué
	 * @return true or false
	 */
	 boolean setTournoiPaye();
	
	
}
