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



%>

<!DOCTYPE html>
<html lang="it">
<head>
<%@ include file="meta.html"%>

</head>
<body>

<%@ include file="header.jsp"%>

<section class="signin-page account">
 <form  class="checkout-form" action="AddAddress" method="get">
<div class="page-wrapper">
   <div class="checkout shopping">
      <div class="container">
         <div class="row">
            <div class="col-md-8">
               <div class="block billing-details">
                  <h4 class="widget-title">Indirizzo</h4>
                  
           
                     <div class="form-group">
                        <label for="user_address">Via </label>
                        <input type="text" class="form-control" id="user_address" name="user_address" placeholder="Via Le mani dal Naso">
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
                        <input type="text" class="form-control" name="user_country" id="user_country" placeholder="CE">
                     </div>
                     <div class="form-group">

                        <label for="user_phone">Telefono</label>
                        <input type="text" class="form-control" name="user_phone" id="user_phone" placeholder="1234567890">
                     </div>
                     <button  type="submit" class="btn btn-main mt-20" id="submit" value="Continua Checkout">Aggiungi</button>
               </div>
       
            </div>
        </form>  <!-- fine form -->
 </section>      
       
    <%@ include file="footer.html"%>

    <%@ include file="script.html"%>
    


  </body>
  </html>