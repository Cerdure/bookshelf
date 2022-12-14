
    $(function(){
      let clickindex = 1;
      $(".top-nav ul li").hover(function(){
        let index = $(this).index();
        if(index==0){
          $("#underbar").stop().animate({'left':'25px'},200,'swing');
        } else {
          $("#underbar").stop().animate({'left':22+100*index+'px'},200,'swing');
        }
      });
      $(".top-nav ul li").click(function(){
        $(this).animate({'color':'black'},300);
        $(".top-nav ul li").not(this).css('color',"rgb(180, 180, 180)");
        clickindex = $(this).index();
      });
      $(".top-nav ul li").mouseleave(function(){
        if(clickindex==0){
          $("#underbar").stop().animate({'left':'25px'},200,'swing');
        } else {
          $("#underbar").stop().animate({'left':22+100*clickindex+'px'},200,'swing');
        }
      });
    });
    $(function(){
      let clickindex = 0;
      $(".bottom-nav ul li").hover(function(){
        let index = $(this).index();
        if(index==0){
          $("#overbar").stop().animate({'left':'20%'},600,'swing');
        } else {
          $("#overbar").stop().animate({'left':20*(index-1)+'%'},300,'swing');
        }
      });
      $(".bottom-nav ul li").mouseleave(function(){
        if(clickindex==0){
          $("#overbar").stop().animate({'left':'20%'},600,'swing');
        } else {
          $("#overbar").stop().animate({'left':20*(clickindex-1)+'%'},300,'swing');
        }
      });
    });
    $(function(){
      let width = $(window).width();
      if(width<1000){
        $(".top-nav ul li").fadeOut(500);
      }
      $(window).resize(function(){
        width = $(this).width();
        if(width>999){
          $(".top-nav ul li").fadeIn(500);
        } else {
          $(".top-nav ul li").fadeOut(500);
        }
        });
    });


  //  tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt

  $(function(){
    $(".search-input .reset").click(function(){
      $(this).parent().find('input').val('');
     });

    $(".side-wrapper").css('transform', 'translateY('+$(window).scrollTop()+'px)');

    $(window).scroll(function(){
      let sct = $(this).scrollTop();
      let mainHeight = $('.main-wrapper').height();
      $(".side-wrapper").css('transform', 'translateY('+sct+'px)');
    });

    $(".reviews").click(function(){
      let mainHeight = $('.main-wrapper').height();
      $('html').stop().animate({scrollTop : mainHeight-900}, 300);
    });

    $(".fold-btn").click(function(){
      if(!$(this).hasClass('clicked')){
        $(this).parent().css({'height':'auto'});
        $(this).css('transform','rotate(180deg)').addClass('clicked');
      } else {
        $(this).parent().css({'height':'40px'});
        $(this).css('transform','rotate(0deg)').removeClass('clicked');
      }
      let sct = $(window).scrollTop();
        $(".side-wrapper").css('transform', 'translateY('+sct+'px)');
    });


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
    let sct = $(window).scrollTop();
    $(".side-wrapper").css('transform', 'translateY('+sct+'px)');
  });

  let phNum = $(".photos").length;
  for(var i=2; i<=phNum+1; i++){
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
        'left':'42%',
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

  

  $(".write-review, .first-review").click(function(){
    $(".write-wrapper-back").addClass("modal-background");
    $(".review-write-wrapper").fadeIn(200);
    $("body").css('overflow-y','hidden');
    rwOpened = true;
  });
  $(".review-write-top-icon").click(function(){
    $(".review-write-wrapper").css('filter','brightness(0.5)');
    $(".close-alert").show();
  });



  window.onkeyup = function(e) {
    var key = e.keyCode ? e.keyCode : e.which;
    if(rwOpened && key == 27) {
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
    $("form").css('filter','brightness(100%)');
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






  // fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff
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
        $(".bottom-nav-sub-wrapper").stop().animate({'bottom':'50px'},500);
        $(".footer-wrapper").stop().animate({'height':'243px'},500);
        $(".main-wrapper").stop().animate({'padding-right':'0'},500);
        $(".side-wrapper").stop().animate({'right':'-300px'},500);
        $(".other-reviews").stop().css({'margin-bottom':'100px'});
      } else {
        $(".bottom-nav-wrapper").stop().animate({'bottom':'-80px'},500);
        $(".bottom-nav-sub-wrapper").stop().animate({'bottom':'-80px'},500);
        $(".footer-wrapper").stop().animate({'height':'173px'},500);
        $(".main-wrapper").stop().animate({'padding-right':'200px'},500);
        $(".side-wrapper").stop().animate({'right':'0'},300);
        $(".other-reviews").stop().css({'margin-bottom':'0'});
      }

      $(window).resize(function(){
      width = $(this).width();
      if(width<1000){
        $(".bottom-nav-wrapper").stop().animate({'bottom':'0px'},500);
        $(".bottom-nav-sub-wrapper").stop().animate({'bottom':'50px'},500);
        $(".footer-wrapper").stop().animate({'height':'243px'},500);
        $(".main-wrapper").stop().animate({'padding-right':'0'},500);
        $(".side-wrapper").stop().animate({'right':'-300px'},500);
        $(".other-reviews").stop().css({'margin-bottom':'100px'});
      } else {
        $(".bottom-nav-wrapper").stop().animate({'bottom':'-80px'},500);
        $(".bottom-nav-sub-wrapper").stop().animate({'bottom':'-80px'},500);
        $(".footer-wrapper").stop().animate({'height':'173px'},500);
        $(".main-wrapper").stop().animate({'padding-right':'200px'},500);
        $(".side-wrapper").stop().animate({'right':'0'},300);
        $(".other-reviews").stop().css({'margin-bottom':'0'});
      }
      });

    
    });

  

    