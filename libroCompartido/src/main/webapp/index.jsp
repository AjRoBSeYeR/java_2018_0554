<%@include file="/includes/navbar.jsp" %>
	<main role="main" class="container">
	<div class="jumbotron">
	<%@include file="/includes/mensajes.jsp" %>
		<h1>Mi libro, Luna de Pluton, es n�mero uno en ventas</h1>
		<h2>Autor: ${paginaMostrar.autor}</h2>
		<p>${paginaMostrar.texto}</p>
	</div>
	<p class="text-right">P�gina: ${paginaMostrar.id} /
		${paginasTotales}</p>

	<ul class="pagination justify-content-center active">
		<li class="page-item"><a class="page-link" href="index?pagina=1">Primera
				p�gina</a></li>

		<c:choose>
			<c:when test="${(paginaMostrar.id-1) <1}">
      			<li class="page-item"><a class="page-link" href="index?pagina=1">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="index?pagina=${paginaMostrar.id-1}">Previous</a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${(paginaMostrar.id+1) >paginasTotales}">
      			<li class="page-item"><a class="page-link" href="index?pagina=${paginasTotales}">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="index?pagina=${paginaMostrar.id + 1}">Next</a></li>
			</c:otherwise>
		</c:choose>
		<li class="page-item"><a class="page-link"
			href="index?pagina=${paginasTotales}">�ltima p�gina</a></li>
	</ul>
	
	<form action="index" method="get">
		<input type="text" name="pagina" value="${paginaMostrar.id}">
		<input type="submit" value="buscar">
	</form>
	</main>
<%@include file="/includes/footer.jsp" %>