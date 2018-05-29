<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>  
<html lang="en">  
  <head>  
    <meta charset="utf-8">  
    <meta http-equiv="X-UA-Compatible" content="IE=edge">  
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    <title>Center a Div in Twitter Bootstrap 3</title>  
    <!-- Bootstrap -->  
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">  
    <link href="${pageContext.request.contextPath}/resources/css/estilo.css" rel="stylesheet">

   
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->  
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->  
    <!--[if lt IE 9]>  
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>  
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>  
    <![endif]-->  
  </head>  
  <body>  
    <div class="container">  
    <div class="row">  
    <div class="center-block">  
    	<form action="buscarProducto.htm" method="post">
						<h2>Búsqueda de Productos</h2>
					
						<table>
							<tr>
								<td>Producto :</td>
								<td><input type="text" name="name" class="form-control" /></td>
							</tr>
							
							<tr>
								<td><button class="btn btn-primary" type="submit" value="Buscar">Buscar</button></td>						
							</tr>
						</table>
					</form>    </div>  
    </div>  
    </div>  
    
    <table class="table">
		<tr>
			<td>Id</td>
			<td>Producto</td>
			<td>Code</td>
			<td>Precio</td>
			<td>Descripción</td>
			<td>Categoria</td>

		</tr>

		<c:forEach items="${lstProduct}" var="prod">
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
    
    
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->  
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>  
    <!-- Include all compiled plugins (below), or include individual files as needed -->  
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>  
  </body>  
</html>  