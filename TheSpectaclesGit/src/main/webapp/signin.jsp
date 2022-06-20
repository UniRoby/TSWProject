<%@page import="model.UtenteBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

String errorClass = "error";
String role = "", nome = "", cognome = "", data = "", email = "";
UtenteBean bean = (UtenteBean) request.getAttribute("utenteBean");
%>
<script type="text/javascript" src="JS/jquery-3.5.1.js"></script>
<script type="text/javascript" src="JS/functions.js"></script>
<script type="text/javascript" src="JS/registrazione.js"></script>
<!DOCTYPE html>
<html lang="en">
<head>

 
  <meta charset="utf-8">
  <meta name="description" content="Registrazione">
  <title>The Spectacles | E-commerce </title>

 <%@ include file="meta.html"%>

	
</script>
</head>
</head>

<body id="body">

<section class="signin-page account">
  <div class="container">
    <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <div class="block text-center">
          <a class="logo" href="index.html">
            <img src="images/logo.png" alt="">
          </a>
          <h2 class="text-center">Create Your Account</h2>
          <form class="text-left clearfix" action="<%=response.encodeURL("registrazione")%>" method ="post" name="formReg" id="form" >
            <div class="form-group">
              <input type="text" class="form-control" name="nome" placeholder="nome"  required="required">
            </div>
            <div class="form-group">
              <input type="text" class="form-control" name="cognome" placeholder="cognome"  required="required">
            </div>
            <div class="form-group">
              <input type="data" class="form-control" name="data"  placeholder="data di nascita" required="required"
              <%=(bean == null || bean.getBirthday() == null) ? "" : String.format("value=\"%s\"", bean.getBirthday())%>
						onchange="formValid.birthday=true">
            </div>
            <div class="form-group">
              <input type="email" class="form-control" name="email"  placeholder="email@esempio.it" required="required"
              <%=(bean == null || bean.getEmail() == null) ? "" : String.format("value=\"%s\"", bean.getEmail())%>
						onkeyup="emailValidator()">
            </div>
            <div class="form-group">
              <input type="password" class="form-control"
              <%=(bean == null || bean.getPass() == null) ? "": String.format("value=\"%s\"", bean.getPass())%>
		        name="pass" placeholder="Password123" required="required"
		        onblur="passwordValidator()">
            </div>
            <div class="text-center">
              <button id="sendInfo" type="button" class="btn btn-main text-center" onclick="buttonNext()">Sign In</button>
            </div>
          </form>
          <p class="mt-20">Already have an account ?<a href="login.html"> Login</a></p>
          <p><a href="forget-password.html"> Forgot your password?</a></p>
        </div>
      </div>
    </div>
  </div>
</section>

   <%@ include file="footer.html"%>

   <%@ include file="script.html"%>


  </body>
  </html>