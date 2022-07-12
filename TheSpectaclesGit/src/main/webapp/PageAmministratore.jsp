<%@page import="dao.*"%>
<%@page import="model.*"%>
<%@page import="control.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
UtenteBean admin = (UtenteBean) request.getAttribute("admin");
Collection<?> occhiali = (Collection<?>) request.getAttribute("occhiali");
if(occhiali == null) {
	response.sendRedirect("./Amministratore");	
	return;
}
%>

<!DOCTYPE html>
<html lang="en">
<head>

  <%@ include file="meta.html"%>
</head>

<body id="body">

<% session.setAttribute("auth",(UtenteBean) request.getSession().getAttribute("auth")); %>

<%@ include file="headerAmministratore.jsp"%>
<section class="products section">
	<div class="container">
		<div class="row">
		<h1 align="center"> Catalogo Prodotti </h1>		
			<div class="col-md-9">		
				<div class="row">	
					
					<% 
					if (occhiali != null && occhiali .size() != 0) {
						Iterator<?> it = occhiali .iterator();
						while (it.hasNext()) {
							OcchialeBean bean = (OcchialeBean) it.next();%>
		
					<div class="col-md-4">
						<div class="product-item">
							<div class="product-thumb">
								
								<img class="img-responsive" src="images/shop/products/<%=bean.getImage()%>" alt="product-img" />
								<div class="preview-meta">
									<ul>
										<li>
											<span  data-toggle="modal" data-target="#product-modal">
											
												<a href="Amministratore?action=dettagli&id=<%= bean.getIdGlasses() %>"><i class="tf-ion-md-search"></i></a>
											</span>
										</li>
										<li>
											<a href="Amministratore?action=modifica&id=<%= bean.getIdGlasses() %>"><i class="tf-ion-pencil-sharp"></i></a>
					                       
										</li>
										<li>
											 <a href="EliminaProdAdmin?id=<%= bean.getIdGlasses() %>" ><i class="tf-ion-md-trash"></i></a>
										</li>
									</ul>
		                      	</div>
							</div>
							<div class="product-content">
								<h4><a href="Amministratore?action=dettagli&id=<%= bean.getIdGlasses() %>"><%=bean.getNameGlasses() %></a></h4>
								<p class="price"><%=bean.getPrice() %>&#8364;</p>
								<p class="price"><%=bean.getBrand() %></p>
							</div>
						</div>
					</div>
					<%
					}
					} else {
					out.println("There is no proucts");
					}
					%>
					<div align="center">
					<a href="Amministratore?action=aggiungi">
					<input type="button" class="btn btn-main btn-medium btn-round-full" value="Aggiungi prodotto al catalogo">
					</a>
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