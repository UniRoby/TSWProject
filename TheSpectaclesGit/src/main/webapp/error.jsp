
<%@page isErrorPage="true" %>





		<div>	
			
			<h1 class="error-code">OPS</h1>
			<p class="error">Qualcosa è andato storto!</p>
			<p class="error">Errore <%=response.getStatus() %></p>
			
			<p><%
				if(exception!=null){
					out.flush();
					response.getWriter().println(exception.getMessage());
					exception.printStackTrace();
				}	
			%></p>
		</div>
			
		<form method="get" action="index.jsp">
			<button  class="btn btn-success mt-2" >Ritorno alla pagina principale</button>
		</form>
                       
           
            
                
            
            


