var createSensorModal = document.getElementById('createSensorModal');
var createRoomModal = document.getElementById('createRoomModal');
var createTechnicianModal = document.getElementById('createTechnicianModal');
var createSponsorModal = document.getElementById('createSponsorModal');
var createEntityModal = document.getElementById('createEntityModal');
var createSensor = document.getElementById("createSensor");
var createRoom = document.getElementById("createRoom");
var createTechnician = document.getElementById("createTechnician");
var createSponsor = document.getElementById("createSponsor");
var createEntity = document.getElementById("createEntity");
var closeSensor = document.getElementById("closeSensor");
var closeRoom = document.getElementById("closeRoom");
var closeTechnician = document.getElementById("closeTechnician");
var closeSponsor = document.getElementById("closeSponsor");
var closeEntity = document.getElementById("closeEntity");

function init() {
  $(".list_password").hide();
  $(".input_name").hide();

}

$(".session").click( function(event){
  console.log (event.target);

    $("#labelcreateuser").show();
    $("#pic_user").show();

  if ($(this).hasClass("selected")){}
 else{
    $(".session").removeClass("selected");
    $(this).addClass("selected");
    $(".list_password").hide(150);
    $(this).find(".list_password").show(250);
  }
});


closeSensor.onclick = function() {
    createSensorModal.style.display = "none";
}

closeRoom.onclick = function() {
    createRoomModal.style.display = "none";
}

closeTechnician.onclick = function() {
    createTechnicianModal.style.display = "none";
}

closeSponsor.onclick = function() {
    createSponsorModal.style.display = "none";
}

closeEntity.onclick = function() {
    createEntityModal.style.display = "none";
}



$("#create_user").click( function(){
  $("#labelcreateuser").hide();
  $("#pic_user").hide();
});

$("#createSensor").click( function(){
    createSensorModal.style.display = "block";
});

$("#createRoom").click( function(){
    createRoomModal.style.display = "block";
});
$("#createTechnician").click( function(){
    createTechnicianModal.style.display = "block";
});
$("#createSponsor").click( function(){
    createSponsorModal.style.display = "block";
});
$("#createEntity").click( function(){
    createEntityModal.style.display = "block";
});

window.onclick = function(event) {
    if (event.target == createSensorModal) {
        createSensorModal.style.display = "none";
    } else if (event.target == createRoomModal) {
        createRoomModal.style.display = "none";
    } else if (event.target == createTechnicianModal) {
        createTechnicianModal.style.display = "none";
    } else if (event.target == createSponsorModal) {
        createSponsorModal.style.display = "none";
    } else if (event.target == createEntityModal) {
        createEntityModal.style.display = "none";
    }
}

/*

$(".input").on("input", function(){
  var index = $(this).index();
  if(index < 3){
    $(this).next().focus();
  }
  else{
    if($(this).parent().parent().hasClass("last")){
      $(".input_name").show(150);
      $(".input_name").focus();
    }
    $(this).parent().parent().css("background-color#3498db");
  }
});

$(".input_name").on("input", function(){
  $(".img_plus").addClass("active");
});

*/

function addSession(name){

}
