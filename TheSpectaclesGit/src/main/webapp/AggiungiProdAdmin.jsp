

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
<body >

<%@ include file="headerAmministratore.jsp"%>

<section class="signin-page account" >
 <form  class="checkout-form" action="AggiungiProdAdmin" method="post" enctype="multipart/form-data" align="center">
<div class="page-wrapper">
   <div class="checkout shopping">
      <div class="container">
         <div class="row">
            <div class="col-md-8">
               <div class="block billing-details">
                  <h4 class="widget-title">Aggiungi Prodotto</h4>
                  <p>Aggiungi le informazioni richieste per aggiungere un nuovo prodotto al catalogo </p>
           
                     


                    	 <div class="form-group">
                           <label for="id">ID Occhiale</label>
                           <input type="text" class="form-control"  name="id" placeholder="Inserisci id Occhiale" required>
                        </div>
                        <div class="form-group">
                           <label for="nome">Nome Occhiale</label>
                           <input type="text" class="form-control"  name="nome" placeholder="Inserisci il nome occhiale" required>
                        </div>
                        <div class="form-group">
                           <label for="brand">Brand</label>
                           <input type="text" class="form-control"  name="brand" placeholder="Inserisci il nome del brand" required>
                        </div>
                        
                          <div class="form-group">
                           <label for="prezzo">Prezzo</label>
                           <input type="text" class="form-control"  name="prezzo" placeholder="Inserisci il prezzo" required>
                       	 </div>
                       	  <div class="form-group">
                           <label for="disp">Disponibilità</label>
                           <input type="text" class="form-control"  name="disp" placeholder="Inserisci la disponibilità/quantità" required>
                       	 </div>
                       	 <div class="form-group">
                           <label for="colore">Colore</label>
                           <input type="text" class="form-control"  name="colore" placeholder="Inserisci il colore" required>
                       	 </div>
                       	 <div class="form-group">
                       	 	<select name="categoria">
							<option value="sole"> Sole </option>
							<option value="vista"> Vista </option>
							<option value="luce"> Luce blu</option>
							</select> 
						</div>
						<div class="form-group">
                       	 <select name="sesso">
							<option value="U"> Uomo </option>
							<option value="D"> Donna </option>
						 </select> 
                      	</div>
                        <div class="form-group">
	                        <label for="desc">Descrizione</label>
	                        <input type="text" class="form-control" name="desc"  required>
                        </div>
                         <div class="form-group">
	                        <label for="desc">Aggiungi immagine 1</label>
	                         <input type="file"  name="img1" accept=".jpg, .jpeg, .png"  required> 
                        </div>
                         <div class="form-group">
	                        <label for="desc">Aggiungi immagine 2</label>
	                         <input type="file"  name="img2" accept=".jpg, .jpeg, .png" > 
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