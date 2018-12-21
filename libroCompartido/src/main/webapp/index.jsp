<%@ include file="includes/cabecera.jsp" %>
<%@ include file="includes/menu.jsp" %>
<div class="container">
	<div class="jumbotron">
		<h1>Libro Compartido</h1>
		<h3>Autor: ${pagina.autor }</h3>
		<p>${pagina.texto }</p>
	</div>
	<p class="text-right">P�gina: ${paginaActual } / ${totalPaginas }</p>
	<!-- Center-aligned -->
<ul class="pagination justify-content-center pagination-lg">
	<c:choose>
    <c:when test="${paginaActual=='1'}">
    <li class="page-item"><a class="page-link disabled">Primera p�gina</a></li>   
     <li class="page-item"><a class="page-link disabled">P�gina anterior</a></li>   
    </c:when>    
    <c:otherwise>
     <li class="page-item"><a class="page-link" href="libro?pagina=1">Primera p�gina</a></li>
     <li class="page-item"><a class="page-link" href="libro?pagina=${paginaActual - 1 }">P�gina anterior</a></li>
    </c:otherwise>
	</c:choose>
	<c:choose>
    <c:when test="${paginaActual==totalPaginas}">
     <li class="page-item"><a class="page-link disabled">Siguiente p�gina</a></li>   
    </c:when>    
    <c:otherwise>
     <li class="page-item"><a class="page-link" href="libro?pagina=${paginaActual + 1 }">Siguiente p�gina</a></li>
    </c:otherwise>
	</c:choose>  
	<c:choose>
    <c:when test="${paginaActual==totalPaginas}">
     <li class="page-item"><a class="page-link disabled">�ltima p�gina</a></li>   
    </c:when>    
    <c:otherwise>
     <li class="page-item"><a class="page-link" href="libro?pagina=${totalPaginas }">�ltima p�gina</a></li>
    </c:otherwise>
	</c:choose>
</ul>
</div>
<%@ include file="includes/pie.jsp" %>