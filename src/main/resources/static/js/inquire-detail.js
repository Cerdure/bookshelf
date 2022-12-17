
$(function () {
  let st = $(window).scrollTop();
  let ubClickindex = 4;
  let obClickindex = 4;

  $(".top-nav ul li")
    .hover(function () {
      let index = $(this).index();
      if (index == 0) {
        $("#underbar").stop().animate({ 'left': '25px' }, 200, 'swing');
      } else {
        $("#underbar").stop().animate({ 'left': 22 + 100 * index + 'px' }, 200, 'swing');
      }
    })
    .click(function () {
      $(this).animate({ 'color': 'black' }, 300);
      $(".top-nav ul li").not(this).css('color', "rgb(180, 180, 180)");
      ubClickindex = $(this).index();
    })
    .mouseleave(function () {
      if (ubClickindex == 0) {
        $("#underbar").stop().animate({ 'left': '25px' }, 200, 'swing');
      } else {
        $("#underbar").stop().animate({ 'left': 22 + 100 * ubClickindex + 'px' }, 200, 'swing');
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
  });
});

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
  '<img src="/img/icon/arrow-return-right.svg">' +
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