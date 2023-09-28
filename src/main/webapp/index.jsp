<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Entidad.Productos" %>
<%@ page import="Negocio.BDNegocio" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CRUD</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<% BDNegocio ObjN = new BDNegocio();
	   ArrayList<Productos> Lista = new ArrayList<>();
	   Lista = ObjN.Listar();
	%>
	<h1>Mantenimiento de Productos</h1>
	<table class="table">
		<tr>
			<th>IdProducto</th>
			<th>Descripcion</th>
			<th>Precio Unidad</th>
			<th>Stock</th>
			<th>Estado</th>
			<th>--- OPCIONES ---</th>
		</tr>
		<% for(Productos ObjP : Lista){
			String LinkView = "<a href=ver.jsp?id=" + ObjP.getIdProducto() + ">Ver</a>";
			String LinkEdit = "<a href=edit.jsp?id=" + ObjP.getIdProducto() + ">Editar</a>";
			String LinkDel = "<a href=del.jsp?id=" + ObjP.getIdProducto() + ">Suprimir</a>";
		%>
			<tr>
				<td><%=ObjP.getIdProducto()%></td>
				<td><%=ObjP.getDescripcion()%></td>
				<td><%=ObjP.getPrecioUnidad()%></td>
				<td><%=ObjP.getStock()%></td>
				<td><%=(ObjP.getEstado() == '1' ? "Disponible" : "No Disponible")%></td>
				<td><%=LinkView%> | <%=LinkEdit%> | <%=LinkDel%></td>
			</tr>
		<% } %>
	</table>
	<a href="add.jsp">Nuevo Producto</a>
</body>
</html>