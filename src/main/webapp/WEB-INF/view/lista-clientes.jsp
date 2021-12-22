<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD Spring</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css"/> 

</head>
<body>
<h1> Listado de clientes</h1>


	<table>
		<thead>
			<tr>
				<th>Nombre </th>
				<th>Apellido </th>
				<th>Email </th>
		
				<th>Modificar</th>
				<th>Eliminar</th>
			</tr>
		</thead>
	
	<c:forEach var="clienteVar" items="${clientes }">
		
		<!-- Link para actualizar -->
		<c:url var="linkActualizar" value="/cliente/FormularioActualizar">
			<c:param name="clienteId" value="${clienteVar.id }"/>
		</c:url>
		
		<!-- Link para eliminar -->
		<c:url var="linkEliminar" value="/cliente/Eliminar">
			<c:param name="clienteId" value="${clienteVar.id }"/>
		</c:url>
		
		<tr>
			<td>${clienteVar.nombre}</td>
			<td>${clienteVar.apellido}</td>
			<td>${clienteVar.email}</td>
			
			<td> <a href="${linkActualizar}"><input type="button" class="bt btn-blue" value="Modificar"/></a></td>
			<td> <a href="${linkEliminar}"><input type="button" class="bt btn-red" value="Eliminar" 
			onclick="if(!(confirm('Vas eliminar un registro. ¿Estas seguro?'))) return false"/></a></td>
		</tr>
	</c:forEach>
</table>
	

	
<br/>

<input class="btn btn-green" type="button" value="Agregar Cliente" style="display: block; margin: 0 auto;" onclick="window.location.href='FormularioAgregar';return false;"/>

</body>
</html>