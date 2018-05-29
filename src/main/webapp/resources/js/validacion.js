
//Si importamos el js en el head antes del body y nos aseguramos que se cargo todo el dom funciona asi:
$(document).ready(function() {
	$("span.help-block").hide();
	$("#btnRegistrarProducto").click(validar);
});

function myFunction1(){
	var txtProd = $("#inputProducto").val();
		
	if(txtProd.trim().length == 0 || txtProd.trim() == " "){
		$("#nombre_requerido").show();
		$("#nombre_requerido").css({'color':'red'});
	}else{
		$("#nombre_requerido").hide();
	}
}

function myFunction2(){

	var txtCod = $("#inputCodigo").val();
	
	if(txtCod.trim().length == 0 || txtCod.trim() == " "){
		$("#codigo_requerido").show();
		$("#codigo_requerido").css({'color':'red'});
	}else{
		$("#codigo_requerido").hide();
	}
}

function validar(){
	var txtProd = $("#inputProducto").val();
	var txtCod = $("#inputCodigo").val();
	var txtPrecio = $("#inputPrecio").val();
	var txtSeleccionarTipo = $("#selectTipo").val();
	alert(txtSeleccionarTipo); 
	
	if(txtProd.trim().length == 0 || txtProd.trim() == " "){
		$("#nombre_requerido").show();
		$("#nombre_requerido").css({'color':'red'});
	}else if(txtCod.trim().length == 0 || txtCod.trim() == " "){
		$("#codigo_requerido").show();
		$("#codigo_requerido").css({'color':'red'});
	}else if(txtPrecio.trim().length == 0 || txtPrecio.trim() == " "){
		$("#precio_requerido").show();
		$("#precio_requerido").css({'color':'red'});
	}else if(txtSeleccionarTipo == "0" || txtSeleccionarTipo == "--Seleccionar--"){
		$("#seleccionar_tipo").show();
		$("#seleccionar_tipo").css({'color':'red'});
	}
	
	
	
	return false;
}






/*
//Si importamos el js  despues del body funciona asi:
$("#btnRegistrarProducto").click(function(){
    alert('clicked!');
    return false;
});
*/
/*
//Si importamos el js en el head antes del body y nos aseguramos que se cargo todo el dom funciona asi:
$(function(){
	$("#btnRegistrarProducto").click(function(){
	    alert('clicked!');
	    return false;
	});
});*/