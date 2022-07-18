<%@page import="dao.*"%>
<%@page import="model.*"%>
<%@page import="control.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Locale" %>
<%@page import="java.util.Date" %>
<%@page import="javax.sql.DataSource" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
ArrayList<OrdineBean> ordini = (ArrayList<OrdineBean>) request.getAttribute("ordini"); 
Date dateStart = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateStart"));
Date dateEnd = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateEnd"));
OcchialeOrdineDao prodotto= new OcchialeOrdineDao();
prodotto.setDB((DataSource) getServletContext().getAttribute("DataSource"));

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
					<h2 class="page-name">Ordini dal Dal <%= new SimpleDateFormat("dd/MM/yyyy", Locale.ITALIAN).format(dateStart).toString() %><br />
                	Al <%= new SimpleDateFormat("dd/MM/yyyy", Locale.ITALIAN).format(dateEnd).toString() %> 
                	</h2>
				</div>
			</div>
		</div>
	</div>
</section>		
<% 
if (ordini.size() == 0){
%>

<h3 align="center"> Non ci sono ordini  Dal <%= new SimpleDateFormat("dd/MM/yyyy", Locale.ITALIAN).format(dateStart).toString() %><br />
                	Al <%= new SimpleDateFormat("dd/MM/yyyy", Locale.ITALIAN).format(dateEnd).toString() %> </h3>

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
									<th>Email</th>
									<th>Totale</th>
									
								</tr>
							</thead>
							<tbody>
							
							<%
							 for(OrdineBean ordine: ordini){
								 	String id= String.valueOf(ordine.getIdOrder());								

								
							
							  %>
								
								<tr>
									<td><%=ordine.getIdOrder()  %></td>
									<td><%= new SimpleDateFormat("dd/MM/yyyy - HH:mm", Locale.ITALIAN).format(ordine.getDate()).toString()%></td>
									<td><span class="label label-success"><%= ordine.getStato() %></span></td>
									<td><%=ordine.getEmail()  %></td>
									<td><%=ordine.getTot()  %>&#8364;</td>
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