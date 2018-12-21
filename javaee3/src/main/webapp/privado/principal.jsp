<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navbar.jsp" %>
	<h1>Bienvenido ${usuarioLogueado.email}</h1>
	<h2>V�deos</h2>
	<table class="table table-hover table-borderless">
		<thead class="thead-dark">
			<tr>
				<th>Nombre</th>
				<th>V�deo</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${videos}" var="video">
				<tr>
					<td>${video.nombre}</td>
					<td><iframe width="420" height="315"
							src="https://www.youtube.com/embed/${video.url}"> </iframe></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<%@include file="../includes/footer.jsp" %>