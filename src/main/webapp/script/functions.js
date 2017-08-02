function updatePrixTotal(){
	var listProduits=new Array();
	var rows=$("#tableAllProducts").find('tr');
	for(var i=1; i<rows.length;i++){
		var r = $(rows[i]);
		var nbProduitForThisRow=Number(r.find(".nbProduit").val());
		var number=Number(r.find(".prixUnit").text());
		var prixTot=(nbProduitForThisRow*number);
		prixTot = parseFloat(prixTot).toFixed(2);
		r.find((".prixTot")).text(prixTot);
	}
	//$("#prixTot").text("€ "+tmp);
}

(function($) {
    $.fn.currencyFormat = function() {
        this.each( function( i ) {
            $(this).change( function( e ){
                if( isNaN( parseFloat( this.value ) ) ) return;
                this.value = parseFloat(this.value).toFixed(2);
            });
        });
        return this; //for chaining
    }
})( jQuery );

// apply the currencyFormat behaviour to elements with 'currency' as their class
$( function() {
    $('.currency').currencyFormat();
});

