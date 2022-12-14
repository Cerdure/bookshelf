$(function () {
 
$(".inner-wrapper").css('height',$('.meta-wrapper').height()-60+'px');

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
      $(this).attr('src','../static/img/icon/ico_eye_active@2x.png').addClass('clicked');
      $(".user-pw").attr('type','text');
    } else {
      $(this).attr('src','../static/img/icon/ico_eye@2x.png').removeClass('clicked');
      $(".user-pw").attr('type','password');
    }
  });

  $(".id-save-check").click(function () {
    if (!$(this).hasClass('clicked')) {
      $(this).attr('src', "../static/img/icon/ico_checkbox_active@2x.png")
        .css({ 'border': 'none', 'width': '12px', 'height': '12px' })
        .animate({ 'backgroundColor': 'rgb(101, 168, 255)' }, 200)
        .addClass('clicked');
    } else {
      $(this).attr('src', "../static/img/icon/ico_checkbox@2x.png")
        .css({ 'border': '1px solid rgb(211, 211, 211)', 'width': '10px', 'height': '10px' })
        .animate({ 'backgroundColor': 'white' }, 200)
        .removeClass('clicked');
    }
  });


  const idRegex = /^[0-9]{11}$/;
  const pwRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,14}$/;
  let login = document.getElementById("login");

  $(".user-id").keyup(function() {
    let value = $(this).val();
    if (idRegex.test(value)) {
      $(this).css('border', "1px solid rgb(101, 168, 255)")
             .addClass('passed used');
      $(this).next().css('color', "rgb(101, 168, 255)");
    } else if (!idRegex.test(value) && value != "") {
      $(this).css('border', "1px solid #ff3873")
             .removeClass('passed')
             .addClass('used');
      $(this).next().css('color', "#ff3873");
    } else {
      $(this).css('border', "1px solid lightgray")
             .removeClass('passed used');
      $(this).next().css('color', "rgb(170, 170, 170)");
    }
    if ($('.user-id').hasClass('passed') && $('.user-pw').hasClass('passed')) {
      login.disabled = false;
    } else {
      login.disabled = true;
    }
  });

  $(".user-pw").keyup(function() {
    let value = $(this).val();
    if (pwRegex.test(value)) {
      $(this).css('border', "1px solid rgb(101, 168, 255)")
             .addClass('passed used');
      $(this).next().css('color', "rgb(101, 168, 255)");
    } else if (!pwRegex.test(value) && value != "") {
      $(this).css('border', "1px solid #ff3873")
             .removeClass('passed')
             .addClass('used');
      $(this).next().css('color', "#ff3873");
    } else {
      $(this).css('border', "1px solid lightgray")
             .removeClass('passed used');
      $(this).next().css('color', "rgb(170, 170, 170)");
    }
    if ($('.user-id').hasClass('passed') && $('.user-pw').hasClass('passed')) {
      login.disabled = false;
    } else {
      login.disabled = true;
    }
  });


  










});

