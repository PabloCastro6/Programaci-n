<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Personas</title>
</head>
<body>

	<h1>Lista de Personas</h1>

	<ul>
		<c:forEach items="${personas}" var="p">

			<li>${p.nombre}-${p.saldoCuenta}</li>

		</c:forEach>
	</ul>

	<label for="provincias">Elija una provincia:</label>

	<select name="provincias" id="provincias">

		<c:forEach items="${listaProvincias}" var="provincia">

			<option value="${provincia.id}">${provincia.descripcion}</option>

		</c:forEach>


	</select>

	<c:forEach items="${personas}" var="p">

		<c:if test="${p.saldoCuenta < 0}">

			<li style="color: red">${p.nombre}-${p.saldoCuenta}</li>

		</c:if>

		<c:if test="${p.saldoCuenta > 0}">

			<li style="color: black">${p.nombre}-${p.saldoCuenta}</li>

		</c:if>

	</c:forEach>

	<c:forEach items="${personas}" var="p">

		<c:choose>
			<c:when test="${p.saldoCuenta > 1000 && p.saldoCuenta < 2000}">
			
				<li> la personas ${p.nombre} tiene ahorros bajos ${p.saldoCuenta}</li>
				
			</c:when>
			
			<c:when test="${p.saldoCuenta < 2000}">
			
				<li> la personas ${p.nombre} tiene ahorros medios ${p.saldoCuenta}</li>
				
			</c:when>
			
			<c:when test="${p.saldoCuenta > 2000}">
			
				<li> la personas ${p.nombre} tiene ahorros altos ${p.saldoCuenta}</li>
				
			</c:when>
		</c:choose>

	</c:forEach>



</body>
</html>