

function init() {
  $(".imgAccueil").hide();
  $("#domisep").hide();
}



function animate() {
  $(".imgAccueil").show(500);
  setTimeout(function(){
      $("#domisep").show(500);
  }, 500);

}
