$(document).on("ready",inicio);

function inicio(){
	$("span.help-block").hide();
	$("#btnRegistrarProducto").click(validar);
}

function validar(){
	alert("validar");
}