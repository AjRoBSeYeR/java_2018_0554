<c:if test="${not empty alerta}">
	<div class="alert alert-warning">
	  ${alerta}
	    <span aria-hidden="true">&times;</span>
	</div>
</c:if>
<c:if test="${not empty creacion}">
	<div class="alert alert-success">
	  ${creacion}
	  <a href="libro?pagina=${totalPaginas}">(Ir a la nueva p�gina)</a>
	    <span aria-hidden="true">&times;</span>
	</div>
</c:if>