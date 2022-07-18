<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.util.*"%>
	<%@page import="dao.*"%>
	<%@page import="model.*"%>
	<%@page import="control.*"%>
	<%@page import="java.util.*"%>

<!DOCTYPE html>
<html lang="it">
<head>

  <meta charset="utf-8">
  <script src="./resources/Ajax.js"></script>
  <title>The Spectacles | E-commerce</title>
  
 <%@ include file="meta.html"%>

</head>

<body id="body">

<section class="forget-password-page account">
  <div class="container">
    <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <div class="block text-center">
          <a class="logo" href="index.html">
            <img src="images/logo.png" alt="">
          </a>
          <h2 class="text-center">Welcome Back</h2>
          <form method="post" class="text-left clearfix">
            <p>per favore inserisci la mail del tuo account</p>
            <div class="form-group">
              <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Account email address" required">
            </div>
            <div class="text-center">
              <button type="submit" id="submit" class="btn btn-main text-center">Request password reset</button>
            </div>
          </form>
          <p class="mt-20"><a href="login.jsp">Back to log in</a></p>
        </div>
      </div>
    </div>
  </div>
</section>

    <%@ include file="footer.html"%>
    <%@ include file="script.html"%>
    <script src="./resources/ajaxForget.js"></script>
    
  </body>
  </html>