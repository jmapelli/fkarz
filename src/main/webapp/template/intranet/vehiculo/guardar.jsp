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
						<h4 class="mb"><i class="fa fa-angle-right"></i> Resultado</h4>

						<% if(request.getAttribute("result").equals("OK")) { %>
							<div class="alert alert-success"><b>Vehiculo</b> guardado correctamente</div>
						<% } %>

						<% if(request.getAttribute("result").equals("ERROR")) { %>
						<div class="alert alert-danger"><b>Vehiculo</b> con nro de registro duplicado</div>
						<% } %>

					</div>
				</div>
			</div>

		</section>
	</section>
</section>

<%@ include file="../../common/footer.jsp"%>
