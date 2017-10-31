<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="pe.edu.cibertec.fkarz.core.vehiculo.VehiculoEntity"%>
<%@page import="pe.edu.cibertec.fkarz.core.reserva.ReservaEntity"%>
<%@ include file="../common/header.jsp"%>
<%
	ReservaEntity re = (ReservaEntity) request.getSession().getAttribute("reserva");
	VehiculoEntity ve = (VehiculoEntity) request.getSession().getAttribute("vehiculo");
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
%>
<section id="container">
	<%@ include file="../common/nav.jsp"%>

	<section id="main-content" style="margin: 0">
		<section class="wrapper">

			<div class="row mt">
				<div class="col-lg-8 col-md-8 col-sm-10 col-xs-12"
					style="margin: auto; float: none;">
					<section class="task-panel tasks-widget">
						<div class="panel-heading">
							<div class="pull-left">
								<h5>Resumen de reserva</h5>
							</div>
							<br>
						</div>
						<div class="panel-body">
							<div class="task-content" style="margin-bottom: 0">
								<table class="table table-striped" style="margin-bottom: 0">
									<tbody>
										<tr>
											<td><b>Fechas reservadas:</b></td>
											<td style="text-align: right;"><%=df.format(re.getFechaInicio())%>
												hasta <%=df.format(re.getFechaFin())%></td>
										</tr>
										<tr>
											<td><b>Subtotal:</b></td>
											<td style="text-align: right;">S/. <%=re.getSubTotal()%></td>
										</tr>
										<tr>
											<td><b>Garantía:</b></td>
											<td style="text-align: right;">S/. <%=re.getGarantia()%></td>
										</tr>
										<tr>
											<td><b>TOTAL:</b></td>
											<td style="text-align: right;">S/. <%=re.getTotal()%></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</section>
				</div>
			</div>

			<div class="row mt">
				<div class="col-lg-8 col-md-8 col-sm-10 col-xs-12"
					style="margin: auto; float: none;">
					<section class="task-panel tasks-widget">
						<div class="panel-heading">
							<div class="pull-left">
								<h5>Datos del vehiculo</h5>
							</div>
							<br>
						</div>
						<div class="panel-body">
							<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12"
								style="height: 176px; background: url(<%=ve.getFoto()%>); background-repeat: no-repeat; background-size: cover; background-position: center;"></div>
							<div class="task-content col-lg-8 col-md-8 col-sm-8 col-xs-12"
								style="margin-bottom: 0; padding: 0">
								<table class="table table-striped" style="margin-bottom: 0">
									<tbody>
										<tr>
											<td><b>Marca:</b></td>
											<td style="text-align: right;"><%=ve.getMarca()%></td>
										</tr>
										<tr>
											<td><b>Modelo:</b></td>
											<td style="text-align: right;"><%=ve.getModelo()%></td>
										</tr>
										<tr>
											<td><b>Año:</b></td>
											<td style="text-align: right;"><%=ve.getAnio()%></td>
										</tr>
										<tr>
											<td><b>Nro. registro:</b></td>
											<td style="text-align: right;"><%=ve.getNroRegistro()%></td>
										</tr>
										<tr>
											<td><b>Color:</b></td>
											<td style="text-align: right;"><%=ve.getColor()%></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</section>
				</div>
			</div>
			<form>
				<div class="row mt">
					<div class="col-lg-8 col-md-8 col-sm-10 col-xs-12"
						style="margin: auto; float: none;">
						<section class="task-panel tasks-widget">
							<div class="panel-heading">
								<div class="pull-left">
									<h5>Datos del pago</h5>
								</div>
								<br>
							</div>
							<div class="panel-body">
								<div class="form-horizontal style-form">
									<div class="form-group">
										<label class="col-sm-2 control-label">Nro. tarjeta:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control"
												placeholder="0123-4567-8987-6543">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Vencimiento:</label>
										<div class="col-sm-2">
											<input type="text" class="form-control" placeholder="05/20">
										</div>
										<label class="col-sm-1 control-label"></label>
										<div class="col-sm-2">
										</div>
										<label class="col-sm-1 control-label">CVV/CVC:</label>
										<div class="col-sm-2">
											<input type="text" class="form-control" placeholder="124">
										</div>
									</div>
									<label class="checkbox-inline" style="margin-bottom: 15px">
										<input type="checkbox" value="true"> Deseo factura
										para esta compra
									</label>
									<div class="form-group">
										<label class="col-sm-2 control-label">Razón social:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">Nro. ruc:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control">
										</div>
									</div>
								</div>
							</div>
						</section>
					</div>
				</div>
				<div class="row mt">
					<div class="col-lg-8 col-md-8 col-sm-10 col-xs-12"
						style="margin: auto; float: none;">
						<div class="col-sm-8">
							<label class="checkbox-inline" style="margin-bottom: 15px">
								<input type="checkbox" value="true">Acepto los terminos
								y condiciones
							</label>
						</div>
						<div class="col-sm-4">
							<button type="button" class="btn btn-primary col-sm-5 col-xs-12">Reservar</button>
							<span class="col-sm-2 hidden-xs"></span>
							<button type="button" class="btn btn-default col-sm-5 col-xs-12">Cancelar</button>
						</div>
					</div>
				</div>

			</form>

		</section>
	</section>
</section>

<%@ include file="../common/footer.jsp"%>