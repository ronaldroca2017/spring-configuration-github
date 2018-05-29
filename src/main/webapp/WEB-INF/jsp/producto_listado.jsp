<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Productos</title>
<base href="${pageContext.request.contextPath}/">
<script src="jquery/jquery-3.2.1.js"></script>
<link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>


<link href="${pageContext.request.contextPath}/resources/css/estilo.css" rel="stylesheet">


<script type="text/javascript">
function aviso(url,producto){
if (!confirm("ALERTA!! va a proceder a eliminar el producto " +producto + ".")) {
return false;
}
else {
document.location = url;
return true;
}
}

function Abrir_ventana (pagina) {
	var opciones= "toolbar=no, location=no, directories=no, status=yes, menubar=yes, scrollbars=no, resizable=yes, width=508, height=365, top=0, left=0";
	window.open(pagina,"",opciones);
	}


function abrirPopup(pagina){
	var posicion_x; 
	var posicion_y; 
	var ancho = 800;
	var alto = 500
	posicion_x=(screen.width/2)-(ancho/2); 
	posicion_y=(screen.height/2)-(alto/2); 
	window.open(pagina,"", "width="+ancho+",height="+alto+",menubar=0,toolbar=0,directories=0,scrollbars=no,resizable=no,left="+posicion_x+",top="+posicion_y+"");
	
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
							<td> <a href="actualizarProductoPopup.htm?id=${prod.id_product}"><font size="4" face="Verdana">${prod.name}</font></a></td>
							<td><a href="javascript:;" onclick="abrirPopup('actualizarProductoPopup.htm?id=${prod.id_product}');">${prod.code}</a></td>
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