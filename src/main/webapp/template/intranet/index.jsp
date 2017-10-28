<%@ include file="../common/header.jsp"%>
<%@ include file="../common/nav.jsp"%>

<%
	String mensaje = (String) request.getAttribute("message");
%>

<%=mensaje%>

<%@ include file="../common/footer.jsp"%>