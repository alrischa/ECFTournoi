package clientServeur;
/**
 * Interface du Tournoi
 * @author GuillaumeO
 *
 */
public interface ITournoi {
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************

	/**
	 * ID du tournoi
	 * @return l'id du tournoi
	 */
	int getIDTournoi();
	
	/**
	 * retourne un classement sous forme d'int.
	 * premi�re colonne=idUtililsateur, deuxi�me colonne=idPlace
	 * @return int[idUtilisateur][idPlace]
	 */
	int[][] getClassement();
	
	/**
	 * ID du JEU (� r�cup�rer via enum)
	 * @return id jeu
	 */
	int getIDJeu();
	
	/**
	 * ID du type Tournoi 0=championnat, 1=�limination directe
	 * @return le type de tournoi
	 */
	int getTypeTournoi();
}
