<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="metier.Tournoi"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="dao.DaoException"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu principal</title>
<link rel="stylesheet" href="../css/BattleRoyal.css">
<script type="text/javascript" src="../js/BattleRoyal.js"></script>
</head>
<body>
	<section>
		<ul class="menu">

			<li><a href="../Vues/Accueil.jsp">Deconnexion</a></li>

		</ul>
		<div>
			<form method="get"
				action="<%=request.getContextPath()%>/controleur/tri">
				<select name="tri">
					<option>Tri par nom
					<option>Tri par date
					<option>Tri par jeux
				</select>
				<button class="btn" type="submit" name="buttontri" class="myButton"
					value="trier">trier</button>
			</form>
		</div>
	</section>
	<div class="centre">

		<h1>
			<img src="../ressources/tournoisV.2.0 petit.png" alt="logo du site">
			BIENVENUE SUR BATTLEROYAL !
		</h1>

		<%
		String erreur = null;
		try {
			DaoException dao = (DaoException)request.getAttribute("erreur");
			erreur = dao.getMessage();
			if (erreur.equals(null))
				erreur = "";
		}

		catch (Exception e) {
					
		}
		

		%>
		<h2>
			<%=erreur%>
		</h2>

		<table class="table" id="table">

			<thead>
				<tr>
					<th>Nom</th>
					<th>Date</th>
					<th>Date limite d'inscription</th>
					<th>Lieu</th>
					<th>Jeux</th>
					<th>Voir</th>
					<th>Supprimer</th>
				</tr>
			</thead>

			<tbody>
				<%
					//out.println("la jsp");
					List<Tournoi> listTournoi = (List<Tournoi>)request.getAttribute("list");
					//out.println("la jsp2");

					Iterator<Tournoi> iterator = listTournoi.iterator();
					while (iterator.hasNext()) {
						Tournoi tournoi = iterator.next();
				%>
				<tr>
					<td><%=tournoi.getNomTournoi()%></td>

					<td><%=tournoi.getDatTournoi()%></td>

					<td><%=tournoi.getDatLimInscrTournoi()%></td>

					<td><%=tournoi.getLieuTournoi()%></td>

					<td><%=tournoi.getJeuxTournoi()%></td>

					<td>
						<form method="post"
							action="<%=request.getContextPath()%>/controleur/modification">
							<button class="btn" type="submit" name="buttonmod"
								value="<%=tournoi.getIdTournoi()%>">Modifier</button>
						</form>
					</td>

					<td>
						<form method="post"
							action="<%=request.getContextPath()%>/controleur/suppression">
							<button class="btn" type="submit" name="buttonsuppr"
								value="<%=tournoi.getIdTournoi()%>">Supprimer</button>
						</form>
					</td>

				</tr>
			</tbody>
			<%
				}
			%>

		</table>

		<br />
		<form action="../Vues/Formulaire.jsp">
			<button type="submit" class="myButton" name="myButton">Creer
				une nouvelle Battle</button>
		</form>


	</div>

</body>
</html>