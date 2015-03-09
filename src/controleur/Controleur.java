package controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Tournoi;
import metier.Utilisateur;
import cSGestionTournoi.ITournoiServices;
import dao.DaoException;


/**
 * Controleur de l'application Tournoi.
 * @author GuillaumeO
 */


@WebServlet(name 	= "controleur", 
description 		= "Controlleur Application", 
urlPatterns 		= {"/controleur/*"})


public class Controleur extends HttpServlet {
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	private static final long serialVersionUID = 1L;
	private ITournoiServices tournoiServices;
	private List<Tournoi> listTournoi;


	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * Methode init du controleur. Est lancée à l'instaciation de la servlet.
	 * Utilise deux methodes afin de creer le contexte  et populer la base une seule fois à sa création.
	 */
	@Override
	public void init() throws ServletException {
		getContext();							//Méthode getContext() pour initialisation bean
		populer();								//Pour remplir la base de données d'un jeux d'essai
		super.init();
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Stocke dans une chaine la methode utilisée par l'action. Permet de savoir si l'action vient du GET ou du POST.
		String methode 			= request.getMethod().toLowerCase();

		// Stocke dans une chaine le chemin d'acces utilisé par l'action.
		String action  			= request.getPathInfo();	

		//********************************************************//
		//0. CONTROLES D'ACCES SANS ACTION (redirection Accueil)**//
		//********************************************************//
		// Si aucune action n'est effectuée, action est positionné sur le chemin /accueil
		if (action == null || action.equals("/*")) {
			action 				= "/accueil";
		}

		//Si l'action vise la methode get et le chemin /accueil, la methode doAccueil est lancée
		if (methode.equals("get") && action.equals("/accueil")) {
			doAccueil(request, response);
			return;
		}

		//********************************************************//
		//I. CONTROLES SUR LA PAGE ACCUEIL (Accueil.jsp)**********//
		//********************************************************//
		//Si l'action vise la methode get et le chemin /listing, la methode doListing est lancée
		else if (methode.equals("get") && action.equals("/listing")) {
			doListing(request, response);
			return;
		}

		//********************************************************//
		//II. CONTROLES SUR LA PAGE CONSULTATION (Listing.jsp)****//
		//********************************************************//
		//Si l'action vise la methode get et le chemin /tri, la methode trier est lancée 
		else if (methode.equals("get")&& action.equals("/tri")){
			trier(request,response);
		}
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);	

		// Stocke dans une chaine la methode utilisée par l'action. Permet de savoir si l'action vient du GET ou du POST.
		String methode = request.getMethod().toLowerCase();

		// Stocke dans une chaine le chemin d'acces utilisé par l'action.
		String action  = request.getPathInfo();	

		//********************************************************//
		//II. CONTROLES SUR LA PAGE CONSULTATION (consultation.jsp)
		//********************************************************//
		//Si l'action vise la methode post et le chemin /suppression, le Tournoi selectionné est supprimé et la methode doListing est jouée 
		if (methode.equals("post")&& action.equals("/suppression")){

			Integer tournoiId = Integer.parseInt(request.getParameter("buttonsuppr"));
			tournoiServices.supprimerTournoi(tournoiServices.rechercherById(tournoiId));
			doListing(request, response);	
		}

		//Si l'action vise la methode post et le chemin /modification, les propriétés du Tournoi sont transmises dans le request 
		//à la page de formulaire des Tournois. L'id du Tournoi est transmis via la session.
		else if (methode.equals("post")&& action.equals("/modification")){

			Integer tournoiId = Integer.parseInt(request.getParameter("buttonmod"));
			Tournoi tournoi = tournoiServices.rechercherById(tournoiId);
			String nomTournoi =  tournoi.getNomTournoi();
			String lieuTournoi = tournoi.getLieuTournoi();
			Integer iDJeux = tournoi.getIDJeu();
			Date dateTournoi = tournoi.getDatTournoi();
			Date dateLimInscr = tournoi.getDatLimInscrTournoi();

			request.setAttribute("nom", nomTournoi);
			request.setAttribute("lieu", lieuTournoi);
			request.setAttribute("jeux", iDJeux);
			request.setAttribute("date", dateTournoi);
			request.setAttribute("datelim", dateLimInscr);
			session.setAttribute("id", tournoiId);
			
			doFormulaire(request, response);

		}

		//********************************************************//
		//III. CONTROLES SUR LA PAGE FORMULAIRE (Formulaire.jsp)**//
		//********************************************************//
		//Si l'action vise la methode post et le chemin /formulaire, les champs du formulaire sont récupérés.
		//l'Id est recupéré de la session afin de savoir si le formulaire est accédé via une création ou une 
		//modification au moment de l'enregistrement. Si l'Id est existant, la methode modifierTournoi est alors
		//appelée. Sinon, le tournoi est crée. La méthode doListing est ensuite appelée afin de retourner sur 
		//la page de listing des Tournois.
		else if (methode.equals("post")&& action.equals("/formulaire")){

			String nomTournoi =  request.getParameter("nom");
			String lieuTournoi = request.getParameter("lieu");
			Integer iDJeux = Integer.parseInt(request.getParameter("jeux"));
			Date dateTournoi = Date.valueOf(request.getParameter("date"));
			Date dateLimInscr = Date.valueOf(request.getParameter("dateLim"));

			Integer tournoiId = (Integer)session.getAttribute("id");
			System.out.println(tournoiId);
			if (tournoiId==null) {

				tournoiServices.creerTournoi(iDJeux, nomTournoi, dateTournoi, dateLimInscr, lieuTournoi);
			}

			else {
				Tournoi tournoi = new Tournoi(tournoiId, 1, nomTournoi, dateTournoi, dateLimInscr, lieuTournoi);
				tournoiServices.modifierTournoi(tournoi);
			}

			doListing(request, response);	
		}

		//Si l'action vise la methode post et le chemin /inscription, le but actuel n'etant que de lever une exception,
		//les inscriptions n'etant à l'heure actuelle pas gérées. TEST!
		else if (methode.equals("post")&& action.equals("/inscription")){
			Tournoi testException = tournoiServices.rechercherById(1);
			Utilisateur utilisateurException = new Utilisateur();
			try {
				tournoiServices.inscrireTournoi(testException, utilisateurException);
				System.out.println("exception non levée.");
			} catch (DaoException e) {
				System.out.println(e.getMessage());
				//**************************************************************************************************************
				//**************************************************************************************************************
				ejbMessage(response);
				//**************************************************************************************************************
				//**************************************************************************************************************
				request.setAttribute("erreur", e);
			}
			doListing(request, response);	
		}
	}




	//METHODES DU CONTROLEUR
	//***************************************************************************************************************************
	//***************************************************************************************************************************	
	/**
	 * Methode d'initialisation du contexte et de connexion aux services EJB
	 * Cette methode est appelée dans l'initialisation du controleur.
	 */
	private void  getContext(){
		InitialContext initialContext;

		try {
			initialContext = new InitialContext();
			tournoiServices 	= (ITournoiServices) initialContext.lookup("ejb:/ProjetTournoiEJB/TournoiBeanSL!cSGestionTournoi.ITournoiServices");
		}

		catch (Exception e) {
			System.out.println("Erreur acces EJB : " + e);
			e.printStackTrace();
		}

	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * Methode de redirection sur page d'accueil de l'application
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doAccueil(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() + "/Vues/Accueil.jsp");

	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * Methode de redirection sur page de Listing des Tournois
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doListing(HttpServletRequest request, HttpServletResponse response) throws IOException {
		listTournoi=tournoiServices.consulter();
		request.setAttribute("list", listTournoi);

		try {
			this.getServletContext().getRequestDispatcher("/Vues/Listing.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * Methode de redirection sur page de formulaire des Tournois
	 * Cette page est utilisable en creation ou en modification.
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void doFormulaire(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.getServletContext().getRequestDispatcher("/Vues/Formulaire.jsp").forward(request, response);
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * Methode de liste par tri. Possedes 3 options en fonction d'une combo:
	 * -tri par nom
	 * -tri par date
	 * -tri par jeux
	 * Une methode differente de la couche service est appelée en fonction de la valeur de "tri"
	 * @param request
	 * @param response
	 */
	private void trier(HttpServletRequest request, HttpServletResponse response) {
		String tri =request.getParameter("tri");

		if (tri.equals("Tri par nom"))
			listTournoi = tournoiServices.consulterByNom();
		if (tri.equals("Tri par date"))
			listTournoi = tournoiServices.consulterByDate();
		if (tri.equals("Tri par jeux"))
			listTournoi = tournoiServices.consulterByJeu();

		request.setAttribute("list", listTournoi);

		try {
			this.getServletContext().getRequestDispatcher("/Vues/Listing.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * Methode pour permettre le remplissage de la base au premier appel de la Servlet.
	 * Cette methode est uniquement présent à des fin d'évaluation de l'application
	 */
	private void populer(){

		String dateS1 = "2015-02-26";
		String dateS2 = "2015-03-30";
		String dateS3 = "2015-04-15";
		String dateS4 = "2015-05-18";
		String dateS5 = "2015-06-20";
		String dateS6 = "2015-07-25";
		String dateS7 = "2015-08-23";
		String dateS8 = "2015-09-27";
		String dateS9 = "2015-11-30";

		Date dateD1 = Date.valueOf(dateS1);
		Date dateD2 = Date.valueOf(dateS2);
		Date dateD3 = Date.valueOf(dateS3);
		Date dateD4 = Date.valueOf(dateS4);
		Date dateD5 = Date.valueOf(dateS5);
		Date dateD6 = Date.valueOf(dateS6);
		Date dateD7 = Date.valueOf(dateS7);
		Date dateD8 = Date.valueOf(dateS8);
		Date dateD9 = Date.valueOf(dateS9);

		tournoiServices.creerTournoi(123, "Tournoi du mois", dateD1, dateD2, "SixFoursLesPlages");
		tournoiServices.creerTournoi(124, "Tournoi de l'année", dateD2, dateD3, "Flayosc");
		tournoiServices.creerTournoi(125, "Tournoi des champions", dateD3, dateD4, "Meounes");
		tournoiServices.creerTournoi(123, "Tournoi Binutti", dateD4, dateD5, "Gareoult");
		tournoiServices.creerTournoi(127, "Tournée des bistros", dateD5, dateD6, "Belgentier");
		tournoiServices.creerTournoi(125, "Tournoi Rolland Garros", dateD6, dateD7, "Neoules");
		tournoiServices.creerTournoi(129, "Tournoi Jacques Vabres", dateD7, dateD8, "Roquevaire");
		tournoiServices.creerTournoi(134, "Tournoi les hélicos", dateD8, dateD9, "Brignoles");
	}
	
	
	//*******************************************************************************************************************************
	//*******************************************************************************************************************************
	/**
	 * Methode d'initialisation du contexte de l'EJB message
	 * @param response
	 * @throws IOException
	 */
	private void ejbMessage(HttpServletResponse response) throws IOException {
		String 			destinationName = "queue/test";
		PrintWriter 		out 			= response.getWriter();
		Context 			ic 				= null;
		ConnectionFactory 	cf 				= null;
		Connection 		connection 		= null;

		try {         
			ic = new InitialContext();

			cf = (ConnectionFactory)ic.lookup("/ConnectionFactory");

			connection = cf.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			Queue queue = (Queue)ic.lookup(destinationName);
			MessageProducer publisher = session.createProducer(queue);

			connection.start();

			TextMessage message = session.createTextMessage("**************************************DEMANDE D'INSCRIPTION IDENTIFIEE!");


			publisher.send(message);

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {         


			if (connection != null)   {
				try {
					connection.close();
				} catch (JMSException e) {                    
					e.printStackTrace();
				}
			} 
		}
	}
}
