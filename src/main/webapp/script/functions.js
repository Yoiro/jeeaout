function updatePrixTotal(object){
	var listProduits=new Array();
	var rows=$("#datatable").find('tr');
	for(var i=0; i<rows.length;i++){
		var r = $(rows[i]);
		var nbProduitForThisRow=Number(r.find(".nbProduit").text());
		console.log("nbProduit: "+nbProduitForThisRow);
		var number=Number(r.find(".prixUnit").text());
		console.log("prixUnitaire: "+number);
		var prixTot=nbProduitForThisRow*number;
		r.find((".prixTot")).text("€ "+prixTot);
	}
	//$("#prixTot").text("€ "+tmp);
	console.log(prixTot);
}