
$(function () {
  let st = $(window).scrollTop();
  let ubClickindex = 4;
  let obClickindex = 4;

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



  $(document).ready(function () {
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


  });       // doc---------------------------------------------------



$(".pw-input input").keyup(function (key){
  if(key.keyCode==13) {
    pwCheck(this);
  }
});

  $("#search-input").keyup(function(key){
    if (key.keyCode == 13) {
        $('.search').submit();
    }
  });

  $(".my-inquire-search").click(function () {
    document.location.replace("/inquire-my");
  });
});



  let headerPassed = false;
  let mainPassed = false;
  let iwOpened = false;

  function formClose(_this){
    $(".write-wrapper-back").removeClass("modal-background");
    $(".inquire-write-wrapper").hide();
    $("body").css('overflow-y','scroll');
    $(".inquire-write-wrapper").css('filter','brightness(100%)');
    $(".inquire-write-wrapper textarea").val('');
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
        document.location.replace("/inquire-detail/"+inquireId);
      } else {
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

function formSubmit(_this){
  let form = $(_this).closest("form");
  let content = form.find("[name=content]");
  content.val(content.val().replace(/\n/g, "<br>"));
  form.submit();
}

