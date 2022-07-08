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
<html lang="it">
<head>


<%@ include file="meta.html"%>

</head>
<body>
<% session.setAttribute("auth",(UtenteBean) request.getSession().getAttribute("auth")); %>

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

 <form  class="checkout-form" action="Checkout" method="get">
<div class="page-wrapper">
   <div class="checkout shopping">
      <div class="container">
         <div class="row">
            <div class="col-md-8">
               <div class="block billing-details">
                  <h4 class="widget-title">Indirizzo</h4>
                  
                  <% if(attivo!=null){ %>
                   
                   <input type="radio"  name="sameadr" value="<%=attivo.getAddress() %>" checked>Default: <%=attivo.getAddress() %><br>
                   <% }%>
                   <%if (indirizzi != null && indirizzi.size() != 0) {
						Iterator<?> it = indirizzi.iterator();
						%>
						<br> Altri indirizzi: <br>
						<%
						while (it.hasNext()) {
							IndirizziBean bean = (IndirizziBean) it.next();%> 
                       <input type="radio" name="sameadr"  value="<%=bean.getAddress() %>"><%=bean.getAddress() %><br>
                   <% }
						%>
						<% }
						%>
						 <input type="radio" name="sameadr" onclick="aggiungi()" value="nuovoIndirizzo">Nuovo indirizzo spedizione<br>
						<script type="text/javascript">
						 function aggiungi(){
							 
							 window.location.href="aggiungiIndirizzo.jsp";
						 }
						 
						</script>
                  
               </div>
               <div class="block">
                  <h4 class="widget-title">Metodo Pagamento</h4>
                  <p>Credit Cart Details (Secure payment)</p>
                  <div class="checkout-product-details">
                     <div class="payment">
                        <div class="card-details">
                          
                              <div class="form-group">
                                 <label for="card-number">Numero Carta <span class="required">*</span></label>
                                 <input  id="card-number" class="form-control" name="cardnumber"  type="tel" placeholder="">
                              </div>
                              <div class="form-group half-width padding-right">
                                 <label for="card-expiry">Scadenza (MM/YY) <span class="required">*</span></label>
                                 <input id="card-expiry" class="form-control" name="expiry" type="tel" placeholder="MM / YY">
                              </div>
                              <div class="form-group half-width padding-left">
                                 <label for="card-cvc">CVV <span class="required">*</span></label>
                                 <input id="card-cvc" class="form-control" name="cvv"  type="tel" maxlength="3" placeholder="123" >
                              </div>
                               
                               <button  type="submit" class="btn btn-main mt-20" id="submit" value="Continua Checkout">Ordina</button>
                        
                        </div>
                     </div>
                  </div>
               </div>
            </div>
        </form>  <!-- fine form -->
          
            <div class="col-md-4">
               <div class="product-checkout-details">
                  <div class="block">
                     <h4 class="widget-title">Order Summary</h4>
                       <%
							Carrello cart= (Carrello) session.getAttribute("carrello");
				              float subtotal=0;
			                  float total=0;
			                  float iva=0;
				   			 for (int i=0; i<car.getDimensione(); i++) { 			
					
						%>
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
                      <%
                          subtotal+=car.getCarrello().get(i).getTotPrezzo();
                    	  iva+=(car.getCarrello().get(i).getTotPrezzo()*22)/100;
                    	  total+=subtotal+iva;
	   			 				}
                
                  
  						%>
                     <!--  
                     <div class="discount-code">
                        <p>Have a discount ? <a data-toggle="modal" data-target="#coupon-modal" href="#!">enter it here</a></p>
                     </div>
                     -->
                    
                     <ul class="summary-prices">
                        <li>
                           <span>Subtotal:</span>
                           <span class="price"><%=subtotal%>&#8364;</span>
                        </li>
                        <li>
                           <span>IVA:</span>
                           <span><%=iva %>&#8364;</span>
                        </li>
                        <li>
                           <span>Shipping:</span>
                           <span>Free</span>
                        </li>
                     </ul>
                     <div class="summary-total">
                        <span>Total</span>
                        
                        <span><%=total%>&#8364;</span>
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