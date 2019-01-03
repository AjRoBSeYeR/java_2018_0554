<%@ include file="../../include/header.jsp"  %>
<%@ include file="../../include/navbar.jsp"  %>
<%@ include file="../../include/mensajes.jsp"  %>

<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
<h1 class="h2">FORMULARIO</h1>
<div class="btn-toolbar mb-2 mb-md-0">
<div class="btn-group mr-2">
<a href="privado/usuarios?op=2&id=-1" class="btn btn-outline-info mb-2 mt-2">Insertar nuevo usuario</a>
</div> 
</div>
</div>
	
	
		<form action="privado/usuarios" method="post" class="col-md-8 offset-md-2">
		
			<div class="form-group">
			    <label for="id">Identificador</label>
			    <input type="text" name="id" value="${usuario.id}" readonly class="form-control">				    		    		    
			</div>	
			
			<div class="form-group">
			    <label for="email">Correo Electornico</label>
			    <input type="email" name="email" value="${usuario.email}" class="form-control" placeholder="tucorreo@electronico.com">		
				<small id="nombre" class="form-text text-muted">correo@correcto.com</small>		    
			</div>
			
			<div class="form-group">
			    <label for="password">Contrase�a</label>
			    <input type="password" name="password" value="${usuario.password}" class="form-control" placeholder="minimo 5 maximo 50 caracteres">			    
				<small id="nombre" class="form-text text-muted">minimo 5, maximo 50 caracteres</small>	
			</div>
			
			<input type="hidden" name="op" value="3">
			<button type="submit" class="btn btn-primary btn-block">GUARDAR</button>
			
			<c:if test="${usuario.id > 0}">
				
			<!-- Button trigger modal -->
			<button type="button" class="btn btn-outline-danger btn-block mt-4 " data-toggle="modal" data-target="#exampleModal">
			  ELIMINAR
			</button>
	
			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Atenci�n</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        � Estas serguro que deseas eliminar el registro ?
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
			        <a href="privado/usuarios?op=4&id=${usuario.id}" class="btn btn-danger">ELIMINAR</a>
			      </div>
			    </div>
			  </div>
			</div>
		
		</c:if>
			
		</form>
		
		
		

	</main>				
		


<%@ include file="../../include/footer.jsp"  %>  