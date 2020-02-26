
/*
 *  Export liste facture rechercher
 */
$(document).ready( function () {
	var table = $('#table_id').DataTable({
		function () {
			var idFacture = [];
	    	var urlPath = "export-liste-facture?liste=";
	    	table.rows({page:'current'}).eq(0).each( function ( index ) {
	    		var row = api.cell(index , 0);  	    	 
	    	    var data = row.data();
	    	    
	    	    idFacture[index] = data;
	    	    urlPath += idFacture[index] + ','; 
	    	} );
	    	
	    	if(idFacture.length > 0){
	    		var href = $('#lienExport').attr('href' , urlPath);
	    	}else{
	    		var href = $('#lienExport').attr('href' , "#");
	    	}
		},
		
		/*
		 *  Affichage Depense et Recette
		 */
		drawCallback: function () {
			var api = this.api();
			
			var sum_depense = 0;
			api.cells("#DEPENSE" , {page:'current'}).eq(0).each( function ( index ) {
			    var cell = api.cell( index );
			    var data = cell.data();
			    var depense = data.toString().replace("Ar", "");
			    depense = depense.replace(".", "");
			    depense = depense.replace(",", ".");
			    depense = parseFloat(depense);
			    sum_depense += depense;
			} );
			
			var sum_recette = 0;
			api.cells("#RECETTE" , {page:'current'}).eq(0).each( function ( index ) {
			    var cell = api.cell( index );
			    var data = cell.data();
			    var recette = data.toString().replace("Ar", "");
			    recette = recette.replace(".", "");
			    recette = recette.replace(",", ".");
			    recette = parseFloat(recette);
			    sum_recette += recette;
			} );
			
			var total_depense = 0;	
			api.cells("#DEPENSE").eq(0).each( function ( index ) {
			    var cell = api.cell( index );
			    var data = cell.data();
			    var depense = data.toString().replace("Ar", "");
			    depense = depense.replace(".", "");
			    depense = depense.replace(",", ".");
			    depense = parseFloat(depense);
			    total_depense += depense;
			} );
			
			var total_recette = 0
			api.cells("#RECETTE").eq(0).each( function ( index ) {
			    var cell = api.cell( index );
			    var data = cell.data();
			    var recette = data.toString().replace("Ar", "");
			    recette = recette.replace(".", "");
			    recette = recette.replace(",", ".");
			    recette = parseFloat(recette);
			    total_recette += recette;
			} );
  	    	
  	    	var p_depense = (sum_depense / total_depense) * 100;
  	    	var p_recette = (sum_recette / total_recette) * 100;
  	    	
  	    	if(sum_depense <= 0){
  	    		$('#ligne_depense').hide();	
  	    	}else{
  	    		sum_depense = sum_depense.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1 ');
  	    		sum_depense = sum_depense.replace("." , ",");
  	    		sum_depense = sum_depense.replace(" " , ".");
  	    		$('#total_depense').text(sum_depense + ' Ar');
  	    		$('#p_depense').text(p_depense.toFixed(2) + '%');
  	    		$('#ligne_depense').show();
  	    	}
  	    	
  	    	if(sum_recette <=0){
  	    		$('#ligne_recette').hide();	
  	    	}else{
  	    		sum_recette = sum_recette.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1 ');
  	    		sum_recette = sum_recette.replace("." , ",");
  	    		sum_recette = sum_recette.replace(" " , ".");
  	  	    	$('#total_recette').text(sum_recette + ' Ar');
  	  	    	$('#p_recette').text(p_recette.toFixed(2) + '%');
  	    		$('#ligne_recette').show();
  	    	}
  	    	
  	    	var idFacture = [];
  	    	var urlPath = "export-liste-facture?liste=";
  	    	table.rows({page:'current'}).eq(0).each( function ( index ) {
  	    		var row = api.cell(index , 0);  	    	 
  	    	    var data = row.data();
  	    	    
  	    	    idFacture[index] = data;
  	    	    urlPath += idFacture[index] + ','; 
  	    	} );
  	    	
  	    	if(idFacture.length > 0){
  	    		var href = $('#lienExport').attr('href' , urlPath);
  	    	}else{
  	    		var href = $('#lienExport').attr('href' , "#");
  	    	}
  	    	
  	    	
  	    },
  	    
    	"order" : [],
    	
    	language: {
            url: "http://localhost:1010/itmada-suivi-treso/js/DataTables/media/French.json"
        }
    });

	$(".graph").onload = function() {
		$('#graph').show(); 
		$('#btnOpenGraph').show(); 
		$('#btnCloseGraph').show();
	};

	$(".graph").onerror = function() {
		$('#graph').hide(); 
		$('#btnOpenGraph').hide(); 
		$('#btnCloseGraph').hide();
	};
	
} );

$('#graph').hide();
$('#btnCloseGraph').hide()

function openGraph(){
	$('#graph').show();
	$('#btnCloseGraph').show();
	$('#btnOpenGraph').hide();
}

function closeGraph(){
	$('#graph').hide();
	$('#btnOpenGraph').show();
	$('#btnCloseGraph').hide();
}