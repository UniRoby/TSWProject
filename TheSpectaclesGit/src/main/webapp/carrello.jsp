<%@page import="dao.*"%>
<%@page import="model.*"%>
<%@page import="control.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>

<%@ include file="meta.html"%>

</head>

<body id="body">

<% session.setAttribute("auth",(OcchialeBean) request.getSession().getAttribute("auth")); %>

<%@ include file="header.jsp"%>





<section class="page-header">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="content">
					<h1 class="page-name">carrello</h1>
					<ol class="breadcrumb">
						<li><a href="index.jsp">Home</a></li>
						<li class="active">carrello</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
</section>
	<%
		Carrello cart= (Carrello) session.getAttribute("carrello");
						
		if ((cart==null) || (cart.getDimensione()==0)) {
	%>
<section class="empty-cart page-wrapper">
  <div class="container">
    <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <div class="block text-center">
        	<i class="tf-ion-ios-cart-outline"></i>
          	<h2 class="text-center">Il tuo carrello è vuoto</h2>
          	<p>Visita il nostro catalogo per aggiunger i prodotti</p>
          	<a href="shop.jsp" class="btn btn-main mt-20">Torna al negozio</a>
      </div>
    </div>
  </div>
</section>

	<%
	}
	else {
		
	%>



<div class="page-wrapper">
  <div class="cart shopping">
    <div class="container">
      <div class="row">
        <div class="col-md-8 col-md-offset-2">
          <div class="block">
            <div class="product-list">
              <form method="post">
                <table class="table">
                  <thead>
                    <tr>
                      <th class="">Nome</th>
                      <th class="">Prezzo</th>
                      <th class="">Codice</th>
                      <th class="">Quantità</th>
                      <th class=""></th>
                    </tr>
                  </thead>
                  <tbody>
                  <%
                    for (int i=0; i<car.getDimensione(); i++) { 
                  %>
                    <tr class="">
                      <td class="">
                        <div class="product-info">
                          <img width="80" src="images/shop/products/<%=cart.getCarrello().get(i).getImage()%>" alt="" />
                          <a href="#!"><%=cart.getCarrello().get(i).getNameGlasses()%></a>
                         
                           
                        </div>
                      </td>
                      <td class=""><%=cart.getCarrello().get(i).getPrice()%>€</td>
                       <td class=""><%=cart.getCarrello().get(i).getIdGlasses()%></td>
                      <td class="">
                      
                      <form action="Prodotto2" method="get">
                        <div class="product-quantity-slider">
                        	<input type="hidden" value="<%= cart.getCarrello().get(i).getIdGlasses() %>" name="nascosto">
							<input id="product-quantity" type="text" value="<%= cart.getCarrello().get(i).getQuantity() %>" name="scelta">
							<input type="submit"  value="Aggiorna" >
						</div>
                      </form>
                      </td>
                      <td class="">
                        <a class="product-remove" href="EliminaProdotto?id=<%= cart.getCarrello().get(i).getIdGlasses() %>">Remove</a> 
                      </td>
                    </tr>
                   <%
					}
					%>
                  </tbody>
                </table>
                <a href="checkout.jsp" class="btn btn-main pull-right">Checkout</a>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
	<%
		}
	%>


 <%@ include file="footer.html"%>

 <%@ include file="script.html"%>


  </body>
  </html>
