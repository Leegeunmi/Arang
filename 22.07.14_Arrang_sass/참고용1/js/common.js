$(function() {

  //스크롤 안움직여도 첫번째 메인은 0.4초후 자동 효과
  setTimeout(function(){
  $("#main-slide1 p").addClass("on");
  $(".nav-left p").addClass("on")
  $(".bg-part:nth-child(1)").addClass("on");
}, 400);
  //header, a.nav-button, backtotop 스크롤탑 0일때 효과
  $(window).scroll(function(){
    let backToTop = $(".back-to-top");
    if( $(this).scrollTop() != 0 ){
      $("header").addClass("on");
      $("a.nav-button").addClass("on");
      backToTop.addClass("on")
    }else{
      $("header").removeClass("on");
      $("a.nav-button").removeClass("on");
      backToTop.removeClass("on")
    };
  });
  //좌측 gnb
  $(".nav-left .nav-left-ul .nav-left-li a").click(function(){
    let thisHash = $(this.hash);
    let isAni = $("html,body").is(":animated");
    $("html,body").stop();
    $("html,body").animate({scrollTop : thisHash.offset().top },1000, 'swing');
    return false;
  });
  //back to top
  $(".back-to-top a").click(function(){
    $("html,body").animate({scrollTop : 0 },500);
    $("body").animate({ opacity: "0" } ,1000)
      .animate({ opacity: "1" }, 2000);
  });
  let count = 0;
  // 스크롤 효과
  $(window).scroll(function(){
    let wHeight = $(this).height();
    let thisScrollTop = $(this).scrollTop();
    let apTop = $(".ani-parent").offset().top;
    let ctTop = $(".content-title").offset().top;
    let ctTop2 = $(".content-title.second").offset().top;
    let smTop = $(".slide.mini").offset().top;
    let winnerHeight = $(window).innerHeight();
    let wheelAction = false;
    // let maxDirec = $(".wheel-wrap section").length - 1;
    let direc = 0; // 방향 전환
    console.log("현재 스크롤탑:" + thisScrollTop);
    $(window).on('wheel', function(event){ // 스크롤 이벤트
      let eventDelta = event.originalEvent.wheelDelta; // 스크롤 위 아래 인식
      //포트폴리오 영역 스크롤 이벤트 함수
      function portfolioArea(c1,top){
        if( thisScrollTop < ctTop ){
          $(".ani-parent.left").css("transform", "translateY(0px)");
          $(".ani-parent.right").css("transform", "translateY(0px)");
        }
        if( thisScrollTop > ctTop + top ){
        let count = c1;
        if( eventDelta < 0 && wheelAction == false ){
          $(".ani-parent.left").css("transform", "translateY(" + (count) + "px)");
          $(".ani-parent.right").css("transform", "translateY( " + -(count) + "px)");
        }else if( eventDelta > 0 && wheelAction == false ){ // down
          $(".ani-parent.left").css("transform", "translateY(" + -(count) + "px)");
          $(".ani-parent.right").css("transform", "translateY( " + (count) + "px)");
        }
        }
      }
      portfolioArea(5,0),portfolioArea(15, 50),portfolioArea(20,100),portfolioArea(25,200),
      portfolioArea(30,300),portfolioArea(35,400),portfolioArea(40,500),portfolioArea(45,600);
      portfolioArea(50,700),portfolioArea(55,800);
    });
    $("#main-slide5 p").addClass("on");
    $("footer p").addClass("on");
    //메인 이미지 효과, 메인 텍스트 효과 영역
    if ( thisScrollTop < $("#main-slide2").offset().top - 800 ){
      $("#main-slide1 p").addClass("on");
      $(".nav-left p").addClass("on")
      $(".bg-part:nth-child(1)").addClass("on");
    }else{
      $(".bg-part:nth-child(1)").removeClass("on");
    }
    //메인 이미지 함수(두번째 슬라이드 부터)
    function scEvent(elem1,num,elem2, elem3){
      if ( thisScrollTop > $(elem1).offset().top - num && thisScrollTop < $(elem1).offset().top + num ){
        $(elem2).addClass("on");
        $(elem3).addClass("on");
      }else{
        $(elem3).removeClass("on");
      }
    }
    scEvent("#main-slide2", 500, "#main-slide2 p", ".bg-part:nth-child(2)")
    scEvent("#main-slide3", 500, "#main-slide3 p", ".bg-part:nth-child(3)")
    scEvent("#main-slide4", 500, "#main-slide4 p", ".bg-part:nth-child(4)")
    //슬라이드 이후 포트폴리오, 뉴스 영역 스크롤 이벤트
    if ( thisScrollTop > $(".content-title").offset().top - 100 ){
      $("#mini1 p").addClass("on");
    }
    if ( thisScrollTop > $(".content-title.second").offset().top - 100 ){
      $("#main-slide6 p").addClass("on");
      $(".img.im-2").addClass("effect2");
    }
    if ( thisScrollTop > $("#mini2").offset().top - 300 ){
      $("#mini2 p").addClass("on2");
      $(".news-main p").addClass("on3");
      $(".news-main img").addClass("on");
    }
  });
  // a.nav-button 마우스 호버 동시효과
  $("a.nav-button").on({
    mouseenter: function(){
      $("a.nav-button i:nth-child(1)").css("width", "21px");
      $("a.nav-button i:nth-child(2)").css("width", "100%");
      $("a.nav-button i:nth-child(3)").css("width", "21px");
    },
    mouseleave: function(){
      $("a.nav-button i:nth-child(1)").css("width", "100%");
      $("a.nav-button i:nth-child(2)").css("width", "18px");
      $("a.nav-button i:nth-child(3)").css("width", "100%");
    }
  });
  // a.nav-button 클릭했을때 효과들
  $("a.nav-button").click(function(){
    let isAni = $(".nav-wrap .nav .nav-inner .links-wrap .links-3").is(":animated");
    if( $(".nav-wrap .nav").hasClass("is-active") ){
      $(".nav-wrap .nav").removeClass("is-active");
    }else{
      $(".nav-wrap .nav").addClass("is-active");
    }
  //햄버거 gnb 순차효과 함수, 실행
  function gnbEf(elem,time){
    $(elem).animate({ right: '-600px', opacity: "0" } ,0)
    .animate({ right: '0px', opacity: "1" }, time);
  }
  function gnbEf2(elem,time){
    $(elem).animate({ marginLeft: '600px', opacity: "0"} ,0)
      .animate({ marginLeft: '0px', opacity: "1"}, time);
  }
    if( !isAni ){
    gnbEf(".nav-wrap .nav .nav-inner .menu-ul .menu-1 p a", 900);
    gnbEf(".nav-wrap .nav .nav-inner .menu-ul .menu-2 p a", 1000);
    gnbEf(".nav-wrap .nav .nav-inner .menu-ul .menu-3 p a", 1100);
    gnbEf(".nav-wrap .nav .nav-inner .menu-ul .menu-4 p a", 1200);
    gnbEf(".nav-wrap .nav .nav-inner .menu-ul .menu-5 p a", 1300);
    gnbEf(".nav-wrap .nav .nav-inner .links-wrap .links-1 p a", 1350);
    gnbEf2(".nav-wrap .nav .nav-inner .links-wrap .links-2", 1400);
    gnbEf2(".nav-wrap .nav .nav-inner .links-wrap .links-3", 1450);
    };
  });
});
