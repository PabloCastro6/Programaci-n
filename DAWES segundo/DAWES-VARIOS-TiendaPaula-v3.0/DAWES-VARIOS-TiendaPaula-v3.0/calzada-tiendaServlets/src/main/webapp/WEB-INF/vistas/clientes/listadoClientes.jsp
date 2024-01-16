<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<form action="http://localhost:8080/tienda/clientes/listarclientes"
				method="POST" id="formulario">

                    <br>
				    <label for="id"> ID Cliente: </label> 
				    <br>
				    <input type="text" id="id" name="id"> 
				    <br>
					<label for="nombre"> Nombre Cliente: </label> 
					<br>
					<input type="text" id="nombre" name="nombre"> 
					<br>
					<label for="correo"> Correo Cliente: </label> 
					<br>
					<input type="text" id="correo" name="correo">
					<br> 
					<label for="poblacion"> Poblacion: </label> 

					<select name="poblaciones" var="poblaciones" form="formulario">
						 <option value=""  selected> -- Seleccione una población -- </option>
						 
   						 	<c:forEach items="${combosPoblaciones}" var="poblacion">
        						<option value="${poblacion.id}">${poblacion.nombre}</option>
    						</c:forEach>

    					<option value="${cliente.idPoblacion}">${cliente.poblacion}</option>
					</select>
					<br>
					<br>
					<label for="activo"> Activo: </label> 
					<br>
					<input type="checkbox" id="activo" name="activo"> 
					<br>
					<input type="submit" value="Enviar">

			</form>

		</div>


		<c:if test="${not empty lista}">
			<table>
				<tr>
					<th>ID</th>
					<th>NOMBRE</th>
					<th>CORREO ELECTRÓNICO</th>
					<th>POBLACION</th>
					<th>ACTIVO</th>
				</tr>

				<c:forEach items="${lista}" var="cliente">

					<tr>
						<td>${cliente.id}</td>
						<td>${cliente.nombre}</td>
						<td>${cliente.correo}</td>
						<td>${cliente.poblacion}</td>
						<td>${cliente.activo}</td>	
					</tr>

				</c:forEach>
			</table>

		</c:if>
	</div>

</body>
</html>
