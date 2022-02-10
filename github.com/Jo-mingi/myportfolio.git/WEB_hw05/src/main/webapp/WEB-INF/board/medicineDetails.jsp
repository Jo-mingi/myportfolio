<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<%@ include file="../inc/header.jsp" %>

<div class="container mt-5 d-flex justify-content-center">
	<div class="w-50 border rounded px-5 py-5 shadow">	
		<h3 class="text-center">${vo.itemName}</h3>
		<form action="list.do" method="get" id="moveForm">
			<input type="hidden" name="viewPage" value="${viewPage}"/>
			<input type="hidden" name="keyWord" value="${keyWord}"/>
			<input type="hidden" name="searchType" value="${searchType}"/>
			<input type="hidden" name="totalCnt" value="${totalCnt}"/>
		</form>
		
		<div class="form-group">
			<label for="itemName" style="display:block">제품명</label>
			<input type="text" class="form-control" id="itemName" name="itemName" readonly value="${vo.itemName}"/>
		</div>
		<div class="form-group">
			<label for="num" style="display:block">업체명</label>
			<input type="text" class="form-control" id="num" name="num" readonly value="${vo.entpName}"/>
		</div>
		<div class="form-group">
			<label for="efcyQesitm">효능</label>
			<textarea class="form-control" id="efcyQesitm" name="efcyQesitm" rows="3" readonly>${vo.efcyQesitm}</textarea>
		</div>
		<div class="form-group">
			<label for="useMethodQesitm">사용법</label>
			<textarea class="form-control" id="useMethodQesitm" name="useMethodQesitm" rows="3" readonly>${vo.useMethodQesitm}</textarea>
		</div>
		<div class="form-group">
			<label for="atpnWarnQesitm">복용 전 주의사항</label>
			<textarea class="form-control" id="atpnWarnQesitm" name="atpnWarnQesitm" rows="3" readonly>${vo.atpnWarnQesitm}</textarea>
		</div>
		<div class="form-group">
			<label for="atpnQesitm">복용 중 주의사항</label>
			<textarea class="form-control" id="atpnQesitm" name="atpnQesitm" rows="3" readonly>${vo.atpnQesitm}</textarea>
		</div>
		<div class="form-group">
			<label for="intrcQesitm">상호작용</label>
			<textarea class="form-control" id="intrcQesitm" name="intrcQesitm" rows="3" readonly>${vo.intrcQesitm}</textarea>
		</div>
		<div class="form-group">
			<label for="seQesitm">부작용</label>
			<textarea class="form-control" id="seQesitm" name="seQesitm" rows="3" readonly>${vo.seQesitm}</textarea>
		</div>
		<div class="form-group">
			<label for="depositMethodQesitm">보관법</label>
			<textarea class="form-control" id="depositMethodQesitm" name="depositMethodQesitm" rows="3" readonly>${vo.depositMethodQesitm}</textarea>
		</div>
		<div class="text-center">
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
	});
</script>

<%@ include file="../inc/footer.jsp" %>