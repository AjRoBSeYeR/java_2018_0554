<%@page import="com.ipartek.formacion.modelo.pojos.Coche"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<style>
nav{
	background:#CCC;
	color:#000;
	padding:20px;
	border-bottom: 3px solid black;
	margin-bottom:20px;

}
</style>

<nav>
<%

	Usuario usuario_logeado = (Usuario)session.getAttribute("usuario_logeado");
	if(usuario_logeado!=null){
%>

<%=usuario_logeado.getEmail() %>
<a href="logout">Cerrar Sesion</a>



<%}else{%>	
<a href="login">Iniciar sesion</a>
	<%}%>
	
	
	<a href="privado/index.jsp">Zona Privada</a>
	<a href="coches">Coches</a>
	<a href="calcular">Ejemplo Calculadora</a>
	
</nav>	