


<%@page import="dao.*"%>
<%@page import="model.*"%>
<%@page import="control.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
UtenteBean admin = (UtenteBean) request.getAttribute("admin");
if (admin == null){
response.sendRedirect("./ControlloAdmin");
return ;
}
%>

<!DOCTYPE html>
<html lang="it">
<head>

<%@ include file="meta.html"%>


<style>
div.log {
  position: absolute;
  right: 200px;
  top: 40px;
}
</style>

</head>

<body id="body">

<%@ include file="headerAmministratore.jsp"%>

<section class="buttons section">
	<div class="container">
		<div class="row">
			<div class="section-title text-center">
				<h1 align="center"> Inserisci l'email del cliente per visualizzare i suoi ordini </h1>
				<!--  <a href="CercaCliente?email=g@gmail.com">Cerca g@gmail.com</a> -->
	             
			</div>
		</div>
		<div class="row mt-30">
			<div class="col-md-12">
	            <div class="buttonPart" align="center">
	           <form action="CercaCliente" method="get"><input type="search" name="email" class="form-Cerca" placeholder="Inserisci email Cliente">
	             </form>
	            </div>
	        </div>		
		</div>
	</div>
</section>



 <%@ include file="footer.html"%>
 <%@ include file="script.html"%>

  </body>
  </html>