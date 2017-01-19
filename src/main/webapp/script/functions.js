function updatePrixTotal(){
	var listProduits=new Array();
	var rows=$("#datatable").find('tr');
	for(var i=1; i<rows.length;i++){
		var r = $(rows[i]);
		var nbProduitForThisRow=Number(r.find(".nbProduit").val());
		console.log("nbProduit: "+nbProduitForThisRow);
		var number=Number(r.find(".prixUnit").text());
		console.log("prixUnitaire: "+number);
		var prixTot=nbProduitForThisRow*number;
		r.find((".prixTot")).text(prixTot);
		console.log("Prix Total: "+prixTot);
	}
	//$("#prixTot").text("€ "+tmp);
	
}