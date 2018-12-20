<%@page import="com.ipartek.formacion.modelo.pojos.Video"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<%@page import="java.util.ArrayList"%>
<style>
nav {
	background-color: #CCC;
	color: black;
	margin-bottom: 3px solid BEBEBE;
}
/* 
#carrito {
	position: fixed;
	background-color: teal;
	color: #FFF;
	top: 0;
	bottom: 0;
	width: 200px;
	height: 500px;
	padding: 5px 10px;
} 
*/
#carrito .titulo {
	text-align: center;
	text-transform: uppercase;
}
</style>
<body>
	<nav>
		<%
			Usuario usuarioLogueado = (Usuario) session.getAttribute("usuario_logueado");
			if (usuarioLogueado != null) {
		%>
		<p><%=usuarioLogueado.getEmail()%></p>
		<a href="logout">Cerrar Sesi�n</a>
		<%
			} else {
		%>
		<a href="login.jsp">Iniciar Sesi�n</a>
		<%
			}
		%>
	</nav>
	<!-- carrito de la compra -->
	<%
		ArrayList<Video> carrito = (ArrayList<Video>) session.getAttribute("carrito");
		if (carrito == null) {
			carrito = new ArrayList<Video>();
		}
	%>
	<div id="carrito">
		<span class="titulo">Carrito compra</span>
		<%
			if (carrito.isEmpty()) {
				out.print("<p>Todav�a no hay productos</p>");
			} else {
				for (Video v : carrito) {
					out.print("<li>");
					out.print(v.getNombre());
					out.print("</li>");
				}
			}
		%>
	</div>
</body>