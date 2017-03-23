function search(){
	
	var isbn = $.trim($('input[name=isbn]').val().replace(/-/g, ''));
	
	if(isbn==""){
		clear();
		alert("Input ISBN");
		$('input[name=isbn]').focus();
		return;
	}
	
    $.ajax({
		url: "https://www.googleapis.com/books/v1/volumes?q=isbn:"+isbn
    }).then(function(data) {
    	if(data.totalItems == "1") {
	    	$('#span_title').html(data.items[0].volumeInfo.title);
	    	$('input[name=title]').val(data.items[0].volumeInfo.title);
	    	$('#span_author').html(data.items[0].volumeInfo.authors[0]);
	    	$('input[name=author]').val(data.items[0].volumeInfo.authors[0]);
	    	if(data.items[0].volumeInfo.industryIdentifiers[0].type=="ISBN_10"){
		    	$('input[name=isbn10]').val(data.items[0].volumeInfo.industryIdentifiers[0].identifier);
		    	$('input[name=isbn13]').val(data.items[0].volumeInfo.industryIdentifiers[1].identifier);
	    	}else{
	    		$('input[name=isbn10]').val(data.items[0].volumeInfo.industryIdentifiers[1].identifier);
		    	$('input[name=isbn13]').val(data.items[0].volumeInfo.industryIdentifiers[0].identifier);
	    	}
    	} else {
    		clear();
        	alert("Confirm ISBN");
        	$('input[name=isbn]').select();
    	}
    });
    
}

function clear(){
	
	$('#span_title').html("");
	$('input[name=title]').val("");
	$('#span_author').html("");
	$('input[name=author]').val("");
	$('input[name=isbn10]').val("");
	$('input[name=isbn13]').val("");
	
}


function addBook(){
	
	if($('input[name=isbn10]').val() == "" || $('input[name=isbn13]').val() == ""){
		alert("Search Book");
		return;
	}
	
	/*
	if($('input[name=review]').val() == ""){
		alert("Write Review");
		return;
	}*/
	
	$("#target").submit();
	
}


function captureReturnKey(e) { 
    if(e.keyCode==13 && e.srcElement.type != 'textarea') 
    return false; 
} 
