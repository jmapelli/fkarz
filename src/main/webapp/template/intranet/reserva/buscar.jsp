<%@ page import="pe.edu.cibertec.fkarz.intranet.reserva.ReservaBuscarIntranetServlet" %>
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
                                <h5>Buscar reserva</h5>
                            </div>
                            <br>
                        </div>
                        <div class="panel-body">
                            <div class="task-content" style="margin-bottom: 0">
                                <form class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Buscar</label>
                                        <div class="col-sm-10">
                                            <select id="action" class="form-control">
                                                <option value="<%=ReservaBuscarIntranetServlet.ACTION_FINDBYSUSCRIPTOR%>">
                                                    Por Suscriptor
                                                </option>
                                                <option value="<%=ReservaBuscarIntranetServlet.ACTION_FINDBYRESERVA%>"
                                                        disabled>Por reserva
                                                </option>

                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 col-sm-2 control-label">Valor</label>
                                        <div class=" col-sm-10">
                                            <div class="input-group">
                                                <input id="valor" type="text"
                                                       class="form-control col-sm-10">
                                                <span class="input-group-btn">
                                            <button id="buscar" class="btn btn-primary" type="button">
                                                <i class="fa fa-search"></i>
                                            </button>
                                        </span>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <hr style="border-top: 1px solid #ddd;">
                            <div style="margin: 5px;">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>Nro. reserva</th>
                                        <th>Nro documento</th>
                                        <th>Nombres y apellidos</th>
                                        <th>Fecha inicio</th>
                                        <th>Fecha fin</th>
                                        <th>Estado</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody id="buscar_result">
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </section>


                </div>
            </div>

        </section>
    </section>
</section>
<%@ include file="../../common/footer.jsp" %>

<script>
    $(function () {
        $('#buscar').click(function (e) {
            e.preventDefault();

            $.get('buscar', {
                    action: $('#action').val(),
                    valor: $('#valor').val()
                }, function (response) {
                    $('#buscar_result').html(response);
                }
            );
        });
    });
</script>