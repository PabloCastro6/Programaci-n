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
<h3> Borrar Categorias</h3>
	<div class= "form">
		<form action="http://localhost:8080/tienda/categorias/formularioborrarcategoria" method ="POST">
			<label for="id"> ID </label>
			<input type ="text" id="id" name="id"><br>
			<label for="nombre"> Nombre </label>
			<input type ="text" id="nombre" name="nombre"><br>
			<label for="apellido">Descripcion</label>
			<input type ="text" id="descripcion" name="descripcion"><br>
			<label for="activo">Activo</label>
			<input type="checkbox" id="activo" name="activo"><br>
			<input type ="submit" value="Buscar">
		
		</form>
	
	
	</div>

<h3> Resultados de la búsqueda</h3>
<c:forEach items="${lista}" var="categoria">

	
	 <div class="form">
	 	<form action="http://localhost:8080/tienda/categorias/borrarcategoria" method="POST" >
	 	
	 		 <label for="id"> ID </label>
			<input type ="text" id="id" name="id"  value="${categoria.id}" readonly><br>
			<label for="nombre"> Nombre </label>
			<input type ="text" id="nombre" name="nombre" value="${categoria.nombre}" readonly><br>
			<label for="apellido">Descripcion</label>
			<input type ="text" id="descripcion" name="descripcion"  value="${categoria.descripcion}" readonly><br>
			<label for="activo">Activo</label>
			
			<c:if test="${categoria.activo == 1}">
				<input type="checkbox" id="activo" name="activo" checked readonly>
			</c:if>
			<c:if test="${categoria.activo == 0}">
				<input type="checkbox" id="activo" name="activo" readonly>
			</c:if>
			
			<br><input type ="submit" value="Borrar">
			
	 	</form>
	 
	 </div>


</c:forEach>

</div> 



</body>
</html>
