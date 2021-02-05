function init() {
    $(".screen").hide();
    $("#slider").slider({
        orientation: "vertical",
        min: 15,
        max: 25,
        step:0.5,
        slide: function( e, ui ) {
            $("#valueSlider").text(ui.value+"°");
        },
    });
}

$(".container_icon").click( function(){
    $(".container_icon").removeClass("selected");
    var index = $(".container_icon").index(this)
    $(this).addClass("selected");
    $(".screen").hide();

    switch($(this).attr("id")) {
        case "cam":
            $("#cam_screen").fadeIn(500);
            break;
        case "light":
            $("#light_screen").fadeIn(500);
            break;
        case "temp":
            $("#temp_screen").fadeIn(500);
            break;
        case "sun":
            $("#sun_screen").fadeIn(500);
            break;
        case "humi":
            $("#humi_screen").fadeIn(500);
            break;
        default:
            break;
    }
});

$(".select_room").change( function(){
    $(".select_room").css("border-color", "#e67e22");
    $(".select_room").css("box-shadow", "0px 0px 10px #e67e22");
    $(".select_room").css("border-width", "3px");
});

$(".lightImg").click( function(){
    if ($(this).hasClass("enable")){
        $(this).removeClass("enable");
        $(this).attr("src", "./img/ampoule_Marine.png");

    }
    else{
        $(this).addClass("enable");
        $(this).attr("src", "./img/ampoule_ciel.png");
    }
});

$(".tempAction").on("click", function (e) {
    var action = e.target.id;
    if (action == "plus" && parseInt($("#tempValue")[0].innerHTML) < 28){
        $("#tempValue")[0].innerHTML = parseInt($("#tempValue")[0].innerHTML) + 1 +"°";
    }
    if (action == "minus" && parseInt($("#tempValue")[0].innerHTML) > 16){
        $("#tempValue")[0].innerHTML = parseInt($("#tempValue")[0].innerHTML) - 1+"°";
    }
});


$(".store").on("click", function (e) {
    var store = $("#"+e.target.id);
    store.animate({height: '0' }, "slow");


});function init() {
    $(".screen").hide();
    $("#slider").slider({
        orientation: "vertical",
        min: 15,
        max: 25,
        step:0.5,
        slide: function( e, ui ) {
            $("#valueSlider").text(ui.value+"°");
        },
    });
}

$(".container_icon").click( function(){
    $(".container_icon").removeClass("selected");
    var index = $(".container_icon").index(this)
    $(this).addClass("selected");
    $(".screen").hide();

    switch($(this).attr("id")) {
        case "cam":
            $("#cam_screen").fadeIn(500);
            break;
        case "light":
            $("#light_screen").fadeIn(500);
            break;
        case "temp":
            $("#temp_screen").fadeIn(500);
            break;
        case "sun":
            $("#sun_screen").fadeIn(500);
            break;
        case "humi":
            $("#humi_screen").fadeIn(500);
            break;
        default:
            break;
    }
});

$(".select_room").change( function(){
    $(".select_room").css("border-color", "#e67e22");
    $(".select_room").css("box-shadow", "0px 0px 10px #e67e22");
    $(".select_room").css("border-width", "3px");
});

$(".lightImg").click( function(){
    if ($(this).hasClass("enable")){
        $(this).removeClass("enable");
        $(this).attr("src", "./img/ampoule_Marine.png");

    }
    else{
        $(this).addClass("enable");
        $(this).attr("src", "./img/ampoule_ciel.png");
    }
});

$(".tempAction").on("click", function (e) {
    var action = e.target.id;
    if (action == "plus" && parseInt($("#tempValue")[0].innerHTML) < 28){
        $("#tempValue")[0].innerHTML = parseInt($("#tempValue")[0].innerHTML) + 1 +"°";
    }
    if (action == "minus" && parseInt($("#tempValue")[0].innerHTML) > 16){
        $("#tempValue")[0].innerHTML = parseInt($("#tempValue")[0].innerHTML) - 1+"°";
    }
});


$(".store").on("click", function (e) {
    var store = $("#"+e.target.id);
    store.animate({height: '0' }, "slow");


});
