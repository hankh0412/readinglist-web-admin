function search() {

    if ($.trim($('input[name=searchWord]').val()) == "") {
        alert("Please enter search term");
        $('input[name=searchWord]').focus();
        return;
    }

    window.open('/popup', '', 'left=200, top=200, width=640, height=480, scrollbars=no, status=no, resizable=no, fullscreen=no, channelmode=no');

}

function addBook() {

    if ($('input[name=isbn10]').val() == "" && $('input[name=isbn13]').val() == "") {
        alert("Search Book");
        return;
    }

    $("#target").submit();

}


function captureReturnKey(e) {
    if (e.keyCode == 13 && e.srcElement.type != 'textarea')
        return false;
} 
