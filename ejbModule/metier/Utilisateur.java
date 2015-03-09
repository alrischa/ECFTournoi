package metier;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import clientServeur.IUtilisateur;

/**
 * 
 * @author GuillaumeO
 *
 */

@Entity
public class Utilisateur implements IUtilisateur, Serializable{
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int idUtilisateur;
	private String pseudo;
	
	
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	public Utilisateur (){
		
	}
	
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	public Utilisateur(int idUtilisateur, String pseudo) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.pseudo = pseudo;
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	@Override
	public int getIdUser() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getPseudo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isItMe(IUtilisateur utilisateur) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", pseudo="
				+ pseudo + "]";
	}

	
	
}
