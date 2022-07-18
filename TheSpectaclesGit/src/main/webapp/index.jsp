<%@page import="dao.*"%>
<%@page import="model.*"%>
<%@page import="control.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%

UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
Collection<?> occhiali = (Collection<?>) request.getAttribute("occhiali");
if(occhiali == null) {
	response.sendRedirect("./OcchialeControl");	
	return;
}
//OcchialeBean occhiale = (OcchialeBean) request.getAttribute("occhiale");

 %>
<!DOCTYPE html>
<html lang="it">
<head>
<% session.setAttribute("auth",(UtenteBean) request.getSession().getAttribute("auth")); %>
<%@ include file="meta.html"%>

</head>

<body id="body">
 

<%@ include file="header.jsp"%>
 

<div class="hero-slider">
  <div class="slider-item th-fullpage hero-area" style="background-image: url(images/slider/theSpectacles.jpg);">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 text-center">
          <p data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".1">PRODOTTI</p>
          <h1 data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".5">Un paio di occhiali è un modo semplice di trasformare il tuo sguardo<br></h1>
          <h3 data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".5"> -Goreski</h3>
          <a data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".8" class="btn" href="shop.jsp">Vai al negozio</a>
        </div>
      </div>
    </div>
  </div>
</div>

<section class="product-category section">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="title text-center">
					<h2>Categorie Occhiali</h2>
				</div>
			</div>
			<div class="col-md-6">
			 
				<div class="category-box">
					<a href="#!">
						<img src="images/index/woman/donna1.jpg" alt="" />
						 
						 <!-- 
						<div class="content">
							  <img class="mySlides" src="images/index/woman/donna1.jpg">
							  <img class="mySlides" src="images/index/woman/donna2.jpg">
							  <img class="mySlides" src="images/index/woman/donna3.jpg">
							  <img class="mySlides" src="images/index/woman/donna4.jpg">
						</div>
						 
						<script type="text/javascript">
							$(document).ready(function(){
								var $smallImages = $(this).attr('src')
							})
						</script>
						-->
						<div class="content">
							<h3>Occhiali Donna</h3>
						</div>					 
					</a>
				</div>
				<div class="category-box">
					<a href="#!">
						<img src="images/index/man/uomo2.jpg" alt="" />
						<div class="content">
							<h3>Occhiali Uomo</h3>
						</div>
					</a>
				</div>
			</div>
			<div class="col-md-6">
				<div class="category-box category-box-2">
					<a href="#!">
						<img src="images/index/man/uomo1.jpg" alt="" />
						<div class="content">
							<h3>Tutti gli Occhiali</h3>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>
</section>

<section class="products section bg-gray">
	<div class="container">
		<div class="row">
			<div class="title text-center">
				<h2>Occhiali più richiesti</h2>
			</div>
		</div>
		<div class="row">

		<% 
		if (occhiali != null && occhiali .size() != 0) {
			Iterator<?> it = occhiali .iterator();
			while (it.hasNext()) {
				OcchialeBean bean = (OcchialeBean) it.next();%>
	
			<div class="col-md-4">
				<div class="product-item">
					<div class="product-thumb">
						<span class="bage">Sale</span>
						<img class="img-responsive" src="images/shop/products/<%=bean.getImage()%>" alt="product-img" />
						<div class="preview-meta">
							<ul>
								<li>
									<span  data-toggle="modal" data-target="#product-modal">
										<i class="tf-ion-ios-search-strong"></i>
									</span>
								</li>
								<li>
			                        <a href="#!" ><i class="tf-ion-ios-heart"></i></a>
								</li>
								<li>
									<a href="#!"><i class="tf-ion-android-cart"></i></a>
								</li>
							</ul>
                      	</div>
					</div>
					<div class="product-content">
						<h4><a href="product-single.html"><%=bean.getNameGlasses() %></a></h4>
						<p class="price"><%=bean.getPrice() %>€</p>
					</div>
				</div>
			</div>
		
			<%
			}
			} else {
			out.println("There is no proucts");
			}
			%>
			
			
			
			
			
			
			

		

		</div>
	</div>	
</section>




 <%@ include file="footer.html"%>
 <%@ include file="script.html"%>

  </body>
  </html>
