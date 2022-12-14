
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

 $(".top-back-title:nth-child(1)").show();
 
 $(".comment-button-cancel").click();
 
 $(".my-comment").mouseover(function(){
  $(".option img:not(.clicked)").stop().fadeOut(100);
  $(this).find(".option img").stop().fadeIn(300);
 }).mouseleave(function(){
  $(".option img:not(.clicked)").stop().fadeOut(100);
 });

 $(".opt-btn").click(function(){
  if(!$(this).hasClass("clicked")){
    $(".opt-btn").stop().fadeOut(0);
    $(this).fadeIn(0);
    let parent = $(this).parent();
    $(".clicked").removeClass("clicked");
    $(this).addClass("clicked");
    $(".box").fadeOut(0);
    parent.find(".box").stop().fadeIn(300);
  } else {
    $(".box").fadeOut(0);
    $(".clicked").removeClass("clicked");
  }
 });

 $('html').click(function(e) {   
	if(!$(e.target).is(".opt-btn, .box, .edit, .remove, .reply")) {
    $(".box").fadeOut(0);
    $(".clicked").removeClass("clicked");
	}
});   

$(".reply").click(function(){
  let div = document.createElement("div");
  div.setAttribute('class','inner-comment');
  div.innerHTML = 
  '<img src="../static/img/icon/arrow-return-right.svg">' +
  '<textarea class="comment" name="comment" maxlength="300" onkeydown="resize(this)" onkeyup="resize(this)" onclick="commentClick(this)" onfocusout="commentFocusout(this)" placeholder="내용을 입력해주세요."></textarea>'+
  '<div class="comment-underline"></div>' +
  '<button class="comment-button-save" type="submit" value="save">등록</button>' +
  '<button class="comment-button-cancel" onclick="myCommentCancel(this)">취소</button>';
  $(this).closest('.my-comment').append(div);
});
 
});

  function hide(_this){
    $("form").css('filter','brightness(100%)');
    $(_this).parent().hide();
  }

  function resize(_this) {
    _this.style.height = "1px";
    _this.style.height = (12+_this.scrollHeight)+"px";
  }

  function commentClick(_this){
    $(_this).parent().find(".comment-underline").stop().animate({'width':'100%'},200,'easeInOutQuad');
    $(_this).parent().find(".comment-button-save").stop().fadeIn(300);
    $(_this).parent().find(".comment-button-cancel").stop().fadeIn(300);
   }

   function commentFocusout(_this){
    $(_this).parent().find(".comment-underline").stop().animate({'width':'0%'},100,'easeInOutQuad');
   }

   function commentCancel(_this){
    let textarea = $(_this).parent().find("textarea");
    textarea.val('');
    $(_this).parent().find(".comment-underline").stop().animate({'width':'0%'},100,'easeInOutQuad');
    $(_this).parent().find(".comment-button-save").stop().fadeOut(100);
    $(_this).parent().find(".comment-button-cancel").stop().fadeOut(100);
    textarea.css('height','1px');
    textarea.css('height',(12+textarea.prop('scrollHeight'))+'px');
   }

   function myCommentCancel(_this){
    $(_this).parent().remove();
   }

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