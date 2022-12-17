
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

$(".top-back-title").show();
$(".middle-nav-underbar").css('left','50%');


  let notFist = false;
  $(".controller a").click(function () {
    let last = Number($(this).parent().children(".index-6").text());
    $(this).parent().find("a").removeClass("index-active");

    if(notFist && $(this).hasClass("index-1")) {
      for (var i = 1; i < 6; i++) {
        $(this).parent().children(".index-"+i).text(i);
      }
      $(this).parent().children(".index-6").show();
      $(this).parent().find(".first-ellipsis").hide();
      $(this).parent().find(".last-ellipsis").show();

    }
    if ($(this).hasClass("index-6")) {
      for (var i = 1; i < 6; i++) {
        $(this).parent().children(".index-"+i).text(i==1?1:last-5+i);
      }
      $(this).parent().children(".index-5").addClass("index-active");
      $(this).parent().children(".index-6").hide();
      $(this).parent().find(".first-ellipsis").show();
      $(this).parent().find(".last-ellipsis").hide();
      notFist = true;
    } else {
      $(this).addClass("index-active");
    }
  });


  $(".controller-btn-right").click(function () {
    let currentActive = $(this).parent().find(".index-active");
    let currentActiveIndex = Number(currentActive.attr('class').substr(6,1));  
    let nextActive = $(this).parent().find(".index-"+(currentActiveIndex+1));
    if (currentActive.text() != $(this).parent().children(".index-6").text()) {
      currentActive.removeClass("index-active");
      if (Number(currentActive.attr('class').substr(6,1)) >= 5) {
        for (var i = 1; i < 6; i++) {
          let orgText = Number($(this).parent().children(".index-"+i).text());
          $(this).parent().children(".index-"+i).text(i==1?1:orgText + 3);
        }
        $(this).parent().children(".index-3").addClass("index-active");
        $(this).parent().find(".first-ellipsis").show();


        let lastPrev = Number($(this).parent().children(".index-5").text());
        let last = Number($(this).parent().children(".index-6").text());
        if (lastPrev + 1 >= last) {
          for (var i = 1; i < 6; i++) {
            let orgText = Number($(this).parent().children(".index-"+i).text());
            $(this).parent().children(".index-"+i).text(i==1?1:orgText + (last - lastPrev));
          }
          $(this).parent().children(".index-6").hide();
          $(this).parent().find(".last-ellipsis").hide();
        }
        notFist = true;
      } else {
        nextActive.addClass("index-active");
      }
    }
  });

  $(".controller-btn-left").click(function () {
    let currentActive = $(this).parent().find(".index-active");
    let currentActiveIndex = Number(currentActive.attr('class').substr(6,1));  
    let currentActiveText = currentActive.text();
    let prevActive = $(this).parent().find(".index-"+(currentActiveIndex-1));

    
    if (currentActive.text() != 1) {
      currentActive.removeClass("index-active");

      if (currentActiveText!=2 && currentActiveIndex == 2) { console.log(2);
        switch(currentActiveText){
          case '6':       
            for (var i = 1; i < 6; i++) {
              $(this).parent().children(".index-"+i).text(i);
            }
            $(this).parent().children(".index-5").addClass("index-active");
            $(this).parent().find(".first-ellipsis").hide();
            break;
          case '5':
            for (var i = 1; i < 6; i++) {
              $(this).parent().children(".index-"+i).text(i);
            }
            $(this).parent().children(".index-4").addClass("index-active");
            $(this).parent().find(".first-ellipsis").hide();
            notFist = false;
            break; 
          case '4': 
            for (var i = 1; i < 6; i++) {
              $(this).parent().children(".index-"+i).text(i);
            }
            $(this).parent().children(".index-3").addClass("index-active");
            $(this).parent().find(".first-ellipsis").hide();
            notFist = false;
            break;  
          default:
            for (var i = 1; i < 6; i++) {
              let orgText = Number($(this).parent().children(".index-"+i).text());
              $(this).parent().children(".index-"+i).text(i==1?1:orgText - 2);
            }
            $(this).parent().children(".index-3").addClass("index-active");
            break;
        }
 
        let lastPrev = Number($(this).parent().children(".index-5").text());
        let last = Number($(this).parent().children(".index-6").text());
        if (lastPrev != last) {
          $(this).parent().children(".index-6").show();
          $(this).parent().find(".last-ellipsis").show();
        }
      } else {
        prevActive.addClass("index-active");
      }
    }
  });




  window.onkeyup = function(e) {
    var key = e.keyCode ? e.keyCode : e.which;
    if(swOpened && key == 27) {
      $(".review-write-search-wrapper").hide();
      swOpened = false;
    } else if (rwOpened && key == 27) {
      $(".review-write-wrapper").css('filter','brightness(0.5)');
      $(".close-alert").show();
    }
  }

  $(".notice-write").click(function(){
    $(".write-wrapper-back").addClass("modal-background");
    $(".notice-write-wrapper").fadeIn(200);
    $("body").css('overflow-y','hidden');
    iwOpened = true;
  });
  $(".notice-write-top-icon").click(function(){
    $(".notice-write-wrapper").css('filter','brightness(0.5)');
    $(".close-alert").show();
  });






});

  let swOpened = false;

  function formClose(_this){
    $(".write-wrapper-back").removeClass("modal-background");
    $("form").hide();
    $("body").css('overflow-y','scroll');
    $(".review-write-book-wrapper").hide();
    $("form").css('filter','brightness(100%)');
    $(".review-write-find-text").text("상품 검색");
    $(".review-book-rating .star-fill").stop().css('width','0px');
    $(".review-book-rating-number .rating-number").text(0); 
    $(".review-write-tag .tag").removeClass("tag-active");
    $("form textarea").val('');
    $(".write-number").text('0/3000');
    $(".review-write-photo-wrapper").remove();
    $(".review-write-attach-photo-button").show();
    hide(_this)
  }



  function hide(_this){
    $("form").css('filter','brightness(100%)');
    $(_this).parent().hide();
  }

  function registCheck(...passed){
    if(passed.every(e => {return e;})) {
      $(".regist-button").removeClass("disable");
    } else {
      $(".regist-button").addClass("disable");
    }
  }
