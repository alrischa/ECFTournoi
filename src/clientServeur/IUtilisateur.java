package clientServeur;
/**
 * Interface de l'Utilisateur
 * @author LaurentB
 *
 */
public interface IUtilisateur {
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************

	/**
	 * Retourne l'id de l'utilisateur
	 * @return id de l'utilisateur
	 */
	int getIdUser();
	
	/**
	 * Retourne le PSEUDO de l'utilisateur
	 * @return pseudo
	 */
	String getPseudo();
	
	/**
	 * retourne true si l'Utilisateur mis en paramètre est le même que l'utilisateur testé
	 * @param utilisateur utilisateur à tester
	 * @return true si même utilisateur false si non
	 */
	boolean isItMe(IUtilisateur utilisateur);

}
