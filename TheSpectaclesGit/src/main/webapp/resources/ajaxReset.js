$(document).ready(function(){

	var errPassword= 0;
	var errRipPassword= 0;
	$('#submit').click(function(){

	var password = $('#password').val();
	var ripPassword = $('#ripPassword').val();
	    
	var expPassword= /^(?=.*\d)(?=.*[a-zA-Z])[a-zA-Z0-9]{7,}$/;
	
		

	console.log(password);	
	console.log(password.match(expPassword));
	console.log(ripPassword);	
	console.log(password==ripPassword);
	
		
	
	if (!(password.match(expPassword)) && errPassword< 1){
		errPassword= errPassword + 1;
		$('#password').after("<b><p id=errorePassword style='color: red;'>Errore nell'inserimento della Password</p></b> <br>");
	}
		
	if (!(password==ripPassword) && errRipPassword< 1){
		errRipPassword= errRipPassword + 1;
		$('#ripPassword').after("<b><p id=erroreRipPassword style='color: red;'>Errore Password diversa</p></b> <br>");
	}
		
	
	
	//eliminazione errori
		
		
	if (ripPassword==password){
		errRipPassword= errRipPassword + 1;
		$('#erroreRipPassword').remove();
	}
		
		
		
	//utilizzo di ajax
		
	if ((ripPassword==password) ){
			$.ajax({
				type: 'POST',
				data: {password: password},
				url: 'ForgetPass',
				success: function(result){
					if (result == "ok"){
					window.location.href="login.jsp";
				}
				}
			})
		}
		
		})
	})