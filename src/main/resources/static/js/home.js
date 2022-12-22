$(function () {
  let st = $(window).scrollTop();
  let width = $(window).width();
  let index = 0;
  let gradientIndex = 0;
  let interval;
  let ubClickindex = 0;
  let obClickindex = 0;

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


    if (width < 1000 && st > 100) {
      $(".top-nav-background").css('animation', 'fadein 0.5s both');
    } else if (width < 1000 && st < 101) {
      $(".top-nav-background").css('animation', 'fadeout 0.5s both');
    }
  $(window)
    .scroll(function () {
      st = $(this).scrollTop();
      width = $(this).width();
      if (width < 1000 && st > 100) {
        $(".top-nav-background").css('animation', 'fadein 0.5s both');
      } else if (width < 1000 && st < 101) {
        $(".top-nav-background").css('animation', 'fadeout 0.5s both');
      }
    })
    .resize(function () {
      st = $(this).scrollTop();
      width = $(this).width();
      if (width > 999) {
        $(".top-nav-background").css('animation', 'fadein 0.5s both');
      } else if (width < 1000 && st < 101) {
        $(".top-nav-background").css('animation', 'fadeout 0.5s both');
      }
    });


  $(".banner-font-wrapper li h1").each(function () {
    $(this).css('opacity', "0%");
  });
  $(".banner-font-wrapper li h4").each(function () {
    $(this).css('opacity', "0%");
  });
  $(".banner-img-wrapper img").each(function () {
    $(this).css('opacity', "0%");
  });
  $(".bf-big-" + index).css('animation', "slidein 0.5s both");
  $(".bf-small-" + index).css('animation', "slidein 1s both");
  $(".banner-img-" + index).css('animation', "slidein 1s both");

  function startInterval() {
    return setInterval(function () {
      gradientIndex++;
      index++;
      index %= 6;
      $(".bf-big-" + (index + 5) % 6).css('animation', 'none');
      $(".bf-small-" + (index + 5) % 6).css('animation', 'none');
      $(".banner-img-" + (index + 5) % 6).css('animation', 'none');
      $(".bf-big-" + index).css('animation', "slidein 0.5s both");
      $(".bf-small-" + index).css('animation', "slidein 1s both");
      $(".banner-img-" + index).css('animation', "slidein 1s both");
      $(".banner-wrapper").animate({ backgroundPosition: 20 * gradientIndex + "%" }, 1000);
      $(".banner-current-index").text(index + 1);
      $(".banner-index-fill").animate({ 'left': (-55 + index * 11) + 'px' }, 500);
    }, 3000);
  }
  interval = startInterval();

  $(".btn-right").click(function () {
    clearInterval(interval);
    interval = startInterval();
    gradientIndex++;
    index++;
    index %= 6;
    $(".bf-big-" + (index + 5) % 6).css('animation', 'none');
    $(".bf-small-" + (index + 5) % 6).css('animation', 'none');
    $(".banner-img-" + (index + 5) % 6).css('animation', 'none');
    $(".bf-big-" + index).css('animation', "slidein 0.5s both");
    $(".bf-small-" + index).css('animation', "slidein 1s both");
    $(".banner-img-" + index).css('animation', "slidein 1s both");
    $(".banner-wrapper").animate({ backgroundPosition: 20 * gradientIndex + "%" }, 1000);
    $(".banner-current-index").text(index + 1);
    $(".banner-index-fill").animate({ 'left': (-55 + index * 11) + 'px' }, 500);
  });
  $(".btn-left").click(function () {
    clearInterval(interval);
    interval = startInterval();
    gradientIndex--;
    index += 5;
    index %= 6;
    $(".bf-big-" + (index + 1) % 6).css('animation', 'none');
    $(".bf-small-" + (index + 1) % 6).css('animation', 'none');
    $(".banner-img-" + (index + 1) % 6).css('animation', 'none');
    $(".bf-big-" + index).css('animation', "slidein 0.5s both");
    $(".bf-small-" + index).css('animation', "slidein 1s both");
    $(".banner-img-" + index).css('animation', "slidein 1s both");
    $(".banner-wrapper").animate({ backgroundPosition: 20 * gradientIndex + "%" }, 1000);
    $(".banner-current-index").text(index + 1);
    $(".banner-index-fill").animate({ 'left': (-55 + index * 11) + 'px' }, 500);
  });

  $(".banner-stop").click(function () {
    clearInterval(interval);
    $(this).fadeOut(100);
    $(".banner-play").fadeIn(200);
  });
  $(".banner-play").click(function () {
    interval = startInterval();
    $(this).fadeOut(100);
    $(".banner-stop").fadeIn(200);
  });



  function bookSearch() {
    $.ajax({                                                      //한글이라 오류남?
      url: "/home-search-input",
      type: "get",
      data: $("#search-form").serialize(),
      dataType: "html",
      async: true,
    }).done(function (data) {
      $('#search-input-results').replaceWith(data);
    });
  }

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
  });

  $(document).ready(function (){

    $(document).on("click","#category-box",function (){
       $("#category-id-input").val($(this).find("#category-id").val());
        $("#search-form").submit();
    });

    $(document).on("keyup ready", ".simple-search input", function () {
        if($(".search-result-outer-wrapper").height() < 5) {
          $(".search-result-outer-wrapper").hide();
        } else {
          $(".search-result-outer-wrapper").show();
        }
    });

  });



  let tbArr1 = new Array(5);
  for (var i = 1; i < 6; i++) {
    let randNum = Math.floor(Math.random() * 62 + 1);
    while (tbArr1.indexOf(randNum) != -1) randNum = Math.floor(Math.random() * 62 + 1);
    tbArr1.push(randNum);
    $(".today-book-img-" + i).attr('src', "/img/book-cover/" + randNum + ".jpg");
    $(".today-book-name-" + i).text("책이름" + randNum);
    $(".today-book-author-" + i).text("작가" + randNum);
  }
  let todayBookimg1 = $(".today-book-img-1").attr('src');
  $(".today-book-background-1").css("background-image", "url(" + todayBookimg1 + ")");
  let todayBookimg2 = $(".today-book-img-2").attr('src');
  $(".today-book-background-2").css("background-image", "url(" + todayBookimg2 + ")");
  let todayBookimg3 = $(".today-book-img-3").attr('src');
  $(".today-book-background-3").css("background-image", "url(" + todayBookimg3 + ")");
  let todayBookimg4 = $(".today-book-img-4").attr('src');
  $(".today-book-background-4").css("background-image", "url(" + todayBookimg4 + ")");
  let todayBookimg5 = $(".today-book-img-5").attr('src');
  $(".today-book-background-5").css("background-image", "url(" + todayBookimg5 + ")");

  let tbIndex = 1;
  $(".tb-btn-left").css('animation', 'fadeout 0.3s both');
  $(".tb-btn-right").css('animation', 'fadeout 0.3s both');

  $(".tb-btn-left").click(function () {
    if (tbIndex > 1) {
      tbIndex--;
      $(".slides ul").animate({ left: -420 * (tbIndex - 1) + "px" }, 1000);
    }
  });
  $(".tb-btn-right").click(function () {
    if (tbIndex < 3) {
      $(".slides ul").animate({ left: -420 * tbIndex + "px" }, 1000);
      tbIndex++;
    }
  });

  $(".tb-button").mouseover(function () {
    if (tbIndex == 1) {
      $(".tb-btn-right").css('animation', 'fadein 0.3s both');
    } else if (tbIndex == 2) {
      $(".tb-btn-left").css('animation', 'fadein 0.3s both');
      $(".tb-btn-right").css('animation', 'fadein 0.3s both');
    } else {
      $(".tb-btn-left").css('animation', 'fadein 0.3s both');
    }
  });

  $(".tb-button").mouseleave(function () {
    $(".tb-btn-left").css('animation', 'fadeout 0.3s both');
    $(".tb-btn-right").css('animation', 'fadeout 0.3s both');
  });


  $(".tb-reset-box").click(function () {
    $(".slides ul li").css('display', 'none');
    let tbArr2 = new Array(5);
    for (var i = 1; i < 6; i++) {
      let randNum = Math.floor(Math.random() * 62 + 1);
      while (tbArr2.indexOf(randNum) != -1) randNum = Math.floor(Math.random() * 62 + 1);
      tbArr2.push(randNum);
      $(".today-book-img-" + i).attr('src', "/img/book-cover/" + randNum + ".jpg");
      $(".today-book-name-" + i).text("책이름" + randNum);
      $(".today-book-author-" + i).text("작가" + randNum);
    }
    let todayBookimg1 = $(".today-book-img-1").attr('src');
    $(".today-book-background-1").css("background-image", "url(" + todayBookimg1 + ")");
    let todayBookimg2 = $(".today-book-img-2").attr('src');
    $(".today-book-background-2").css("background-image", "url(" + todayBookimg2 + ")");
    let todayBookimg3 = $(".today-book-img-3").attr('src');
    $(".today-book-background-3").css("background-image", "url(" + todayBookimg3 + ")");
    let todayBookimg4 = $(".today-book-img-4").attr('src');
    $(".today-book-background-4").css("background-image", "url(" + todayBookimg4 + ")");
    let todayBookimg5 = $(".today-book-img-5").attr('src');
    $(".today-book-background-5").css("background-image", "url(" + todayBookimg5 + ")");
    $(".slides ul li").fadeIn(500);
  });


  let arr = [];
  let bestEntire = [];
  let bestDomestic = [];
  let bestForeign = [];
  let steadyEntire = [];
  let steadyDomestic = [];
  let steadyForeign = [];
  let best = true;
  let steady = false;
  let entire = true;
  let domestic = false;
  let foreign = false;

  for (var i = 0; i < 60; i++) {
    let randNum = Math.floor(Math.random() * 62 + 1);
    while (arr.indexOf(randNum) != -1) randNum = Math.floor(Math.random() * 62 + 1);
    arr.push(randNum);
    if (bestEntire.length != 10) {
      bestEntire.push(randNum);
    } else if (bestDomestic.length != 10) {
      bestDomestic.push(randNum);
    } else if (bestForeign.length != 10) {
      bestForeign.push(randNum);
    } else if (steadyEntire.length != 10) {
      steadyEntire.push(randNum);
    } else if (steadyDomestic.length != 10) {
      steadyDomestic.push(randNum);
    } else {
      steadyForeign.push(randNum);
    }
  }

  for (var j = 0; j < 10; j++) {
    $(".best-img-" + (j + 1)).attr('src', "/img/book-cover/" + bestEntire[j] + ".jpg");
  }
  $(".title-best").click(function () {
    best = true;
    steady = false;
  });
  $(".title-steady").click(function () {
    best = false;
    steady = true;
  });
  $(".title-entire").click(function () {
    entire = true;
    domestic = false;
    foreign = false;
  });
  $(".title-domestic").click(function () {
    entire = false;
    domestic = true;
    foreign = false;
  });
  $(".title-foreign").click(function () {
    entire = false;
    domestic = false;
    foreign = true;
  });

  $(".best-title-wrapper ul li").not(".best-title-center, .top-10").click(function () {
    if (best && entire) {
      $(".best-books-wrapper").css('display', 'none');
      for (var j = 0; j < 10; j++) {
        $(".best-img-" + (j + 1)).attr('src', "/img/book-cover/" + bestEntire[j] + ".jpg");
      }
      $(".best-books-wrapper").fadeIn(500);
      $(".title-best").css('color', 'black');
      $(".title-steady").css('color', 'lightgray');
      $(".title-entire").css('color', 'black');
      $(".title-domestic").css('color', 'lightgray');
      $(".title-foreign").css('color', 'lightgray');
    }
    else if (best && domestic) {
      $(".best-books-wrapper").css('display', 'none');
      for (var j = 0; j < 10; j++) {
        $(".best-img-" + (j + 1)).attr('src', "/img/book-cover/" + bestDomestic[j] + ".jpg");
      }
      $(".best-books-wrapper").fadeIn(500);
      $(".title-best").css('color', 'black');
      $(".title-steady").css('color', 'lightgray');
      $(".title-entire").css('color', 'lightgray');
      $(".title-domestic").css('color', 'black');
      $(".title-foreign").css('color', 'lightgray');
    }
    else if (best && foreign) {
      $(".best-books-wrapper").css('display', 'none');
      for (var j = 0; j < 10; j++) {
        $(".best-img-" + (j + 1)).attr('src', "/img/book-cover/" + bestForeign[j] + ".jpg");
      }
      $(".best-books-wrapper").fadeIn(500);
      $(".title-best").css('color', 'black');
      $(".title-steady").css('color', 'lightgray');
      $(".title-entire").css('color', 'lightgray');
      $(".title-domestic").css('color', 'lightgray');
      $(".title-foreign").css('color', 'black');
    }
    else if (steady && entire) {
      $(".best-books-wrapper").css('display', 'none');
      for (var j = 0; j < 10; j++) {
        $(".best-img-" + (j + 1)).attr('src', "/img/book-cover/" + steadyEntire[j] + ".jpg");
      }
      $(".best-books-wrapper").fadeIn(500);
      $(".title-best").css('color', 'lightgray');
      $(".title-steady").css('color', 'black');
      $(".title-entire").css('color', 'black');
      $(".title-domestic").css('color', 'lightgray');
      $(".title-foreign").css('color', 'lightgray');
    }
    else if (steady && domestic) {
      $(".best-books-wrapper").css('display', 'none');
      for (var j = 0; j < 10; j++) {
        $(".best-img-" + (j + 1)).attr('src', "/img/book-cover/" + steadyDomestic[j] + ".jpg");
      }
      $(".best-books-wrapper").fadeIn(500);
      $(".title-best").css('color', 'lightgray');
      $(".title-steady").css('color', 'black');
      $(".title-entire").css('color', 'lightgray');
      $(".title-domestic").css('color', 'black');
      $(".title-foreign").css('color', 'lightgray');
    }
    else if (steady && foreign) {
      $(".best-books-wrapper").css('display', 'none');
      for (var j = 0; j < 10; j++) {
        $(".best-img-" + (j + 1)).attr('src', "/img/book-cover/" + steadyForeign[j] + ".jpg");
      }
      $(".best-books-wrapper").fadeIn(500);
      $(".title-best").css('color', 'lightgray');
      $(".title-steady").css('color', 'black');
      $(".title-entire").css('color', 'lightgray');
      $(".title-domestic").css('color', 'lightgray');
      $(".title-foreign").css('color', 'black');
    }
  });

});


