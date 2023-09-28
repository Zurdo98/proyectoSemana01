<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Entidad.Productos" %>
<%@ page import="Negocio.BDNegocio" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Editar</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<% 	String Id = request.getParameter("id");
		BDNegocio ObjN = new BDNegocio();
	   	Productos ObjP = new Productos();
	   	ObjP = ObjN.Buscar(Id);
	%>
	<h1>Suprimir Producto</h1>
	<form action="grabar">
		<table class="table">
			<tr><td>IdProducto</td><td><input name="txtid" value=<%=ObjP.getIdProducto()%> readonly/></td></tr>
			<tr><td>Descripcion</td><td><%=ObjP.getDescripcion()%></td></tr>
			<tr><td>Precio Unidad</td><td><%=ObjP.getPrecioUnidad()%></td></tr>
			<tr><td>Stock</td><td><%=ObjP.getStock()%></td></tr>
			<tr><td>Estado</td><td><%=ObjP.getEstado()%></td></tr>
			<tr><td><input type="submit" value="Confirmar" /></td></tr>
		</table>
	</form>
	<a href="index.jsp">Regresar a Listado</a>
</body>
</html>