<%@page import="model.UtenteBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="en">
<head>

 
  <meta charset="utf-8">
  <script src="./resources/Ajax.js"></script>
  <meta name="description" content="Registrazione">
  <title>The Spectacles  E-commerce </title>

 	<%@ include file="meta.html"%>
	
	

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
          <h2 class="text-center">Crea il tuo Account</h2>
          
          <form class="text-left clearfix"  name="formReg" method ="post">
            
            <div class="form-group">
              <input type="text" class="form-control" name="nome" placeholder="Inserisci nome" id="nome"  required="required">
            </div>
            <div class="form-group">
              <input type="text" class="form-control" name="cognome" placeholder="Inserisci cognome" id="cognome" required="required">
            </div>
            <div class="form-group">
              <input type="date" class="form-control" name="data" id="data" placeholder="dd-mm-yyyy" required="required"min="1920-01-01" max="2030-12-31">
            </div>
            <div class="form-group">
              <input type="email" class="form-control" name="email" id="email" placeholder="email@esempio.it" required="required">
            </div>
            <div class="form-group">
              <input type="password" class="form-control"name="new password" id="password" placeholder="Password123" required="required" >
            </div>
            <div class="form-group">
              <input type="password" class="form-control"name="rip password" id="ripPassword" placeholder="Conferma Password" required="required" >
            </div>
            <div class="text-center">
              <button type="button" class="btn btn-main text-center" id="submit" value="Registrati" >Sign In</button>
            </div>
          </form>
          
          <p class="mt-20">Hai già un account?<a href="login.jsp"> Login</a></p>
         
        </div>
      </div>
    </div>
  </div>
</section>
 
   <%@ include file="footer.html"%>

   <%@ include file="script.html"%>
   <script src="./resources/ajaxRegistrazione.js"></script>


  </body>
  </html>