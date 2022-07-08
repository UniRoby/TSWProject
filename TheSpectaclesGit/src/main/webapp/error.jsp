<%@page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="it">
<head>


 <%@ include file="meta.html"%>

</head>

<body id="body">
	<section class="page-404">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<a href="index.jsp">
						<img src="images/logo.jpg" alt="site logo" />
					</a>
					<h1>Errore <%=response.getStatus() %></h1>
					<h2>Qualcosa è andato storto!</h2>
						<p><%
							if(exception!=null){
								out.flush();
								response.getWriter().println(exception.getMessage());
								exception.printStackTrace();
							}	
						%></p>
					<a href="index.jsp" class="btn btn-main"><i class="tf-ion-android-arrow-back"></i>Pagina Principale</a>
					
				</div>
			</div>
		</div>
	</section>
   
   
   
<%@ include file="footer.html"%>

 <%@ include file="script.html"%>

  </body>
  </html>
