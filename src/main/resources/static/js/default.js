
$(function () {

  let st = $(window).scrollTop();
  let width = $(window).width();

  if (width > 999) {
    $(".top-nav ul li").fadeIn(500);
    $(".bottom-nav-wrapper").stop().animate({ 'bottom': '-80px' }, 500);
    $(".top-move-button").stop().animate({ 'bottom': '20px' }, 500);
    $("footer").stop().animate({ 'margin-bottom': '0px' }, 500);
  } else {
    $(".bottom-nav-wrapper").stop().animate({ 'bottom': '0px' }, 500);
    $(".top-move-button").stop().animate({ 'bottom': '60px' }, 500);
    $("footer").stop().animate({ 'margin-bottom': '40px' }, 500);
    $(".top-nav ul li").fadeOut(500);
  }

  $(window)
    .resize(function () {
      st = $(this).scrollTop();
      width = $(this).width();
      if (width > 999) {
        $(".top-nav ul li").fadeIn(500);
        $(".bottom-nav-wrapper").stop().animate({ 'bottom': '-80px' }, 500);
        $(".top-move-button").stop().animate({ 'bottom': '20px' }, 500);
        $("footer").stop().animate({ 'height': '173px' }, 500);
      } else {
        $(".bottom-nav-wrapper").stop().animate({ 'bottom': '0px' }, 500);
        $(".top-move-button").stop().animate({ 'bottom': '60px' }, 500);
        $("footer").stop().animate({ 'height': '223px' }, 500);
        $(".top-nav ul li").fadeOut(500);
      }
    });


  $(".footer-infor-title").click(function () {
    if (!$(this).hasClass("clicked")) {
      $(".footer-infor").fadeIn(300);
      $(this).text("사업자 정보 닫기 ∧");
      $(this).addClass("clicked");
    } else {
      $(".footer-infor").fadeOut(300);
      $(this).text("사업자 정보 열기 ∨");
      $(this).removeClass("clicked");
    }
  });

  $(".top-move-button").click(function () {
    $('html').stop().animate({ scrollTop: 0 }, 1000);
  });


});
