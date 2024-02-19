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
<h3> Modificación de clientes</h3>
	<div class= "form">
		<form action="http://localhost:8080/tienda/clientes/formularioactualizarclientes" method ="POST">
			<label for="id">Id Cliente</label> 
				<input type="text" id="id" name="id"> 
				<br>
				<label for="nombre">Nombre</label>
				<input type="text" id="nombre" name="nombre"> 
				<br>
				<label for="correo">Correo Electronico</label>
				<input type="text" id="correo" name="correo"> 
				<br>
				<label for="idPoblacion">Poblacion</label>
				<select name="idPoblacion" id="idPoblacion" >
					<option value="">Seleccione una opcion</option>
						<c:forEach items="${comboPoblacion}" var="poblacion">
							<option value="${poblacion.id}">${poblacion.descripcion}</option>
						</c:forEach>
				</select>
				<br>
				<label for="activo">Activo:</label> 
				<input type="checkbox" id="activo" name="activo">
				<br>
			 	<input type="submit" value="Buscar">
		</form>
	
	
	</div>

<h3> Resultados de la búsqueda</h3>
<c:forEach items="${lista}" var="cliente">

	
	 <div class="form">
	 	<form action="http://localhost:8080/tienda/clientes/actualizarclientes" method="POST" >
	 	<label for="idClien">Id Cliente</label> 
				<input type="text" id="idClien" value="${cliente.id}" name="idClien"> 
				<br>
				<label for="name">Nombre</label>
				<input type="text" id="name" value="${cliente.nombre}" name="name"> 
				<br>
				<label for="correoElec">Correo Electronico</label>
				<input type="text" id="correoElec" value="${cliente.correo}" name="correoElec"> 
				<br>
				<label for="idPoblac">Poblacion</label>
				<select name="idPoblac" id="idPoblac" >
            	<option value="${poblacion.id}" selected>${poblacion.descripcion}</option>
						<c:forEach items="${comboPoblacion}" var="poblacion">
							<option value="${poblacion.id}">${poblacion.descripcion}</option>
						</c:forEach>
				</select>
				<br>
				<label for="activ">Activo:</label> 
				<input type="checkbox" id="activ" value="${cliente.activo}" name="activ">
				<br>
			 	<input type="submit" value="Modificar">
	 	</form>
	 
	 </div>


</c:forEach>

</div> 



</body>
</html>
