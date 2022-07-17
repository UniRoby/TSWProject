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
	response.sendRedirect("./ShopControl");	
	return;
}

 %>

<!DOCTYPE html>
<html lang="it">
<head>

  <%@ include file="meta.html"%>
  
  <!-- 
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
  <script type="text/javascript">
  $function()
  {
	  $('#idimg').hover(function()
			  {
		  var img1="${bean.getImage()}";
		  var img2="${bean.getImage2()}";
		  
		  			$('#diimg').attr('src','images/shop/products/+img2+');
		  
			  },
			  function()
			  {
				  $('idimg').attr('src', 'images/shop/products/+img1+')
			  })			  
  })
  
    
  </script>

	 -->
	



  
</head>

<body id="body">

<% session.setAttribute("auth",(UtenteBean) request.getSession().getAttribute("auth")); %>

<%@ include file="header.jsp"%>
<%@ include file="shopHeader.jsp" %>
			<div class="col-md-9">		
				<div class="row">				
					<% 
					if (occhiali != null && occhiali .size() != 0) {
						Iterator<?> it = occhiali .iterator();
						while (it.hasNext()) {
							OcchialeBean bean = (OcchialeBean) it.next();
					%>
		
					<div class="col-md-4">
						<div class="product-item">
							<div class="product-thumb">
								<span class="bage">Sale</span>
								<img class="img-responsive" src="images/shop/products/<%=bean.getImage()%>" alt="product-img" />
								<div class="preview-meta">
									<ul>
										<li>
											<span  data-toggle="modal" data-target="#product-modal">
												<a href="Prodotto?action=dettagli&id=<%= bean.getIdGlasses() %>"><i class="tf-ion-ios-search-strong"></i></a>
											</span>
										</li>
										<li>
					                        <a href="#!" ><i class="tf-ion-ios-heart"></i></a>
										</li>
										<li>
											<a href="Prodotto?action=aggiungi&id=<%= bean.getIdGlasses() %>"><i class="tf-ion-android-cart"></i></a>
										</li>
									</ul>
		                      	</div>
							</div>
							<div class="product-content">
								<h4><a href="Prodotto?action=dettagli&id=<%= bean.getIdGlasses() %>"><%=bean.getNameGlasses() %></a></h4>
								<p class="price"><%=bean.getPrice() %>&#8364;</p>
								<p class="price"><%=bean.getBrand() %></p>
							</div>
						</div>
					</div>
					<%
					}
					} else {
					out.println("Non ci sono Prodotti");
					}
					%>
				</div>				
			</div>
		</div>
	</div>
</section>
 


 <%@ include file="footer.html"%>

 <%@ include file="script.html"%>


  </body>
  </html>
