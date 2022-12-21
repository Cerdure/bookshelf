$(function () {
 
  $(window).resize(function(){
    let mh = $('.meta-wrapper').height();
    if(mh<800){
      $(".meta-wrapper").css('height','800px');
      $(".inner-wrapper").css('height','100%');
    } else {
      $(".meta-wrapper").css('height','100%');
    }
  });

  $(".form-group").on({
    keyup: function () {
      $(this).find('label').stop().animate({
        'position': 'relative',
        'font-size': '10px',
        'top': '10px',
        'left': '10px'
      }, 200);
    },
    mouseover: function () {
      $(this).find('label').stop().animate({
        'position': 'relative',
        'font-size': '10px',
        'top': '10px',
        'left': '10px'
      }, 200);
    },
    mouseleave: function () {
      if ($(this).find('input').val() == '') {
        $(this).find('label').stop().animate({
          'position': 'absolute',
          'top': '50%',
          'transform': 'translateY(-50%)',
          'font-size': '14px',
          'left': '20px'
        }, 300);
      }
    }
  });

  $(".form-group input").click(function(){
    let anotherInput = $(".form-group input").not($(this));
    if (anotherInput.val() == '') {
      anotherInput.next().stop().animate({
        'position': 'absolute',
        'top': '50%',
        'transform': 'translateY(-50%)',
        'font-size': '14px',
        'left': '20px'
      }, 300);
    }
  });
  
  $(".pw-wrapper img").click(function(){
    if(!$(this).hasClass('clicked')){
      $(this).attr('src','/img/icon/ico_eye_active@2x.png').addClass('clicked');
      $(".user-pw").attr('type','text');
    } else {
      $(this).attr('src','/img/icon/ico_eye@2x.png').removeClass('clicked');
      $(".user-pw").attr('type','password');
    }
  });

  $(".id-save-check").click(function () {
    if (!$(this).hasClass('clicked')) {
      $("#rememberMe").prop('checked',true);
      $(this).attr('src', "/img/icon/ico_checkbox_active@2x.png")
        .css({ 'border': 'none', 'width': '12px', 'height': '12px' })
        .animate({ 'backgroundColor': 'rgb(101, 168, 255)' }, 200)
        .addClass('clicked');
    } else {
      $("#rememberMe").prop('checked',false);
      $(this).attr('src', "/img/icon/ico_checkbox@2x.png")
        .css({ 'border': '1px solid rgb(211, 211, 211)', 'width': '10px', 'height': '10px' })
        .animate({ 'backgroundColor': 'white' }, 200)
        .removeClass('clicked');
    }
  });




});

