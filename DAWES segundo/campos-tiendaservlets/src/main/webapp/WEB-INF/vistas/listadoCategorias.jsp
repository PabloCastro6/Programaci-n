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
	
		<form action = "http://localhost:8080/tienda/categorias/listarcategoria" method = "POST">
			<label for = "id">ID Categoria</label>
				<input type = "text" id = "id" name = "id">
			<label for = "nombre">Nombre de la Categoria</label>
				<input type = "text" id = "nombre" name = "nombre">
			<label for = "descripcion">Descripcion</label>
				<input type = "text" id = "descripcion" name = "descripcion">
			<label for = "activo">Activo</label>
				<input type = "checkbox" id="activo" name ="activo">
			<input type = "submit" value = "enviar">
		</form>
	
	</div>
	
	<c:if test ="${not empty lista }">
		<table>
			<tr>
				<th>ID</th>
				<th>NOMBRE</th>
				<th>DESCRIPCION</th>
				<th>ACTIVO</th>
			</tr>
			<c:forEach items="${lista}" var="categoria">
				<tr>
					<td>${categoria.id}</td>
					<td>${categoria.nombre}</td>
					<td>${categoria.descripcion}</td>
					<td>${categoria.activo}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</div>



</body>
</html>
