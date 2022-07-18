<%@page import="dao.*"%>
<%@page import="model.*"%>
<%@page import="control.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
if(request.getSession().getAttribute("auth") == null) {
response.sendRedirect(getServletContext().getContextPath() +
"/login.jsp"); } 
UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");

ArrayList<OrdineBean> ordini = (ArrayList<OrdineBean>) request.getAttribute("ordini");


%>
<!DOCTYPE html>
<html lang="it">
<head>


	<%@ include file="meta.html"%>
	<% session.setAttribute("auth",(UtenteBean) request.getSession().getAttribute("auth")); %>
</head>

<body id="body">

<%@ include file="header.jsp"%>

<section class="page-header">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="content">
					<h1 class="page-name">Cronologia Ordini</h1>
				</div>
			</div>
		</div>
	</div>
</section>
<section class="user-dashboard page-wrapper">
	<div class="container">
		<div class="row">
		<div class="col-md-12">
			<ul class="list-inline dashboard-menu text-center">
				<li><a class="active" href="CronologiaOrdini">Ordini</a></li>
				<li><a href="Indirizzo?page=ok">Indirizzi</a></li>										
				<li><a href="profile_details.jsp">Dettagli Profilo</a></li>	
			</ul> 
				<div class="dashboard-wrapper user-dashboard">
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>Order ID</th>
									<th>Date</th>
									<th>Status</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							
							<%
							for(int i=0;i<ordini.size();i++){
								
								OrdineBean ordine= new OrdineBean();
								ordine=ordini.get(i);
								
							
							  %>
								
								<tr>
									<td><%=ordine.getIdOrder()  %></td>
									<td><%= ordine.getDate() %></td>
									
									<td><span class="label label-success"><%= ordine.getStato() %></span></td>
									<td><a href="DettagliOrdini?ordineId=<%=ordine.getIdOrder().toString() %>" class="btn btn-default">View</a></td>
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
 <%@ include file="footer.html"%>

 <%@ include file="script.html"%>

  </body>
  </html>