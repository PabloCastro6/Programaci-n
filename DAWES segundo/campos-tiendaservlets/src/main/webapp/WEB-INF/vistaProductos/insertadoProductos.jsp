<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page isELIgnored="false"%>
<html>
<head>
<link rel="stylesheet" href="/tienda/css/index.css">
<link rel="stylesheet" href="/tienda/css/formularios.css">
<link rel="stylesheet" href="/tienda/css/tablas.css">
</head>
<body>
	<header>
		<h2>Gestión de Tiendas</h2>
	</header>
	<%@include file="/menu.html"%>

	<div class="container">
	
		<div class="form">
			<form action="http://localhost:8080/tienda/productos/insertarproducto" method="POST" id="formulario">

			<label for = "nombre">Nombre del producto</label> <br>  
				<input type = "text" id = "nombre" name = "nombre"><br>
			<label for = "descripcion">Descripcion</label> <br>
				<input type = "text" id = "descripcion" name = "descripcion"><br>
			<label for = "precio">Precio</label> <br>
				<input type = "text" id="precio" name ="precio"><br>
			<label for = "cantidadStock">Cantidad en Stock</label> <br>
				<input type = "text" id="cantidadStock" name ="cantidadStock"><br>
			<label for="idCategoria">ID_Categoria</label><br>
			
			<select name ="idCategoria" id="idCategoria" form ="formulario">
				<c:forEach items ="${comboCategoria}" var="categoria">
					
					<option value="${categoria.id}">${categoria.nombre}</option>
					
				</c:forEach>
				
			
			</select><br>
			
			<label for="idProveedor">ID_Proveedor</label><br>
			
			<select name ="idProveedor" id="idProveedor" form ="formulario">
				<c:forEach items ="${comboProveedor}" var="proveedor">
					
					<option value="${proveedor.id}">${proveedor.nombre}</option>
					
				</c:forEach>
				
			
			</select><br>
			<input type="submit" value="Enviar">

			</form>

		</div>

	</div>

</body>
</html>