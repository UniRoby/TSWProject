$(document).ready(function(){
	var err= 0;

	$('#submit').click(function(){
	var email= $('#exampleInputEmail1').val();
	
	var expEm= /^([a-z1-9.-])*@([a-z])+(.com)$/;
	console.log(email);	
	console.log(password.match(expEm));
	
	
	if (!(email.match(expEm)) && err < 1){
		err= err + 1;
		$('#exampleInputEmail1').after("<b><p id=erroreEmail style='color: red;'>Errore nell'inserimento dell'email</p></b> <br>");
	}
	
	
	
	if (email.match(expEm) ){
		$('#erroreEmail').remove();
	
		$.ajax({
			type: 'POST',
			data: {email: email},
			url: 'cercaMail',
			success: function(result){
				if(result=="Nulla" && err3 < 1){
				err3= err3 + 1;
					$('#exampleInputEmail1').after("<b><p id=erroreUtente style='color: red;'>Errore Utente non trovato</p></b> <br>");		
				}
				
				if (result == "ok"){
					window.location.href="resetPassword.jsp";
				}
				
			}
		})
		
	
	}
	})
	
})