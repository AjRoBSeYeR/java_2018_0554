<%@ include file="../../includes/cabecera.jsp" %>
<%@ include file="../../includes/menu.jsp" %>
<%@ include file="../../includes/mensajes.jsp" %>
	<main role="main" class="container">
	<div class="jumbotron">
		<h3>Videos Registrados</h3>
		<table class="table">
		<thead class="thead-dark">
		<tr>
		<th>ID</th>
		<th>Nombre</th>
		<th>Codigo</th>
		<th>Usuario</th>
		<th>Editar/Borrar</th>
		<th><a href="privado/videos?op=2&id=-1" class="btn btn-success">Crear Nuevo</a></th>
		</tr>
		</thead>
		<tbody class="bg-light">
		<c:forEach items="${videos}" var="v">
		<tr>
  			<td>${v.id}</td> <td>${v.nombre}</td> 
  			<td>${v.codigo}</td>
  			<td>${v.usuario.email}</td> 
  			
  			<td colspan="2"><a href="privado/videos?op=2&id=${v.id}" class="btn btn-info">Editar/Borrar</a></td>
  			
  		</tr>
 		</c:forEach>
 		</tbody>
 		</table>
	</div>
	</main>
<%@include file="../../includes/pie.jsp"%>