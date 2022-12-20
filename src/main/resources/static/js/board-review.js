
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

$(function() {
  let width = $(".top-back-wrapper").width();
  $(".top-background").css('background-size', width + 'px');


  $(window).resize(function () {
    let width = $(".top-back-wrapper").width();
    $(".top-background").css('background-size', width + 'px');
  });

  $(".top-back-title").show();
  $(".middle-nav-underbar").css('left', '0%');

  

  let reviews = $(".my-review .body").toArray();

  reviews.forEach(e => e.querySelector(".review").offsetHeight < e.querySelector("span").offsetHeight ?
      e.querySelector(".fold-button").style.display = 'block' :
      e.querySelector(".fold-button").style.display = 'none'
  );

  $(window).resize(function () {
    reviews.forEach(e => e.querySelector(".review").offsetHeight < e.querySelector("span").offsetHeight ?
        e.querySelector(".fold-button").style.display = 'block' :
        e.querySelector(".fold-button").style.display = 'none'
    );
  });


  let rfbClicked = false;

  $(".my-review .fold-button").click(function () {
    if (!rfbClicked) {
      $(this).parent().find(".review").css({'overflow': 'visible', 'display': 'block'});
      $(this).find(".icon").css('transform', 'rotate(180deg)');

      rfbClicked = true;
    } else {
      $(this).parent().find(".review").css({'overflow': 'hidden', 'display': '-webkit-box'});
      $(this).find(".icon").css('transform', 'rotate(0deg)');
      rfbClicked = false;
    }
  });


  $(".photos").mouseover(function () {
    if (!phOpened)
      $(this).find(".plus").stop().fadeIn(300);
  }).mouseleave(function () {
    if (!phOpened)
      $(this).find(".plus").stop().fadeOut(300);
  });

  let phOpened = false;
  $(".photos").click(function () {
    if (!phOpened) {
      $(this).fadeOut(10, function () {
        $(this).css({
          'position': 'fixed',
          'top': '50%',
          'right': 'auto',
          'left': '50%',
          'width': '600px',
          'height': '400px',
          'transform': 'translate(-50%,-50%)',
          'background-size': 'contain',
          'z-index': '11'
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
          'bottom': '-30px',
          'right': 'auto',
          'left': '50%',
          'transform': 'translateX(-50%)',
          'width': 'auto',
          'height': 'auto',
          'background-color': 'rgba(0, 0, 0, 0)',
          'font-size': '25px',
          'line-height': '25px',
          'filter': 'drop-shadow(black 0px 0px 2px)',
          'text-shadow': '0px 0px 2px black'
        });
        $(this).show(300);
        phOpened = true;
      });
    }
  });

  $(".photos .close").click(function () {
    let photos = $(this).parent();
    photos.hide(100, function () {
      photos.css({
        'position': 'absolute',
        'top': '0',
        'right': '0',
        'left': 'auto',
        'transform': 'auto',
        'width': '64px',
        'height': '64px',
        'transform': 'none',
        'background-size': 'cover',
        'z-index': '0',
        'background-image': 'url(' + photos.children("img").eq(0).attr('src') + ')'
      });
      $(this).find(".close").hide();
      $(this).find(".btn-left").hide();
      $(this).find(".btn-right").hide();
      $(this).find(".number").text('+' + ($(this).find("img").toArray().length - 1));
      $(this).find(".number").css({
        'bottom': '0',
        'right': '0',
        'left': 'auto',
        'transform': 'none',
        'width': '20px',
        'height': '15px',
        'background-color': 'rgba(0, 0, 0, 0.6)',
        'font-size': '11px',
        'line-height': '15px',
        'filter': 'none',
        'text-shadow': 'none'
      });
      phCurrentIndex = 1;
      photos.fadeIn(300, function () {
        phOpened = false;
      });
    });
  });

  let phCurrentIndex = 1;
  $(".photos .btn-left").click(function () {
    let photos = $(this).parent();
    let maxIndex = photos.find("img").toArray().length;
    if (phCurrentIndex != 1) {
      photos.fadeOut(100, function () {
        phCurrentIndex--;
        photos.css({
          'background-image': 'url(' + photos.children().eq(phCurrentIndex).attr('src') + ')'
        });
        photos.find(".number").text(phCurrentIndex + " / " + maxIndex);
      });
      photos.fadeIn(300);
    }
  });
  $(".photos .btn-right").click(function () {
    let photos = $(this).parent();
    let maxIndex = photos.find("img").toArray().length;
    if (phCurrentIndex != maxIndex) {
      photos.fadeOut(100, function () {
        phCurrentIndex++;
        photos.css({
          'background-image': 'url(' + photos.children().eq(phCurrentIndex).attr('src') + ')'
        });
        photos.find(".number").text(phCurrentIndex + " / " + maxIndex);
      });
      photos.fadeIn(300);
    }
  });


  $(document).ready(function () {
    $(document).on("click", ".search-result .select", function () {
      let bookId = $(this).parent().find(".book-id").val();
      let bookImg = $(this).parent().find("img").attr('src');
      let bookName = $(this).parent().find(".name").text();
      $(".review-book-id").val(bookId);
      $(".review-book-img").attr('src', bookImg);
      $(".review-book-name").text(bookName);
      $(".review-write-book-wrapper").show();
      $(".review-write-search-wrapper").hide();
      swOpened = false;
      $(".review-write-find").animate({'backgroundColor': 'lightgray'}, 500);
      $(".review-write-find-text").text('상품 재검색');
    });
    $(document).on("change", "#sortOrder", function () {
      bookSearch();
    });
    $(document).on("click", ".search-controller .controller-btn-left", function () {
      let page = Number($(".search-controller .index-active").text()) - 1;
      bookSearch(page);
    });
    $(document).on("click", ".search-controller .controller-btn-right", function () {
      let page = Number($(".search-controller .index-active").text()) + 1;
      bookSearch(page);
    });
    $(document).on("click", ".search-controller #idx", function () {
      let page = $(this).text();
      bookSearch(page);
    });
    $(document).on("click", ".review-title-write", function () {
      $(".write-wrapper-back").addClass("modal-background");
      $(".review-write-wrapper").fadeIn(200);
      $("body").css('overflow-y', 'hidden');
      rwOpened = true;
    });

      let reviews = $(".my-review .body").toArray();

      reviews.forEach(e => e.querySelector(".review").offsetHeight < e.querySelector("span").offsetHeight ?
          e.querySelector(".fold-button").style.display = 'block' :
          e.querySelector(".fold-button").style.display = 'none'
      );

      $(document).on("resize", window, function () {
        reviews.forEach(e => e.querySelector(".review").offsetHeight < e.querySelector("span").offsetHeight ?
            e.querySelector(".fold-button").style.display = 'block' :
            e.querySelector(".fold-button").style.display = 'none'
        );
      });

    $(document).on("mouseover", "form .star-empty img", function () {
      let index = $(this).index();
      $(this).closest(".review-book-rating").find(".star-fill").stop().animate({ 'width': 34.5 * (index + 1) + 'px' }, 300);
      $(this).closest(".review-book-info").find(".rating-number").text(index + 1);
    });
    $(document).on("click", "form .star-empty img", function () {
      $(this).closest(".review-book-info").find(".rating-number-input").val($(this).index()+1);
      bookPassed = true;
      registCheck(tagPassed, reviewPassed, bookPassed);
    })
    $(document).on("mouseleave", "form .star-empty img", function () {
      let clickidx = $(this).closest(".review-book-info").find(".rating-number-input").val();
      $(this).closest(".review-book-rating").find(".star-fill").stop().animate({ 'width': 34.5 * clickidx + 'px' }, 300);
      $(this).closest(".review-book-info").find(".rating-number").text(clickidx);
    });
    $(document).on("click",".review-write-tag .tag", function () {
      $(".review-write-tag .tag").removeClass("tag-active");
      $(this).addClass("tag-active");
      $(".review-write-tag-input").val($(this).text());
      tagPassed = true;
      registCheck(tagPassed, reviewPassed, bookPassed);
    });
    $(document).on("keyup", "form textarea", function () {
      let reviewVal = $(this).val();
      $(".write-number").text(reviewVal.length + "/3000");
      if (reviewVal.length > 9) {
        reviewPassed = true;
      } else {
        reviewPassed = false;
      }
      registCheck(tagPassed, reviewPassed, bookPassed);
    });
    $(document).on("click",".review-write-top-icon", function () {
      $("form").css('filter', 'brightness(0.5)');
      $(".close-alert").show();
    });
    $(document).on("change","#modify-wrapper .review-write-photo-input", function(event){
        if (event.target.files.length > 0 && event.target.files.length < 6) {
          imgCount = 0;
          let imgs = document.querySelectorAll(".review-write-photo-wrapper");
          if( imgs != null){imgs.forEach(e => e.remove());} 
    
          for (var image of event.target.files) {
            imgCount++;
              let reader = new FileReader();
              reader.onload = function (event) {
                let div = document.createElement("div");
                div.setAttribute('class', 'review-write-photo-wrapper');
                div.innerHTML = '<div class="review-write-photo-cancel" onclick="deleteImg(this)">X</div>';
                let img = document.createElement("input");
                img.setAttribute("style", "background-image: url(" + event.target.result + ")");
                img.setAttribute("type", "file");
                img.setAttribute("class", "review-write-photo");
                img.setAttribute("disabled", true);
                document.querySelector("#modify-wrapper .review-write-attach-photo").appendChild(div).appendChild(img);
              }
              reader.readAsDataURL(image);
              imgChange();
          }
        } else if (event.target.files.length > 5) {
          alert('이미지는 최대 5장까지 업로드 가능합니다.');
          attchReset();
      }
    });
    });       // doc---------------------------------------------------


  

    function bookSearch(_page) {
      let data = {
        name: $("#search-input").val(),
        sortOrder: $('#sortOrder option:selected').val()
      };
      $.ajax({
        url: "/review/book-search?page=" + _page,
        type: "get",
        data: data,
        dataType: "html",
        async: true,
        error: function (xhr, status, error) {
          console.log(error);
        }
      }).done(function (books) {
        $('#search-results').replaceWith(books);
        $('.search-result-info .input-value').text("'" + data.name + "'");
        $("#sortOrder").val(data.sortOrder).prop("selected", true);
      });
    }

    $(".review-write-find").click(function () {
      $(".review-write-search-wrapper").fadeIn(200);
      swOpened = true;
    });

    $("#search-input").keyup(function (key) {
      if (key.keyCode == 13) {
        bookSearch(0);
      }
    });
    $("#search-icon").click(function () {
      bookSearch(0);
    });


    $(".search-title img").click(function () {
      $(".review-write-search-wrapper").hide();
      swOpened = false;
    });


    window.onkeyup = function (e) {
      var key = e.keyCode ? e.keyCode : e.which;
      if (swOpened && key == 27) {
        $(".review-write-search-wrapper").hide();
        swOpened = false;
      } else if (rwOpened && key == 27) {
        $(".review-write-wrapper").css('filter', 'brightness(0.5)');
        $(".close-alert").show();
      }
    }


    $(".my-review .modify").click(function(){
      let mdReviewId = $(this).closest(".my-review").find("#review-id").val();
      console.log(mdReviewId);
      $.ajax({
        url: "/review/"+mdReviewId,
        type: "get",
        dataType: "html",
        error: function (xhr, status, error) {
          console.log(error);
        }
      }).done(function(review){
        $('#modify-wrapper').replaceWith(review);
        $(".review-modify-wrapper").attr("action", "/review-modify/"+mdReviewId);
        setInterval(function(){
          $('#modify-wrapper').fadeIn(300);
        },100); 
        $(".review-title-write").css('pointer-events','none');
      });
    });


    $(".my-review .delete").click(function(){
      let mdReviewId = $(this).closest(".my-review").find("#review-id").val();
      deleteAlert(mdReviewId);
    });

  });

  let starClickIndex = -1;
  let bookPassed = false;
  let tagPassed = false;
  let reviewPassed = false;
  let swOpened = false;
  let rwOpened = false;
  let imgCount = 0;

  function imgChange() {
    if (imgCount == 5) {
      $(".review-write-attach-photo-button").hide();
    } else {
      $(".review-write-attach-photo-button").show();
    }
    $(".review-write-attach-title span:last-child").text(imgCount + '/5');
  }

  function setThumbnail(event) {
    if (event.target.files.length > 0 && event.target.files.length < 6) {
      imgCount = 0;
      let imgs = document.querySelectorAll(".review-write-photo-wrapper");
      if( imgs != null){imgs.forEach(e => e.remove());} 

      for (var image of event.target.files) {
        imgCount++;
          let reader = new FileReader();
          reader.onload = function (event) {
            let div = document.createElement("div");
            div.setAttribute('class', 'review-write-photo-wrapper');
            div.innerHTML = '<div class="review-write-photo-cancel" onclick="deleteImg(this)">X</div>';
            let img = document.createElement("input");
            img.setAttribute("style", "background-image: url(" + event.target.result + ")");
            img.setAttribute("type", "file");
            img.setAttribute("class", "review-write-photo");
            img.setAttribute("disabled", true);
            document.querySelector(".review-write-attach-photo").appendChild(div).appendChild(img);
          }
          reader.readAsDataURL(image);
          imgChange();
      }
    } else if (event.target.files.length > 5) {
      alert('이미지는 최대 5장까지 업로드 가능합니다.');
      attchReset();
    }
  }

  function attchReset() {
    imgCount = 0;
    let imgs = document.querySelectorAll(".review-write-photo-wrapper");
    if( imgs != null){imgs.forEach(e => e.remove());} 

    let parent = document.querySelector(".review-write-attach-photo-button");
    document.querySelector(".review-write-photo-input").remove();  

    parent.innerHTML = '<input name="imageFiles" class="review-write-photo-input" type="file" multiple="multiple" accept=".jpg, .jpeg, .png, .gif" onchange="setThumbnail(event, this)"></input>';
  }

  function deleteImg(_this) {
    $(_this).parent().remove();
    imgCount--;
    imgChange();
  }

  function formClose(_this) {
    $(".write-wrapper-back").removeClass("modal-background");
    $("#modify-wrapper .modal-background").hide();
    $("form").hide();
    $("body").css('overflow-y', 'scroll');
    $(".review-write-book-wrapper").hide();
    $("form").css('filter', 'brightness(100%)');
    $(".review-write-find-text").text("상품 검색");
    $(".review-book-id").val('');
    $(".review-book-rating .star-fill").stop().css('width', '0px');
    $(".review-book-rating-number .rating-number-input").val(0);
    $(".review-book-rating-number .rating-number").text(0);
    $(".review-write-tag .tag").removeClass("tag-active");
    $(".review-write-tag-input").val('');
    $("form textarea").val('');
    $(".write-number").text('0/3000');
    $(".review-write-photo-wrapper").remove();
    $(".review-write-attach-photo-button").show();
    $(".regist-button").addClass("disable");
    $(".review-title-write").css('pointer-events','all');
    bookPassed = false;
    tagPassed = false;
    reviewPassed = false;
    rwOpened = false;
    imgCount = 0;
    starClickIndex = -1;
    hideCloseAlert(_this)
  }


  function hideCloseAlert(_this) {
    $("form").css('filter', 'brightness(100%)');
    $(_this).parent().hide();
  }

  function hideDeleteAlert(_this) {
    $(".write-wrapper-back").removeClass("modal-background");
    $(_this).parent().hide();
  }

  function registCheck(...passed) {
    if (passed.every(e => {return e;})) {
      $(".regist-button").removeClass("disable");
    } else {
      $(".regist-button").addClass("disable");
    }
  }



  function deleteAlert(_reviewId) {
    console.log("deleteAlert " + reviewId);
    reviewId = _reviewId;
    $(".write-wrapper-back").addClass("modal-background");
    $(".delete-alert").show();
  }
  let reviewId;

  function reviewDelete() {
    $.ajax({
      url: "/review-delete/"+reviewId,
      type: "post",
      error: function (xhr, status, error) {
        console.log(error);
      }
    }).done(function(result){
      document.location.replace("/review");
    });
  }
