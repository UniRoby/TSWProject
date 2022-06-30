<%@page import="dao.*"%>
<%@page import="model.*"%>
<%@page import="control.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%

UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");




%>

<!DOCTYPE html>
<html lang="en">
<head>

 <% session.setAttribute("auth",(OcchialeBean) request.getSession().getAttribute("auth")); %>
<%@ include file="meta.html"%>

</head>
<body>
<% session.setAttribute("auth",(OcchialeBean) request.getSession().getAttribute("auth")); %>

<%@ include file="header.jsp"%>

<section class="page-header">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="content">
					<h1 class="page-name">Checkout</h1>
					<ol class="breadcrumb">
						<li><a href="index.jsp">Home</a></li>
						<li class="active">checkout</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
</section>

 <form  class="checkout-form" action="Pagamento" method="get">
<div class="page-wrapper">
   <div class="checkout shopping">
      <div class="container">
         <div class="row">
            <div class="col-md-8">
               <div class="block billing-details">
                  <h4 class="widget-title">Indirizzo</h4>
                  
                    
                     <div class="form-group">
                        <label for="user_address">Via </label>
                        <input type="text" class="form-control" id="user_address" placeholder="Via Le mani dal Naso">
                     </div>
                     <div class="checkout-country-code clearfix">
                        <div class="form-group">
                           <label for="user_post_code">Codice Postale</label>
                           <input type="text" class="form-control" id="user_post_code" name="zipcode" value="81100">
                        </div>
                        <div class="form-group" >
                           <label for="user_city">Città</label>
                           <input type="text" class="form-control" id="user_city" name="city" placeholder="Caserta">
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="user_country">Provincia</label>
                        <input type="text" class="form-control" id="user_country" placeholder="CE">
                     </div>
                  
               </div>
               <div class="block">
                  <h4 class="widget-title">Metodo Pagamento</h4>
                  <p>Credit Cart Details (Secure payment)</p>
                  <div class="checkout-product-details">
                     <div class="payment">
                        <div class="card-details">
                          
                              <div class="form-group">
                                 <label for="card-number">Numero Carta <span class="required">*</span></label>
                                 <input  id="card-number" class="form-control" name="cardnumber"  type="tel" placeholder="â¢â¢â¢â¢ â¢â¢â¢â¢ â¢â¢â¢â¢ â¢â¢â¢â¢">
                              </div>
                              <div class="form-group half-width padding-right">
                                 <label for="card-expiry">Scadenza (MM/YY) <span class="required">*</span></label>
                                 <input id="card-expiry" class="form-control" name="expiry" type="tel" placeholder="MM / YY">
                              </div>
                              <div class="form-group half-width padding-left">
                                 <label for="card-cvc">CVV <span class="required">*</span></label>
                                 <input id="card-cvc" class="form-control" name="cvv"  type="tel" maxlength="3" placeholder="123" >
                              </div>
                               
                               <button  type="button" class="btn btn-main mt-20" id="submit" value="Continua Checkout">Odina</button>
                        
                        </div>
                     </div>
                  </div>
               </div>
            </div>
        </form> 
            <%
				Carrello cart= (Carrello) session.getAttribute("carrello");
	
	   			 for (int i=0; i<car.getDimensione(); i++) { 			
		
			%>
            <div class="col-md-4">
               <div class="product-checkout-details">
                  <div class="block">
                     <h4 class="widget-title">Order Summary</h4>
                     <div class="media product-card">
                        <a class="pull-left" href="Prodotto?action=dettagli&id=<%=cart.getCarrello().get(i).getIdGlasses()%>">
                           <img class="media-object" src="images/shop/products/<%=cart.getCarrello().get(i).getImage()%>" alt="Image" />
                        </a>
                        <div class="media-body">
                           <h4 class="media-heading"><a href="product-single.html">Ambassador Heritage 1921</a></h4>
                           <p class="price"><%=car.getCarrello().get(i).getQuantity()%> x <%=car.getCarrello().get(i).getPrice()%>&#8364;</p>
                           <span class="remove" >Remove</span>
                        </div>
                     </div>
                     <!--  
                     <div class="discount-code">
                        <p>Have a discount ? <a data-toggle="modal" data-target="#coupon-modal" href="#!">enter it here</a></p>
                     </div>
                     -->
                     
                     <ul class="summary-prices">
                        <li>
                           <span>Subtotal:</span>
                           <span class="price"><%=car.getCarrello().get(i).getTotPrezzo()%>&#8364;</span>
                        </li>
                        <li>
                           <span>Shipping:</span>
                           <span>Free</span>
                        </li>
                     </ul>
                     <div class="summary-total">
                        <span>Total</span>
                        <span><%=car.getCarrello().get(i).getTotPrezzo()%>&#8364;</span>
                     </div>
                     <div class="verified-icon">
                        <img src="images/shop/verified.png">
                     </div>
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
	
   <!--  
   <div class="modal fade" id="coupon-modal" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-body">
               <form>
                  <div class="form-group">
                     <input class="form-control" type="text" placeholder="Enter Coupon Code">
                  </div>
                  <button type="submit" class="btn btn-main">Apply Coupon</button>
               </form>
            </div>
         </div>
      </div>
   </div>
   -->
   
 <%@ include file="footer.html"%>

 <%@ include file="script.html"%>

    


  </body>
  </html>