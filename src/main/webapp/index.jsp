<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ include file="./template/common/header.jsp" %>
<section id="container">
    <%@ include file="./template/common/nav.jsp" %>

    <section id="main-content" style="margin: 0">
        <section class="wrapper">
            <div class="row mt">
                <div class="col-lg-12">
                    <div class="form-panel">
                        <h5>Filtrar</h5>
                        <form class="form-inline" role="form">

                            <div class="form-group">
                                <input id="fecha_inicio" type="date" class="form-control"
                                       placeholder="Fecha de inicio">
                            </div>

                            <div class="form-group">
                                <input id="fecha_fin" type="date" class="form-control"
                                       placeholder="Fecha de fin">
                            </div>

                            <button id="search" type="submit" class="btn btn-theme">Buscar</button>
                        </form>
                    </div>
                </div>
            </div>

            <div id="result_search"></div>

        </section>
    </section>
</section>

<%@ include file="./template/common/footer.jsp" %>

<script type="text/javascript">
    $(function () {
        $('#search').click(function (e) {
            e.preventDefault();

            $.get('extranet/buscar', {
                fecha_inicio: $('#fecha_inicio').val(),
                fecha_fin: $('#fecha_fin').val()
            }, function (response) {
                $('#result_search').html(response);
            });

        })
    });
</script>