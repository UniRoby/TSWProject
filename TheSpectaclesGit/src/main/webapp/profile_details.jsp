<%@page import="dao.*"%>
<%@page import="model.*"%>
<%@page import="control.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
if(request.getSession().getAttribute("auth")== null) {
response.sendRedirect(getServletContext().getContextPath() +
"/login.jsp"); 
	} 

UtenteBean auth = (UtenteBean) request.getSession().getAttribute("auth");
%>

<!DOCTYPE html>
<html lang="it">
<head>

  	<%@ include file="meta.html"%>
	<% session.setAttribute("auth",(UtenteBean) request.getSession().getAttribute("auth")); %>
</head>

<body id="body">

<% session.setAttribute("auth",(UtenteBean) request.getSession().getAttribute("auth")); %>

<%@ include file="header.jsp"%>

<section class="page-header">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="content">
					<h1 class="page-name">Dettagli Profilo</h1>
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
				<li><a href="CronologiaOrdini">Ordini</a></li>
				<li><a href="Indirizzo?page=ok">Indirizzi</a></li>										
				<li><a class="active" href="Profile">Dettagli Profilo</a></li>	
			</ul> 
        <div class="dashboard-wrapper dashboard-user-profile">
          <div class="media">
            <div class="media-body">
              <ul class="user-profile-list">
                <li><span>Nome:</span><%= auth.getFirstName() %></li>
                <li><span>Cognome:</span><%= auth.getLastName() %></li>
                <li><span>Email:</span><%= auth.getEmail()%></li>
               <!--  <li><span>Data di nascita:</span><%= auth.getBirthday() %></li> -->
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

 <%@ include file="footer.html"%>
 <%@ include file="script.html"%>
    
  </body>
  </html>