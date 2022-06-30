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

<% session.setAttribute("auth",(OcchialeBean) request.getSession().getAttribute("auth")); %>
<%@ include file="meta.html"%>

  
<!-- Page Wrapper -->
<section class="page-wrapper success-msg">
  <div class="container">
    <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <div class="block text-center">
        	<i class="tf-ion-android-checkmark-circle"></i>
          <h2 class="text-center">Grazie per il tuo Ordine!</h2>
          <p>L'ordine da te effettuato è andato a buon fine.</p>
          <a href="shop.jsp" class="btn btn-main mt-20">Continua lo Shopping</a>
        </div>
      </div>
    </div>
  </div>
</section><!-- /.page-warpper -->

<%@ include file="footer.html"%>

 <%@ include file="script.html"%>


  </body>
  </html>