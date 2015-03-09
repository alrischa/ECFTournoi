<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="fr">

<head>

<meta charset="utf-8">

<title>GestionTournoiAccueil</title>

<link rel="stylesheet" href="../css/BattleRoyalIndex.css">


<script type="text/javascript" src="../js/TournoiAccueil.js"></script>
</head>
<body>


	<div class="centre">
		<h1>BattleRoyal</h1>
		<p>
			<img src="../ressources/tournoisV.2.0 grand.png">
		</p>
		<h2>Connexion</h2>
		<form action="<%= request.getContextPath() %>/controleur/listing"
			method="get">
			<p>
		
			</p>

			<table>
				<tr>
					<td><input type="email" name="email" id="saisieMail" class = "formulaire" placeholder = "exemple@toto.com" disabled/></td>
				</tr>
				<tr>
					<td><input type="password" name="password" id="saisiePassword" class = "formulaire" placeholder = "mot de passe" disabled/></td>
				</tr>
			</table>
			<p>
				<input type="submit" class = "myButton" value="valider" />
			</p>
			<br />
		</form>
	</div>



</body>
</html>