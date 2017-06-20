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
	<script src="jquery/jquery-3.2.1.js"></script>
<script src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script src="bootstrap-3.3.7/js/validacion.js"></script>

<link rel="stylesheet" href="css/estilo.css" type="text/css" />


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
			<div class="col-lg-5 col-lg-offset-3">
				<div class="panel panel-info" style="width: 140% !important">
					<div class="panel-heading">
						<h4>Registrar Producto</h4>
					</div>
					<div class="panel-body">
					
						<form:form action="saveProducto.htm" commandName="product"
							cssClass="form-horizontal" role="form">
							<div class="form-group">
								<label for="inputProducto" class="col-sm-3 control-label">Producto</label>
								<div class="col-sm-6">
									<form:input type="text" class="form-control" id="inputProducto"
										placeholder="Producto" path="name" />
									
								</div>
								<div class="col-sm-3">
								<span class="help-block">* Nombre requerido</span>
								</div>
								
							</div>

							<div class="form-group">
								<label for="inputCodigo" class="col-sm-3 control-label">C&oacutedigo</label>
								<div class="col-sm-3">
									<form:input type="text" class="form-control" id="inputCodigo"
										placeholder="Codigo" path="code" />
								
								</div>
								
								<div class="col-sm-3"></div>
								<div class="col-sm-3">
								<span class="help-block">* C&oacutedigo requerido</span>
								</div>
							</div>

							<div class="form-group">
								<label for="inputPrecio" class="col-sm-3 control-label">Precio</label>
								<div class="col-sm-3 inputGroupContainer">
								<div class="input-group">
									<form:input type="text" class="form-control"  id="inputPrecio" 
										placeholder="Precio" path="price"/>
										<span class="input-group-addon">$</span>
									</div>
								</div>
								<div class="col-sm-3"></div>
								<div class="col-sm-3">
								<span class="help-block">* Precio requerido</span>
								</div>
							</div>
							
							
							<div class="form-group">
								<label for="inputTipo" class="col-sm-3 control-label">Tipo</label>
								<div class="col-sm-6 selectContainer">
							<form:select path="category.id_Category" class="form-control">
								<form:options items="${categoriesTypes}" itemLabel="name" itemValue="id_Category"/>										
							</form:select>
								</div>
								
								<div class="col-sm-3">
								<span class="help-block">* Seleccionar tipo</span>
								</div>
							</div>
							
							<div class="form-group">
								<label for="inputDescripcion" class="col-sm-3 control-label">Descripci&oacuten</label>
								<div class="col-sm-7">
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

							
							<div class="form-group">
								<label class="col-sm-3 control-label">Distribuci&oacuten</label>
								<div class="col-sm-9">
									<div class="radio">
										<label> <form:radiobutton  path="distribution" value="Interior"/>Interior
										</label>
									</div>
									<div class="radio">
										<label> <form:radiobutton  path="distribution" value="Exterior"/> Exterior
										</label>
									</div>
									<p class="help-block">Producto para interior o exterior del país</p>
								</div>
							</div>
							
								
						<div class="form-group">
								<label class="col-sm-3 control-label">Nivel</label>
								<div class="col-sm-9">
								
							
										<form:radiobuttons path="levelProduct" items="${nivelProduct}"></form:radiobuttons>
										
									
									
									<p class="help-block">Nivel del producto</p>
								</div>
							</div>


							<button type="button" class="btn btn-info" id="btnRegistrarProducto">Registrar Producto
								</button >
						</form:form>


					</div>
				</div>
			</div>

		</div>

	</div>
</body>
</html>