<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/tienda/css/index.css">
<link rel="stylesheet" href="/tienda/css/formularios.css">
<link rel="stylesheet" href="/tienda/css/tablas.css">
</head>
<body>
	<header>
		<h2>Gestión de Tienda</h2>
	</header>
	<%@include file="/menu.html"%>
	<div class="container">


		<div class="form">
			<form
				action="http://localhost:8080/tienda/productos/insertarproductos"
				method="POST" id="formulario">
				<label for="nombre"> Nombre</label> <input type="text" id="nombre"
					name="nombre"><br> <label for="descripcion">
					Descripcion</label> <input type="text" id="descripcion" name="descripcion">
				<br> <label for="precio">Precio</label> <input type="text"
					id="precio" name="precio"><br> <label for="cantidad">Cantidad
					en stock</label> <input type="text" id="cantidad" name="cantidad"><br>
				<label for="categoria">Categoria</label> 
				<select name="categoria" id="categoria" form="formulario">
				
					<c:forEach items="${comboCategoria}" var="categoria">

						<option value="${categoria.id}">${categoria.descripcion}</option>


					</c:forEach>

				</select> <br>
				<label for="activo">Proveedor</label> <select name="proveedor"
					id="proveedor" form="formulario">
					<c:forEach items="${comboProveedor}" var="proveedor">

						<option value="${proveedor.id}">${proveedor.descripcion}</option>


					</c:forEach>

				</select> <br> <input type="submit" value="Insertar">
			</form>
		</div>
	</div>
</body>
</html>