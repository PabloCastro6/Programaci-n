<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "jakarta.tags.core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>




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

<div class="container">
		<h3>Modificar Productos</h3>
		<div class="form">
			<form action="http://localhost:8080/tienda/productos/formularioactualizarproductos" method="POST">
			
				<label for="id">Id Producto:</label> 
				<br>
				<input type="text" id="id" name="id"> 
				<br>
				<label for="nombre">Nombre:</label>
				<br>
				<input type="text" id="nombre" name="nombre"> 
				<br>
				<label for="descripcion">Descripción:</label>
				<br>
				<input type="text" id="descripcion" name="descripcion"> 
				<br>
				<label for="precio">Precio:</label>
				<br>
				<input type="text" id="precio" name="precio"> 
				<br>
				<label for="precio" >Cantidad en Stock:</label>
				<br>
				<input type="text" id="cantidadStock" name="cantidadStock"> 
				<br>
				<label for="categoria">Categoría:</label>
				<br>
				<select name="idCategoria" id="idCategoria" >
				
				<c:forEach items="${comboCategorias}" var="categoria">
						<option value="${categoria.id}">${categoria.nombre}</option>
				</c:forEach>
				
				</select>
				<br><br>
				<label for="precio" >Proveedor:</label>
				<br>
				<select name="idProveedor" id="idProveedor" >
				
				<c:forEach items="${comboProveedores}" var="proveedor">
						<option value="${proveedor.id}">${proveedor.nombre}</option>
				</c:forEach>
				
				</select>
				<br><br>
			 	<input type="submit" value="Enviar">
			</form>
		</div>

	<c:forEach items="${lista}" var="producto">
	
		<div class="form">
			<form action="http://localhost:8080/tienda/productos/actualizarproductos" method="POST">
			
				<label for="id">Id Producto:</label> 
				<br>
				<input type ="text" id="id" name="id" value="${producto.id}" readonly>
				<br>
				<label for="nombre">Nombre:</label>
				<br>
				<input type ="text" id="nombre" name="nombre" value="${producto.nombre}">
				<br>
				<label for="descripcion">Descripción:</label>
				<br>
				<input type="text" id="descripcion" name="descripcion" value="${producto.descripcion}"> 
				<br>
				<label for="precio">Precio:</label>
				<br>
				<input type="text" id="precio" name="precio" value="${producto.precio}"> 
				<br>
				<label for="precio" >Cantidad en Stock:</label>
				<br>
				<input type="text" id="cantidadStock" name="cantidadStock" value="${producto.cantidadStock}"> 
				<br>
				<label for="categoria">Categoría:</label>
				<br>
				<select name="idCategoria" id="idCategoria">
				    <c:forEach items="${comboCategorias}" var="categoria">
        				<option value="${categoria.id}" <c:if test="${categoria.id eq producto.idCategoria}">selected</c:if>>${categoria.nombre}</option>
				    </c:forEach>
				</select>
				<br><br>
				<label for="precio" >Proveedor:</label><br>	
				<select name="idProveedor" id="idProveedor">
				    <c:forEach items="${comboProveedores}" var="proveedor">
        				<option value="${proveedor.id}" <c:if test="${proveedor.id eq producto.idProveedor}">selected</c:if>>${proveedor.nombre}</option>
				    </c:forEach>
				</select>	
			<br>
			
			<input type="submit" value="Modificar">
			</form>

	
		</div>
	
			<br>
	</c:forEach>

		
		
</div>
</body>
</html>