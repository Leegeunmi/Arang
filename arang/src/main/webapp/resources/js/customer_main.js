/**
 * 
 */
 function cart(tmpvar) {
	console.log(tmpvar);
	var a = fetch(
		"http://localhost:8080/arang/customer_page/customer_cart?"+new URLSearchParams({sid:tmpvar}),
		 {
			method  : "GET",
			//headers : {"Content-Type": "application/json"},
			//body : JSON.stringify({"itemName" : itemName})
		}
	)
	console.log(a);
}

//(function(window, $) {
//	var document = window.document;
//	var _ua = navigator.userAgent;
//	var _isDevice = "";
//	var _isBrowser = "";	
//}(this, jQuery));

$(function() {
  $('.fade_in').on('inview', function(event, isInView, visiblePartX, visiblePartY) {
    if (isInView) {
      $(this).addClass('fade_in_anime');
    } else {
	  $(this).removeClass('fade_in_anime');
    }
  });
    $('.up').on('inview', function(event, isInView, visiblePartX, visiblePartY) {
    if (isInView) {
      $(this).addClass('up_anime');
    } else {
      $(this).removeClass('up_anime');
    }
  });
});