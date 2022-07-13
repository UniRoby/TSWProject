



<div style="float:right;">
<label><b> Aggiungi un immagine:</b></label>
<input type="file"  name="fileProd" accept=".jpg, .jpeg, .png"> <br> <br>
</div>
<input type="submit" class="login" value="Conferma aggiunta">
</form>
</div>
</body>
</html>





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
 <form  class="checkout-form" action="AggiungiProdAdmin" method="post" enctype="multipart/form-data">
<div class="page-wrapper">
   <div class="checkout shopping">
      <div class="container">
         <div class="row">
            <div class="col-md-8">
               <div class="block billing-details">
                  <h4 class="widget-title">Aggiungi Prodotto</h4>
                  <p>Aggiungi le informazioni richieste per aggiungere un nuovo prodotto al catalogo </p>
           
                     

<input type="text" name="disponibilitaProd" placeholder="Inserisci la disponibilità (SI o NO)" size="40px" required> <br>
<label><b>Quantità:</b></label> <br>
<input type="text" name="quantitaProd" placeholder="Inserisci la quantita del prodotto" size="40px" required> <br>
<label><b>IVA del prodotto:</b></label> <br>
<input type="text" name="ivaProd" placeholder="Inserisci l'iva del prodotto (0.22)" size="40px" required> <br>
<label><b>Descrizione:</b></label> <br>
<input type="text" name="descrizioneProd" placeholder="Inserisci la descrizione del prodotto" size="40px" required> <br>
<label><b>Prezzo base:</b></label> <br>
<input type="text" name="prezzoBaseProd" placeholder="Inserisci il prezzo base del prodotto" size="40px" required> <br>
<label><b>Tipologia prodotto:</b></label>
<select name="tipologia">
<option value="cane"> Cane </option>
<option value="gatto"> Gatto </option>
<option value="animali piccola taglia"> Animali piccola taglia </option>
<option value="uccelli"> Uccelli </option>
</select> 
                     
                        <div class="form-group">
                           <label for="user_post_code">Nome Prodotto</label>
                           <input type="text" class="form-control"  name="nome" placeholder="Inserisci il nome del prodotto" required>
                        </div>
                        <div class="form-group">
                           <label for="user_post_code">Brand</label>
                           <input type="text" class="form-control"  name="brand" placeholder="Inserisci il nome del brand" required>
                        </div>
                         <div class="form-group">
                           <label for="user_post_code">Codice Occhiale</label>
                           <input type="text" class="form-control"  name="brand" placeholder="Inserisci il codice occhiale" required>
                        </div>
                          <div class="form-group">
                           <label for="user_post_code">Prezzo</label>
                           <input type="text" class="form-control"  name="prezzo" placeholder="Inserisci il prezzo" required>
                        </div>
                      
                        
                      
                     
                     <div class="form-group">
                        <label for="user_country">Prezzo</label>
                        <input type="text" class="form-control" name="prezzo"   required>
                     </div>
                     <div class="form-group">
                        <label for="user_country">Quantità</label>
                        <input type="text" class="form-control" name="disp"   required>
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