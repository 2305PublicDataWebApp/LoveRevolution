<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <header id="header">
	  <div class="container">
	    <h1 class="logo"><a href="/index.jsp">로고</a></h1>

	    <ul class="menu_right">
	    	<c:if test = "${memberId eq null}">
        		<li class="menu_right_item"><a href="/member/register.do">회원가입</a></li>
        		<li class="menu_right_item"><a href="/member/login.do">로그인</a></li>
        		<li class="menu_right_item"><a href="/notice/write.do">공지사항입력</a></li>
        		<li class=menu_right_item><a href="/notice/list.do">공지사항리스트</a></li>
	    	</c:if>
	    	
	    	<c:if test = "${memberId ne null}">
                <h2 class="session_txt"><strong>${memberName }</strong>님 ,환영합니다.</h2>
        		<li class="menu_right_item"><a href="/member/logout.do">로그아웃</a></li>
        		<li class="menu_right_item"><a href="/member/mypage.do">마이페이지</a></li>
        		<li class="menu_right_item"><a href="/notice/write.do">공지사항입력</a></li>
        		<li class=menu_right_item><a href="/notice/list.do">공지사항리스트</a></li>
			</c:if>
	    </ul>

	  </div>
 </header>