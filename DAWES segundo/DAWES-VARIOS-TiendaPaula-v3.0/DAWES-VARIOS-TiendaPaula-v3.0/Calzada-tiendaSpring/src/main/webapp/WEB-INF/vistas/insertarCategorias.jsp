<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page isELIgnored="false"%>
<html>
<head>
<link rel="stylesheet" href="/tienda/css/index.css">
<link rel="stylesheet" href="/tienda/css/formularios.css">
<link rel="stylesheet" href="/tienda/css/tablas.css">
</head>
<body>
	<header>
			<h1> Panel de control Tienda de componentes informaticos </h1>
	</header>
	<%@include file="/menu.html"%>


	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/tienda/categorias/insertarcategorias"
				method="POST">

				    <label for="id"> ID Categoria: </label> 
				    <input type="text" id="id" name="id"> 
					<label for="nombre"> Nombre Categoria: </label> 
					<input type="text" id="nombre" name="nombre"> 
					<label for="descripcion"> Descripcion Categoria: </label> 
					<input type="text" id="descripcion" name="descripcion">  
					<label for="activo"> Activo: </label> 
					<input type="checkbox" id="activo" name="activo"> 
					<input type="submit" value="Insertar">

			</form>

		</div>

		
			<c:if test="${resultado == 1 }">
			
				<p> Categoria insertada correctamente </p>
			
			</c:if>
	</div>
</body>
</html>