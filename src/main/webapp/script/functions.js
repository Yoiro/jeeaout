function updatePrixTotal() {
	var listProduits=new Array();
	var rows=$("#tableAllProducts").find('tr');
	for(var i=0; i < rows.length;i++){
		var r = $(rows[i]);
		var nbProduitForThisRow=Number(r.find(".nbProduit").val());
		var number=Number(r.find(".prixUnitaire").text());
		var prixTot=(nbProduitForThisRow*number);
		prixTot = parseFloat(prixTot).toFixed(2);
		r.find((".prixTot")).text(prixTot);
	}
}

function snackbar() {
	// Get the snackbar DIV
    var x = document.getElementById("snackbar")

    // Add the "show" class to DIV
    x.className = "show";

    // After 3 seconds, remove the show class from DIV
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
}