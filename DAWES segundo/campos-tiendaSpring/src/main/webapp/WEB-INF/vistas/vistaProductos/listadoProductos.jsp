<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "jakarta.tags.core" %>


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
<%@include file="/menu.html" %>

<div class = "container">

	<div class = "form">
	
		<form action = "http://localhost:8080/tienda/productos/listarproducto" method = "POST" id="formulario">
			<label for = "id">ID Categoria</label> <br>
				<input type = "text" id = "id" name = "id"> <br>
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
				<c:forEach items ="${comboCategorias}" var="categoria">
					
					<option value="${categoria.id}">${categoria.nombre}</option>
					
				</c:forEach>
			
			</select><br>
			<label for="idProveedor">ID_Proveedor</label><br>
			<select name ="idProveedor" id="idProveedor" form ="formulario">
				<c:forEach items ="${comboProveedores}" var="proveedor">
					
					<option value="${proveedor.id}">${proveedor.nombre}</option>
					
				</c:forEach>
			
			</select><br>
			<input type="submit" value="Enviar">
		</form>
	
	</div>
	
	<c:if test ="${not empty lista }">
		<table>
			<tr>
				<th>ID</th>
				<th>NOMBRE</th>
				<th>DESCRIPCION</th>
				<th>PRECIO</th>
				<th>CANTIDAD STOCK</th>
				<th>ID_CATEGORIA</th>
				<th>ID_PROVEEDOR</th>
			</tr>
			<c:forEach items="${lista}" var="categoria">
				<tr>
					<td>${categoria.id}</td>
					<td>${categoria.nombre}</td>
					<td>${categoria.descripcion}</td>
					<td>${categoria.precio}</td>
					<td>${categoria.cantidadStock}</td>
					<td>${categoria.idCategoria}</td>
					<td>${categoria.idProveedor}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</div>



</body>
</html>
