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
		<main class="main member member_mypage" id="member_mypage">
			<div class="container">
				<div class="mypage_wrap">
          <form action="/member/mypage.do" method="post">
            <h2 class="main_txt">마이페이지</h2>
            <ul>
              <li>
                <label>아이디</label>
                <input type="text" name="memberId" value="${member.memberId}" readonly>
              </li>
              <li>
                <label>비밀번호</label>
                <input type="password" name="memberPw" value="${member.memberPw}" readonly>
              </li>
              <li>
                <label>나이</label>
                <input type="text" name="memberAge" value="${member.memberAge}" readonly>
              </li>
              <li>
                <label>이름</label>
                <input type="text" name="memberName" value="${member.memberName}" readonly>
              </li>
              <li>
                <label>성별</label>
                <input type="text" name="memberGender" value="${member.memberGender}" readonly<c:if test="${member.memberGender eq 'M'}"></c:if>>
              </li>
              <li>
                <label>이메일</label>
                <input type="text" name="memberEmail" value="${member.memberEmail}" readonly>
              </li>
              <li>
                <label>전화번호</label>
                <input type="text" name="memberPhone" value="${member.memberPhone}" readonly>
              </li>
              <li>
                <label>주소</label>
                <input type="text" id="member-address" name="memberAddress" value="${member.memberAddress}" readonly>
              </li>
            </ul>
            <div class="btn_wrap">
            	<a href="/member/update.do?memberId=${member.memberId}" class="btn_update">수정페이지이동</a>
           	</div>
          </form>
        </div>
			</div>
		</main>
		<!-- 푸터 -->
    	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	</body>
</html>