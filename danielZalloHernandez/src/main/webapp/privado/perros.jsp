<%@include file="/includes/navbar.jsp"%>
<main role="main" class="container">


<div class="jumbotron">

	<h1>
		Listado de perros
	</h1>
	
	<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>Chip/N�mero de identificaci�n</th>
					<th>Nombre</th>
					<th>Raza</th>
					<th>Acci�n</th>
					
				</tr>
			</thead>
			<tbody >
					<c:forEach items="${applicationScope.perros}" var="perro">
					<tr>
						<td><c:out value="${perro.value.chipAsignado.num_identifiacion}"/></td>
						<td><c:out value="${perro.value.nombre}" /></td>
						<td><c:out value="${perro.value.raza}" /></td>
						<td><a href="privado/verPerro?id=${perro.value.id}" class="btn  btn-primary btn-block "/>Ver m�s </a> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>
</main>
<%@include file="/includes/footer.jsp"%>
