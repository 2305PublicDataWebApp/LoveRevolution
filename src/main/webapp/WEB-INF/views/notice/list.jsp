<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<!-- head 파일 -->
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
<body>
	<!-- 헤더 -->
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<main class="main notice notice_list" id="notice_list">
		<div class="container">
		<div class="notice_list_wrap">
          <h1 class="main_txt">공지사항 목록</h1>
          <table class="table_wrap">
            <!-- <colgroup>
              <col width="15%"></col>
              <col width="40%"></col>
              <col width="30%"></col>
              <col width="15%"></col>
            </colgroup>-->
            <thead class="thead_area">
              <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>등록일</th>
              </tr>
            </thead>
            <tbody class="tbody_area">
              <c:forEach var="notice" items="${nList}" varStatus="i">
                <tr>
                  <td>${notice.noticeNo }</td>
                  <c:url var="detailUrl" value="/notice/detail.do">
                    <c:param name="noticeNo" value="${notice.noticeNo }"></c:param>
                  </c:url>
                  <td><a href="${detailUrl }">${notice.noticeTitle }</a></td>
                  <td>${notice.noticeAdmin }</td>
                  <td><fmt:formatDate pattern="yyyy-MM-dd"
                      value="${notice.nCreateDate }" /></td>
                </tr>
              </c:forEach>
            </tbody>
            <tfoot>
              <tr align="center" class="paging_area">
                <td colspan="5"><c:if test="${pInfo.startNavi !=1}">
                    <c:url var="prevUrl" value="/notice/list.do">
                      <c:param name="page" value="${pInfo.startNavi-1 }"></c:param>
                    </c:url>
                    <a href="${prevUrl }">[이전]</a>
                  </c:if> <c:forEach begin="${pInfo.startNavi }" end="${pInfo.endNavi }"
                    var="p">
                    <c:url var="pageUrl" value="/notice/list.do">
                      <c:param name="page" value="${p }"></c:param>
                    </c:url>
                    <a href="${pageUrl }">${p }</a>&nbsp;
                    </c:forEach> <c:if test="${pInfo.endNavi != naviTotalCount }">
                    <c:url var="nextUrl" value="/notice/list.do">
                      <c:param name="page" value="${pInfo.endNavi+1 }"></c:param>
                    </c:url>
                    <a href="${nextUrl }">[다음]</a>
                  </c:if></td>
              </tr>
            </tfoot>
          </table>
          </div>
		</div>
	</main>
	<!-- 푸터 -->
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>