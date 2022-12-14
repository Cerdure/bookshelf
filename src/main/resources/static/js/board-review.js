
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
  $(".middle-nav-underbar").css('left','0%');

  let starFill = $(".review-book-rating .star-fill");
  let ratingNum = $(".review-book-rating-number .rating-number");

  $(".review-book-rating .star-empty img")
  .mouseover(function(){
    let index = $(this).index();
    starFill.stop().animate({'width':34.5*(index+1)+'px'},300);
    ratingNum.text(index+1);
  })
  .click(function(){
    starClickIndex = $(this).index();
    bookPassed = true;
    registCheck(tagPassed,reviewPassed,bookPassed);
  })
  .mouseleave(function(){
    starFill.stop().animate({'width':34.5*(starClickIndex+1)+'px'},300);
    ratingNum.text(starClickIndex+1);
  });

  let reviews = $(".my-review .body").toArray();
  
  reviews.forEach(e => e.querySelector(".review").offsetHeight<e.querySelector("span").offsetHeight?
  e.querySelector(".fold-button").style.display='block':
  e.querySelector(".fold-button").style.display='none'
  );

  $(window).resize(function(){
    reviews.forEach(e => e.querySelector(".review").offsetHeight<e.querySelector("span").offsetHeight?
    e.querySelector(".fold-button").style.display='block':
    e.querySelector(".fold-button").style.display='none'
    );
  });


  let rfbClicked = false;

  $(".my-review .fold-button").click(function(){
    if(!rfbClicked){
      $(this).parent().find(".review").css({'overflow':'visible','display':'block'});
      $(this).find(".icon").css('transform','rotate(180deg)');
      
      rfbClicked = true;
    } else {
      $(this).parent().find(".review").css({'overflow':'hidden','display':'-webkit-box'});
      $(this).find(".icon").css('transform','rotate(0deg)');
      rfbClicked = false;
    }
  });

  let phNum = $(".photos").length;
  for(var i=1; i<=phNum; i++){
    let photos =".my-review:nth-child("+i+") .photos";
    $(photos).css("background-image",'url('+$(photos+" img:nth-child(2)").attr('src')+')');
    $(photos+" .number").text('+'+($(photos+" img").length-1));
  }


  $(".photos").mouseover(function(){
    if(!phOpened)
    $(this).find(".plus").stop().fadeIn(300);
  }).mouseleave(function(){
    if(!phOpened)
    $(this).find(".plus").stop().fadeOut(300);
  });

  let phOpened = false;
  $(".photos").click(function(){
    if(!phOpened){
    $(this).fadeOut(10,function(){
      $(this).css({
        'position':'fixed',
        'top':'50%',
        'right':'auto',
        'left':'50%',
        'width':'600px',
        'height':'400px',
        'transform':'translate(-50%,-50%)',
        'background-size':'contain',
        'z-index':'11'
      });
      $(this).find(".plus").fadeOut(0);
      $(this).find(".close").show();
      $(this).find(".btn-left").show();
      $(this).find(".btn-right").show();
      $(this).prev().show();
      $(this).find(".number").text(
        '1 / ' + $(this).find("img").toArray().length
      );
      $(this).find(".number").css({
        'bottom':'-30px',
        'right':'auto',
        'left':'50%',
        'transform':'translateX(-50%)',
        'width':'auto',
        'height':'auto',
        'background-color':'rgba(0, 0, 0, 0)',
        'font-size':'25px',
        'line-height':'25px',
        'filter':'drop-shadow(black 0px 0px 2px)',
        'text-shadow':'0px 0px 2px black'
      });
      $(this).show(300);
      phOpened = true;
    });
    }
  });
  
  $(".photos .close").click(function(){
    let photos = $(this).parent();
    photos.hide(100,function(){
      photos.css({
        'position':'absolute',
        'top':'0',
        'right':'0',
        'left':'auto',
        'transform':'auto',
        'width':'64px',
        'height':'64px',
        'transform':'none',
        'background-size':'cover',
        'z-index':'0',
        'background-image': 'url(' + photos.children("img").eq(0).attr('src') + ')'
      });
      $(this).find(".close").hide();
      $(this).find(".btn-left").hide();
      $(this).find(".btn-right").hide();
      $(this).find(".number").text('+'+($(this).find("img").toArray().length-1));
      $(this).find(".number").css({
        'bottom':'0',
        'right':'0',
        'left':'auto',
        'transform':'none',
        'width':'20px',
        'height':'15px',
        'background-color':'rgba(0, 0, 0, 0.6)',
        'font-size':'11px',
        'line-height':'15px',
        'filter':'none',
        'text-shadow':'none'
      });
      phCurrentIndex = 1;
      photos.fadeIn(300, function(){
        phOpened = false;
      });
    });
  });

  let phCurrentIndex = 1;
  $(".photos .btn-left").click(function(){
    let photos = $(this).parent();
    let maxIndex = photos.find("img").toArray().length;
    if(phCurrentIndex != 1){ 
      photos.fadeOut(100,function(){
        phCurrentIndex--;
        photos.css({
          'background-image':'url('+ photos.children().eq(phCurrentIndex).attr('src')+')'
        });
        photos.find(".number").text(phCurrentIndex + " / " + maxIndex);
      });
      photos.fadeIn(300);
    }
  });
  $(".photos .btn-right").click(function(){
    let photos = $(this).parent();
    let maxIndex = photos.find("img").toArray().length;
    if(phCurrentIndex != maxIndex){
      photos.fadeOut(100,function(){
        phCurrentIndex++;
        photos.css({
          'background-image':'url('+ photos.children().eq(phCurrentIndex).attr('src')+')'
        });
        photos.find(".number").text(phCurrentIndex + " / " + maxIndex);
      });
      photos.fadeIn(300);
    }
  });


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




  $(".search-result .select").click(function(){
    let bookImg = $(this).parent().find("img").attr('src');
    let bookName =  $(this).parent().find(".name").text();
    $(".review-book-img").attr('src', bookImg);
    $(".review-book-name").text(bookName);
    $(".review-write-book-wrapper").show();
    $(".review-write-search-wrapper").hide();
    swOpened = false;
    $(".review-write-find").animate({'backgroundColor':'lightgray'},500);
    $(".review-write-find-text").text('상품 재검색');
    
  });

  $(".review-write-tag .tag").click(function(){
    $(".review-write-tag .tag").removeClass("tag-active");
    $(this).addClass("tag-active");
    tagPassed = true;
    registCheck(tagPassed,reviewPassed,bookPassed);
  });

  $(".review-write-wrapper textarea").keyup(function(){
    let reviewVal = $(this).val();
    $(".write-number").text(reviewVal.length+"/3000");
    if(reviewVal.length>9){
      reviewPassed = true;
    } else {
      reviewPassed = false;
    }
    registCheck(tagPassed,reviewPassed,bookPassed);
  });

  

  $(".review-title-write").click(function(){
    $(".write-wrapper-back").addClass("modal-background");
    $(".review-write-wrapper").fadeIn(200);
    $("body").css('overflow-y','hidden');
    rwOpened = true;
  });
  $(".review-write-top-icon").click(function(){
    $(".review-write-wrapper").css('filter','brightness(0.5)');
    $(".close-alert").show();
  });



  $(".review-write-find").click(function(){
    $(".review-write-search-wrapper").fadeIn(200);
    swOpened = true;
  });

  $(".search-title img").click(function(){
    $(".review-write-search-wrapper").hide();
    swOpened = false;
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

});

  let starClickIndex = -1;
  let bookPassed = false;
  let tagPassed = false;
  let reviewPassed = false;
  let rwOpened = false;
  let imgCount = 0;
 
  function imgChange(){
      if(imgCount==5){
        $(".review-write-attach-photo-button").hide();
      } else {
        $(".review-write-attach-photo-button").show();
      }
    $(".review-write-attach-title span:last-child").text(imgCount+'/5');
  }

  function setThumbnail(event) {
    for (var image of event.target.files) {
      let reader = new FileReader();
      reader.onload = function(event) {
        let div = document.createElement("div");
        div.setAttribute('class','review-write-photo-wrapper');
        div.innerHTML = '<div class="review-write-photo-cancel" onclick="deleteImg(this)">X</div>';
        let img = document.createElement("img");
        img.setAttribute("src", event.target.result);
        img.setAttribute("class", "review-write-photo");
        document.querySelector(".review-write-attach-photo").appendChild(div).appendChild(img);
      };
      reader.readAsDataURL(image);
      imgCount++;
    }
    imgChange();
  }

  function deleteImg(_this){
    $(_this).parent().remove();
    imgCount--;
    imgChange();
  }

  function myReviewSet(_this, myReview){
    myReview.bookImg = $(_this).parent().find(".review-book-img").attr('src');
    myReview.bookName = $(_this).parent().find(".review-book-name").text();
    myReview.rating = $(_this).parent().find(".rating-number").text();
    myReview.tag = $(_this).parent().find(".tag-active").text();
    myReview.review = $(_this).parent().find(".review-write").val();
    myReview.attach = $(_this).parent().find(".review-write-photo").toArray();
  }

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
    bookPassed = false;
    tagPassed = false;
    reviewPassed = false;
    rwOpened = false;
    imgCount = 0;
    starClickIndex = -1;
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