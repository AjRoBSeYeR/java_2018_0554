<ol class="list-group">

<!--  recojo variable carrito del servlet de carritoController (esa variable almacena una lista de array de los videos a�adidos con el boton a�adir)-->
	<c:forEach items="${carrito}" var="v">
	<span class="border border-primary">
		
		<li class="list-group p-3">${v.id} + ${v.nombre} " </li> <!-- solo id y nombre del video -->
	
		</span>
		<button type="button">sdsd</button>
				</c:forEach>
			</ol>