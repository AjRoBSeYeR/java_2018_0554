<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>
<%@ include file="includes/mensajes.jsp" %>


    <main role="main" class="container">
      <div class="jumbotron">
   			<p>publicada por: ${pagina.autor}</p>
   			<textarea class="pagina">
   			 		${pagina.contenido}	
   			</textarea>
   			<p>p�gina <c:choose><c:when test="${totalpaginas <= 0}">0</c:when><c:otherwise>${paginaactual+1}</c:otherwise></c:choose> de ${totalpaginas}</p> 
   			<p><c:if test="${paginaactual>0}"><a href="pagina?pag=${paginaactual-1}" class="float-left"> << anterior </a></c:if><c:if test="${paginaactual < totalpaginas-1 }"><a href="pagina?pag=${paginaactual+1}" class="float-right"> siguiente >></a></c:if></p>
      </div>
    </main>
<%@ include file="includes/footer.jsp" %>

