/*
 *  @Author Mike
 */
$(document).ready( function () {
	var type = $('#typeFacture option:selected').text()
	if(type.startsWith("RECETTE")){
		$('#catFacture').hide();
	}else{
		$('#catFacture').show();
	}
});

function factType(){
	var type = $('#typeFacture option:selected').text()
	if(type.startsWith("RECETTE")){
		$('#catFacture').hide();
	}else{
		$('#catFacture').show();
	}
}