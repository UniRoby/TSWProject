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
<html lang="en">
<head>

  <%@ include file="meta.html"%>
</head>

<body id="body">

<%@ include file="headerAmministratore.jsp"%>
   				
<section class="buttons section">
	<div class="container">
		<div class="row">
			<div class="section-title text-center">
				<h1 align="center"> Benvenuto Amministratore </h1>
				<h2><%= admin.getFirstName() %></h2>
			</div>
		</div>
		<div class="row mt-30">
			<div class="col-md-12">
	            <div class="buttonPart" align="center">
	            
	              <ul class="list-inline mt-10">
	                <li class="li"><a href="ControlloAdmin?azione=controllo" class="btn btn-main btn-large btn-round-full">Controlla il catalogo</a></li>
	                <li class="li"><a href="ControlloAdmin?azione=ordiniNominativo" class="btn btn-main btn-large btn-round-full">Controlla gli ordini per clienten</a></li>
	               <li class="li"><a href="ControlloAdmin?azione=ordiniData" class="btn btn-main btn-large btn-round-full">Controlla gli ordini per Data</a></li>
	              </ul>
	            </div>
	        </div>		
		</div>
	</div>
</section>




 <%@ include file="footer.html"%>

 <%@ include file="script.html"%>


  </body>
  </html>