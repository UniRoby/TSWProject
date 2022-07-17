<%@page import="dao.*"%>
<%@page import="model.*"%>
<%@page import="control.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
ArrayList<OrdineBean> ordiniUtente = (ArrayList<OrdineBean>) request.getAttribute("email");
UtenteBean dati=(UtenteBean) request.getAttribute("dati");
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
   		<section class="page-header">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="content">
					<h1 class="page-name">Ordini di <%=dati.getFirstName() %>, <%=dati.getLastName() %> </h1>
				</div>
			</div>
		</div>
	</div>
</section>		
<% 
if (ordiniUtente.size() == 0){
%>

<h3 align="center"> L'utente non ha effettuato alcun acquisto </h3>

<%
}

else {
%>
<section class="user-dashboard page-wrapper">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="dashboard-wrapper user-dashboard">
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>Order ID</th>
									<th>Date</th>
									<th>Status</th>
									<th>Totale</th>
									
								</tr>
							</thead>
							<tbody>
							
							<%
							for(int i=0;i<ordiniUtente.size();i++){
								
								OrdineBean ordine= new OrdineBean();
								ordine=ordiniUtente.get(i);
								
							
							  %>
								
								<tr>
									<td><%=ordine.getIdOrder()  %></td>
									<td><%= ordine.getDate() %></td>
									
									<td><span class="label label-success"><%= ordine.getStato() %></span></td>
									<td><%=ordine.getTot() %></td>
								</tr>
							<%
							}
								
							%>
								
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<%} %>




 <%@ include file="footer.html"%>
 <%@ include file="script.html"%>

  </body>
  </html>