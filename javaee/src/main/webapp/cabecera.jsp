<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<style>
	nav {
		background-color: #CCC;
		color: black;
		margin-bottom: 3px solid BEBEBE;
	}
</style>
<body>
	<nav> <%
 	Usuario usuarioLogueado = (Usuario) session.getAttribute("usuario_logueado");
 	if (usuarioLogueado != null) {
 %>
	<p><%=usuarioLogueado.getEmail()%></p>
	<a href="logout">Cerrar Sesi�n</a> <%
 	} else {
 %> <a href="login.jsp">Iniciar Sesi�n</a> <%
 	}
 %> </nav>
</body>