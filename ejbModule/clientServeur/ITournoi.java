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
	 * première colonne=idUtililsateur, deuxième colonne=idPlace
	 * @return int[idUtilisateur][idPlace]
	 */
	int[][] getClassement();
	
	/**
	 * ID du JEU (à récupèrer via enum)
	 * @return id jeu
	 */
	int getIDJeu();
	
	/**
	 * ID du type Tournoi 0=championnat, 1=élimination directe
	 * @return le type de tournoi
	 */
	int getTypeTournoi();
}
