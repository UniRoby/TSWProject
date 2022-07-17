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
ArrayList<OcchialeOrdineBean> prodotti = (ArrayList<OcchialeOrdineBean>) request.getAttribute("prodotti");

System.out.println("orderDetails\n"+prodotti);
OrdineBean ordine= (OrdineBean) request.getAttribute("ordine");

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
					<h1 class="page-name">Dettaglio Ordine </h1> <!-- ordine.getIdOrder() -->
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
					 <li><a href="order.jsp">Ordini</a></li>
			          <li><a class="active" href="Indirizzo?page='ok'">Indirizzi</a></li>
			          <li><a href="profile-details.jsp">Dettagli Profilo</a></li>
				</ul>
				<div class="dashboard-wrapper user-dashboard">
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>Img</th>
									<th>Nome</th>
									<!-- <th>Brand</th> -->
									<th>Quantità</th>
									<th>Prezzo Totale</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							<%
								float tot = 0;
								for(OcchialeOrdineBean prodotto: prodotti){
									tot+= prodotto.getPrezzoEffettivo() * prodotto.getQuantita(); 
							%>
								<tr>
									<td>
				                          <img width="80" src="images/shop/products/<%=prodotto.getProdotto().getImage()%>" alt="" />

				                      </td>
									<td><%= prodotto.getIdProdotto()%></td>
									<!-- <td><%= prodotto.getProdotto().getBrand()%></td> -->
									<td><%= prodotto.getQuantita()%></td>
									<td><%= tot %>&#8364;</td>
									
									
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
</section>
 <%@ include file="footer.html"%>

 <%@ include file="script.html"%>

  </body>
  </html>