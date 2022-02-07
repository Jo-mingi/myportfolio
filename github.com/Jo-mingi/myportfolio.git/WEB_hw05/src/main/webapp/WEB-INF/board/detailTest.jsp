<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../inc/header.jsp" %>

<div class="container mt-5 d-flex justify-content-center">
	<div class="w-50 border rounded px-5 py-5 shadow">	
		<h3 class="text-center">글보기</h3>
		<form action="list.do" method="get" id="moveForm">
			<input type="hidden" name="viewPage" value="${viewPage}"/>
			<input type="hidden" name="bid" value="${board.bid}"/>
			<input type="hidden" name="keyWord" value="${keyWord}"/>
			<input type="hidden" name="searchType" value="${searchType}"/>
			<input type="hidden" name="totalCnt" value="${totalCnt}"/>
		</form>
		
		<div class="form-group">
			<label for="bid" style="display:block">번호</label>
			<input type="text" class="form-control" id="bid" name="bid" readonly value="${board.bid}"/>
		</div>
		<div class="form-group">
			<label for="subject" style="display:block">제목</label>
			<input type="text" class="form-control" id="subject" name="subject" readonly value="${board.subject}"/>
		</div>
		<div class="form-group">
			<label for="contents">내용</label>
			<textarea class="form-control" id="contents" name="contents" rows="3" readonly>${board.contents}</textarea>
		</div>
		<div class="form-group">
			<label for="writer">작성자</label>
			<input type="text" class="form-control" id="writer" name="writer" readonly value="${board.writer}"/>
		</div>
		<div class="text-center">
			<button type="button" class="btn btn-primary mr-2" id="modify">수정하기</button>
			<button type="button" id="list" class="btn btn-secondary">리스트</button>
		</div>
	</div>
</div> <!-- .container -->

<script type="text/javascript">
	$(document).ready(()=>{
		var moveForm = $("#moveForm");
		$("#list").click(()=>{
			/* location.href="<c:url value='/list.do?viewPage=${param.viewPage}'/>"; */
			/* location.href="<c:url value='/list.do?viewPage=${viewPage}&searchType=${searchType}&keyWord=${keyWord}&totalCnt=${totalCnt}'/>"; */
			moveForm.submit();
		});
		
		$("#modify").click(()=>{
			/* location.href="<c:url value='/modify.do?bid=${board.bid}&viewPage=${viewPage}&searchType=${searchType}&keyWord=${keyWord}&totalCnt=${totalCnt}'/>"; */
			moveForm.attr("action", "modify.do");
			moveForm.submit();
		});
	});
</script>

<%@ include file="../inc/footer.jsp" %>