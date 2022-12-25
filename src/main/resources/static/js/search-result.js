
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

  $(".category").click(function (){
    bookSearch();
  });

  $(".publish-date").click(function (){
    bookSearch();
  });

  $(".search-input .reset").click(function () {
    $(this).parent().find('input').val('');
    $(".search-result-category").remove();
    $(".search-result-book").remove();
    $("#search-form").submit();
  });

  $(".reset-btn").click(function (){
    $(".side-wrapper input").prop("checked", false);
    $(".publish-date-wrapper .default").prop("checked",true);
    bookSearch();
  });


});


function inputBookSearch() {
  $.ajax({                                                      //한글이라 오류남?
    url: "/search-result-input",
    type: "get",
    data: $("#search-form").serialize(),
    dataType: "html",
    async: true,
  }).done(function (data) {
    $('#search-input-results').replaceWith(data);
  });
}

function bookSearch(_page) { console.log("bookSearch");
  var $chk = $('category');
  var formData = $(".meta-wrapper").serializeArray();

  if(!$chk.is(':checked')){
    formData.push({
      name : $chk.attr('name'),
      value : false
    });
  }
  $.ajax({
    url: "/search-result/book-search?page=" + _page,
    type: "get",
    data: formData,
    dataType: "html",
    async: true,
    error: function (xhr, status, error) {
      console.log(error);
    }
  }).done(function (data) {
    console.log("done");
    $('#search-results').replaceWith(data);
  });
}
$(document).ready(function () {
  $(document).on("change", "#sortOrderSelect", function () {
    $("#sortOrder").val($(this).val());
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
  $(document).on("keyup ready", ".search-input input", function (key) {
      $("#search-input-hidden").val($(this).val());
      if (key.keyCode == 13) {
        $("#search-form").submit();
      } else {
        // bookSearch(0);
        inputBookSearch();
      }
  });
  $(document).on("click", ".search-input .icon", function () {
    bookSearch(0);
  });

});


