<!DOCTYPE html>
<html lang="it">
<head>

 <%@ include file="meta.html"%>

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
<p class="p1" align="center"> 
The Spectacles nasce nel 2022 da un gruppo di studenti dell'Università degli Studi di Salerno che 
hanno pensato di realizzare un e-commerce finalizzato alla vendita di occhiali per tutte le esigenze. 

		<div class="row">
			<div class="title"><h2>Il Team</h2></div>
		</div>

<div align="center">
<div>
	<div>
		<div class="container">
			<img src="images/team/roberto.jpg" class="imge"><br><br>
   		</div>
					<p><b>Roberto Piscopo</b><br>

						Student di Informatica all'Università degli Studi di Salerno.<br>

						</p>
						<p>
								<br>Contatti:<br>
								r.piscopo8@studenti.unisa.it<br>

								

								<a href="https://github.com/UniRoby">Github.com/UniRoby</a></p>

	</div>
</div>

<div align="center">
	<div>
		<div class="container">
			<img src="images/team/mario.jpg" class="imge"><br><br>
   		</div>
					<p><b>Mario Ranieri</b><br>
						Studente di Informatica all'Università degli Studi di Salerno.<br>
						</p>
						<p>
								<br>Contatti:<br>

								m.ranieri@studenti.unisa.it<br>					
								<a href="https://github.com/Mario3107">Github.com/Mario3107</a></p>
	</div>

</div>

<div align="center">
	<div>
		<div class="container">
			<img src="images/team/Alessandro.jpg" class="imge"><br><br>
   		</div>
					<p><b>Alessandro Satta</b><br>
						Studente di Informatica all'Università degli Studi di Salerno.<br>					
						</p>
						<p>
								<br>Contatti:<br>
								a.satta2@studenti.unisa.it<br>
								<a href="https://github.com/TechAlexS">Github.com/TechAlexS</a>
						</p>
	</div>
</div>
</div>

 <%@ include file="footer.html"%>
 <%@ include file="script.html"%>

  </body>
  </html>