
$(function () {
  let clickindex = 4;
  $(".top-nav ul li").hover(function () {
    let index = $(this).index();
    if (index == 0) {
      $("#underbar").stop().animate({ 'left': '25px' }, 200, 'swing');
    } else {
      $("#underbar").stop().animate({ 'left': 22 + 100 * index + 'px' }, 200, 'swing');
    }
  });
  $(".top-nav ul li").click(function () {
    $(this).animate({ 'color': 'black' }, 300);
    $(".top-nav ul li").not(this).css('color', "rgb(180, 180, 180)");
    clickindex = $(this).index();
  });
  $(".top-nav ul li").mouseleave(function () {
    if (clickindex == 0) {
      $("#underbar").stop().animate({ 'left': '25px' }, 200, 'swing');
    } else {
      $("#underbar").stop().animate({ 'left': 22 + 100 * clickindex + 'px' }, 200, 'swing');
    }
  });
});

$(function () {
  let st = $(window).scrollTop();
  let width = $(window).width();
  if (width > 999) {
    $(".top-nav ul li").fadeIn(500);
  } else {
    $(".top-nav ul li").fadeOut(500);
  }
  if(st>150){
    $(".middle-nav-wrapper").css({
      'position':'fixed',
      'top':'70px',
      'border-top': 'none',
      'border-bottom':'1px solid #ebebeb',
      'box-shadow':'none'
    });
    $(".top-nav-background").css({
      'box-shadow':'none'
    });
    $(".meta-wrapper").css('margin-top','45px');
  } else {
    $(".middle-nav-wrapper").css({
      'position':'relative',
      'top':'0px',
      'border-top': '1px solid lightgray',
      'box-shadow':'0px -3px 5px 0px rgba(0, 0, 0, 0.03)'
    });
    $(".top-nav-background").css({
      'box-shadow':'0px 3px 5px 0px rgba(0, 0, 0, 0.05)'
    });
    $(".meta-wrapper").css('margin-top','0px');
  }
 
  $(window)
  .scroll(function(){
    st = $(this).scrollTop();
    if(st>150){
      $(".middle-nav-wrapper").css({
        'position':'fixed',
        'top':'70px',
        'border-top': 'none',
        'border-bottom':'1px solid #ebebeb',
        'box-shadow':'none'
      });
      $(".top-nav-background").css({
        'box-shadow':'none'
      });
      $(".meta-wrapper").css('margin-top','45px');
    } else {
      $(".middle-nav-wrapper").css({
        'position':'relative',
        'top':'0px',
        'border-top': '1px solid lightgray',
        'box-shadow':'0px -3px 5px 0px rgba(0, 0, 0, 0.03)'
      });
      $(".top-nav-background").css({
        'box-shadow':'0px 3px 5px 0px rgba(0, 0, 0, 0.05)'
      });
      $(".meta-wrapper").css('margin-top','0px');
    }
  })
  .resize(function () {
    width = $(this).width();
    if (width > 999) {
      $(".top-nav ul li").fadeIn(500);
    } else {
      $(".top-nav ul li").fadeOut(500);
    }
  });
});

$(function () {
  let clickindex = 5;
  $(".bottom-nav ul li").hover(function () {
    let index = $(this).index();
    if (index == 0) {
      $("#overbar").stop().animate({ 'left': '0%' }, 600, 'swing');
    } else {
      $("#overbar").stop().animate({ 'left': 20 * (index - 1) + '%' }, 300, 'swing');
    }
  });
  $(".bottom-nav ul li").mouseleave(function () {
    if (clickindex == 0) {
      $("#overbar").stop().animate({ 'left': '0%' }, 600, 'swing');
    } else {
      $("#overbar").stop().animate({ 'left': 20 * (clickindex - 1) + '%' }, 300, 'swing');
    }
  });
});

// ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt

$(function(){
  let width = $(".top-back-wrapper").width();
  $(".top-background").css('background-size',width+'px');


$(window).resize(function(){
  let width = $(".top-back-wrapper").width();
  $(".top-background").css('background-size',width+'px');
});

 $(".top-back-title").show();
 
});

// fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff

    $(function(){
      let isClosed = true;
      $(".footer-infor-title").click(function(){
        if(isClosed){
          $(".footer-infor").fadeIn(300);
          $(this).text("사업자 정보 닫기 ∧");
          isClosed = false;
        } else {
          $(".footer-infor").fadeOut(300);
          $(this).text("사업자 정보 열기 ∨");
          isClosed = true;
        }  
      });
    });
    $(function(){
      let width = $(window).width();
      if(width<1000){
        $(".bottom-nav-wrapper").stop().animate({'bottom':'0px'},500);
        $(".top-move-button").stop().animate({'bottom':'60px'},500);
        $("footer").stop().animate({'margin-bottom':'40px'},500);
      } else {
        $(".bottom-nav-wrapper").stop().animate({'bottom':'-80px'},500);
        $(".top-move-button").stop().animate({'bottom':'20px'},500);
        $("footer").stop().animate({'margin-bottom':'0px'},500);
      }
      $(window).resize(function(){
      width = $(this).width();
      if(width<1000){
        $(".bottom-nav-wrapper").stop().animate({'bottom':'0px'},500);
        $(".top-move-button").stop().animate({'bottom':'60px'},500);
        $("footer").stop().animate({'height':'223px'},500);
      } else {
        $(".bottom-nav-wrapper").stop().animate({'bottom':'-80px'},500);
        $(".top-move-button").stop().animate({'bottom':'20px'},500);
        $("footer").stop().animate({'height':'173px'},500);
      }
      });
      $(".top-move-button").click(function(){
        $('html').stop().animate({scrollTop : 0}, 1000);
      });
    });