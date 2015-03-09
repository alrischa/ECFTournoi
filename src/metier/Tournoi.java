package metier;

import java.io.Serializable;
import java.util.Arrays;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import clientServeur.ITournoi;

/**
 * 
 * @author GuillaumeO
 *
 */

@Entity
public class Tournoi implements Serializable, ITournoi{
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************

	/**
	 * 
	 */
	
	//Parametres de la classe Tournoi ***********************************************************************
	//*******************************************************************************************************
	private static final long serialVersionUID = 1L;
	
	@Id
	private int idTournoi;
	private int idCreateur;
	private String nomTournoi;
	private String lieuTournoi;
	private int [][] classementTournoi;
	private int jeuxTournoi;
	private int etatTournoi;
	private Date datTournoi;
	private Date datLimInscrTournoi;
	
	
	//Constructeur par defaut de la classe Tournoi***********************************************************
	//*******************************************************************************************************
	public Tournoi(){								//Utilisé par l'Entity Manager uniquement.
		
	}
	
	//Constructeur paramétré*********************************************************************************
	//*******************************************************************************************************
	public Tournoi(int idTournoi, int idCreateur, String nomTournoi,
			Date datTournoi, Date datLimInscrTournoi, String lieuTournoi) {
		super();
		this.idTournoi = idTournoi;
		this.idCreateur = idCreateur;
		this.nomTournoi = nomTournoi;
		this.datTournoi = datTournoi;
		this.datLimInscrTournoi = datLimInscrTournoi;
		this.lieuTournoi = lieuTournoi;
	}
	
	//Methodes de la classe Tournoi**************************************************************************
	//*******************************************************************************************************
	@Override
	public int getIDTournoi() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[][] getClassement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIDJeu() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTypeTournoi() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getIdTournoi() {
		return idTournoi;
	}

	public void setIdTournoi(int idTournoi) {
		this.idTournoi = idTournoi;
	}

	public int getIdCreateur() {
		return idCreateur;
	}

	public void setIdCreateur(int idCreateur) {
		this.idCreateur = idCreateur;
	}

	public String getNomTournoi() {
		return nomTournoi;
	}

	public void setNomTournoi(String nomTournoi) {
		this.nomTournoi = nomTournoi;
	}

	public int getJeuxTournoi() {
		return jeuxTournoi;
	}

	public void setJeuxTournoi(int jeuxTournoi) {
		this.jeuxTournoi = jeuxTournoi;
	}

	public Date getDatTournoi() {
		return datTournoi;
	}

	public void setDatTournoi(Date datTournoi) {
		this.datTournoi = datTournoi;
	}

	public Date getDatLimInscrTournoi() {
		return datLimInscrTournoi;
	}

	public void setDatLimInscrTournoi(Date datLimInscrTournoi) {
		this.datLimInscrTournoi = datLimInscrTournoi;
	}

	@Override
	public String toString() {
		return "Tournoi [idTournoi=" + idTournoi + ", idCreateur=" + idCreateur
				+ ", nomTournoi=" + nomTournoi + ", classementTournoi="
				+ Arrays.toString(classementTournoi) + ", jeuxTournoi="
				+ jeuxTournoi + ", etatTournoi=" + etatTournoi
				+ ", datTournoi=" + datTournoi + ", datLimInscrTournoi="
				+ datLimInscrTournoi + "]";
	}

	public String getLieuTournoi() {
		return lieuTournoi;
	}

	public void setLieuTournoi(String lieuTournoi) {
		this.lieuTournoi = lieuTournoi;
	}

	public int[][] getClassementTournoi() {
		return classementTournoi;
	}

	public void setClassementTournoi(int[][] classementTournoi) {
		this.classementTournoi = classementTournoi;
	}

	public int getEtatTournoi() {
		return etatTournoi;
	}

	public void setEtatTournoi(int etatTournoi) {
		this.etatTournoi = etatTournoi;
	}

}
