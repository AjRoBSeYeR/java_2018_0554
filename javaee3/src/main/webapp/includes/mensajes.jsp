<c:if test="${not empty mensaje.alerta}">
	<div class="alert alert-${mensaje.tipo}">
	  ${mensaje.alerta}
	</div>
</c:if>
<%-- <c:if test="${not empty creacion}">
	<div class="alert alert-success">
	  ${creacion}
	  <a href="libro?pagina=${totalPaginas}">(Ir a la nueva p�gina)</a>
	    <span aria-hidden="true">&times;</span>
	</div>
</c:if> --%>