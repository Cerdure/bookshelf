$(function () {
  const arr = [];
  let count = 0;
  let check = false;
  let st = $(window).scrollTop();
  let width = $(window).width();
  let ubClickindex = 2;
  let obClickindex = 2;

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

    


  function bannerSlide(speed) {
    $(".banner-current-index").text(count % 16 + 1 < 10 ? '0' + (count % 16 + 1) : count % 16 + 1);
    $(".banner-index-fill").stop().animate({ 'left': (-57 + (count % 16) * 3.8) + 'px' }, 500);
    count++;

    if (count == 17) {
      $(".banner-img-wrapper ul").animate({ 'right': -3405 + 160 * count + 'px' }, speed,
        function () {
          $(".banner-img-wrapper ul").css('right', '-3295px');
          count = 1;
        });
    } else if (check && count == 1) {
      $(".banner-img-wrapper ul").animate({ 'right': '-685px' }, speed,
        function () {
          $(".banner-img-wrapper ul").css('right', '-3295px');

        });
    } else if (count < 3) {
      $(".banner-img-wrapper ul").animate({ 'right': -3405 - 50 + 160 * count + 'px' }, speed);
    } else if (count > 11) {
      $(".banner-img-wrapper ul").animate({ 'right': -3405 + 160 * count + 'px' }, speed);
    }
    else {
      $(".banner-img-wrapper ul").animate({ 'right': -3405 + 160 * count + 'px' }, speed);
    }
    $(".bi-" + (count + 3) % 16).animate({
      'width': '160px', 'height': '220px', 'top': '0px', 'opacity': '0.5'
    }, speed);
    $(".bi-" + (count + 3) % 16).removeClass("bi-active");
    $(".bi-" + (count + 3) % 16 + " img").animate({
      'width': '140px', 'height': '200px'
    }, speed);

    $(".bi-" + (count + 4) % 16).animate({
      'width': '210px', 'height': '290px', 'top': '-70px', 'opacity': '1'
    }, speed);
    $(".bi-" + (count + 4) % 16).addClass("bi-active");
    $(".bi-" + (count + 4) % 16 + " img").animate({
      'width': '190px', 'height': '270px'
    }, speed);

    $(".banner-font-big").text($(".bi-active").find(".book-name").val());
    $(".active-origin-price").text(Number($(".bi-active").find(".book-origin-price").val()).toLocaleString('ko-KR') + '원');
    $(".active-discount-rate").text('-' + $(".bi-active").find(".book-discount-rate").val() + '%');
    $(".active-discount-price").text(Number($(".bi-active").find(".book-discount-price").val()).toLocaleString('ko-KR') + '원');
    $(".banner-before").css('backgroundImage', 'url(' + $(".bi-" + (count + 4) % 16 + " img").attr('src') + ')');

   
  }

  function bannerSlideReverse(speed) {

    check = true;
    count = (count + 15) % 16;

    if (count == 0) {
      $(".banner-img-wrapper ul").animate({ 'right': -3455 + 160 * count + 'px' }, speed,
        function () {
          $(".banner-img-wrapper ul").css('right', '-845px');
          count = 0;
        });
    } else if (count < 3) {
      $(".banner-img-wrapper ul").animate({ 'right': -3405 - 50 + 160 * count + 'px' }, speed);
    } else if (count > 11) {
      $(".banner-img-wrapper ul").animate({ 'right': -3405 + 160 * count + 'px' }, speed);
    } else {
      $(".banner-img-wrapper ul").animate({ 'right': -3405 + 160 * count + 'px' }, speed);
    }

    $(".banner-current-index").text((count) % 16 == 0 ? 16 : (count) % 16 < 10 ? '0' + (count) % 16 : (count) % 16);
    $(".banner-index-fill").stop().animate({ 'left': (-57 + ((count) % 16 == 0 ? 15 : (count - 1) % 16) * 3.8) + 'px' }, 500);

    $(".bi-" + (count + 5) % 16).animate({
      'width': '160px', 'height': '220px', 'top': '0px', 'opacity': '0.5'
    }, speed);
    $(".bi-" + (count + 5) % 16).removeClass("bi-active");
    $(".bi-" + (count + 5) % 16 + " img").animate({
      'width': '140px', 'height': '200px'
    }, speed);

    $(".bi-" + (count + 4) % 16).animate({
      'width': '210px', 'height': '290px', 'top': '-70px', 'opacity': '1'
    }, speed);
    $(".bi-" + (count + 4) % 16).addClass("bi-active");
    $(".bi-" + (count + 4) % 16 + " img").animate({
      'width': '190px', 'height': '270px'
    }, speed);

    $(".banner-font-big").text($(".bi-active").find(".book-name").val());
    $(".active-origin-price").text(Number($(".bi-active").find(".book-origin-price").val()).toLocaleString('ko-KR') + '원');
    $(".active-discount-rate").text('-' + $(".bi-active").find(".book-discount-rate").val() + '%');
    $(".active-discount-price").text(Number($(".bi-active").find(".book-discount-price").val()).toLocaleString('ko-KR') + '원');
    $(".banner-before").css('backgroundImage', 'url(' + $(".bi-" + (count + 4) % 16 + " img").attr('src') + ')');


  }

  bannerSlide(300);
  let itv = setInterval(function () {
    setInterval(bannerSlide(300), 4000);
  }, 4000);

  $(".btn-right").click(function () {
    clearInterval(itv);
    bannerSlide(300);
    itv = setInterval(function () {
      setInterval(bannerSlide(300), 4000);
    }, 4000);
  });
  $(".btn-left").click(function () {
    clearInterval(itv);
    bannerSlideReverse(300);
    itv = setInterval(function () {
      setInterval(bannerSlide(300), 4000);
    }, 4000);
  });

  $(".banner-stop").click(function () {
    clearInterval(itv);
    $(this).fadeOut(100);
    $(".banner-play").fadeIn(200);
  });
  $(".banner-play").click(function () {
    itv = setInterval(function () {
      setInterval(bannerSlide(300), 4000);
    }, 4000);
    $(this).fadeOut(100);
    $(".banner-stop").fadeIn(200);
  });

  $(window)
    .blur(function () {
      clearInterval(itv);
    })
    .focus(function () {
      clearInterval(itv);
      itv = setInterval(function () {
        setInterval(bannerSlide(300), 4000);
      }, 4000);
    });


  $(".category-title span").click(function () {
    let categoryIndex = $(this).index();

    switch (categoryIndex) {
      case 0:
        $('html').stop().animate({ scrollTop: 609 }, 1000);
        return;
      case 1:
        $('html').stop().animate({ scrollTop: 1090 }, 1000);
        return;
      case 2:
        $('html').stop().animate({ scrollTop: 1900 }, 1000);
        return;
      case 3:
        $('html').stop().animate({ scrollTop: 2910 }, 1000);
        return;
    }
  });

  $(".category-img-wrapper div").click(function () {
    let categoryIndex = $(this).index();

    switch (categoryIndex) {
      case 0:
        $('html').stop().animate({ scrollTop: 609 }, 1000);
        return;
      case 1:
        $('html').stop().animate({ scrollTop: 1090 }, 1000);
        return;
      case 2:
        $('html').stop().animate({ scrollTop: 1900 }, 1000);
        return;
      case 3:
        $('html').stop().animate({ scrollTop: 2910 }, 1000);
        return;
    }
  });


  if (st > 557) {
    $(".category-wrapper").css({
      'position': 'fixed',
      'top': '-92px',
      'width': '100%',
      'border': 'none',
      'z-index': '5'
    });
    $(".sale-wrapper").css({
      'margin-top':'230px'
    });
    $(".category-title-wrapper").css({
      'position': 'fixed',
      'top': '112px',
      'background': 'white',
      'border-bottom': '1px solid #ebebeb',
    });
    if (width < 1280) {
      $(".category-title").css({
        'width': '80%'
      });
    }
    $(".category-img-wrapper").css({
      'height': '160px'
    });
  } else {
    $(".category-wrapper").css({
      'position': 'relative',
      'top': 'auto',
      'width': '1280px',
      'border': '1px solid #eaeaea',
      'z-index': '0'
    });
    $(".sale-wrapper").css({
      'margin-top':'auto'
    });
    $(".category-title-wrapper").css({
      'position': 'relative',
      'top': '0px',
      'background': 'none',
      'border-bottom': 'none',
      'z-index': '0'
    });
    $(".category-title").css({
      'width': '1000px',
    });
    $(".category-img-wrapper").css({
      'height': '100px'
    });
  }

  $(window).scroll(function () { 
    st = $(this).scrollTop();           console.log(st);
    width = $(this).width();

    if (st > 557) {
      $(".category-wrapper").css({
        'position': 'fixed',
        'top': '-92px',
        'width': '100%',
        'border': 'none',
        'z-index': '5'
      });
      $(".sale-wrapper").css({
        'margin-top':'230px'
      });
      $(".category-title-wrapper").css({
        'position': 'fixed',
        'top': '112px',
        'background': 'white',
        'border-bottom': '1px solid #ebebeb',
        'z-index': '5'
      });
      if (width < 1280) {
        $(".category-title").css({
          'width': '80%'
        });
      }
      $(".category-img-wrapper").css({
        'height': '160px'
      });
    } else {
      $(".category-wrapper").css({
        'position': 'relative',
        'top': 'auto',
        'width': '1280px',
        'border': '1px solid #eaeaea',
        'z-index': '0'
      });
      $(".sale-wrapper").css({
        'margin-top':'auto'
      });
      $(".category-title-wrapper").css({
        'position': 'relative',
        'top': '0px',
        'background': 'none',
        'border-bottom': 'none',
        'z-index': '0'
      });
      $(".category-title").css({
        'width': '1000px',
      });
      $(".category-img-wrapper").css({
        'height': '100px'
      });
    }

    if (st < 500) {
      $(".category-title-wrapper span").stop().animate({ 'color': '#696969' }, 300);
    } else if (st < 800) {
      $(".category-title span:nth-child(1)").stop()
        .animate({ 'color': 'rgb(255, 190, 0)' }, 200);
      $(".category-title span:not(.category-title span:nth-child(1))").stop()
        .animate({ 'color': '#696969' }, 200);
    } else if (st < 1750) {
      $(".category-title span:nth-child(2)").stop()
        .animate({ 'color': 'rgb(255, 190, 0)' }, 200);
      $(".category-title span:not(.category-title span:nth-child(2))").stop()
        .animate({ 'color': '#696969' }, 200);
    } else if (st < 2700) {
      $(".category-title span:nth-child(3)").stop()
        .animate({ 'color': 'rgb(255, 190, 0)' }, 200);
      $(".category-title span:not(.category-title span:nth-child(3))").stop()
        .animate({ 'color': '#696969' }, 200);
    } else {
      $(".category-title span:nth-child(4)").stop()
        .animate({ 'color': 'rgb(255, 190, 0)' }, 200);
      $(".category-title span:not(.category-title span:nth-child(4))").stop()
        .animate({ 'color': '#696969' }, 200);
    }
  })
    .resize(function () {
      st = $(this).scrollTop();
      width = $(this).width();

      if (st > 557 && width < 480) {
        $(".category-title").css({
          'width': '450px',
        });
      } else if (st > 557 && width > 479) {
        if (width < 1280) {
          $(".category-title").css({
            'width': '80%'
          });
        }
      } else {
        $(".category-title").css({
          'width': '1000px',
        });
      }
    });

});




$(function () {
  const arr = [];
  const row = Array.from(Array(2), () => new Array(9));

  for (var i = 0; i < 18; i++) {
    let randNum = Math.floor(Math.random() * 62 + 1);
    while (arr.indexOf(randNum) != -1) randNum = Math.floor(Math.random() * 62 + 1);
    arr.push(randNum);
    row[Math.floor(i / 9)][i % 9] = randNum;
  }


  function slide() {
    $(".sale-row-0").animate({ 'right': '130px' }, 5000, "linear", function () {
      let nextImgs = [];
      let nextNames = [];
      let nextAuthors = [];
      for (var i=1; i<10; i++){
        nextImgs[i] =  $(".sale-row-0 a:nth-child(" + (i % 9 + 1) + ") img").attr('src');
        nextNames[i] =  $(".sale-row-0 a:nth-child(" + (i % 9 + 1) + ") #sale-book-name").text();
        nextAuthors[i] =  $(".sale-row-0 a:nth-child(" + (i % 9 + 1) + ") #sale-discount-rate").text();
      }
      for (var k = 1; k < 10; k++) {
        $(".sale-row-0 a:nth-child(" + k + ") img").attr('src', nextImgs[k]);
        $(".sale-row-0 a:nth-child(" + k + ") #sale-book-name").text(nextNames[k]);
        $(".sale-row-0 a:nth-child(" + k + ") #sale-discount-rate").text(nextAuthors[k]);
      }
      $(".sale-row-0 a:nth-child(10) img").attr('src', nextImgs[1]);
      $(".sale-row-0 a:nth-child(10) #sale-book-name").text(nextNames[1]);
      $(".sale-row-0 a:nth-child(10) #sale-discount-rate").text(nextAuthors[1]);
      $(this).css('right', '0px');
    });
  }

  function reversSlide() {
    $(".sale-row-1").animate({ 'right': '-130px' }, 5000, "linear", function () {
      let prevImgs = [];
      let prevNames = [];
      let prevAuthors = [];
      for (var i=1; i<10; i++){
        prevImgs[i] =  $(".sale-row-1 a:nth-child(" + ((i + 7) % 9 + 1) + ") img").attr('src');
        prevNames[i] =  $(".sale-row-1 a:nth-child(" + ((i + 7) % 9 + 1) + ") #sale-book-name").text();
        prevAuthors[i] =  $(".sale-row-1 a:nth-child(" + ((i + 7) % 9 + 1) + ") #sale-discount-rate").text();
      }
      for (var k = 1; k < 10; k++) {
        $(".sale-row-1 a:nth-child(" + k + ") img").attr('src', prevImgs[k]);
        $(".sale-row-1 a:nth-child(" + k + ") #sale-book-name").text(prevNames[k]);
        $(".sale-row-1 a:nth-child(" + k + ") #sale-discount-rate").text(prevAuthors[k]);
      }
      $(".sale-row-1 a:nth-child(10) img").attr('src', prevImgs[1]);
      $(".sale-row-1 a:nth-child(10) #sale-book-name").text(prevNames[1]);
      $(".sale-row-1 a:nth-child(10) #sale-discount-rate").text(prevAuthors[1]);
      $(this).css('right', '0px');
    });
  }

  slide(); reversSlide();
  let saleInterval = [setInterval(slide, 5000), setInterval(reversSlide, 5000)];


  $("#search-input").keyup(function(key){
    if (key.keyCode == 13) {
      $("#search-form").submit();
    } else {
      bookSearch();
    }
  });

  $(".search-input .reset").click(function () {
    $(this).parent().find('input').val('');
    $(".search-result-category").remove();
    $(".search-result-book").remove();
    $(".search-result-outer-wrapper").hide();
  });

  function bookSearch() {
    $.ajax({                                                    
      url: "/event-sale",
      type: "get",
      data: $("#search-form").serialize(),
      dataType: "html",
      async: true,
    }).done(function (data) {
      $('#search-input-results').replaceWith(data);
      if(data.length < 100) {
        $(".search-result-outer-wrapper").hide();
      } else {
        $(".search-result-outer-wrapper").show();
      }
    });
  }

});


$(function () {
  let date = new Date();
  y = date.getFullYear();
  m = date.getMonth();
  let currentDay = date.getDate();
  let lastDay = new Date(y, m + 1, 0).getDate();
  let checked = false;
  let count = 0;

  for (var i = 28; i < 36; i++) {
    if (i <= lastDay) {
      $(".check-day" + i).css('display', '');
    } else {
      $(".check-day" + i).css('display', 'none');
    }
  }

  const checkImg = "/img/icon/patch-check-fill.svg";

  $(window).scroll(function () {
    if (!checked && $(this).scrollTop() > 2900) {
      $(".check-day" + currentDay).css({
        'height': '100%',
        'position': 'absolute',
        'color': 'rgba(0,0,0,0)'
      });
      $("#check-day" + currentDay + "-wrapper").css({
        'top': '30px',
        'backgroundImage': 'url(' + checkImg + ')',
        'backgroundPosition': 'center',
        'backgroundRepeat': 'no-repeat',
        'backgroundSize': 'contain',
        'animation': 'jello-horizontal 0.9s both',
        'opacity': '0.4'
      });
      count++;
      setTimeout(function () {
        $(".check-fill-end").animate({
          'left': 147.5 + 494.5 / lastDay * count + 'px'
        }, 500).css('animation', 'border-color-change 1s');
        $(".check-fill").animate({
          'left': -100 + 100 / lastDay * count + '%'
        }, 500).css('animation', 'background-color-change linear 1s');
        $(".check-box-top-current").text(count + '일').css(
          'animation', 'jello-horizontal 0.9s both'
        );
      }, 500);

      checked = true;
    }
  });

});




