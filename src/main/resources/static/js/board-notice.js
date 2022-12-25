
$(function () {
  let st = $(window).scrollTop();
  let ubClickindex = 4;
  let obClickindex = 4;

  $(".top-nav ul li")
    .hover(function () {
      let index = $(this).index();
      if (index == 0) {
        $("#underbar").stop().animate({ 'left': '0%' }, 200, 'swing');
      } else {
        $("#underbar").stop().animate({ 'left': 20 * index + '%' }, 200, 'swing');
      }
    })
    .click(function () {
      $(this).animate({ 'color': 'black' }, 300);
      $(".top-nav ul li").not(this).css('color', "rgb(180, 180, 180)");
      ubClickindex = $(this).index();
    })
    .mouseleave(function () {
      if (ubClickindex == 0) {
        $("#underbar").stop().animate({ 'left': '0%' }, 200, 'swing');
      } else {
        $("#underbar").stop().animate({ 'left': 20 * ubClickindex + '%' }, 200, 'swing');
      }
    });

  $(".bottom-nav ul li")
    .hover(function () {
      let index = $(this).index();
      if (index == 0) {
        $("#overbar").stop().animate({ 'left': '0%' }, 600, 'swing');
      } else {
        $("#overbar").stop().animate({ 'left': 20 * (index - 1) + '%' }, 300, 'swing');
      }
    })
    .mouseleave(function () {
      if (obClickindex == 0) {
        $("#overbar").stop().animate({ 'left': '0%' }, 600, 'swing');
      } else {
        $("#overbar").stop().animate({ 'left': 20 * obClickindex + '%' }, 300, 'swing');
      }
    });


  if(st>160){
    $(".middle-nav-wrapper").css({
      'position':'fixed',
      'top':'60px',
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
    if(st>160){
      $(".middle-nav-wrapper").css({
        'position':'fixed',
        'top':'60px',
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
  });
});


$(function(){
  let width = $(".top-back-wrapper").width();
  $(".top-background").css('background-size',width+'px');


$(window).resize(function(){
  let width = $(".top-back-wrapper").width();
  $(".top-background").css('background-size',width+'px');
});

$(".top-back-title").show();



  window.onkeyup = function(e) {
    var key = e.keyCode ? e.keyCode : e.which;
    if (nwOpened && key == 27) {
      $(".review-write-wrapper").css('filter','brightness(0.5)');
      $(".close-alert").show();
    }
  }

  $(document).ready(function () {
    $(document).on("click", ".notice-write", function () {
      $(".write-wrapper-back").addClass("modal-background");
      $(".notice-write-wrapper").fadeIn(200);
      $("body").css('overflow-y', 'hidden');
      nwOpened = true;
    });

    $(document).on("keyup", ".notice-input-header", function () {
      let val = $(this).val();
      if(val!=''){
        headerPassed = true;
      } else {
        headerPassed = false;
      }
      registCheck(headerPassed,mainPassed);
    });

    $(document).on("keyup", ".notice-input-main", function () {
      let val = $(this).val();
      $(".write-number").text(val.length+"/3000");
      if(val.length>9){
        mainPassed = true;
      } else {
        mainPassed = false;
      }
      registCheck(headerPassed,mainPassed);
    });

    $(document).on("click",".notice-write-top-icon", function () {
      $("form").css('filter', 'brightness(0.5)');
      $(".close-alert").show();
    });

  });
});



let headerPassed = false;
let mainPassed = false;
let nwOpened = false;

function formClose(_this){
  $(".write-wrapper-back").removeClass("modal-background");
  $(".notice-write-wrapper").hide();
  $("body").css('overflow-y','scroll');
  $(".notice-write-wrapper").css('filter','brightness(100%)');
  $(".notice-write-wrapper textarea").val('');
  $(".write-number").text('0/3000');
  $(".notice-write-photo-wrapper").remove();
  $(".notice-write-attach-photo-button").show();
  $(".private-check").prop("checked", false);
  $(".private-pw").val('');
  $(".regist-button").addClass("disable");
  $(".notice-write").css('pointer-events','all');
  headerPassed = false;
  mainPassed = false;
  nwOpened = false;
  hideAlert(_this)
}

function registCheck(...passed){
  if(passed.every(e => {return e;})) {
    $(".regist-button").removeClass("disable");
  } else {
    $(".regist-button").addClass("disable");
  }
}

function hideAlert(_this) {
  $(".write-wrapper-back").removeClass("modal-background");
  $("form").css('filter', 'brightness(100%)');
  $(_this).parent().hide();
}

function formSubmit(_this){
  let form = $(_this).closest("form");
  let content = form.find("[name=content]");
  content.val(content.val().replace(/\n/g, "<br>"));
  form.submit();
}
