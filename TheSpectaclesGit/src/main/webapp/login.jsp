<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.util.*"%>
	<%@page import="dao.*"%>
	<%@page import="model.*"%>
	<%@page import="control.*"%>
	<%@page import="java.util.*"%>


<!DOCTYPE html>
<html lang="it">
<head>


  <meta charset="utf-8">
  <script src="./resources/Ajax.js"></script>
  <title>The Spectacles | E-commerce</title>
  
 <%@ include file="meta.html"%>

</head>

<body id="body">

<section class="signin-page account">
  <div class="container">
    <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <div class="block text-center">
          <a class="logo" href="index.jsp">
            <img src="images/logo.jpg" alt=""
            style="max-width:1000px; max-height:200px; "/>
          </a>
          <h2 class="text-center">BenTornato</h2>
          
          
          <form class="text-left clearfix" name="formLog" method="post">
           
            <div class="form-group">
             <div id="userPass">
              <input id="email1" type="email" class="form-control" name="email" placeholder="email@esempio.com" required 
              onclick="myFunction()" onmouseout="myFunction2()"> 
            </div> 
            <div class="form-group">
              <input id="password1" type="password" class="form-control" name="pass" placeholder="Inserisci Password" required 
              onclick="myFunction1()" onmouseout="myFunction3()">
            
            <div class="text-center">
              <button  type="button" class="btn btn-main text-center" id="submit" value="Accedi" onclick=true >Login</button>
              
               </div>
              </div>
            </div>
          </form>
          
          
          <p class="mt-20">Nuovo sul sito?<a href="signin.jsp"> Crea un nuovo Account</a></p>
        </div>
      </div>
    </div>
  </div>
</section>

   <script>
   function myFunction(){
	   document.getElementById("email1").style.borderColor = "red";
   }
   </script>
   
     <script>
   function myFunction2(){
	   document.getElementById("email1").style.borderColor = "initial";
   }
   </script>
   
     <script>
   function myFunction1(){
	   document.getElementById("password1").style.borderColor = "red";
   }
   </script>
     <script>
   function myFunction3(){
	   document.getElementById("password1").style.borderColor = "initial";
   }
   </script>
   <script>
	var input = document.getElementById("password1");
	input.addEventListener("keypress", function(event) {
  			if (event.key === "Enter") {
    			event.preventDefault();
    			document.getElementById("submit").click();
	}});
	</script>
    <%@ include file="footer.html"%>
    <%@ include file="script.html"%>
    <script src="./resources/ajaxLogin.js"></script>
    
  </body>
  </html>