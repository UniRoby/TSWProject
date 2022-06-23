$(document).ready(function(){
	var err= 0;
	var err2= 0;
	var err3= 0;
	$('#submit').click(function(){
	var email= $('#email1').val();
	var password= $('#password1').val();	
	var expEm= /^([a-z1-9.-])*@([a-z])+(.com)$/;
	var expEm2= /^(?=.*\d)(?=.*[a-zA-Z])[a-zA-Z0-9]{7,}$/;
	
	if (!(email.match(expEm)) && err < 1){
		err= err + 1;
		$('#email1').after("<b><p id=erroreEmail style='color: red;'>Errore nell'inserimento dell'email</p></b> <br>");
	}
	
	if(!(password.match(expEm2)) && err2 < 1){
		err2= err2 + 1;
		$('#password1').after("<b><p id=errorePassword style='color: red;'>Errore formato Password</p></b> <br>");
	}
	
	if (email.match(expEm) ){
		$('#erroreEmail').remove();
		if(password.match(expEm2)){
				$('#errorePassword').remove();
		$.ajax({
			type: 'POST',
			data: {email: email, password: password},
			url: 'Login',
			success: function(result){
				if(result=="Nulla" && err3 < 1){
				err3= err3 + 1;
					$('#email1').after("<b><p id=erroreUtente style='color: red;'>Errore Utente non trovato</p></b> <br>");		
				}
				
				if (result == "Admin"){
					window.location.href="ControlloAdmin";
				}
				if (result == "Utente"){
					window.location.href="shop.jsp";
				}
			}
		})
		}
	
	}
	})
	
})