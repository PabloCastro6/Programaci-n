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
</header>
<h2>Panel de control Tienda de computadoras</h2>

<%@include file="/menu.html" %>

<h2>Listado Categorias</h2>
<div class="container">
	<div class= "form">
		<form action="http://localhost:8080/tienda/categorias/listarcategorias" method ="POST">
			<label for="id"> ID Categoria</label>
			<input type ="text" id="id" name="id"><br>
			<label for="nombre"> Nombre</label>
			<input type ="text" id="nombre" name="nombre"><br>
			<label for="apellido">Descripcion</label>
			<input type ="text" id="descripcion" name="descripcion"><br>
			<label for="activo">Activo</label>
			<input type="checkbox" id="activo" name="activo"><br>
			<input type ="submit" value="Enviar">
		
		</form>
	
	
	</div>

<c:if test="${not empty lista }">
	<table>
		<tr>
			<th>ID</th>
			<th>NOMBRE </th>
			<th>DESCRIPCION </th>
			<th>ACTIVO </th>
		</tr>
		
		<c:forEach items="${lista}" var="categoria">
		
			<tr>
				<td> ${categoria.id} </td>
				<td> ${categoria.nombre} </td>
				<td> ${categoria.descripcion } </td>
				<td> ${categoria.activo } </td>
			</tr>
		
		</c:forEach>
	
	</table>
</c:if>

</div>



</body>
</html>
