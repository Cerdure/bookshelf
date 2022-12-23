
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


$(function(){
  let width = $(".top-back-wrapper").width();
  $(".top-background").css('background-size',width+'px');


$(window).resize(function(){
  let width = $(".top-back-wrapper").width();
  $(".top-background").css('background-size',width+'px');
});

  $(".top-back-title").show();
  $(".middle-nav-underbar").css('left','25%');







  $(document).ready(function () {
    // $(document).on("change", "#sortOrder", function () {
    //   bookSearch();
    // });
    $(document).on("click", ".inquire-write", function () {
      $(".write-wrapper-back").addClass("modal-background");
      $(".inquire-write-wrapper").fadeIn(200);
      $("body").css('overflow-y', 'hidden');
      iwOpened = true;
    });

    $(document).on("keyup", ".inquire-input-header", function () {
      let val = $(this).val();
      if(val!=''){
        headerPassed = true;
      } else {
        headerPassed = false;
      }
      registCheck(headerPassed,mainPassed);
    });

      $(document).on("keyup", ".inquire-input-main", function () {
        let val = $(this).val();
        $(".write-number").text(val.length+"/3000");
        if(val.length>9){
          mainPassed = true;
        } else {
          mainPassed = false;
        }
        registCheck(headerPassed,mainPassed);
    });

    $(document).on("click",".inquire-write-top-icon", function () {
      $("form").css('filter', 'brightness(0.5)');
      $(".close-alert").show();
    });



    $(document).on("click", ".private-check", function(){
      if($(this).is(':checked')){
        $(".private-pw").stop().show();
        $(".private-pw").stop().animate({'width':'200px'},300);
      } else {
        $(".private-pw").stop().animate({'width':'0px'},300,function(){
          $(".private-pw").stop().hide();
        });
      }
    });

    $(document).on("click",".my-inquire-search", function () {
      document.location.replace("/inquire-my");
    });
  });       // doc---------------------------------------------------



$(".pw-input input").keyup(function (key){
  if(key.keyCode==13) {
    pwCheck(this);
  }
});

 


});

  let headerPassed = false;
  let mainPassed = false;
  let iwOpened = false;
  let imgCount = 0;

function imgChange() {
  if (imgCount == 5) {
    $(".inquire-write-attach-photo-button").hide();
  } else {
    $(".inquire-write-attach-photo-button").show();
  }
  $(".inquire-write-attach-title span:last-child").text(imgCount + '/5');
}

function setThumbnail(event) {
  if (event.target.files.length > 0 && event.target.files.length < 6) {
    imgCount = 0;
    let imgs = document.querySelectorAll(".inquire-write-photo-wrapper");
    if( imgs != null){imgs.forEach(e => e.remove());}

    for (var image of event.target.files) {
      imgCount++;
      let reader = new FileReader();
      reader.onload = function (event) {
        let div = document.createElement("div");
        div.setAttribute('class', 'inquire-write-photo-wrapper');
        div.innerHTML = '<div class="inquire-write-photo-cancel" onclick="deleteImg(this)">X</div>';
        let img = document.createElement("input");
        img.setAttribute("style", "background-image: url(" + event.target.result + ")");
        img.setAttribute("type", "file");
        img.setAttribute("class", "inquire-write-photo");
        img.setAttribute("disabled", true);
        document.querySelector(".inquire-write-attach-photo").appendChild(div).appendChild(img);
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
  let imgs = document.querySelectorAll(".inquire-write-photo-wrapper");
  if( imgs != null){imgs.forEach(e => e.remove());}

  let parent = document.querySelector(".inquire-write-attach-photo-button");
  document.querySelector(".inquire-write-photo-input").remove();

  parent.innerHTML = '<input name="imageFiles" class="inquire-write-photo-input" type="file" multiple="multiple" accept=".jpg, .jpeg, .png, .gif" onchange="setThumbnail(event, this)"></input>';
}

function deleteImg(_this) {
  $(_this).parent().remove();
  imgCount--;
  imgChange();
}

  function formClose(_this){
    $(".write-wrapper-back").removeClass("modal-background");
    $("form").hide();
    $("body").css('overflow-y','scroll');
    $("form").css('filter','brightness(100%)');
    $("form textarea").val('');
    $(".write-number").text('0/3000');
    $(".inquire-write-photo-wrapper").remove();
    $(".inquire-write-attach-photo-button").show();
    $(".private-check").prop("checked", false);
    $(".private-pw").val('');
    $(".regist-button").addClass("disable");
    $(".inquire-write").css('pointer-events','all');
    headerPassed = false;
    mainPassed = false;
    iwOpened = false;
    hideAlert(_this)
  }

  function registCheck(...passed){
    if(passed.every(e => {return e;})) {
      $(".regist-button").removeClass("disable");
    } else {
      $(".regist-button").addClass("disable");
    }
  }

// ${inquire.closed==1?'pwInput('+inquire.pw+','+inquire.id+')':'location.href=/inquire?id='+inquire.id}

  function inquireDetail(_this){
  inquireId =  $(_this).parent().find("#inquireId").val();
    $.ajax({
      url: "/inquire-closedCheck/"+inquireId,
      type: "get",
      data_type: "text",
      error: function (xhr, status, error) {
        console.log(error);
      }
    }).done(function(result){
      if(result == null || result == ''){
        console.log("not Closed");
      } else {
        console.log(result);
        inquirePw = result;
        $(".write-wrapper-back").addClass("modal-background");
        $(".pw-input").fadeIn(300);
        $(".pw-input input").focus();
      }
    });
  }

  let inquireId;
  let inquirePw;

  function pwCheck(_this){
    if($(_this).parent().find("input").val()==inquirePw){
      document.location.replace("/inquire-detail/"+inquireId);
    } else {
      $(".pw-input input").css('border','1px solid #ff3873');
    }
  }

function hideAlert(_this) {
  $(".write-wrapper-back").removeClass("modal-background");
  $("form").css('filter', 'brightness(100%)');
  $(_this).parent().hide();
}

