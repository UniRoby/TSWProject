<%@page import="model.UtenteBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="it">
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
          <h2 class="text-center">Inserisci la Nuova Password</h2>
            			
          
          <form class="text-left clearfix"  name="formReg" method ="post">
            
            <div class="form-group">
              <input type="password" class="form-control"name="new password" id="password" placeholder="Password" required="required" >
            </div>
            <div class="form-group">
              <input type="password" class="form-control"name="rip password" id="ripPassword" placeholder="Conferma Password" required="required" >
            </div>
            <div class="text-center">
              <button type="button" class="btn btn-main text-center" id="submit" value="Conferma" >Conferma</button>
            </div>
          </form>
          
          
         
        </div>
      </div>
    </div>
  </div>
</section>
 
   <%@ include file="footer.html"%>

   <%@ include file="script.html"%>
   <script src="./resources/ajaxReset.js"></script>

  </body>
  </html>