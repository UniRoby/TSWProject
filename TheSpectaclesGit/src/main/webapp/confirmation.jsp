<%@page import="dao.*"%>
<%@page import="model.*"%>
<%@page import="control.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
IndirizziBean ind= (IndirizziBean) request.getSession().getAttribute("address");
 %>

<!DOCTYPE html>
<html lang="it">
<head>
<%@ include file="meta.html"%>
<% session.setAttribute("auth",(UtenteBean) request.getSession().getAttribute("auth")); %>

<%@ include file="header.jsp"%>



  
<!-- Page Wrapper -->
<section class="page-wrapper success-msg">
  <div class="container">
    <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <div class="block text-center">
        	<i class="tf-ion-android-checkmark-circle"></i>
          <h2 class="text-center">Grazie <%= auth.getFirstName() %> per il tuo Ordine!</h2>
          <p>L'ordine da te effettuato &e andato a buon fine.</p>
          <p>In direzione verso <%=ind.getAddress() %></p>
          <a href="shop.jsp" class="btn btn-main mt-20">Continua lo Shopping</a>
           <a href="Ordini?action=ordiniEffettuati" class="btn btn-main mt-20">Ordini effettuati</a>
        </div>
      </div>
    </div>
  </div>
</section><!-- /.page-warpper -->

<%@ include file="footer.html"%>

 <%@ include file="script.html"%>


  </body>
  </html>