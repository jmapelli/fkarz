<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<%@ include file="../../common/header.jsp"%>

<section id="container">
	<%@ include file="../../common/nav.jsp"%>
	<%@ include file="../../common/sidebar.jsp"%>

	<section id="main-content">
		<section class="wrapper">

			<h3><i class="fa fa-angle-right"></i> Vehiculo</h3>

			<div class="row mt">
				<div class="col-lg-12">
					<div class="form-panel">
						<h4 class="mb"><i class="fa fa-angle-right"></i> Crear</h4>
						<form class="form-horizontal style-form" method="post" action="vehiculo?action=guardar">

							<div class="form-group">
								<label class="col-sm-2 col-sm-2 control-label">Nro. de registro</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="nroRegistro">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 col-sm-2 control-label">Marca</label>
								<div class="col-sm-10">
									<select class="form-control" name="marca">
										<option value="MERCEDES BENZ">MERCEDES BENZ</option>
										<option value="KIA">KIA</option>
										<option value="HYUNDAI">HYUNDAI</option>
										<option value="TOYOTA">TOYOTA</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 col-sm-2 control-label">Modelo</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="modelo" value="SEDAN">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 col-sm-2 control-label">Año</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="anio">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 col-sm-2 control-label">Color</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="color">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 col-sm-2 control-label">Foto</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="foto">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 col-sm-2 control-label">Combustible</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="combustible" value="GNV">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 col-sm-2 control-label">Precio</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="precio">
								</div>
							</div>

							<button type="submit" class="btn btn-theme" name="guardar">Guardar</button>

						</form>
					</div>
				</div>
			</div>

		</section>
	</section>
</section>

<%@ include file="../../common/footer.jsp"%>
