<%@ page import="pe.edu.cibertec.fkarz.core.reserva.ReservaEntity" %>
<%@ page import="pe.edu.cibertec.fkarz.core.reserva.ReservaEstadoEntity" %>
<%@ page import="pe.edu.cibertec.fkarz.util.Estado" %>
<%@ page import="pe.edu.cibertec.fkarz.util.DateUtil" %>
<%@ page import="pe.edu.cibertec.fkarz.core.garantia.GarantiaEntity" %>
<%@ page import="pe.edu.cibertec.fkarz.core.garantia.GarantiaEstadoEntity" %>
<%@ page import="pe.edu.cibertec.fkarz.core.vehiculo.VehiculoEntity" %>
<%@ page import="pe.edu.cibertec.fkarz.core.reserva.ReservaPenalizacionEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="pe.edu.cibertec.fkarz.core.contrato.ContratoEntity" %><%--
  Created by IntelliJ IDEA.
  User: JosueAngel
  Date: 04/12/2017
  Time: 01:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    ReservaEntity reserva = (ReservaEntity) request.getAttribute("reserva");
    ReservaEstadoEntity reserva_estado = (ReservaEstadoEntity) request.getAttribute("reserva_estado");
    GarantiaEntity garantia = (GarantiaEntity) request.getAttribute("garantia");
    GarantiaEstadoEntity garantia_estado = (GarantiaEstadoEntity) request.getAttribute("garantia_estado");
    VehiculoEntity vehiculo = (VehiculoEntity) request.getAttribute("vehiculo");
    ContratoEntity contrato = (ContratoEntity) request.getAttribute("contrato");
    List<ReservaPenalizacionEntity> penalizaciones = (List) request.getAttribute("penalizaciones");
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ include file="../../common/header.jsp" %>

<section id="container">
    <%@ include file="../../common/nav.jsp" %>
    <%@ include file="../../common/sidebar.jsp" %>

    <section id="main-content">
        <section class="wrapper">

            <div class="row mt">
                <div class="col-lg-12">
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
                                        <td><b>Nro. reserva:</b></td>
                                        <td style="text-align: right;"><%=reserva.getNroOrden()%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><b>Estado:</b></td>
                                        <td style="text-align: right;"><%=Estado.toString(reserva_estado.getEstado())%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><b>Fechas reservadas:</b></td>
                                        <td style="text-align: right;"><%=DateUtil.toString("dd/MM/yyyy", reserva.getFechaInicio())%>
                                            hasta <%=DateUtil.toString("dd/MM/yyyy", reserva.getFechaFin())%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><b>Subtotal:</b></td>
                                        <td style="text-align: right;">S/. <%=reserva.getTotal()%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><b>Garantía:</b></td>
                                        <td style="text-align: right;">S/. <%=garantia.getMonto()%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><b>TOTAL:</b></td>
                                        <td style="text-align: right;">S/. <%=reserva.getTotal() + garantia.getMonto()%>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </section>
                </div>
            </div>

            <div class="row mt">
                <div class="col-lg-12">
                    <section class="task-panel tasks-widget">
                        <div class="panel-heading">
                            <div class="pull-left">
                                <h5>Datos del vehiculo</h5>
                            </div>
                            <br>
                        </div>
                        <div class="panel-body">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12"
                                 style="height: 176px; background: url(<%=vehiculo.getFoto()%>); background-repeat: no-repeat; background-size: cover; background-position: center;"></div>
                            <div class="task-content col-lg-8 col-md-8 col-sm-8 col-xs-12"
                                 style="margin-bottom: 0; padding: 0">
                                <table class="table table-striped" style="margin-bottom: 0">
                                    <tbody>
                                    <tr>
                                        <td><b>Marca:</b></td>
                                        <td style="text-align: right;"><%=vehiculo.getMarca()%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><b>Modelo:</b></td>
                                        <td style="text-align: right;"><%=vehiculo.getModelo()%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><b>Año:</b></td>
                                        <td style="text-align: right;"><%=vehiculo.getAnio()%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><b>Nro. registro:</b></td>
                                        <td style="text-align: right;"><%=vehiculo.getNroRegistro()%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><b>Color:</b></td>
                                        <td style="text-align: right;"><%=vehiculo.getColor()%>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </section>
                </div>
            </div>

            <div class="row mt">
                <div class="col-lg-12">
                    <section class="task-panel tasks-widget">
                        <div class="panel-heading">
                            <div class="pull-left">
                                <h5>Garantía</h5>
                            </div>
                            <br>
                        </div>
                        <div class="panel-body">
                            <div class="task-content" style="margin-bottom: 0; padding: 0">
                                <table class="table table-striped" style="margin-bottom: 0">
                                    <tbody>
                                    <tr>
                                        <td><b>Monto en garantía:</b></td>
                                        <td style="text-align: right;">S/. <%=garantia.getMonto()%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><b>Fecha devolución:</b></td>
                                        <td style="text-align: right;"><%=DateUtil.toString("dd/MM/yyyy", garantia.getFechaDevolucion())%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><b>Estado:</b></td>
                                        <td style="text-align: right;"><%=Estado.toString(garantia_estado.getEstado())%>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </section>
                </div>
            </div>


            <div class="row mt">
                <div class="col-lg-12">
                    <section class="task-panel tasks-widget">
                        <div class="panel-heading">
                            <div class="pull-left">
                                <h5>Datos del contrato</h5>
                            </div>
                            <br>
                        </div>
                        <div id="contrato_result" class="panel-body">
                            <%if (contrato == null) {%>
                            <button id="subir" type="button" class="btn btn-primary">Registrar contrato
                            </button>
                            <%} else {%>
                            <div class="task-content" style="margin-bottom: 0; padding: 0">
                                <table class="table table-striped" style="margin-bottom: 0">
                                    <tbody>
                                    <tr>
                                        <td><b>Registrado el:</b></td>
                                        <td style="text-align: right;"><%=DateUtil.toString("dd/MM/mmmm", contrato.getFechaRegistro())%>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><b>Documento:</b></td>
                                        <td style="text-align: right;">
                                            <a href="<%=contrato.getUri()%>" >Decargar</a>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <%}%>
                        </div>
                    </section>
                </div>
            </div>

        </section>
    </section>
</section>

<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" style="text-align: center">Registrar contrato</h4>
            </div>
            <div class="modal-body" style="text-align: center;">
                <div class="input-group">
                    <input id="file" type="file" class="form-control col-sm-10">
                </div>
            </div>
            <div class="modal-footer">
                <button id="guardar" type="button" class="btn btn-default" data-dismiss="modal">registrar</button>
            </div>
        </div>
    </div>
</div>

<%@ include file="../../common/footer.jsp" %>

<script>
    $(function () {
        $('#subir').click(function (e) {
            $('#modal').modal({
                backdrop: 'static',
                keyboard: false,
                show: true
            });
        });

        $('#guardar').click(function (e) {
            e.preventDefault();

            $.post('contrato', {
                    file: $('#file').val(),
                    reserva: '<%=reserva.getId()%>'
                }, function (response) {
                    $('#contrato_result').html(response);
                }
            );
        });
    });
</script>

