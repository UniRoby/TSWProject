<%@page import="dao.*"%>
<%@page import="model.*"%>
<%@page import="servlet.*"%>
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
OcchialeBean occhiale = (OcchialeBean) request.getAttribute("occhiale");

 %>

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
					<h1 class="page-name">Shop</h1>
					<ol class="breadcrumb">
						<li><a href="index.jsp">Home</a></li>
						<li class="active">shop</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
</section>


<section class="products section">
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="widget">
					<h4 class="widget-title">Short By</h4>
					<form method="post" action="#">
                        <select class="form-control">
                            <option>Man</option>
                            <option>Women</option>
                            <option>Accessories</option>
                            <option>Shoes</option>
                        </select>
                    </form>
	            </div>
				<div class="widget product-category">
					<h4 class="widget-title">Categories</h4>
					<div class="panel-group commonAccordion" id="accordion" role="tablist" aria-multiselectable="true">
					  	<div class="panel panel-default">
						    <div class="panel-heading" role="tab" id="headingOne">
						      	<h4 class="panel-title">
						        	<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
						          	Shoes
						        	</a>
						      	</h4>
						    </div>
					    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
							<div class="panel-body">
								<ul>
									<li><a href="#!">Brand & Twist</a></li>
									<li><a href="#!">Shoe Color</a></li>
									<li><a href="#!">Shoe Color</a></li>
								</ul>
							</div>
					    </div>
					  </div>
					  <div class="panel panel-default">
					    <div class="panel-heading" role="tab" id="headingTwo">
					      <h4 class="panel-title">
					        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
					         	Duty Wear
					        </a>
					      </h4>
					    </div>
					    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
					    	<div class="panel-body">
					     		<ul>
									<li><a href="#!">Brand & Twist</a></li>
									<li><a href="#!">Shoe Color</a></li>
									<li><a href="#!">Shoe Color</a></li>
								</ul>
					    	</div>
					    </div>
					  </div>
					  <div class="panel panel-default">
					    <div class="panel-heading" role="tab" id="headingThree">
					      <h4 class="panel-title">
					        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
					          	WorkOut Shoes
					        </a>
					      </h4>
					    </div>
					    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
					    	<div class="panel-body">
					      		<ul>
									<li><a href="#!">Brand & Twist</a></li>
									<li><a href="#!">Shoe Color</a></li>
									<li><a href="#!">Gladian Shoes</a></li>
									<li><a href="#!">Swis Shoes</a></li>
								</ul>
					    	</div>
					    </div>
					  </div>
					</div>
					
				</div>
			</div>
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
								<p class="price"><%=bean.getPrice() %></p>
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
		</div>
	</div>
</section>





 <%@ include file="footer.html"%>

 <%@ include file="script.html"%>


  </body>
  </html>
