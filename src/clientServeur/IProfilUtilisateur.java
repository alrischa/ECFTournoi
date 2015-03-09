package clientServeur;
/**
 * Interface du Profil Utilisateur
 * Contient les points et les récompenses des utilisateurs
 * @author GuillaumeL
 *
 */
public interface IProfilUtilisateur {
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************

	/**
	 * return id de l'utilisateur
	 * @return id de l'utilisateur
	 */
	int getIdUser();
	
	/**
	 * retourne les points de l'utilisateur
	 * @return points de l'utilisateur
	 */
	int getPoints();
	
	/**
	 * int[idRecompense][idJeu] une récompense correspond au Jeu correspondant
	 * @return le tableau idRecompense/idJeu
	 */
	int[][] getRecompense(); 

	
}
