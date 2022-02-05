$(document).on("click", "#btn-toggle", function (e) {
  var $button = $(this);
  if ($button.hasClass("card-body-visible")) {
    $button.parents(".card").find(".card-body").slideUp();
    $button.removeClass("card-body-visible");
    $button.parents(".card").find("i").removeClass("fa-chevron-up").addClass("fa-chevron-down");
  } else {
    $button.parents(".card").find(".card-body").slideDown();
    $button.addClass("card-body-visible");
    $button.parents(".card").find("i").removeClass("fa-chevron-down").addClass("fa-chevron-up");
  }
});