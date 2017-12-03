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
                                <form class="form-inline">
                                    <div class="form-group">
                                        <input type="text" class="form-control"
                                               placeholder="Buscar por nro. reserva">
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control"
                                               placeholder="Buscar por suscriptor">
                                    </div>
                                    <button class="btn btn-theme">Buscar</button>
                                </form>
                            </div>
                            <hr style="border-top: 1px solid #ddd;">
                            <div id="result" style="margin: 5px;">
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
                                    <tbody>
                                    <tr>
                                        <td>Rxxxxxx</td>
                                        <td>3216548</td>
                                        <td>Josue Mapelli</td>
                                        <td>20-05-2017</td>
                                        <td>20-05-2017</td>
                                        <td>ACTIVO</td>
                                        <td>
                                            <button class="btn btn-success btn-xs">
                                                <i class="fa fa-sign-in"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Rxxxxxx</td>
                                        <td>3216548</td>
                                        <td>Josue Mapelli</td>
                                        <td>20-05-2017</td>
                                        <td>20-05-2017</td>
                                        <td>ACTIVO</td>
                                        <td>
                                            <button class="btn btn-success btn-xs">
                                                <i class="fa fa-sign-in"></i>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Rxxxxxx</td>
                                        <td>3216548</td>
                                        <td>Josue Mapelli</td>
                                        <td>20-05-2017</td>
                                        <td>20-05-2017</td>
                                        <td>ACTIVO</td>
                                        <td>
                                            <button class="btn btn-success btn-xs">
                                                <i class="fa fa-sign-in"></i>
                                            </button>
                                        </td>
                                    </tr>
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
