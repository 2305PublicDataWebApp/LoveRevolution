<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<!-- head 파일 -->
	<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
	<body>
	    <!-- 헤더 -->
	    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	    <main class="main mainpage" id="mainpage">
          <div class="section" id="happen">
            <div class="titleBox">
              <h2 data-splitting>실시간 회원 성혼수 공개</h2>
              <p data-splitting>회원 수 36,750명 ㅣ 성혼수 47,606명</p>
            </div>
          </div>
          <div class="section" id="business">
            <div class="titleBox">
              <h2 data-splitting>대한민국 결혼 정보 업계 <br> 매출액 1위 <strong class="red_txt">연애혁명</strong></h2>
            </div>
            <ul class="iconList">
              <li>
                <div class="icon">
                  <img src="/resources/images/common/prime_logo_01.png" alt="">
                </div>
                <dl class="box_txt_wrap">
                  <dt class="box_txt">KCOP인 대회 수상</dt>
                </dl>
              </li>
              <li>
                <div class="icon">
                  <img src="/resources/images/common/prime_logo_02.png" alt="">
                </div>
                <dl class="box_txt_wrap">
                  <dt class="box_txt">올해의 브랜드 상</dt>
                </dl>
              </li>
              <li>
                <div class="icon">
                  <img src="/resources/images/common/prime_logo_03.png" alt="">
                </div>
                <dl class="box_txt_wrap">
                  <dt class="box_txt">소비자에게 신뢰받는 착한브랜드 대상</dt>
                </dl>
              </li>
            </ul>
          </div>
          <div class="section" id="portfolio">
            <div class="titleBox">
              <h2 data-splitting>설레는 인연과의 만남, <br>이젠 기다리지 마세요</h2>
            </div>
          </div>
          <div class="section" id="community">
            <div class="titleBox">
              <h2 data-splitting>전문직, 명문대 등 수준 높은 회원 Pool을 통해 <br>폭넓은 만남 기회를 제공합니다.</h2>
            </div>
          </div>
          <!-- 푸터 -->
          <div class="section fp-auto-height" id="footer">
              <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
          </div>
	    </main>
	</body>