
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
    if(st>150){
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
  $(".middle-nav-underbar").css('left','25%');


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
          case '6': console.log(6);        
            for (var i = 1; i < 6; i++) {
              $(this).parent().children(".index-"+i).text(i);
            }
            $(this).parent().children(".index-5").addClass("index-active");
            $(this).parent().find(".first-ellipsis").hide();
            break;
          case '5': console.log(5);
            for (var i = 1; i < 6; i++) {
              $(this).parent().children(".index-"+i).text(i);
            }
            $(this).parent().children(".index-4").addClass("index-active");
            $(this).parent().find(".first-ellipsis").hide();
            notFist = false;
            break; 
          case '4': console.log(4);
            for (var i = 1; i < 6; i++) {
              $(this).parent().children(".index-"+i).text(i);
            }
            $(this).parent().children(".index-3").addClass("index-active");
            $(this).parent().find(".first-ellipsis").hide();
            notFist = false;
            break;  
          default: console.log('d');
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




  $(".inquire-write").click(function(){
    $(".write-wrapper-back").addClass("modal-background");
    $(".inquire-write-wrapper").fadeIn(200);
    $("body").css('overflow-y','hidden');
    iwOpened = true;
  });
  $(".inquire-write-top-icon").click(function(){
    $(".inquire-write-wrapper").css('filter','brightness(0.5)');
    $(".close-alert").show();
  });

  $(".inquire-input-header, .notice-input-header, .winner-input-header").keyup(function(){
    let val = $(this).val();
    if(val!=''){
      headerPassed = true;
    } else {
      headerPassed = false;
    }
    registCheck(headerPassed,mainPassed);
  });
  $(".inquire-input-main, .notice-input-main, .winner-input-main").keyup(function(){
    let val = $(this).val();
    $(".write-number").text(val.length+"/3000");
    if(val.length>9){
      mainPassed = true;
    } else {
      mainPassed = false;
    }
    registCheck(headerPassed,mainPassed);
  });
  $(".private-check").click(function(){
    if($(this).is(':checked')){ console.log(1);
      $(".private-pw").stop().show();
      $(".private-pw").stop().animate({'width':'200px'},300);
    } else {
      $(".private-pw").stop().animate({'width':'0px'},300,function(){
      $(".private-pw").stop().hide();
      });
    }
  });

 


});

  let headerPassed = false;
  let mainPassed = false;
  let iwOpened = false;
 

  

  function formClose(_this){
    $(".write-wrapper-back").removeClass("modal-background");
    $("form").hide();
    $("body").css('overflow-y','scroll');
    $("form").css('filter','brightness(100%)');
    $("form textarea").val('');
    $(".write-number").text('0/3000');
    headerPassed = false;
    mainPassed = false;
    iwOpened = false;
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
