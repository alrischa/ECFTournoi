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
	 * retourne true si l'Utilisateur mis en param�tre est le m�me que l'utilisateur test�
	 * @param utilisateur utilisateur � tester
	 * @return true si m�me utilisateur false si non
	 */
	boolean isItMe(IUtilisateur utilisateur);

}
