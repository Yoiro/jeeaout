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
