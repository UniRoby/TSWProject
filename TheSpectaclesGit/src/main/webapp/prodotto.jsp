<%@page import="dao.*"%>
<%@page import="model.*"%>
<%@page import="control.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
/*ArrayList<OcchialeBean> occhiale = (ArrayList<OcchialeBean>) request.getAttribute("descrizione");
OcchialeBean bean = (OcchialeBean) occhiale.get(0);
System.out.println("----------------------------------------------------------------------\n"+bean+"\n");*/

OcchialeBean bean = (OcchialeBean) request.getAttribute("descrizione");

 %>
<!DOCTYPE html>
<html lang="it">
<head>

<%@ include file="meta.html"%>

</head>

<body id="body">
<% session.setAttribute("auth",(UtenteBean) request.getSession().getAttribute("auth")); %>

<%@ include file="header.jsp"%>



<% 
		if (bean != null) {
			
			
				%>

<section class="single-product">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<ol class="breadcrumb">
					<li><a href="index.jsp">Home</a></li>
					<li><a href="shop.jsp">Shop</a></li>
					<li class="active">Single Product</li>
				</ol>
			</div>	
		</div>
		
		<div class="row mt-20">
		
			<div class="col-md-5">
				<div class="single-product-slider">
					<div id='carousel-custom' class='carousel slide' data-ride='carousel'>
						<div class='carousel-outer'>
							<!-- me art lab slider -->
							<div class='carousel-inner '>
								<div class='item active'>
									<img src='images/shop/products/<%=bean.getImage()%>' alt='' data-zoom-image="images/shop/single-products/product-1.jpg" />
								</div>
								<div class='item'>
									<img src='images/shop/products/<%=bean.getImage()%>' alt='' data-zoom-image="images/shop/single-products/product-2.jpg" />
								</div>
							</div>
							
							<!-- sag sol -->
							<a class='left carousel-control' href='#carousel-custom' data-slide='prev'>
								<i class="tf-ion-ios-arrow-left"></i>
							</a>
							<a class='right carousel-control' href='#carousel-custom' data-slide='next'>
								<i class="tf-ion-ios-arrow-right"></i>
							</a>
						</div>
						
					
						
						<ol class='carousel-indicators mCustomScrollbar meartlab'>
							<li data-target='#carousel-custom' data-slide-to='0' class='active'>
								<img src='images/shop/products/<%=bean.getImage()%>' alt='' />
							</li>
							<li data-target='#carousel-custom' data-slide-to='1'>
								<img src='images/shop/products/<%=bean.getImage()%>' alt='' />
							</li>
							
						</ol>
						
					</div>
				</div>
			</div>
			<div class="col-md-7">
				<div class="single-product-details">
					<h2><%=bean.getBrand()%></h2>

					<p class="product-price"><%=bean.getPrice()%> &euro;</p>

					
					<p class="product-description mt-20">
						<%=bean.getNameGlasses()%>
					</p>
			       <p> Categoria: <%=bean.getCategory()%> </p>

					 					
					

					
					 <!-- <div class="product-size">
						<span>Size:</span>
						<select class="form-control">
							<option>S</option>
							<option>M</option>
							<option>L</option>
							<option>XL</option>
						</select>
					</div> -->
					
				
					<div class="product-quantity">
						<span>Quantity: <%=bean.getAvailability()%></span>
						<div class="product-quantity-slider">
							<input id="product-quantity" type="text" value="0" name="product-quantity">
						</div>
					</div>
					
					<a href="Prodotto?action=aggiungi&id=<%= bean.getIdGlasses() %>" class="btn btn-main mt-20">Add To Cart</a>
				</div>
			</div>
		</div>
		
		
		<div class="row">
			<div class="col-xs-12">
				<div class="tabCommon mt-20">
					<ul class="nav nav-tabs">
						<li class="active"><a data-toggle="tab" href="#details" aria-expanded="true">Details</a></li>
						
					</ul>
					<div class="tab-content patternbg">
						<div id="details" class="tab-pane fade active in">
							<h4>Breve descrizione</h4>
							<p><%=bean.getDescription()%></p>
							
						</div>
						
						
						
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

	<%
			
			} else {
			out.println("There is no proucts");
			}
			%>



    
	 <%@ include file="footer.html"%>

     <%@ include file="script.html"%>
	

  </body>
  </html>