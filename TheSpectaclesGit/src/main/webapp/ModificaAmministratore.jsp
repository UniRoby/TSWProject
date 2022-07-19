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

OcchialeBean occhiale= (OcchialeBean)request.getAttribute("modifica");
UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");



%>

<!DOCTYPE html>
<html lang="it">
<head>
<%@ include file="meta.html"%>

</head>
<body>

<%@ include file="headerAmministratore.jsp"%>

<section class="signin-page account">
 <form  class="checkout-form" action="Modifica" method="get">
<div class="page-wrapper">
   <div class="checkout shopping">
      <div class="container">
         <div class="row">
            <div class="col-md-8">
               <div class="block billing-details">
                  <h4 class="widget-title">Modifica Prodotto</h4>
                  
           				
                     
                     
                        <div class="form-group">
                           <label for="user_post_code">Nome Occhiale</label>
                           <input type="text" class="form-control"  name="nome" required>
                        </div>
                      
                     
                     <div class="form-group">
                        <label for="user_country">Prezzo</label>
                        <input type="text" class="form-control" name="prezzo"   required>
                     </div>
                     <div class="form-group">
                        <label for="user_country">Quantità</label>
                        <input type="text" class="form-control" name="disp"   required>
                     </div>
                      <div>
                      	<input type="hidden" name="id" value="<%=occhiale.getIdGlasses()%>">
                      </div>
                     

                     
                     <div class="form-group">
                        <label for="user_country">Descrizione</label>
                        <input type="text" class="form-control" name="desc"  required>
                     </div>
                     <button  type="submit" class="btn btn-main mt-20" id="submit" value="modifica">Aggiungi</button>
               </div>
       
            </div>
        </form>  <!-- fine form -->
 </section>      
       
    <%@ include file="footer.html"%>
    <%@ include file="script.html"%>
    
 </body>
 </html>