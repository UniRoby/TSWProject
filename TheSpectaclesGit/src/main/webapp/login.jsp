<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.util.*"%>
	<%@page import="dao.*"%>
	<%@page import="model.*"%>
	<%@page import="servlet.*"%>
	<%@page import="java.util.*"%>
<%
	
    UtenteBean bean = (UtenteBean) request.getAttribute("utenteBean");
    String errorClassAccess = "error";
    String user = "", pass = "";
    List<String> errorsFoundAccess = (List<String>) request.getAttribute("errorsFound");
    if (errorsFoundAccess != null) {
    	if (errorsFoundAccess.contains("user"))
    		user = errorClassAccess;
    	if (errorsFoundAccess.contains("pass"))
    		pass = errorClassAccess;
    }
    List<String> errorsFound = (List<String>) request.getAttribute("errorsFound");
%>

<!DOCTYPE html>
<html lang="en">
<head>


  <meta charset="utf-8">
  <script type="text/javascript" src="js/jquery-3.5.1.js"></script>
 <script type="text/javascript" src="js/functions.js"></script>
 <script type="text/javascript" src=webapp/js/accesso.js"></script>
 <script type="text/javascript" src="js/login.js"></script>
  <script type="text/javascript" src="js/registrazione.js"></script>
  <title>The Spectacles | E-commerce</title>
  
 <%@ include file="meta.html"%>
<script type="text/javascript">
	$(document).ready(
			function() {
				document.getElementById("userPass").childNodes[1].childNodes[1]
						.addEventListener("blur", function() {
							onlySomethingValidator("user", "user", "infoUser",
									/[A-z]|[0-9]|\?|,|\-|\./, true);
						});
			});
<%if (errorsFound != null && errorsFound.size() > 0) {
	if (!errorsFound.contains("user")) {%>
	formValid.user = true;
<%}
	if (!errorsFound.contains("pass")) {%>
	formValid.pass = true;
<%}
}%>
	
</script>
</head>

<body id="body">

<section class="signin-page account">
  <div class="container">
    <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <div class="block text-center">
          <a class="logo" href="index.html">
            <img src="images/logo.jpg" alt="">
          </a>
          <h2 class="text-center">Ben Tornato</h2>
          
          
          
          <form class="text-left clearfix" action="<%=response.encodeURL("Login")%>" name="formLog" method="post">
            <div class="form-group">
              <input type="email" class="form-control"  name="email"  placeholder="email@esempio.it" required="required"
              <%=(bean == null || bean.getEmail() == null) ? "" : String.format("value=\"%s\"", bean.getEmail())%>
						onkeyup="emailValidator()">
			  <p id="infoEmail">seguire il formato indicato</p>
            </div>
            
            <div class="form-group">
              <input type="password" class="form-control" <%=(bean == null || bean.getPass() == null) ? "": String.format("value=\"%s\"", bean.getPass())%>
		        name="pass" placeholder="Password123" required="required"
		        onblur="passwordValidator()">
		        <p id="infoPass">inserire almeno una lettera maiuscola e un numero</p>
            <div class="text-center">
            
              <button id="sendInfo" type="button" class="btn btn-main text-center" onclick="send()">Login</button>
              <p id="infoNextButton"></p>
            </div>
          </form>
          
          
          <p class="mt-20">Nuovo sul sito?<a href="signin.jsp"> Crea un nuovo Account</a></p>
        </div>
      </div>
    </div>
  </div>
</section>

  <%@ include file="footer.html"%>

 <%@ include file="script.html"%>
    


  </body>
  </html>