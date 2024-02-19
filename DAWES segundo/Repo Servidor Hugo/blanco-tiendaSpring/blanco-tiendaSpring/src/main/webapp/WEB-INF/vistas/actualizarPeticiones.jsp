<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


   <%@ page isELIgnored="false"%>
<html>
<head>
	 <link rel="stylesheet" href="/tienda/css/index.css">
	 <link rel="stylesheet" href="/tienda/css/formularios.css">
	 <link rel="stylesheet" href="/tienda/css/tablas.css">
</head>
<body>
<header>
<h2>Panel de control Tienda de computadoras</h2>
</header>
<%@include file="/menu.html" %>



<div class="container">
<h3> Modificación de peticiones</h3>
	<div class= "form">
		<form action="http://localhost:8080/tienda/peticiones/formularioactualizarpeticiones" method ="POST" id="formulario">
				<label for="id"> ID Peticion</label>
				<input type="text" id="id"name="id"><br>
				<label for="cliente"> Cliente</label>
				<select name="cliente" id="cliente" form="formulario">
				<option value="">Seleccionar Cliente</option>
				<c:forEach items="${comboCliente}" var="cliente">
					<option value="${cliente.id}">${cliente.descripcion}</option>
				</c:forEach>
				</select> <br>
				<label for="producto"> Producto</label>
				<select name="producto" id="producto" form="formulario">
				<option value="">Seleccionar Producto</option>
				<c:forEach items="${comboProducto}" var="producto">
					<option value="${producto.id}">${producto.descripcion}</option>
				</c:forEach>
				</select> <br>
				<label for="cantidad">Cantidad</label> 
				<input type="text" id="cantidad" name="cantidad">
				<br> 
				<label for="estado">Estado</label> 	
				<select name="estado" id="estado" form="formulario">	
					<option value="">Seleccionar Estado</option>					
				<c:forEach items="${comboEstado}" var="estado">
					<option value="${estado.id}">${estado.descripcion}</option>
				</c:forEach>
				</select> <br>
				<label for="fecha">Fecha desde:</label> 
				<input type="date" id="fecha"name="fecha"><br>
				<input type ="submit" value="Buscar">
		</form>
	
	
	</div>

<h3> Resultados de la búsqueda</h3>
<c:forEach items="${lista}" var="peticion">

	
	 <div class="form">
	 	<form action="http://localhost:8080/tienda/peticiones/actualizarpeticiones" method="POST" >
	 	
			<label for="id"> ID Peticion</label>
			<input type ="text" id="id" name="id" value="${peticion.id}" readonly><br>
	 		
			<label for="cliente"> Cliente</label>
			<select name="cliente" id="cliente" form="formulario">
			<c:forEach items="${comboCliente}" var="cliente">
				<option value="${cliente.id}">${cliente.descripcion}</option>
			</c:forEach>
			</select> <br>
			<label for="producto"> Producto</label>
			<select name="producto" id="producto" form="formulario">
				<c:forEach items="${comboProducto}" var="producto">
					<option value="${producto.id}">${producto.descripcion}</option>
			</c:forEach>
			</select> <br>
			<label for="cantidad">Cantidad</label> 
			<input type="text" id="cantidad" value="${peticion.cantidad}" name="cantidad">
			<br> 
			<label for="estado">Estado</label> 	
			<select name="estado" id="estado" form="formulario">	
				<c:forEach items="${comboEstado}" var="estado">
					<option value="${estado.id}">${estado.descripcion}</option>
				</c:forEach>
			</select> <br>
			<label for="fecha">Fecha desde:</label> 
			<input type="date" value="${peticion.fecha}" id="fecha" name="fecha"><br>
			<input type ="submit" value="Modificar">
			
	 	</form>
	 
	 </div>


</c:forEach>

</div> 



</body>
</html>
