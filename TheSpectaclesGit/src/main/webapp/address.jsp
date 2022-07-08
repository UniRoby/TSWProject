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
IndirizziBean attivo= (IndirizziBean) request.getAttribute("attivo");
Collection<?> indirizzi = (Collection<?>) request.getAttribute("indirizzi");




%>


<!DOCTYPE html>
<html lang="en">


<head>

<%@ include file="meta.html"%>

</head>

<body id="body">

<% session.setAttribute("auth",(UtenteBean) request.getSession().getAttribute("auth")); %>

<%@ include file="header.jsp"%>


<section class="page-header">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="content">
					<h1 class="page-name">Rubrica Indirizzi</h1>
					<ol class="breadcrumb">
						<li><a href="index.jsp">Home</a></li>
						<li class="active">my account</li>
					</ol>
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
          <li><a href="dashboard.html">Dashboard</a></li>
          <li><a href="order.html">Ordini</a></li>
          <li><a class="active" href="address.html">Indirizzi</a></li>
          <li><a href="profile-details.html">Dettagli Profilo</a></li>
        </ul>
        <div class="dashboard-wrapper user-dashboard">
          <div class="table-responsive">
            <table class="table">
              <thead>
                <tr>
                  <th>Nome</th>
                  <th>Indirizzo</th>
                  <th>Città</th>
                  <th>CAP</th>
                  <th class="col-md-2 col-sm-3">Telefono</th>
                  <th></th>
                </tr>
              </thead>
               <tbody>
                <tr>
                  <td><%= auth.getFirstName() %> <%= auth.getLastName() %></td>
                  
                  <%if (indirizzi != null && indirizzi.size() != 0) {
						Iterator<?> it = indirizzi.iterator();
						while (it.hasNext()) {
							IndirizziBean bean = (IndirizziBean) it.next();%>
                  <td>Adam Smith</td>
                  <td>9/4 C Babor Road, Mohammad Pur, Dhaka</td>
                  <td>Bangladesh</td>
                  
                  <% }						
					 	}%>
                  
                  <td>+884 5452 6452</td>
                  <td>
                    <div class="btn-group" role="group">
                      <button type="button" class="btn btn-default"><i class="tf-pencil2" aria-hidden="true"></i></button>
                      <button type="button" class="btn btn-default"><i class="tf-ion-close" aria-hidden="true"></i></button>
                    </div>
                  </td>
                </tr>
                <tr>
                  <td>Samsung</td>
                  <td>Adam Smith</td>
                  <td>9/4 C Babor Road, Mohammad Pur, Dhaka</td>
                  <td>Bangladesh</td>
                  <td>+884 5452 6452</td>
                  <td>
                    <div class="btn-group" role="group">
                      <button type="button" class="btn btn-default"><i class="tf-pencil2" aria-hidden="true"></i></button>
                      <button type="button" class="btn btn-default"><i class="tf-ion-close" aria-hidden="true"></i></button>
                    </div>
                  </td>
                </tr>
                <tr>
                  <td>Motorola</td>
                  <td>Adam Smith</td>
                  <td>9/4 C Babor Road, Mohammad Pur, Dhaka</td>
                  <td>Bangladesh</td>
                  <td>+884 5452 6452</td>
                  <td>
                    <div class="btn-group" role="group">
                      <button type="button" class="btn btn-default"><i class="tf-pencil2" aria-hidden="true"></i></button>
                      <button type="button" class="btn btn-default"><i class="tf-ion-close" aria-hidden="true"></i></button>
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<footer class="footer section text-center">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<ul class="social-media">
					<li>
						<a href="https://www.facebook.com/themefisher">
							<i class="tf-ion-social-facebook"></i>
						</a>
					</li>
					<li>
						<a href="https://www.instagram.com/themefisher">
							<i class="tf-ion-social-instagram"></i>
						</a>
					</li>
					<li>
						<a href="https://www.twitter.com/themefisher">
							<i class="tf-ion-social-twitter"></i>
						</a>
					</li>
					<li>
						<a href="https://www.pinterest.com/themefisher/">
							<i class="tf-ion-social-pinterest"></i>
						</a>
					</li>
				</ul>
				<ul class="footer-menu text-uppercase">
					<li>
						<a href="contact.html">CONTACT</a>
					</li>
					<li>
						<a href="shop.html">SHOP</a>
					</li>
					<li>
						<a href="pricing.html">Pricing</a>
					</li>
					<li>
						<a href="contact.html">PRIVACY POLICY</a>
					</li>
				</ul>
				<p class="copyright-text">Copyright &copy;2021, Designed &amp; Developed by <a href="https://themefisher.com/">Themefisher</a></p>
			</div>
		</div>
	</div>
</footer>
    <!-- 
    Essential Scripts
    =====================================-->
    
    <!-- Main jQuery -->
    <script src="plugins/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap 3.1 -->
    <script src="plugins/bootstrap/js/bootstrap.min.js"></script>
    <!-- Bootstrap Touchpin -->
    <script src="plugins/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.js"></script>
    <!-- Instagram Feed Js -->
    <script src="plugins/instafeed/instafeed.min.js"></script>
    <!-- Video Lightbox Plugin -->
    <script src="plugins/ekko-lightbox/dist/ekko-lightbox.min.js"></script>
    <!-- Count Down Js -->
    <script src="plugins/syo-timer/build/jquery.syotimer.min.js"></script>

    <!-- slick Carousel -->
    <script src="plugins/slick/slick.min.js"></script>
    <script src="plugins/slick/slick-animation.min.js"></script>

    <!-- Google Mapl -->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCC72vZw-6tGqFyRhhg5CkF2fqfILn2Tsw"></script>
    <script type="text/javascript" src="plugins/google-map/gmap.js"></script>

    <!-- Main Js File -->
    <script src="js/script.js"></script>
    


  </body>
  </html>