<!DOCTYPE html>
<html lang="it">
<head>

 <%@ include file="meta.html"%>
<!--  
 
  
  
  <style>
.p1{
margin: 1px;
width: 100%;
}


.imge{
	border-radius: 50%;
	width:100%;
	width:180px;
	height:180px;
}

.card {
  box-shadow: 0 5px 10px 0 white;
  border-color: white;
  max-width: 300px;
  margin: auto;  
  text-align: left;
}

.col{
  float: left;
  width: auto;
  padding: 50px;
  border-color: white;
  margin : auto;
}



.row:after {
  content: "";
  display: table;
  clear: both;
  border-color: white;
}

@media screen and (max-width: 600px) {
  .col {
    width: 100%;
  }
}

.container {
  position: relative;
  width: 100%;
  }
  
.overlay {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  height: 100%;
  width: 100%;
  opacity: 0;
  transition: .5s ease;
}

.container:hover .overlay {
  opacity: 1;
}

.imge1 {
  width: 100%;
  position: absolute;
}
</style>

-->

<style>
.p1{
margin: 1px;
width: 100%;
}


.imge{
	border-radius: 50%;
	width:100%;
	width:180px;
	height:180px;
}

.card {
  box-shadow: 0 5px 10px 0 white;
  border-color: white;
  max-width: 300px;
  margin: auto;  
  text-align: left;
}
.col{
  float: left;
  width: 20%;
  padding: 10px;
  border-color: white;
}


.row:after {
  content: "";
  display: table;
  clear: both;
  border-color: white;
}

@media screen and (max-width: 600px) {
  .col {
    width: 100%;
  }
}

.container {
  position: relative;
  width: 100%;
  }
  
.overlay {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  height: 100%;
  width: 100%;
  opacity: 0;
  transition: .5s ease;
}

.container:hover .overlay {
  opacity: 1;
}

.imge1 {
  width: 100%;
  position: absolute;
}
</style>

</head>

<body id="body">

<%@ include file="header.jsp"%>

<section class="page-header">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="content">
					<h1 class="page-name">Chi Siamo</h1>
					<ol class="breadcrumb">
						<li><a href="index.html">Home</a></li>
						<li class="active">chi siamo</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
</section>
<p class="p1"> 
The Spectacles nasce nel 2022 da un gruppo di studenti dell'Università degli Studi di Salerno che 
hanno pensato di realizzare un e-commerce finalizzato alla vendita di occhiali per tutte le esigenze. 

		<div class="row">
			<div class="title"><h2>Il Team</h2></div>
		</div>

<div class="row">
<div class="col">
	<div class="card">
		<div class="container">
			<img src="images/team/Alessandro.jpg" class="imge"><br><br>
			<div class="overlay">
   				 <div class="imge1"><img src="./image/ChiSiamoMarilyn.jpeg" style="width:180px; height:180px; border-radius: 50%;">
   				 </div>
   			</div>
   		</div>
					<p><b>Roberto Piscopo</b><br>
						Studentessa di Informatica all'Università degli Studi di Salerno.<br>
						</p>
						<p>
								<br>Contatti:<br>
								M.Ferrara115@studenti.unisa.it<br>
								<a href="https://github.com/MiriamFerrara">Github.com/MiriamFerrara</a></p>
	</div>
</div>

<div class="col">
	<div class="card">
		<div class="container">
			<img src="images/team/Alessandro.jpg" class="imge"><br><br>
			<div class="overlay">
   				 <div class="imge1"><img src="./image/ChiSiamoMarilyn.jpeg" style="width:180px; height:180px; border-radius: 50%;">
   				 </div>
   			</div>
   		</div>
					<p><b>Mario Ranieri</b><br>
						Studentessa di Informatica all'Università degli Studi di Salerno.<br>
						</p>
						<p>
								<br>Contatti:<br>
								M.Ferrara115@studenti.unisa.it<br>
								<a href="https://github.com/MiriamFerrara">Github.com/MiriamFerrara</a></p>
	</div>
</div>

<div class="col">
	<div class="card">
		<div class="container">
			<img src="images/team/Alessandro.jpg" class="imge"><br><br>
			<div class="overlay">
   				 <div class="imge1"><img src="./image/ChiSiamoMarilyn.jpeg" style="width:180px; height:180px; border-radius: 50%;">
   				 </div>
   			</div>
   		</div>
					<p><b>Alessandro Satta</b><br>
						Studente di Informatica all'Università degli Studi di Salerno.<br>					
						</p>
						<p>
								<br>Contatti:<br>
								a.satta2@studenti.unisa.it<br>
								<a href="https://github.com/TechAlexS">https://github.com/TechAlexS</a>
						</p>
	</div>
</div>
</div>
<br><br>


 
 
 <%@ include file="footer.html"%>
 <%@ include file="script.html"%>


  </body>
  </html>