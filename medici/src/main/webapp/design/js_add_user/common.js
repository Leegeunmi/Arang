$(document).ready(function(){

  var date = new Date();
  var selYear = date.getFullYear();
  getYears(selYear);
  $('#yearbox').val(selYear);
  $('#yearbox').change(function(){
      var chgYear = $(this).val();
      getYears(chgYear);
      $('#yearbox').val(chgYear);
  });
});

function getYears(getY) {
  $("#yearBox option").remove();
  var stY = Number(getY)-100;
  var enY = Number(getY);
for(var y = stY; y <= enY; y++) {
  $('#yearBox').append("<option value='"+ y +"'>"+ y + "</option>");
}
}
