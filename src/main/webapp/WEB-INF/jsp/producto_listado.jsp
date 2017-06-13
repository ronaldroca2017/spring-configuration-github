<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Productos</title>
<base href="${pageContext.request.contextPath}/">
<link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap-3.3.7/css/bootstrap-responsive.min.css" rel="stylesheet">
<script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script src="jquery/jquery-3.2.1.js"></script>
<link rel="stylesheet" href="css/estilo.css" type="text/css" />

<script language="JavaScript">
function aviso(url,producto){
if (!confirm("ALERTA!! va a proceder a eliminar el producto " +producto + ".")) {
return false;
}
else {
document.location = url;
return true;
}
}
</script>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="center-block">
				<form action="buscarProducto.htm" method="post">
					<h2>Búsqueda de Productos</h2>

					<table>
						<tr>
							<td>Producto</td>
							<td><input type="text" name="name" class="form-control" /></td>
						</tr>

					</table>
					<br>
					<div style="text-align: right;">
					 <div class="btn-group">
					 		<button class="btn btn-info" type="button"
									value="Agregar" onclick="location.href='${pageContext.request.contextPath}/insertProducto.htm'" >Agregar</button>

					 </div>
					 
					  <div class="btn-group">

							<button class="btn btn-primary" type="submit"
									value="Buscar">Buscar</button>
					 </div>
					 </div>
				</form>

			</div>

		</div>
		<br>
		<div>
			<table class="table table-bordered table-hover table-condensed">
				<thead>
					<tr>
						<th>Id</th>
						<th>Producto</th>
						<th>Code</th>
						<th>Precio</th>
						<th>Descripción</th>
						<th>Categoria</th>
						<th>Eliminar</th>

					</tr>
				</thead>

				<tbody>
					<c:forEach items="${lstProduct}" var="prod">
						<tr>
							<td class="active">${prod.id_product}</td>
							<td>${prod.name}</td>
							<td>${prod.code}</td>
							<td class="info">${prod.price}</td>
							<td>${prod.description}</td>
							<td>${prod.category.name}</td>
							<td><a href="javascript:;" onclick="aviso('eliminarProducto.htm?id=${prod.id_product}','${prod.name}'); return false;">eliminar</a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>

</body>
</html>