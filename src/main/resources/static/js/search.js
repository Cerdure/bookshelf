$(function () {
  let ubClickindex = 1;
  let obClickindex = 1;

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

  $(".search-input .reset").click(function () {
    $(this).parent().find('input').val('');
    $(".search-result-category").remove();
    $(".search-result-book").remove();
  });

  function bookSearch() {
    $.ajax({
      url: "/search-input",
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

  $(document).ready(function (){
    $(document).on("click","#category-box",function (){
       $("#category-id-input").val($(this).find("#category-id").val());
        $("#search-form").submit();
    });
  });

  $(".category-wrapper ul li").click(function (){
    $("#category-id-input").val($(this).find(".category-id").val());
    $("#search-form").submit();
  });

  $(".recommend-wrapper ul li").click(function (){
    $("#search-input").val($(this).text());
    $("#search-form").submit();
  });







  let startTime = 9;
  let innerInterval = setInterval(function (){ console.log("first "+startTime);
    if(startTime < 0){
      clearInterval(innerInterval);
      startTime = 9;
    } else { console.log(startTime);
      $('.trend-'+(startTime+1)).addClass("flip");
      startTime--;
    }
  },100);

  let intervalOn = false;
  let outerInterval = setInterval(function (){ console.log('oi');
    if(!intervalOn){
      $('.trend-wrapper ul li div').removeClass("flip");
      $.ajax({
        url: "/search-trend",
        type: "post",
        dataType: "json",
        error: function (xhr, status, error) {
          console.log(error);
        }
        }).done(function(result){
          let trends = result;
        innerInterval = setInterval(function (){
          if(startTime < 0){
            clearInterval(innerInterval);
            startTime = 9;
          } else { 
            $('.trend-'+(startTime+1)).text(trends[startTime].searchData);
            $('.trend-'+(startTime+1)).addClass("flip");
            startTime--;
          }
        },100);
      });
      intervalOn = true;
    }
  },10000);

  $(window)
  .blur(function () {
    clearInterval(outerInterval);
  })
  .focus(function () {
    clearInterval(outerInterval);
    $('.trend-wrapper ul li div').removeClass("flip");
                        $.ajax({
                          url: "/search-trend",
                          type: "post",
                          dataType: "json",
                          error: function (xhr, status, error) {
                            console.log(error);
                          }
                          }).done(function(result){
                            let trends = result;
                          innerInterval = setInterval(function (){
                            if(startTime < 0){
                              clearInterval(innerInterval);
                              startTime = 9;
                            } else { 
                              $('.trend-'+(startTime+1)).text(trends[startTime].searchData);
                              $('.trend-'+(startTime+1)).addClass("flip");
                              startTime--;
                            }
                          },100);
                        });

    outerInterval = setInterval(function (){
                      if(!intervalOn){
                        $('.trend-wrapper ul li div').removeClass("flip");
                        $.ajax({
                          url: "/search-trend",
                          type: "post",
                          dataType: "json",
                          error: function (xhr, status, error) {
                            console.log(error);
                          }
                          }).done(function(result){
                            let trends = result;
                          innerInterval = setInterval(function (){
                            if(startTime < 0){
                              clearInterval(innerInterval);
                              startTime = 9;
                            } else { 
                              $('.trend-'+(startTime+1)).text(trends[startTime].searchData);
                              $('.trend-'+(startTime+1)).addClass("flip");
                              startTime--;
                            }
                          },100);
                        });
                        intervalOn = true;
                      }
                    },10000);
  });






  
  let date = new Date();
  month = date.getMonth() + 1;
  day = date.getDate()
  hour = date.getHours();
  minute = date.getMinutes();
  $(".trend-current-time").text(month + '.' + day + " " + hour + ":" + minute + " 기준");

});

