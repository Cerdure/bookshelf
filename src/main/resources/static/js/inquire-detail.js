
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

 $(".top-back-title:nth-child(1)").show();

 $(document).ready(function (){
     $(document).on("change","#modify-wrapper .inquire-write-photo-input", function(event){
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
                     document.querySelector("#modify-wrapper .inquire-write-attach-photo").appendChild(div).appendChild(img);
                 }
                 reader.readAsDataURL(image);
                 imgChange();
             }
         } else if (event.target.files.length > 5) {
             alert('이미지는 최대 5장까지 업로드 가능합니다.');
             attchReset();
         }
     });

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
         let parent = $(this).closest(".my-comment");
         let parentId = parent.find("#replyId").val();
         let parentNickname = parent.find(".name").text();
         let parentChildNum = Number(parent.find("#childNum").val());
         let form = document.createElement("form");
         form.setAttribute('class','inner-comment');
         form.innerHTML =
             '<input id="parentId" type="hidden" value="'+ parentId +'">' +
             '<input id="commentSeq" type="hidden" value="'+ (Number(parent.find("#replySeq").val())+parentChildNum+1) +'">' +
             '<input id="commentLevel" type="hidden" value="'+ (Number(parent.find("#replyLevel").val())+1) +'">' +
             '<img src="/img/icon/arrow-return-right.svg">' +
             '<strong>@'+parentNickname+'</strong>'+
             '<textarea class="comment" name="content" maxlength="300" onkeydown="resize(this)" ' +
             'onkeyup="resize(this)" onclick="commentClick(this)" onfocusout="commentFocusout(this)" ' +
             'placeholder="내용을 입력해주세요."></textarea>'+
             '<div class="comment-underline"></div>' +
             '<div class="comment-button-save" value="save" onclick="replySave(this)">등록</div>' +
             '<div class="comment-button-cancel" onclick="myCommentCancel(this)">취소</div>';
         $(this).closest('.my-comment').append(form);
     });


 });

    $('html').click(function(e) {
        if(!$(e.target).is(".opt-btn, .box, .edit, .remove, .reply")) {
            $(".box").fadeOut(0);
            $(".clicked").removeClass("clicked");
        }
    });




});

  function replySave(_this){
          let data = {
              content: $(_this).parent().find(".comment").val(),
              seq: $(_this).parent().find("#commentSeq").val(),
              level:$(_this).parent().find("#commentLevel").val(),
              parentNickname: $(_this).parent().find("strong").text()
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
              $('.comment-wrapper').replaceWith(replies);
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

   function commentFocusout(_this){
    $(_this).parent().find(".comment-underline").stop().animate({'width':'0%'},100,'easeInOutQuad');
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

function deleteAlert(_inquireId) {
    inquireId = _inquireId;
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
        }
    });
}

let inquireId;
let inquirePw;

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

