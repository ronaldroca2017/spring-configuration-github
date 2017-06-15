<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1'> 
<title>Guardar Producto</title>
<base href="${pageContext.request.contextPath}/">
<link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap-3.3.7/css/bootstrap-responsive.min.css"
	rel="stylesheet">
<script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script src="jquery/jquery-3.2.1.js"></script>
<link rel="stylesheet" href="css/estilo.css" type="text/css" />

	<script type="text/javascript">
		function actualizarSubmit(){
			
			document.frmActualizar.submit();
			window.close();
			
		}
		
		
		function cargar(){
		    opener.location.reload();
		   // window.close();
		}
		
	</script>
</head>
<body>
<!--

á = &aacute

é = &eacute

í = &iacute

ó = &oacute

ú = &uacute

ñ = &ntilde
 -->
	<br>
	<div class="container master-container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h4>Actualizar Producto</h4>
					</div>
					<div class="panel-body">
					
						<form:form action="updateProducto.htm" commandName="product"
							cssClass="form-horizontal" role="form" name="frmActualizar" onsubmit="cargar();">
							
							<form:hidden path="id_product"/>
							
							<div class="form-group">
								<label for="inputProducto" class="col-sm-3 control-label">Producto</label>
								<div class="col-sm-9">
									<form:input type="text" class="form-control" id="inputProducto"
										placeholder="Producto" path="name" />
					
								</div>
							</div>

							<div class="form-group">
								<label for="inputCodigo" class="col-sm-3 control-label">C&oacutedigo</label>
								<div class="col-sm-3">
									<form:input type="text" class="form-control" id="inputCodigo"
										placeholder="Codigo" path="code" />
								
								</div>
							</div>

							<div class="form-group">
								<label for="inputPrecio" class="col-sm-3 control-label">Precio</label>
								<div class="col-sm-3">
									<form:input type="text" class="form-control"  id="inputPrecio" 
										placeholder="Precio" path="price"/>
									
								</div>
							</div>
							
							
							<div class="form-group">
								<label for="inputTipo" class="col-sm-3 control-label">Tipo</label>
								<div class="col-sm-6">
							<form:select path="category.id_Category">
								<form:options items="${categoriesTypes}" itemLabel="name" itemValue="id_Category"/>										
							</form:select>
								</div>
							</div>
							
							<div class="form-group">
								<label for="inputDescripcion" class="col-sm-3 control-label">Descripci&oacuten</label>
								<div class="col-sm-9">
								<form:textarea type="textarea" rows="5" cols="20"  class="form-control" 
									id="inputDescripcion" path="description"/>
							
									
								</div>
							</div>
							
							

							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-9">
									<div class="checkbox">
										<label> <form:checkbox path="checkBoxActive" /> Active
										</label>
									</div>
									<p class="help-block">Marcar si el producto esta activo</p>
								</div>
							</div>

							 <input type="submit" class="btn btn-info" value="je Producto" />
							
						</form:form>


					</div>
				</div>
			</div>

		</div>

	</div>
</body>
</html>