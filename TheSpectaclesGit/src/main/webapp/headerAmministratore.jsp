

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
										<tspan x="-55" y="325">The Spectacles - admin</tspan>
									</text>
								</g>
							</g>
						</svg>
					</a>
				</div>
			</div>
				<div class="log">
				
					<ul>
					<%
				    if (session.getAttribute("auth") != null) {
				    %>
				
				   <li class="login">
						<a href="log-out" ><i class=""></i>Logout </a>
						<ul class="dropdown-menu search-dropdown">
						</ul>
					</li>
					<%
					} else {
					%>
                    <li class="login">
						<a href="login.jsp" ><i class=""></i>Login </a>
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
		</div>
	</div>
</section><!-- End Top Header Bar -->


<!-- Main Menu Section -->
<section class="menu">
	<nav class="navbar navigation">
		<div class="container">
			<div class="navbar-header">
				<h2 class="menu-title">Gestione</h2>
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
						<a href="ControlloAmministratore.jsp">Home</a>
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
										<li class="dropdown-header">Opzioni</li>
										<li role="separator" class="divider"></li>
										<li><a href="ControlloAdmin?azione=controllo">Controlla il catalogo</a></li>
										<li><a href="ControlloAdmin?azione=ordiniNominativo">Controlla gli ordini per cliente</a></li>
										<li><a href="ControlloAdmin?azione=ordiniData">Controlla gli ordini per Data</a></li>

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
