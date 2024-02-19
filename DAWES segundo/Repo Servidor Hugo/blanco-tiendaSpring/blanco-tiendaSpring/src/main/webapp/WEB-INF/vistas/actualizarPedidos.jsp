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
<h3> Modificación de Pedidos </h3>
	<div class= "form">
		<form action="http://localhost:8080/tienda/pedidos/formularioactualizarpedidos" method ="POST" id="formulario">
			<label for="id">Id Pedido</label> 
				<input name="id" type="text" id="id" name="id"> 
				<br>				    
				<label for="cliente">Clientes</label> 
				<select name="cliente" id="cliente" form="formulario">
					<option value="">Seleccione una opcion</option>
					<c:forEach items="${comboClientes}" var="cliente">
						<option value="${cliente.id}">${cliente.descripcion}</option>
					</c:forEach>
				</select> 
				    <br>
				    <label for="fecha">Fecha desde:</label>
				    <input name="fecha" type="date" id="fecha">
				    <br>
				 <label for="estado">Estado</label> 	
				<select name="estado" id="estado" form="formulario">	
					<option value="">Seleccionar Estado</option>					
				<c:forEach items="${comboEstados}" var="estado">
					<option value="${estado.id}">${estado.descripcion}</option>
				</c:forEach>
				</select> <br>
			 	<input type="submit" value="Buscar">
		</form>
	
	
	</div>

<h3> Resultados de la búsqueda</h3>
<c:forEach items="${lista}" var="pedidos">

	
	 <div class="form">
	 	<form action="http://localhost:8080/tienda/pedidos/actualizarpedidos" method="POST">
	 	
	 	<label for="idPedido">Id Pedido</label> 
				<input name="idPedido" type="text" id="idPedido" name="idPedido" value="${pedidos.id}" readonly> 
				<br>				    
				<label for="idcliente">Clientes</label> 
				<select name="idcliente" id="idcliente" form="formulario">
					<c:forEach items="${comboClientes}" var="cliente">
						<option value="${cliente.id}">${cliente.descripcion}</option>
					</c:forEach>
				</select> 
				    <br>
				    <label for="fechaDesde">Fecha desde:</label>
				    <input name="fechaDesde" type="date" id="fechaDesde">
				    <br>
				 <label for="estad">Estado</label> 	
				<select name="estad" id="estad" form="formulario">	
				<c:forEach items="${comboEstados}" var="estado">
					<option value="${estado.id}">${estado.descripcion}</option>
				</c:forEach>
				</select> <br>
			 	<input type="submit" value="Modificar">
	 	</form>
	 
	 </div>


</c:forEach>

</div> 



</body>
</html>
