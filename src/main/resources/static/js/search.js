$(function () {
  let ubClickindex = 1;
  let obClickindex = 1;

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

  let startTime;
  for (startTime = 1; startTime < 6; startTime++) {
    $(".trend-wrapper ul:nth-child(3) li:nth-child(" + startTime + ")")
      .css('animation-delay', '0.' + (5 - startTime) + 's');
  }
  for (startTime = 1; startTime < 6; startTime++) {
    $(".trend-wrapper ul:nth-child(2) li:nth-child(" + startTime + ")")
      .css('animation-delay', '0.' + (10 - startTime) + 's');
  }

  let date = new Date();
  month = date.getMonth() + 1;
  day = date.getDate()
  hour = date.getHours();
  minute = date.getMinutes();
  $(".trend-current-time").text(month + '.' + day + " " + hour + ":" + minute + " 기준");

});

