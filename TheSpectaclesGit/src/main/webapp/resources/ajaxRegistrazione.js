$(document).ready(function(){
	var errNome= 0;
	var errCognome= 0;
	var errData= 0;
	var errEmail= 0;
	var errPassword= 0;
	var errRipPassword= 0;

	
	
	$('#submit').click(function(){
		var nome = $('#nome').val();
		var cognome = $('#cognome').val();
		var data= $('#data').val();
		var email = $('#email').val();
		var password = $('#password').val();
		var ripPassword = $('#ripPassword').val();
	    
		var expNomeCognome= /^[A-Za-z]+$/;
		var expEmail= /^([a-z1-9.-])*@([a-z])+(.com)$/;
		//var expTelefono= /^([0-9]{3} [0-9]{3} [0-9]{4})$/;
		//var expCodice= /^([A-Z0-9])+$/;
		//var expProvincia= /^[A-Za-z]+$/;
		//var expCap= /^([0-9]{5})$/;
		//var expCitta= /^[A-Za-z]+$/;
		//var expVia= /^[A-Za-z0-9\W]+$/;
		var expData=/^([0-9]{1,2})-([0-9]{1,2})-([0-9]{4})$/;
		
		if (!(nome.match(expNomeCognome)) && errNome < 1){
		errNome= errNome + 1;
		$('#nome').after("<b><p id=erroreNome style='color: red;'>Errore nell'inserimento del nome</p></b> <br>");
	}
	
	if (!(cognome.match(expNomeCognome)) && errCognome < 1){
		errCognome= errCognome + 1;
		$('#cognome').after("<b><p id=erroreCognome style='color: red;'>Errore nell'inserimento del cognome</p></b> <br>");
	}
	
	
	if (!(email.match(expEmail)) && errEmail < 1){
		errEmail= errEmail + 1;
		$('#email').after("<b><p id=erroreEmail style='color: red;'>Errore nell'inserimento dell'email</p></b> <br>");
	}
	if (!(data.match(expData)) && errData< 1){
		errData= errData + 1;
		$('#email').after("<b><p id=erroreEmail style='color: red;'>Errore nell'inserimento della Data</p></b> <br>");
	}
	
	
	
	//eliminazione errori
	
	if (nome.match(expNomeCognome)){
		errNome= errNome + 1;
		$('#erroreNome').remove();
	}
	
	if (cognome.match(expNomeCognome)){
		errCognome= errCognome + 1;
		$('#erroreCognome').remove();
	}
	
	if (data.match(expData)){
		errData= errData + 1;
		$('#erroreUsername').remove();
	}
	
	if (email.match(expEmail)){
		errEmail= errEmail + 1;
		$('#erroreEmail').remove();
	}
	
	if (password.match(expEmail)){
		errrrPassword= errrrPassword + 1;
		$('#errorerrPassword').remove();
	}
	
	if (password.match(expEmail)){
		errrrPassword= errrrPassword + 1;
		$('#errorerrPassword').remove();
	}
	
	
	
	//utilizzo di ajax
	
	if ((nome.match(expNomeCognome)) && (cognome.match(expNomeCognome)) && (data.match(expData)) && (email.match(expEmail))){
		$.ajax({
			type: 'POST',
			data: {nome: nome, cognome: cognome, data: data, email: email, password: password, ripPassword: ripPassword},
			url: 'Signin',
			success: function(result){
				window.location.href= result;
			}
		})
	}
	
	})
})