/**
 * javascript contenant les fonctions de controle des champs password et mot de passe.
 * 
 */
function isValidForm() {

	validate = true;

	if (!isEmail()){
		alert("Format Email non Valide. Veuillez-verifier votre saisie")
		validate = false;
	}
	if (!isPassword()){
		alert("Format de mot de passe non Valide. Veuillez-verifier votre saisie")
		validate = false;
	}
	return validate;
}

function isEmail(){

	var email = document.getElementById("saisieMail");
	verifEmail = email.value;

	// La 1ère étape consiste à définir l'expression régulière d'une adresse email
	var regEmail = new RegExp('^[0-9a-z._-]+@{1}[0-9a-z.-]{2,}[.]{1}[a-z]{2,5}$','i');

	return regEmail.test(verifEmail);
}


function isPassword(){

	var password = document.getElementById("saisiePassword");
	verifPassword = password.value;

	// La 2eme étape consiste à définir l'expression régulière d'un mot de passe
	var regPassword = new RegExp('/^[a-zA-Z0-9]+{8,12}$/');

	return regPassword.test(verifPassword);	
}