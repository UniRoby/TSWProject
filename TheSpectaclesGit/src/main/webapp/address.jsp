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
          <li><a href="order.jsp">Ordini</a></li>
          <li><a class="active" href="Indirizzo?page='ok'">Indirizzi</a></li>
          <li><a href="profile-details.jsp">Dettagli Profilo</a></li>
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
         
             
                  
                  <%if (indirizzi != null && indirizzi.size() != 0) {
						Iterator<?> it = indirizzi.iterator();
						while (it.hasNext()) {
							IndirizziBean bean = (IndirizziBean) it.next();%>
                
                  
                 
                  
                
                <tr>
                  <td><%= auth.getFirstName() %> <%= auth.getLastName() %></td>
                  <td><%= bean.getAddress() %></td>
                  <td><%= bean.getCity() %>, <%= bean.getProvince() %> </td>
                  <td><%= bean.getCap() %></td>
                  <td>+884 5452 6452</td>
                  <td>
                    <div class="btn-group" role="group">
                      <button type="button" class="btn btn-default"><i class="tf-pencil2" aria-hidden="true"></i></button>
                      <button type="button" class="btn btn-default"><i class="tf-ion-close" aria-hidden="true"></i></button>
                    </div>
                  </td>
                </tr>
              
              </tbody>
               <% }						
					 	}%>
            </table>
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