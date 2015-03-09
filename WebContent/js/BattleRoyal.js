/**
 * 
 */
function getCoord(id) {

	var idButton = document.getElementById(id);
	var rowSelect = idButton.getAttribute("id");

	alert(document.getElementById("idTournoi"+rowSelect).innerHTML);
	var idTournoi = document.getElementById("idTournoi"+rowSelect).innerHTML;

	document.getElementById("buttonName").innerHTML = "idTournoi"+rowSelect;
	
	
	return idTournoi;

}

function inscription() {
	
	alert("Votre inscription a ete prise en compte. Un email va etre envoye a l organisateur.");
	
}