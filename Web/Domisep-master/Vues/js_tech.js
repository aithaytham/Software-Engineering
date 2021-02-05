function init() {
    $(".descriptionTicket").hide();

    $(".liTicket").on("click", function (e) {

        if ($("#" + e.target.id + " .descriptionTicket").is(":visible")) {
            $("#" + e.target.id + " .descriptionTicket").slideUp(500);
        }
        else {
            $("#" + e.target.id + " .descriptionTicket").slideDown(500);
            $('html, body').animate({
                scrollTop: $("#" + e.target.id + " .descriptionTicket").offset().top
            }, 1000);
        }
    });
}




