/* 우편번호 API */
function sample4_execDaumPostcode(){
	new daum.Postcode({
		oncomplete : function(data) {
			document.querySelector("#member-address").value="["+data.zonecode +"] "+data.roadAddress
		}
	}).open();
}

// TweenMax 라이브러리
$("#mainpage").fullpage({
    navigation: true,
    navigationTooltips: ["회원수","사업","성혼","하이엔드"],
    showActiveTooltip: true,
    
    onLeave: function(origin, destination, direction){
		var leavingSection = this;
		if(origin.index == 0 && direction =='down'){
			timeline02.play();
		} else if(origin.index == 1 && direction =='down') {
            timeline03.play();
        }else if(origin.index == 2 && direction =='down') {
            timeline04.play();
        }
	}
    
});

Splitting();
var timeline01 = new TimelineMax();
var timeline02 = new TimelineMax({paused:true,delay:1});
var timeline03 = new TimelineMax({paused:true,delay:1});
var timeline04 = new TimelineMax({paused:true,delay:1});
timeline01.staggerFrom(  $("#happen .titleBox h2 .char") , 1 , { 
                                                        x:100,
                                                        opacity:0,
                                                        ease:Back.easeOut,
                                                        stagger:0.05
                                                    })
.staggerFrom(  $("#happen .titleBox p .word") , 1 , { 
                                                        x:100,
                                                        opacity:0,
                                                        ease:Back.easeOut,
                                                        stagger:0.05
                                                    });    
//////timeline02//////////////////
timeline02.staggerFrom(  $("#business .titleBox h2 .char") , 1 , { 
    x:100,
    opacity:0,
    ease:Back.easeOut,
    stagger:0.05
})
.staggerFrom(  $("#business .titleBox p .word") , 1 , { 
    x:100,
    opacity:0,
    ease:Back.easeOut,
    stagger:0.05
})                                                                                                 .staggerFrom(  $("#business .iconList li") , 1 , { 
    scale:0,
    opacity:0,
    ease:Back.easeOut,
    stagger:0.05
})                                                                                                 
//////timeline03//////////////////
timeline03.staggerFrom(  $("#portfolio .titleBox h2 .char") , 1 , { 
    x:100,
    opacity:0,
    ease:Back.easeOut,
    stagger:0.05
})
.staggerFrom(  $("#portfolio .titleBox p .word") , 1 , { 
    x:100,
    opacity:0,
    ease:Back.easeOut,
    stagger:0.05
})                                                                                                 .staggerFrom(  $("#portfolio .portfolioList li") , 1 , { 
    scale:0,
    opacity:0,
    ease:Back.easeOut,
    stagger:0.05
})      
//////timeline04//////////////////
timeline04.staggerFrom(  $("#community .titleBox h2 .char") , 1 , { 
    x:100,
    opacity:0,
    ease:Back.easeOut,
    stagger:0.05
})
.staggerFrom(  $("#community .titleBox p .word") , 1 , { 
    x:100,
    opacity:0,
    ease:Back.easeOut,
    stagger:0.05
})                                                                                                 .staggerFrom(  $("#community .anchorList li") , 1 , { 
    x:100,
    opacity:0,
    ease:Back.easeOut,
    stagger:0.05
})    

                                                                                         
// 메인 페이지 마우스호버
/*$("#mainpage #business .iconList li").on("mouseenter",function(){
    $("#business .iconList li").addClass("on");
});
$("#mainpage #business .iconList li").on("mouseleave",function(){
    $("#business .iconList li").removeClass("on");
});*/








