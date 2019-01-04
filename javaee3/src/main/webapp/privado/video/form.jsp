<%@ include file="../../includes/cabecera.jsp"%>
<%@ include file="../../includes/navbar.jsp"%>

<main role="main" class="container "> 
<%@ include file="../../includes/mensajes.jsp"%>

<div class="row">
	<div class="col-6">

		<form action="privado/videos" method="post">
			<div class="form-group">
				<label for="id">Identificador</label> 
				<input type="text" class="form-control" id="id" name="id" value="${video.id}" readonly>
			</div>
			<div class="form-group">
				<label for="nombre">Nombre</label> 
				<input type="text" class="form-control" id="nombre" name="nombre" value="${video.nombre}" placeholder="Nombre del video">
				<small name="nombre" id="nombre" class="form-text text-muted" >Nombre del video</small>
				 
			</div>
			<div class="form-group">
				<label for="codigo">Codigo</label> 
				<input type="text" class="form-control" id="codigo" name="codigo" value="${video.codigo}" placeholder="M�nimo y M�ximo 11 car�cteres">
				<small name="codigo" id="codigo" class="form-text text-muted" >M�nimo y M�ximo 11 car�cteres</small>
			</div>
			<div class="form-group">
				<input type="hidden" class="form-control" id="op" name="op"	value="3">
			</div>
			<div class="form-group">
				<label for="id_usuario">Selecciona el due�o del video</label>
				<select name="id_usuario" class="form-control">
				<c:choose>
  					<c:when test="${video.id != -1}">
						<c:forEach items="${usuarios}" var="u">
	            			<option value="${u.id}" ${(u.id ==video.usuario.id)?"selected":"" }>${u.email}</option>
						</c:forEach>
  					</c:when>
				 	<c:otherwise>
				    	<c:forEach items="${usuarios}" var="u">
	            			<option value="${u.id}" ${(u.id ==sessionScope.usuario.id)?"selected":"" }>${u.email}</option>
						</c:forEach>
				  	</c:otherwise>
				</c:choose>
				
				
				
				
				

					
				</select>
			</div>	

			<button type="submit" class="btn btn-primary btn-block">Guardar</button>
		</form>

		<c:if test="${video.id > 0}">

			<button type="button" class="btn btn-outline-danger btn-block mt-4"data-toggle="modal" data-target="#exampleModal">Eliminar</button>

			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Atenci�n</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">�Estas seguro que deseas eliminar el registro?</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"	data-dismiss="modal">Cerrar</button>
							<a href="privado/videos?op=4&id=${video.id}"class="btn btn-danger ">Eliminar</a>
						</div>
					</div>
				</div>
			</div>



		</c:if>
	</div>
	<div class="col-6 ">
	<iframe width="560" height="315"
		src="https://www.youtube.com/embed/${video.codigo}" frameborder="0"
		allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
		allowfullscreen></iframe>
</div>
</div>
<!-- .col-6 -->




<!-- .row --> </main>

<%@ include file="../../includes/footer.jsp"%>