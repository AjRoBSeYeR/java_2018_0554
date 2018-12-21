
<%@page import="com.ipartek.formacion.modelo.pojos.Video"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.modelo.pojos.Usuario"%>
<h1>Listado Videos</h1>




<form action="videos" method="post">
	<input type="text" name="busqueda" value="${busqueda}" required>
	<input type="submit" value="filtrar">
</form>
	<c:if ${videos.isEmpty()}>
	<p style="color:red">No existen videos</p>
	</c:if>


<ol>
	<c:forEach items="${videos}" var="vid">
					<li>${vid.nombre}</li>
					<iframe width="560" height="315" src="https://www.youtube.com/embed/${vid.url}/embed" frameborder="0" 
					allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" 
					allowfullscreen></iframe>

</c:forEach>
</ol>

