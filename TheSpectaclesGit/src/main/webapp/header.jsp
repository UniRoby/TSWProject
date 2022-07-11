
<%@page import="dao.*"%>
<%@page import="model.*"%>

<!-- Start Top Header Bar -->
<section class="top-header">
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-xs-12 col-sm-4">
				<div class="contact-number">
			
					
				</div>
			 </div>
			 <div class="col-md-4 col-xs-12 col-sm-4">
				<!-- Site Logo -->
				<div class="logo text-center">
					<a href="index.jsp">
						<!-- replace logo here 
						<svg width="490px" height="40px" viewBox="0 0 155 40" version="1.1" xmlns="http://www.w3.org/2000/svg"
							xmlns:xlink="http://www.w3.org/1999/xlink">
							<g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd" font-size="40"
								font-family="AustinBold, Austin" font-weight="bold">
								<g id="Group" transform="translate(-108.000000, -297.000000)" fill="#000000">
									<text id="Spectacles">
										<tspan x="-55" y="325">The Spectacles</tspan>
									</text>
								</g>
							</g>
						</svg>
						-->
						<svg width="490px" height="40px" viewBox="0 0 155 40" version="1.1" xmlns="http://www.w3.org/2000/svg"
							xmlns:xlink="http://www.w3.org/1999/xlink">
							<g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd" font-size="40"
								font-family="AustinBold, Austin" font-weight="bold">
								<g id="Group" transform="translate(-108.000000, -297.000000)" fill="#000000">
									<text id="Spectacles">
										<tspan x="-55" y="325">The Spectacles</tspan>
									</text>
								</g>
							</g>
						</svg>
					</a>
				</div>
			</div>
			<div class="col-md-4 col-xs-12 col-sm-4">
				<!-- Cart -->
				
				<%
					Carrello car= (Carrello) session.getAttribute("carrello");
					float totale=0;
					
				%>
				<ul class="top-menu text-right list-inline">
					<li class="dropdown cart-nav dropdown-slide">
			<a href="cart.jsp" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"><i
								class="tf-ion-android-cart"></i>Carrello</a>
						
						<% if ((car==null) || (car.getDimensione()==0)) { %>
							<div class="dropdown-menu cart-dropdown">
							
								<div class="media">
									<div class="media-body">
										<h4 class="media-heading"><a href="#!">Nessun prodotto nel carrello</a></h4>
									</div>
								</div>
							</div>
						
							 <%
								}
								else {
									for (int i=0; i<car.getDimensione(); i++) {
							%>
						<div class="dropdown-menu cart-dropdown">
							<!-- Cart Item -->
							<div class="media">
								<a class="pull-left" href="#!">
									<img class="media-object" src="images/shop/products/<%=car.getCarrello().get(i).getImage()%>" alt="image" />
								</a>
								<div class="media-body">
									<h4 class="media-heading"><a href="#!"><%=car.getCarrello().get(i).getNameGlasses()%></a></h4>
									<div class="cart-price">
										<span><%=car.getCarrello().get(i).getQuantity()%> x</span>
										<span><%=car.getCarrello().get(i).getPrice()%>&#8364;</span>
									</div>
									<h5><strong><%=car.getCarrello().get(i).getTotPrezzo()%>&#8364;</strong></h5>
									    
								</div>
								<a href="EliminaProdotto?id=<%= car.getCarrello().get(i).getIdGlasses() %>" class="remove"><i class="tf-ion-close"></i></a>
							</div><!-- / Cart Item -->
						

                           <%
                             totale=totale + car.getCarrello().get(i).getTotPrezzo();
							}
							%>
							
							
							<div class="cart-summary">
								<span>Total</span>
								<span class="total-price"><%=totale%>&#8364;</span>
							</div>
							<ul class="text-center cart-buttons">
								<li><a href="carrello.jsp" class="btn btn-small">Carrello</a></li>
								<li><a href="checkout.jsp" class="btn btn-small btn-solid-border">Pagamento</a></li>
							</ul>
						</div>
						<%
						}
						%>

					</li><!-- / Cart -->

					<!-- Search -->
					<li class="dropdown search dropdown-slide">
						<a href="#!" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"><i
								class="tf-ion-ios-search-strong"></i>Cerca </a>
						<ul class="dropdown-menu search-dropdown">
							<li>
								<form action="search" method="get"><input type="search" name="brand"class="form-Cerca" placeholder="Inserisci Marca"></form>
							</li>
						</ul>
					</li><!-- / Search -->

					<!-- Languages -->			
					 
					<%
				    if (session.getAttribute("auth") != null) {
				    %>
				
				   <li class="login">
						<a href="log-out" ><i
								class=""></i>Logout </a>
						<ul class="dropdown-menu search-dropdown">
						</ul>
					</li>
					<%
					} else {
					%>
                    <li class="login">
						<a href="login.jsp" ><i
								class=""></i>Login </a>
						<ul class="dropdown-menu search-dropdown">
						</ul>
					</li>
					<%
					}
					%>
				</ul><!-- / .nav .navbar-nav .navbar-right -->
			</div>
		</div>
	</div>
</section><!-- End Top Header Bar -->


<!-- Main Menu Section -->
<section class="menu">
	<nav class="navbar navigation">
		<div class="container">
			<div class="navbar-header">
				<h2 class="menu-title">Main Menu</h2>
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
					aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>

			</div><!-- / .navbar-header -->

			<!-- Navbar Links -->
			<div id="navbar" class="navbar-collapse collapse text-center">
				<ul class="nav navbar-nav">

					<!-- Home -->
					<li class="dropdown ">
						<a href="index.jsp">Home</a>
					</li><!-- / Home -->


					<!-- Elements -->
					<li class="dropdown dropdown-slide">
						<a href="shop.jsp" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="350"
							role="button" aria-haspopup="true" aria-expanded="false">Shop <span
								class="tf-ion-ios-arrow-down"></span></a>
						<div class="dropdown-menu">
							<div >

								<!-- Basic -->
								<div>
									<ul>
										<li class="dropdown-header">Categorie</li>
										<li role="separator" class="divider"></li>
										<li><a href="Categoria?tipo=vista">Occhiali da Vista</a></li>
										<li><a href="Categoria?tipo=sole">Occhiali da Sole</a></li>
										<li><a href="Categoria?tipo=luce">Occhiali filtro luce blu</a></li>

									</ul>
								</div>




							</div><!-- / .row -->
						</div><!-- / .dropdown-menu -->
					</li><!-- / Elements -->

						
						
						
					<li class="dropdown dropdown-slide">
						<a href="#!" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="350"
							role="button" aria-haspopup="true" aria-expanded="false">Profilo <span
								class="tf-ion-ios-arrow-down"></span></a>
						<div class="dropdown-menu">
							<div >

								<!-- Basic -->
								<div>
									<ul>
									<li class="dropdown-header">Dashboard</li>
										<li role="separator" class="divider"></li>
										<li><a href="profile_details.jsp">Dettagli Profilo</a></li>
										<li><a href="CronologiaOrdini">Ordini</a></li>
										<li><a href="Indirizzo?page='ok'">Indirizzi</a></li>

									</ul>
								</div>




							</div><!-- / .row -->
						</div><!-- / .dropdown-menu -->
					</li><!-- / Elements -->
						
						
						
						
					





				

				</ul><!-- / .nav .navbar-nav -->

			</div>
			<!--/.navbar-collapse -->
		</div><!-- / .container -->
	</nav>
</section>
