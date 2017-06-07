<%@ include file = "/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Productos</title>
</head>
<body>
	<h4>${parametro}</h4>
	
	
	<div align="center">
		
		<div >
			<fieldset style="text-align: center;">
			<legend>Busqueda de productos</legend>
			
				<label>Nombre :</label> 
				<input type="text" name="name" />
			
			</fieldset>
			
			<table>
				<tr>
					<td>Id</td>
					<td>Producto</td>
				</tr>
			
				<c:forEach  items="${lstProduct}" var="prod">
					<tr>
						<td>${prod.id_product}</td>
						<td>${prod.name}</td>
						
					</tr>
				</c:forEach>
				
			
			</table>
			
			
		</div>
		
		
		
	</div>
	
</body>
</html>