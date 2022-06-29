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
	var data=  new Date($('#data').val()).toString();
	var email = $('#email').val();
	var password = $('#password').val();
	var ripPassword = $('#ripPassword').val();
	    
	var expNomeCognome= /^[A-Za-z]+$/;
	var expEmail= /^([a-z1-9.-])*@([a-z])+(.com)$/;
	var expPassword= /^(?=.*\d)(?=.*[a-zA-Z])[a-zA-Z0-9]{7,}$/;
	//var expData=/^([0-9]{1,2})-([0-9]{1,2})-([0-9]{4})$/;
		
	console.log(nome);	
	console.log(nome.match(expNomeCognome));	
	console.log(cognome);	
	console.log(cognome.match(expNomeCognome));	
	console.log(data);
	console.log(email);		
	console.log(email.match(expEmail));	
	console.log(password);	
	console.log(password.match(expPassword));
	console.log(ripPassword);	
	console.log(password==ripPassword);
	
		
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
	/*if (!(data.match(expData)) && errData< 1){
		errData= errData + 1;
		$('#data').after("<b><p id=erroreEmail style='color: red;'>Errore nell'inserimento della Data</p></b> <br>");
	}*/
	if (!(password.match(expPassword)) && errPassword< 1){
		errPassword= errPassword + 1;
		$('#password').after("<b><p id=errorePassword style='color: red;'>Errore nell'inserimento della Password</p></b> <br>");
	}
		
	if (!(password==ripPassword) && errRipPassword< 1){
		errRipPassword= errRipPassword + 1;
		$('#ripPassword').after("<b><p id=erroreRipPassword style='color: red;'>Errore Password diversa</p></b> <br>");
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
		
	/*if (data.match(expData)){
		errData= errData + 1;
		$('#erroreUsername').remove();
	}*/
		
	if (email.match(expEmail)){
		errEmail= errEmail + 1;
		$('#erroreEmail').remove();
	}
		
	if (password.match(expEmail)){
		errPassword= errPassword + 1;
		$('#errorePassword').remove();
	}
		
	if (ripPassword==password){
		errRipPassword= errRipPassword + 1;
		$('#erroreRipPassword').remove();
	}
		
		
		
	//utilizzo di ajax
		
	if ((nome.match(expNomeCognome)) && (cognome.match(expNomeCognome)) && (email.match(expEmail)) && (ripPassword==password) ){
			$.ajax({
				type: 'POST',
				data: {nome: nome, cognome: cognome, data: data, email: email, password: password},
				url: 'Signin',
				success: function(result){
					if (result == "Utente"){
					window.location.href="shop.jsp";
				}
				}
			})
		}
		
		})
	})