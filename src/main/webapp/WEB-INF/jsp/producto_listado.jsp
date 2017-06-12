<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Productos</title>
<base href="${pageContext.request.contextPath}/">
</head>
<body>
	<h4>${parametro}</h4>
	
	
	<div align="center">
		
		<div >
			<fieldset style="border: 1px solid rgb(255,232,57);width: 400px;margin:auto;">
			<legend>Busqueda de productos</legend>
			
			<form action="buscarProducto.htm" method="post">
				<label>Nombre :</label> 
				<input type="text" name="name" />
				<input type="submit" value="Buscar" />
			</form>
			</fieldset>
		
			<table>
				<tr>
					<td>Id</td>
					<td>Producto</td>
					<td>Code</td>
					<td>Precio</td>
					<td>Descripción</td>
					<td>Categoria</td>
					
				</tr>
			
				<c:forEach  items="${lstProduct}" var="prod">
					<tr>
						<td>${prod.id_product}</td>
						<td>${prod.name}</td>
						<td>${prod.code}</td>
						<td>${prod.price}</td>
						<td>${prod.description}</td>
						<td>${prod.category.name}</td>
						
					</tr>
				</c:forEach>
				
			
			</table>
			
			
		</div>
		
		
		
	</div>
	
</body>
</html>