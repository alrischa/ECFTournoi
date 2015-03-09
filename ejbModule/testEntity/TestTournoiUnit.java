package testEntity;

import static org.junit.Assert.*;

import java.sql.Date;

import metier.Tournoi;

import org.junit.Test;

public class TestTournoiUnit {
/**
 * Classe de test de l'entity Tournoi
 * @GuillaumeO
 */
	
	//***************************************************************************************************************************
	//***************************************************************************************************************************	
	/**
	 * Methode de test du constructeur paramétré
	 */
	@Test
	public void testTournoiIntIntStringDateDateString() {
		String dateS1 = "2015-02-26";
		String dateS2 = "2015-03-30";
		Date dateD1 = Date.valueOf(dateS1);
		Date dateD2 = Date.valueOf(dateS2);
		Tournoi tournoi = new Tournoi(123, 12, "test", dateD1, dateD2, "bandol");
		
		assertEquals(tournoi.getIdTournoi(), 123);
		assertEquals(tournoi.getIdCreateur(), 12);
		assertEquals(tournoi.getNomTournoi(), "test");
		assertEquals(tournoi.getDatTournoi(), dateD1);
		assertEquals(tournoi.getDatLimInscrTournoi(), dateD2);
		assertEquals(tournoi.getLieuTournoi(), "bandol");

		assertNotEquals(tournoi.getLieuTournoi(), "Roubaix");
		
	}

	//***************************************************************************************************************************
	//***************************************************************************************************************************	
	/**
	 * Méthode de test du getter d'Id du Tournoi
	 * 	 * @Test
	 */
	@Test
	public void testGetIDTournoi() {
		String dateS1 = "2015-02-26";
		String dateS2 = "2015-03-30";
		Date dateD1 = Date.valueOf(dateS1);
		Date dateD2 = Date.valueOf(dateS2);
		Tournoi tournoi = new Tournoi(123, 12, "test", dateD1, dateD2, "bandol");
		
		assertEquals(tournoi.getIdTournoi(), 123);

	}

	//***************************************************************************************************************************
	//***************************************************************************************************************************	
	/**
	 * Méthode de test du setter de l'id du Tournoi
	 * @Test
	 */
	public void testSetIdTournoi() {
		String dateS1 = "2015-02-26";
		String dateS2 = "2015-03-30";
		Date dateD1 = Date.valueOf(dateS1);
		Date dateD2 = Date.valueOf(dateS2);
		Tournoi tournoi = new Tournoi(123, 12, "test", dateD1, dateD2, "bandol");
		
		tournoi.setIdTournoi(6);
		
		assertEquals(tournoi.getIdTournoi(), 6);

	}

	//***************************************************************************************************************************
	//***************************************************************************************************************************	
	/**
	 * Methode de test du getter de l'id du créateur du Tournoi
	 * @Test
	 */
	public void testGetIdCreateur() {
		String dateS1 = "2015-02-26";
		String dateS2 = "2015-03-30";
		Date dateD1 = Date.valueOf(dateS1);
		Date dateD2 = Date.valueOf(dateS2);
		Tournoi tournoi = new Tournoi(123, 12, "test", dateD1, dateD2, "bandol");
				
		assertEquals(tournoi.getIdCreateur(), 12);
	}

	//***************************************************************************************************************************
	//***************************************************************************************************************************	
	/**
	 * Méthode de test du setter de l'id du createur de tournoi
	 * @Test
	 */
	public void testSetIdCreateur() {
		String dateS1 = "2015-02-26";
		String dateS2 = "2015-03-30";
		Date dateD1 = Date.valueOf(dateS1);
		Date dateD2 = Date.valueOf(dateS2);
		Tournoi tournoi = new Tournoi(123, 12, "test", dateD1, dateD2, "bandol");	
		
		tournoi.setIdCreateur(15);
		
		assertEquals(tournoi.getIdCreateur(), 15);	
	}

	//***************************************************************************************************************************
	//***************************************************************************************************************************	
	/**
	 * Méthode de test du getter du nom du Tournoi
	 * @Test
	 */
	public void testGetNomTournoi() {
		String dateS1 = "2015-02-26";
		String dateS2 = "2015-03-30";
		Date dateD1 = Date.valueOf(dateS1);
		Date dateD2 = Date.valueOf(dateS2);
		Tournoi tournoi = new Tournoi(123, 12, "test", dateD1, dateD2, "bandol");	
		
		assertEquals(tournoi.getNomTournoi(), "bandol");
	}

	//***************************************************************************************************************************
	//***************************************************************************************************************************	
	/**
	 * Methode de test du setter du nom du Tournoi
	 * @Test
	 */
	public void testSetNomTournoi() {
		String dateS1 = "2015-02-26";
		String dateS2 = "2015-03-30";
		Date dateD1 = Date.valueOf(dateS1);
		Date dateD2 = Date.valueOf(dateS2);
		Tournoi tournoi = new Tournoi(123, 12, "test", dateD1, dateD2, "bandol");	
		
		tournoi.setNomTournoi("test2");
		
		assertEquals(tournoi.getIdTournoi(), "test2");
	}

	//***************************************************************************************************************************
	//***************************************************************************************************************************	
	/**
	 * Méthode de test du getter de la date du Tournoi
	 * @Test
	 */
	public void testGetDatTournoi() {
		String dateS1 = "2015-02-26";
		String dateS2 = "2015-03-30";
		Date dateD1 = Date.valueOf(dateS1);
		Date dateD2 = Date.valueOf(dateS2);
		Tournoi tournoi = new Tournoi(123, 12, "test", dateD1, dateD2, "bandol");
				
		assertEquals(tournoi.getDatTournoi(), dateD1);
		
	}

	//***************************************************************************************************************************
	//***************************************************************************************************************************	
	/**
	 * Methode de test du Setter de la date du Tournoi
	 * @Test
	 */
	public void testSetDatTournoi() {
		String dateS1 = "2015-02-26";
		String dateS2 = "2015-03-30";
		Date dateD1 = Date.valueOf(dateS1);
		Date dateD2 = Date.valueOf(dateS2);
		Tournoi tournoi = new Tournoi(123, 12, "test", dateD1, dateD2, "bandol");
		
		tournoi.setDatTournoi(dateD2);
		
		assertEquals(tournoi.getDatTournoi(), dateD2);
		
	}

	//***************************************************************************************************************************
	//***************************************************************************************************************************	
	/**
	 * Methode de test du getter de la date limite d'inscription
	 * @Test
	 */
	public void testGetDatLimInscrTournoi() {
		String dateS1 = "2015-02-26";
		String dateS2 = "2015-03-30";
		Date dateD1 = Date.valueOf(dateS1);
		Date dateD2 = Date.valueOf(dateS2);
		Tournoi tournoi = new Tournoi(123, 12, "test", dateD1, dateD2, "bandol");
				
		assertEquals(tournoi.getDatLimInscrTournoi(), dateD2);
		
	}

	//***************************************************************************************************************************
	//***************************************************************************************************************************	
	/**
	 * Methode de test du setter de la date limite d'inscription du Tounroi
	 * @Test
	 */
	public void testSetDatLimInscrTournoi() {
		String dateS1 = "2015-02-26";
		String dateS2 = "2015-03-30";
		Date dateD1 = Date.valueOf(dateS1);
		Date dateD2 = Date.valueOf(dateS2);
		Tournoi tournoi = new Tournoi(123, 12, "test", dateD1, dateD2, "bandol");	
		
		tournoi.setDatLimInscrTournoi(dateD1);
		
		assertEquals(tournoi.getDatLimInscrTournoi(), dateD1);
		
	}

	//***************************************************************************************************************************
	//***************************************************************************************************************************	
	/**
	 * Methode de test du getter du lieu du Tournoi
	 * @Test
	 */
	public void testGetLieuTournoi() {
		String dateS1 = "2015-02-26";
		String dateS2 = "2015-03-30";
		Date dateD1 = Date.valueOf(dateS1);
		Date dateD2 = Date.valueOf(dateS2);
		Tournoi tournoi = new Tournoi(123, 12, "test", dateD1, dateD2, "bandol");
				
		assertEquals(tournoi.getLieuTournoi(), "bandol");
		
	}

	//***************************************************************************************************************************
	//***************************************************************************************************************************	
	/**
	 * Methode de test du setter du lieu du Tournoi
	 * @Test
	 */
	public void testSetLieuTournoi() {
		String dateS1 = "2015-02-26";
		String dateS2 = "2015-03-30";
		Date dateD1 = Date.valueOf(dateS1);
		Date dateD2 = Date.valueOf(dateS2);
		Tournoi tournoi = new Tournoi(123, 12, "test", dateD1, dateD2, "bandol");	
		
		tournoi.setLieuTournoi("Meounes");
		
		assertEquals(tournoi.getLieuTournoi(), "Meounes");
	}


}
