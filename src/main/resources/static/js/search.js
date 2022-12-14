
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
      let startTime;
      for(startTime=1;startTime<6;startTime++){
        $(".trend-wrapper ul:nth-child(3) li:nth-child("+startTime+")")
        .css('animation-delay','0.'+(5-startTime)+'s');
      }
      for(startTime=1;startTime<6;startTime++){
        $(".trend-wrapper ul:nth-child(2) li:nth-child("+startTime+")")
        .css('animation-delay','0.'+(10-startTime)+'s');
      }

      let date = new Date();
      month = date.getMonth()+1;
      day = date.getDate()
      hour = date.getHours();
      minute = date.getMinutes();
      $(".trend-current-time").text(month+'.'+day+" "+hour+":"+minute+" 기준");
    });
      






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
        $(".footer-wrapper").stop().animate({'bottom':'50px'},500);
      } else {
        $(".bottom-nav-wrapper").stop().animate({'bottom':'-80px'},500);
        $(".top-move-button").stop().animate({'bottom':'20px'},500);
        $(".footer-wrapper").stop().animate({'bottom':'0px'},500);
      }
      });

      $(".top-move-button").click(function(){
        $('html').stop().animate({scrollTop : 0}, 1000);
      });
    });

  

    