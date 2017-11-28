<%@page
	import="pe.edu.cibertec.fkarz.intranet.SuscriptorIntranetServlet"%>
<aside>
	<div id="sidebar" class="nav-collapse ">
		<ul class="sidebar-menu" id="nav-accordion">
			<p class="centered">
				<a href="profile.html"><img
					src="<%=request.getContextPath()%>/assets/img/ui-sam.jpg"
					class="img-circle" width="60"></a>
			</p>
			<h5 class="centered">Josue Mapelli</h5>

			<li class="mt"><a
				href="<%=request.getContextPath()%>/intranet/reserva"> <i
					class="fa fa-book"></i><span>Reservas</span>
			</a></li>

			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-users"></i> <span>Suscriptores</span>
			</a>
				<ul class="sub">
					<li><a
						href="<%=request.getContextPath()%>/intranet/suscriptor">Listar
							suscriptores</a></li>
					<li><a
						href="<%=request.getContextPath()%>/intranet/suscriptor?action=<%=SuscriptorIntranetServlet.ACTION_CREAR%>">Crear
							suscriptor</a></li>
				</ul></li>

			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-car"></i> <span>Vehículos</span>
			</a>
				<ul class="sub">
					<li><a href="<%=request.getContextPath()%>/intranet/vehiculo">Listar vehículos</a></li>
					<li><a href="<%=request.getContextPath()%>/intranet/vehiculo?action=<%=SuscriptorIntranetServlet.ACTION_CREAR%>">Crear vehículo</a></li>
				</ul></li>

			<li class="mt" style="margin-top: 0px;"><a href="<%=request.getContextPath()%>/intranet/pago">
					<i class="fa fa-money"></i><span>Pagos</span>
			</a></li>
		</ul>
	</div>
</aside>