
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

 $(".top-back-title:nth-child(1)").show();


 $(document).ready(function (){
     $(document).on("mouseover", ".my-comment",function (){
         $(".option img:not(.clicked)").stop().fadeOut(100);
         $(this).find(".option img").stop().fadeIn(300);
     });
     $(document).on("mouseleave", ".my-comment",function (){
         $(".option img:not(.clicked)").stop().fadeOut(100);
     });
     $(document).on("click", ".opt-btn",function (){
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
     $(document).on("click", ".reply", function (){
         $(".box").fadeOut(0);
         $(".inner-comment").remove();
         let parent = $(this).closest(".my-comment");
         let parentId = parent.find("#replyId").val();
         let form = document.createElement("form");
         form.setAttribute('class','inner-comment');
         form.innerHTML =
             '<input id="parentId" type="hidden" value="'+ parentId +'">' +
             '<img src="/img/icon/arrow-return-right.svg">' +
             '<textarea class="comment" name="content" maxlength="300" onkeydown="resize(this)" ' +
             'onkeyup="resize(this)" onclick="commentClick(this)" onfocusout="commentFocusout(this)" ' +
             'placeholder="내용을 입력해주세요."></textarea>'+
             '<div class="comment-underline"></div>' +
             '<div class="comment-button-save" value="save" onclick="replySave(this)">등록</div>' +
             '<div class="comment-button-cancel" onclick="myCommentCancel(this)">취소</div>';
         $(this).closest('.my-comment').append(form);
     });

     $(document).on("click", ".my-comment .edit", function () {
         $(this).closest(".my-comment").find(".option").hide();
         let origin = $(this).closest(".my-comment").find(".body"); //+origin.text().length
         if(origin.find("strong")==null){
             commentBodyText = origin.text();
         } else {
             commentBodyText = origin.text().substring(origin.text().indexOf(" ")+1, origin.text().length);
         }
         origin.text('');
         let form = document.createElement("form");
         form.setAttribute('class','inner-comment');
         form.innerHTML =
             '<textarea class="mod-comment" name="content" maxlength="300" onkeydown="resize(this)" ' +
             'onkeyup="resize(this)" onclick="commentClick(this)" onfocusout="commentFocusout(this)" ' +
             'placeholder="수정할 내용을 입력해주세요.">'+commentBodyText+'</textarea>'+
             '<div class="comment-underline"></div>' +
             '<div class="comment-button-save" value="save" onclick="replyModify(this)">수정</div>' +
             '<div class="comment-button-cancel" onclick="myCommentCancel(this)">취소</div>';
         $(this).closest('.my-comment').find(".body").append(form);
     });

     $(document).on("click", ".my-comment .remove", function () {
         replyId = $(this).closest(".my-comment").find("#replyId").val();
         $(".write-wrapper-back").addClass("modal-background");
         $(".reply-delete-alert").show();
     });

 });

    $('html').click(function(e) {
        if(!$(e.target).is(".opt-btn, .box, .edit, .remove, .reply")) {
            $(".box").fadeOut(0);
            $(".clicked").removeClass("clicked");
        }
    });

    $(".detail-wrapper .sub-title .edit").click(function (){
        $('#modify-wrapper').fadeIn(300);
        iwOpened = true;
    });


    $(document).on("keyup", ".inquire-input-header", function () { console.log("header")
        let val = $(this).val();
        if(val!=''){
            headerPassed = true;
        } else {
            headerPassed = false;
        }
        registCheck(headerPassed,mainPassed);
    });

    $(document).on("keyup", ".inquire-input-main", function () { console.log("main")
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
                $(".private-pw").val('');
            });
        }
    });

    $(".detail-wrapper .sub-title .remove").click(function(){
        inquireId = $('#inquireId').val();
        deleteAlert();
    });
});

    let commentBodyText;
    let inquireId;
    let inquirePw;
    let replyId;
    let headerPassed = true;
    let mainPassed = true;
    let iwOpened = false;


    function formClose(_this){
        $("#modify-wrapper").hide();
        $("body").css('overflow-y','scroll');
        $("form").css('filter','brightness(100%)');
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

  function replySave(_this){
          let data = {
              content: $(_this).parent().find(".comment").val(),
              parentId: $(_this).parent().find("#parentId").val()
          };
          $.ajax({
              url: "/reply/" + $("#inquireId").val(),
              type: "post",
              data: data,
              dataType: "html",
              async: true,
              error: function (xhr, status, error) {
                  console.log(error);
              }
          }).done(function (replies) {
              document.location.replace("/inquire-detail/"+$("#inquireId").val());
          });
  }

function replyModify(_this){
    let data = {
        replyId: $(_this).closest(".my-comment").find("#replyId").val(),
        content: $(_this).parent().find(".mod-comment").val(),
    };
    $.ajax({
        url: "/reply-modify/" + $("#inquireId").val(),
        type: "post",
        data: data,
        dataType: "html",
        async: true,
        error: function (xhr, status, error) {
            console.log(error);
        }
    }).done(function (replies) {
        document.location.replace("/inquire-detail/"+$("#inquireId").val());
    });
}

function replyDelete(_this){
    let data = {
        replyId: replyId,
    };
    $.ajax({
        url: "/reply-delete/" + $("#inquireId").val(),
        type: "post",
        data: data,
        dataType: "html",
        async: true,
        error: function (xhr, status, error) {
            console.log(error);
        }
    }).done(function (replies) {
        document.location.replace("/inquire-detail/"+$("#inquireId").val());
    });
}

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

function hideDeleteAlert(_this) {
    $(".write-wrapper-back").removeClass("modal-background");
    $(_this).parent().hide();
}

function deleteAlert() {
    $(".write-wrapper-back").addClass("modal-background");
    $(".delete-alert").show();
}

function inquireDelete() {
    $.ajax({
        url: "/inquire-delete/"+inquireId,
        type: "post",
        error: function (xhr, status, error) {
            console.log(error);
        }
    }).done(function(result){
        document.location.replace("/inquire");
    });
}


function inquireDetail(_this){
    inquireId =  $(_this).parent().find(".inquireId").val();
      if(closed!=1){
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
              }
          });
      } else {
          $(".write-wrapper-back").addClass("modal-background");
          $(".pw-input").fadeIn(300);
      }
}


function pwCheck(_this){
    console.log("pwCheck pw="+inquirePw);
    console.log("pwCheck id="+inquireId);
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