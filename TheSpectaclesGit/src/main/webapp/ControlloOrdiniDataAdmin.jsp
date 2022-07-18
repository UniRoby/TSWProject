


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
				<h1 align="center"> Visualizza ordini per data </h1>
				<h2>Seleziona la data desiderata per visualizzare tutti gli ordini effettuati nell'intervallo di date scelto</h2>
				
			</div>
		</div>
		<div class="row mt-30">
			<div class="col-md-12">
	            <div class="buttonPart" align="center">
				<form action="ordiniData" method="get">
				<div align="center">
				Inserisci la data di inizio:<br><input type="date" name="dateStart"><br><br>
				Inserisci la data di fine:<br><input type="date" name="dateEnd"><br><br>
				<input type="hidden" name="skip" value="0">
				<input type="hidden" name="limit" value="10">
				
				 <button  type="submit" value="Cerca" class="btn btn-main btn-small btn-round-full">
				</div>
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