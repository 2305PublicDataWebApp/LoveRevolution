<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<!-- head 파일 -->
	<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
	<body>
		<!-- 헤더 -->
	    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
		<!-- 메인 -->
		<main class="main member member member_update" id="member_update">
			<div class="container">
				<div class="modify_wrap">
          <form action="/member/update.do" method="post">
            <h2 class="main_txt">회원정보수정</h2>
            <ul>
              <li class="info_line">
                <label for="memberId">아이디</label>
                <input type="text" id="memberId" name="memberId" value="${member.memberId}" readonly>
              </li>
              <li class="info_line">
                <label for="memberPw">비밀번호</label>
                <input type="password" id="memberPw" name="memberPw" value="${member.memberPw}">
              </li>
              <li class="info_line">
                <label for="memberAge">나이</label>
                <input type="text" id="memberAge" name="memberAge" value="${member.memberAge}" readonly>
              </li>
              <li class="info_line">
                <label for="memberName">이름</label>
                <input type="text" id="memberName" name="memberName" value="${member.memberName}">
              </li>
              <li class="info_line info_gender">
                <label>성별</label>
                <span>${member.memberGender }</span>
              </li>
              <li class="info_line">
                <label for="memberEmail">이메일</label>
                <input type="text" id="memberEmail" name="memberEmail" value="${member.memberEmail}">
              </li>
              <li class="info_line">
                <label for="memberPhone">전화번호</label>
                <input type="text" id="memberPhone" name="memberPhone" value="${member.memberPhone}">
              </li>
              <li class="info_line info_address">
                <label for="member-address">주소</label>
                <input type="text" id="member-address" name="memberAddress" value="${member.memberAddress}">
                <input type="button" class="address_btn" onclick="sample4_execDaumPostcode();" value="주소 검색">
              </li>
            </ul>
            <div class="btn_wrap">
	            <button type="submit" class="btn btn_update">수정하기</button>
	            <a href="/member/delete.do?memberId=${member.memberId}" class="btn btn_delete">탈퇴하기</a>
	            <a href="/member/mypage.do?memberId=${member.memberId}" class="btn btn_prev">이전페이지로 이동</a>
            </div>
          </form>
        </div>
			</div>
		</main>
		<!-- 푸터 -->
    	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	</body>
</html>