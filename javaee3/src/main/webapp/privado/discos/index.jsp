<%@ include file="../../includes/header.jsp"  %>
<%@ include file="../../includes/navbar.jsp"  %>
<%@ include file="../../includes/mensajes.jsp"  %>






<h1>Listado de Discos</h1>


<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>T�tulo</th>
				<th>Artista</th>
				<th>Portada</th>
				<th>A�o</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${disco}" var="dis">
	
			
			
			<tr>
			
				<td>${dis.id}</td>
				<td><a href="privado/discos?op=2&id=${dis.id}">${dis.titulo}</td>
				<td>${dis.artista}</td>
				<td><img width=150 height=150 src="${dis.portada}" alt="imagen"></td>
				<td>${dis.year}</td>
			</tr>
			
			</c:forEach>
		</tbody>
	</table>
	
	<%@ include file="../../includes/footer.jsp"%>