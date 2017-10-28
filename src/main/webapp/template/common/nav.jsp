<%@page import="pe.edu.cibertec.fkarz.auth.AuthServlet"%>
<header class="header black-bg">
	
<!-- 	<div class="sidebar-toggle-box"> -->
<!-- 		<div class="fa fa-bars tooltips" data-placement="right" -->
<!-- 			data-original-title="Toggle Navigation"></div> -->
<!-- 	</div> -->

	<a href="intranet" class="logo"><b>F-KARZ</b></a>

	<div class="top-menu">

		<ul class="nav pull-right notify-row top-menu" style="display: block;">
			<li class="dropdown"><a data-toggle="dropdown"
				class="dropdown-toggle" href="#" style="margin: 0"> <i class="fa fa-user"></i>
			</a>
				<ul class="dropdown-menu extended tasks-bar inbox"
					style="left: auto; right: 0">
					<div class="notify-arrow notify-arrow-green"
						style="left: auto; right: 5px"></div>
					<li>
						<p class="green">Bienvenido!</p>
					</li>

					<li><a href="index.html#"> <span class="photo"><img
								alt="avatar" src="assets/img/ui-danro.jpg"></span> <span
							class="subject"> <span class="from">Josue Mapelli</span>
						</span> <span class="message">kxel@outlook.com</span>
					</a></li>

					<li><a class="logout" href="#">Mis reservas</a></li>
					<li><a class="logout"
						href="auth?action=<%=AuthServlet.ACTION_LOGOUT%>">Cerrar
							sesión</a></li>
				</ul></li>
		</ul>
	</div>
</header>