<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import= "java.sql.Date"%>
<%@ page import="metier.Tournoi"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="ISO-8859-1">
<title>BattleRoyal : manipulation d'un tournoi</title>
<link rel="stylesheet" href="../css/BattleRoyalManip.css">
<script type="text/javascript" src="../js/BattleRoyalIndex.js"></script>
</head>
<body>

	<div class="centre">
		<h1>BattleRoyal</h1>
		<p>
			<img src="../ressources/tournoisV.2.0 moyen2.png">
		</p>
		<h2>Formulaire Tournoi</h2>
		
		
			<section>
			<form action="<%= request.getContextPath() %>/controleur/formulaire" method="post" >
				<table>
				
					<tr>
					<td><input type="text" name="nom" class="formulaire" placeholder="nom du Tournoi" value="<%=request.getAttribute("nom")%>"/></td>
					</tr>
					
					<tr>
					<td><input type="text" name="lieu" class="formulaire" placeholder="lieu du Tournoi" value="<%=request.getAttribute("lieu")%>"/></td>
					</tr>
					
					<tr>			
					<td><input type="number" name="jeux" class="formulaire" placeholder="Jeux du Tournoi" value="<%=request.getAttribute("jeux")%>"/></td>
					</tr>
					
					<tr>
					<td><input type="date" name="date" class="formulaire" placeholder="date du Tournoi" value="<%=request.getAttribute("date")%>"/></td>
					<tr>
					
					<td><input type="date" name="dateLim" class="formulaire" placeholder="date limite du Tournoi" value="<%=request.getAttribute("datelim")%>"/></td>
					
				</table>
		
				<p class="submit"><button type="submit" class="myButton">Enregistrer</button></p>
		
		
		 </form>
		<form action="<%= request.getContextPath() %>/controleur/listing" method="get">
			<p class="submit"><button type="submit" class="myButton">Retour</button></p>
		</form>
				<form action="<%= request.getContextPath() %>/controleur/inscription" method="post">
			<p class="submit"><button type="submit" class="myButton">inscription</button></p>
		</form>
		</section>
		

	</div>

</body>
</html>


