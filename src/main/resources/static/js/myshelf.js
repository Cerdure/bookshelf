
$(function () {
  let st = $(window).scrollTop();
  let ubClickindex = 3;
  let obClickindex = 3;

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


  if(st>210){
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
    $(".entire-book-title").css({
      'position':'fixed',
      'top':'115px',
      'left':'50%',
      'transform':'translateX(-50%)'
    });
    $(".entire-book-title-background").fadeIn(0);
    $(".entire-book").css('margin-top','100px');
    $(".entire-book-order-list").css('box-shadow','0px 5px 5px 0px rgba(0, 0, 0, 0.1)');
    $(".entire-book-number-list").css('box-shadow','0px 5px 5px 0px rgba(0, 0, 0, 0.1)');
    $(".record-top").css('margin-top','45px');
    $(".order-list-title-wrapper").css('margin-top','45px');
  } else {
    $(".middle-nav-wrapper").css({
      'position':'relative',
      'top':'0px',
      'border-top': '1px solid lightgray',
      'box-shadow':'0px -3px 5px 0px rgba(0, 0, 0, 0.05)'
    });
    $(".top-nav-background").css({
      'box-shadow':'0px 3px 5px 0px rgba(0, 0, 0, 0.1)'
    });
    $(".entire-book-title").css({
      'position':'relative',
      'top':'0',
      'left':'0',
      'transform':''
    });
    $(".entire-book-title-background").fadeOut(0);
    $(".entire-book").css('margin-top','0px');
    $(".entire-book-order-list").css('box-shadow','none');
    $(".entire-book-number-list").css('box-shadow','none');
    $(".record-top").css('margin-top','0px');
    $(".order-list-title-wrapper").css('margin-top','0px');
  }
  if(st>214){
    $(".order-list-title-wrapper").css({
      'position':'fixed',
      'top':'70px',
      'border-bottom':'1px solid #ebebeb',
      'height':'60px',
      'box-shadow':'0px 3px 5px 0px rgba(0,0,0,0.1)'
    });
    $(".order-list-title-inner-wrapper").css({
      'height':'60px'
    });
    $(".order-list-wrapper").css(
      'margin-top','111px'
    )
  } else {
    $(".order-list-title-wrapper").css({
      'position':'relative',
      'top':'0',
      'border-bottom':'none',
      'height':'70px',
      'box-shadow':'none'
    });
    $(".order-list-title-inner-wrapper").css({
      'height':'70px'
    });
    $(".order-list-wrapper").css(
      'margin-top','0px'
    )
  }

  $(window)
  .scroll(function(){
    st = $(this).scrollTop();
    if(st>210){
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
      $(".entire-book-title").css({
        'position':'fixed',
        'top':'115px',
        'left':'50%',
        'transform':'translateX(-50%)'
      });
      $(".entire-book-title-background").fadeIn(0);
      $(".entire-book").css('margin-top','100px');
      $(".entire-book-order-list").css('box-shadow','0px 5px 5px 0px rgba(0, 0, 0, 0.1)');
      $(".entire-book-number-list").css('box-shadow','0px 5px 5px 0px rgba(0, 0, 0, 0.1)');
      $(".record-top").css('margin-top','45px');
      $(".order-list-title-wrapper").css('margin-top','45px');
  
    } else {
      $(".middle-nav-wrapper").css({
        'position':'relative',
        'top':'0px',
        'border-top': '1px solid lightgray',
        'box-shadow':'0px -3px 5px 0px rgba(0, 0, 0, 0.05)'
      });
      $(".top-nav-background").css({
        'box-shadow':'0px 3px 5px 0px rgba(0, 0, 0, 0.1)'
      });
      $(".entire-book-title").css({
        'position':'relative',
        'top':'0',
        'left':'0',
        'transform':''
      });
      $(".entire-book-title-background").fadeOut(0);
      $(".entire-book").css('margin-top','0px');
      $(".entire-book-order-list").css('box-shadow','none');
      $(".entire-book-number-list").css('box-shadow','none');
      $(".record-top").css('margin-top','0px');
      $(".order-list-title-wrapper").css('margin-top','0px');
  
    }
    if(st>214){
      $(".order-list-title-wrapper").css({
        'position':'fixed',
        'top':'70px',
        'border-bottom':'1px solid #ebebeb',
        'height':'60px',
        'box-shadow':'0px 3px 5px 0px rgba(0,0,0,0.1)'
      });
      $(".order-list-title-inner-wrapper").css({
        'height':'60px'
      });
      $(".order-list-wrapper").css(
        'margin-top','111px'
      )
    } else {
      $(".order-list-title-wrapper").css({
        'position':'relative',
        'top':'0',
        'border-bottom':'none',
        'height':'70px',
        'box-shadow':'none'
      });
      $(".order-list-title-inner-wrapper").css({
        'height':'70px'
      });
      $(".order-list-wrapper").css(
        'margin-top','0px'
      )
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

  let ebsClicked = false;
  $(".entire-book-search img:first-child").click(entireInputIn);
  function entireInputIn() {
    if (!ebsClicked) {
      $(".entire-book-search input").animate({
        'width': '300px'
      }, 200);
      $(".entire-book-search img:first-child").css({
        'top': '48%',
        'left': '32px'
      });
      $(".entire-book-search img:nth-child(3)").css('display', 'none');
      $(".entire-book-search-text").fadeIn(300);
      ebsClicked = true;
    }
  }

  $(".entire-book-search-text").click(function () {
    $(".entire-book-search")
    if (ebsClicked) {
      $(".entire-book-search input").animate({
        'width': '0px'
      }, 200, function () {
        $(this).css('display', 'none');
        $(".entire-book-search img:first-child").css('top', '50%');
      });
      setTimeout(function () {
        $(".entire-book-search img:first-child").css('left', '0px');
      }, 150);
      $(".entire-book-search img:nth-child(3)").fadeIn(1000);
      $(".entire-book-search-text").css('display', 'none');
      ebsClicked = false;
    }
  });



  let ebnBookNum = 12;  // 책 권수(변동)
  $(".entire-book-number-text").text("전체 "+ebnBookNum+"권"); 
  let ebnClicked = false;
  let ebnCurrentIndex = 0;
  let ebnfadeinCount;
  let ebnfadeOutCount;

 $(".entire-book-number").click(function(){
  ebnfadeinCount = 1;
  ebnfadeOutCount = 4;
  if(!ebnClicked){
    $(".entire-book-number img").attr('src','/img/icon/up-arr.png')
    .css({'bottom':'3px','left':'2px','width':'9px'});
    $(".entire-book-number-text").animate({'color':'#ffbb00'},300);
    $(".entire-book-number-list").stop().animate({'height':'65px'},0, function(){
      $(".entire-book-number-list li").stop().fadeOut(0);
      $(".entire-book-number-list li").each(e => {
        if(e==ebnCurrentIndex) return;
        $(".entire-book-number-list li:nth-child("+(e+1)+")").fadeIn(200*ebnfadeinCount);
        ebnfadeinCount++;
      });
    });
    ebnClicked = true;
  } else {
    $(".entire-book-number img").attr('src','/img/icon/down-arr.png')
    .css({'bottom':'-3px','left':'0px','width':'14px'});
    $(".entire-book-number-text").animate({'color':'black'},300);

    $(".entire-book-number-list li").each(e => {
      if(e==ebnCurrentIndex) return;
      $(".entire-book-number-list li:nth-child("+(e+1)+")").stop().fadeIn(0);
    });
    $(".entire-book-number-list li").each(e => {
      $(".entire-book-number-list li:nth-child("+(e+1)+")").fadeOut(100*ebnfadeOutCount);
      ebnfadeOutCount--;
    });

    setTimeout(function(){
      $(".entire-book-number-list").stop().animate({'height':'0px'},0);
    },200);
    ebnClicked = false;
  }
 });

 $(".entire-book-number-list li").click(function(){
  ebnCurrentIndex = $(this).index();
  switch(ebnCurrentIndex) {
    case 0:
      $(".entire-book-number-text").text("전체 "+ebnBookNum+"권"); break;
    case 1:
      $(".entire-book-number-text").text("읽은 책 "+ebnBookNum+"권"); break;
    case 2:
      $(".entire-book-number-text").text("읽지 않은 책 "+ebnBookNum+"권"); break;
    case 3:
      $(".entire-book-number-text").text("다 읽은 책 "+ebnBookNum+"권"); break;
  }
 });





  let eboClicked = false;
  let eboCurrentIndex = 0;
  let eboFadeinCount;
  let eboFadeOutCount;

 $(".entire-book-order").click(function(){
  eboFadeinCount = 1;
  eboFadeOutCount = 6;
  if(!eboClicked){
    $(".entire-book-order img").attr('src','/img/icon/up-arr.png')
    .css({'bottom':'-11px','right':'2px','width':'9px','margin-left':'10px'});
    $(".entire-book-order span").animate({'color':'#ffbb00'},300);
    $(".entire-book-order-list").animate({'height':'105px'},0,function(){
      $(".entire-book-order-list li").stop().fadeOut(0);
      $(".entire-book-order-list li").each(e => {
        if(e==eboCurrentIndex) return;
        $(".entire-book-order-list li:nth-child("+(e+1)+")").fadeIn(150*eboFadeinCount);
        eboFadeinCount++;
      });
    });
    eboClicked = true;
  } else {
    $(".entire-book-order img").attr('src','/img/icon/down-arr.png')
    .css({'bottom':'-7px','right':'0px','width':'14px','margin-left':'5px'});
    $(".entire-book-order span").animate({'color':'black'},300);
    $(".entire-book-order-list li").each(e => {
      if(e==eboCurrentIndex) return;
      $(".entire-book-order-list li:nth-child("+(e+1)+")").stop().fadeIn(0);
    });
    $(".entire-book-order-list li").each(e => {
      $(".entire-book-order-list li:nth-child("+(e+1)+")").fadeOut(100*eboFadeOutCount);
      eboFadeOutCount--;
    });

    setTimeout(function(){
      $(".entire-book-order-list").animate({'height':'0px'},0);
    },200);
    eboClicked = false;
  }
 });

 $(".entire-book-order-list li").click(function(){
  eboCurrentIndex = $(this).index();
  switch(eboCurrentIndex) {
    case 0:
      $(".entire-book-order span").text("최근 담은 순"); break;
    case 1:
      $(".entire-book-order span").text("최근 읽은 순"); break;
    case 2:
      $(".entire-book-order span").text("책 제목 순"); break;
    case 3:
      $(".entire-book-order span").text("저자명 순"); break;
    case 4:
      $(".entire-book-order span").text("출판사 순"); break;
    case 5:
      $(".entire-book-order span").text("최근 발행 순"); break;
  }
 });


 
$(".middle-nav div:not(.middle-nav-underbar)").click(function(){
  let mnIndex = $(this).index();
  switch(mnIndex){
    case 0:
      $(".shelf-wrapper, .record-wrapper, .order-list-wrapper, .order-list-title-wrapper, .record-question-box, .order-list-title-detail-wrapper").fadeOut(0);
      $(".entire-book-wrapper").fadeIn(300);
      $(".middle-nav-underbar").animate({'left':mnIndex*25+'%'},300);
      break;
    case 1:
      $(".entire-book-wrapper, .record-wrapper, .order-list-wrapper, .order-list-title-wrapper, .record-question-box, .order-list-title-detail-wrapper").fadeOut(0);
      $(".shelf-wrapper").fadeIn(300);
      $(".middle-nav-underbar").animate({'left':mnIndex*25+'%'},300);
      break;
    case 2:
      $(".entire-book-wrapper, .shelf-wrapper, .order-list-wrapper, .order-list-title-wrapper, .record-question-box, .order-list-title-detail-wrapper").fadeOut(0);
      $(".record-wrapper").fadeIn(300);
      $(".middle-nav-underbar").animate({'left':mnIndex*25+'%'},300);
      break;
    case 3:
      $(".entire-book-wrapper, .shelf-wrapper, .record-wrapper, .record-question-box, .order-list-title-detail-wrapper").fadeOut(0);
      $(".order-list-wrapper, .order-list-title-wrapper").fadeIn(300);
      $(".middle-nav-underbar").animate({'left':mnIndex*25+'%'},300);
      break;  
  }
});


$(".record-sort span").click(function(){
  let recordSortIndex = $(this).index();
  $(".record-sort-button").animate({'left':(5+65*recordSortIndex)+'px'},300);
  $(".record-sort span").animate({'color':'#b3b3b3'},100);
  $(this).animate({'color':'#6495ed'},300);
});



const graphValue = [];
let labelLength;
for(var i=0;i<3;i++){
  graphValue[i] = $(".record-graph-data-label-"+(i+1)).text();
  labelLength = graphValue[i].length;
  graphValue[i] = Number(graphValue[i].substring(0,labelLength-1));
}
let maxgraphValue = Math.max(graphValue[0],graphValue[1],graphValue[2]);

for(var i=1;i<4;i++){
 $(".record-graph-stick-wrapper-"+i).css('height',(240*graphValue[i-1]/maxgraphValue)+'px');
 $(".record-graph-stick-"+i).css('height',((240*graphValue[i-1]/maxgraphValue)-30)+'px');
}


let orderIsClicked = false;
$(".order-list-title-button, .detail-title img, .detail-bottom-apply").click(function(){
  if(!orderIsClicked) {
    $(".order-list-title-detail-wrapper").fadeIn(200);
    orderIsClicked = true;
  } else {
    $(".order-list-title-detail-wrapper").fadeOut(100);
    orderIsClicked = false;
  }
});


$("#detail-range-select").change(function(){
  let drsIndex = $("#detail-range-select :selected").index();
  switch(drsIndex) {
    case 0:
      $(".detail-range-start, .detail-range-end").css({
        'background-color':'#f5f5f5',
        'pointer-events':'none',
        'cursor':''
      });
      $(".detail-range-start").datepicker('setDate','-1m');
      break;
    case 1:
      $(".detail-range-start, .detail-range-end").css({
        'background-color':'#f5f5f5',
        'pointer-events':'none',
        'cursor':''
      });
      $(".detail-range-start").datepicker('setDate','-2m');
      break;
    case 2:
      $(".detail-range-start, .detail-range-end").css({
        'background-color':'#f5f5f5',
        'pointer-events':'none',
        'cursor':''
      });
      $(".detail-range-start").datepicker('setDate','-3m');
      break;
    case 3:
      $(".detail-range-start, .detail-range-end").css({
        'background-color':'#f5f5f5',
        'pointer-events':'none',
        'cursor':''
      });
      $(".detail-range-start").datepicker('setDate','-6m');
      break;
    case 4:
      $(".detail-range-start, .detail-range-end").css({
        'background-color':'white',
        'pointer-events':'all',
        'cursor':'pointer'
      });
      $(".detail-range-start").datepicker('setDate','today');
      break;
  }
});


$(".detail-range-start").datepicker({
  dateFormat: 'yy-mm-dd'
  ,showOtherMonths: true
  ,showMonthAfterYear:true
  ,changeYear: true
  ,changeMonth: true             
  ,showOn: "both" 
  ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif"
  ,buttonImageOnly: true
  ,buttonText: "선택"            
  ,yearSuffix: "년"
  ,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
  ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
  ,dayNamesMin: ['일','월','화','수','목','금','토']
  ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일']
  ,minDate: "-5Y"
  ,maxDate: "0D"
}).datepicker('setDate', '-1m'); 

$(".detail-range-end").datepicker({
  dateFormat: 'yy-mm-dd'  
  ,showOtherMonths: true
  ,showMonthAfterYear:true
  ,changeYear: true
  ,changeMonth: true             
  ,showOn: "both" 
  ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif"
  ,buttonImageOnly: true
  ,buttonText: "선택"            
  ,yearSuffix: "년"
  ,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
  ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
  ,dayNamesMin: ['일','월','화','수','목','금','토']
  ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일']
  ,minDate: "-5Y"
  ,maxDate: "0D" 
}).datepicker('setDate', 'today'); 

$('.detail-range-start').datepicker();
$('.detail-range-start').datepicker("option", "maxDate", $(".detail-range-end").val());
$('.detail-range-start').datepicker("option", "onClose", function ( selectedDate ) {
    $(".detail-range-end").datepicker( "option", "minDate", selectedDate );
});

$('.detail-range-end').datepicker();
$('.detail-range-end').datepicker("option", "minDate", $(".detail-range-start").val());
$('.detail-range-end').datepicker("option", "onClose", function ( selectedDate ) {
    $(".detail-range-start").datepicker( "option", "maxDate", selectedDate );
});


$(".detail-bottom-reset").click(function(){
  $("#detail-range-select").val("month-1").prop("selected",true);
  $(".detail-range-start, .detail-range-end").css({
    'background-color':'#f5f5f5',
    'pointer-events':'none',
    'cursor':''
  });
  $(".detail-range-start").datepicker('setDate','-1m');
  $("#detail-state-select").val("entire").prop("selected",true);
  $(".order-list-detail-search input").val("");
});

let rqclicked = false;
$(".record-question, .record-question-info img").click(function(){
  if(!rqclicked){
    $(".record-question-box").fadeIn(200);
    rqclicked = true;
  } else {
    $(".record-question-box").fadeOut(100);
    rqclicked = false;
  }
});

}); 


    