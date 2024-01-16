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
			<form action="http://localhost:8080/tienda/clientes/formularioactualizarcliente"
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
					<input type="submit" value="Buscar">


			</form>

		</div>
		
		<h3> Resultados de la búsqueda </h3>


			<c:forEach items="${lista}" var="cliente">
				
				<div class="form">
					
					<form action="http://localhost:8080/tienda/clientes/actualizarcliente" method="POST" id="formulario">
						<br>
				    	<label for="id"> ID Cliente: </label> 
				    	<br>
				    	<input type="text" id="id" name="id" value="${cliente.id}" readonly> 
				   	 	<br>
						<label for="nombre"> Nombre Cliente: </label> 
						<br>
						<input type="text" id="nombre" name="nombre" value="${cliente.nombre}"> 
						<br>
						<label for="descripcion"> Correo Cliente: </label> 
						<br>
						<input type="text" id="correo" name="correo" value="${cliente.correo}">
						<br>
						<label for="categoria"> Poblacion: </label> 

					<select name="poblaciones" var="poblaciones">

   						 <c:forEach items="${combosPoblaciones}" var="poblacion">
        					<option value="${poblacion.id}">${poblacion.nombre}</option>
    					</c:forEach>

    					<option value="${cliente.idPoblacion}" selected>${cliente.poblacion}</option>
					</select>
					<br>
					<label for="activo"> Activo</label> 
					
						<c:if test="${cliente.activo == 1}">
					 	 
					 	<input type="checkbox" id="activo" name="activo" checked> 
					 	 
						</c:if>
						<c:if test="${cliente.activo == 0}">
					 	 
					 	<input type="checkbox" id="activo" name="activo"> 
					 	 
						</c:if> 
						<br>
						<input type="submit" value="Modificar">

					</form>
					
				
				</div>
				
			</c:forEach>
			
		</div>
</body>
</html>