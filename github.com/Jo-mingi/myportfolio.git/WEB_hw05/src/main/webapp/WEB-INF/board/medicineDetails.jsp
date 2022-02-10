<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<%@ include file="../inc/header.jsp" %>

<div class="container">
	<div class="modal fade show" id="MemoModal">
	  <div class="modal-dialog">
	    <div class="modal-content ml-5" style="width:400px">
	    <!-- Modal header -->
	      <div class="modal-header border-0">
	      	<h4 class="modal-title">이 약은 나에게?</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button> <!-- X 버튼 -->
	      </div>
	      <!-- Modal body -->
	      <form action="${ctx}/memoInsert.do">
		      	<input type="hidden" name="id" value="${sessionScope.sessionUserId}"/>
		      	<input type="hidden" name="memo" value="#meno"/>
		      <div class="modal-body px-5 pt-0">
		      	<input type="text" name="itemName" value="${vo.itemName}" disabled/>
		      	<textarea class="form-control mt-3" id="meno" name="meno" rows="20"></textarea>
		      </div>
	      <!-- Modal footer -->
		      <div class="modal-footer border-0 d-flex justify-content-center">
		        <button type="submit" class="btn btn-primary pt-2"><i class="far fa-save fa-lg"></i></button>
		        <button type="reset" class="btn btn-secondary pt-2"><i class="fas fa-eraser fa-lg"></i></button>
		      </div>
	      </form>
	    </div>
	  </div>
	</div>
</div>

<div class="container mt-5 d-flex justify-content-center" id="detailContainer">
	<div class="w-100 border rounded px-5 py-5 shadow">
		<h3 class="text-center">${vo.itemName}</h3>
		<form action="list.do" method="get" id="moveForm2">
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
		<c:if test="${vo.atpnWarnQesitm!=null && vo.atpnWarnQesitm!=''}">
			<div class="form-group">
				<label for="atpnWarnQesitm">복용 전 주의사항</label>
				<textarea class="form-control" id="atpnWarnQesitm" name="atpnWarnQesitm" rows="3" readonly>${vo.atpnWarnQesitm}</textarea>
			</div>
		</c:if>
		<c:if test="${vo.atpnQesitm!=null && vo.atpnQesitm!=''}">
		<div class="form-group">
			<label for="atpnQesitm">복용 중 주의사항</label>
			<textarea class="form-control" id="atpnQesitm" name="atpnQesitm" rows="3" readonly>${vo.atpnQesitm}</textarea>
		</div>
		</c:if>
		<c:if test="${vo.intrcQesitm!=null && vo.intrcQesitm!=''}">
		<div class="form-group">
			<label for="intrcQesitm">상호작용</label>
			<textarea class="form-control" id="intrcQesitm" name="intrcQesitm" rows="3" readonly>${vo.intrcQesitm}</textarea>
		</div>
		</c:if>
		<c:if test="${vo.seQesitm!=null && vo.seQesitm!=''}">
		<div class="form-group">
			<label for="seQesitm">부작용</label>
			<textarea class="form-control" id="seQesitm" name="seQesitm" rows="3" readonly>${vo.seQesitm}</textarea>
		</div>
		</c:if>
		<c:if test="${vo.depositMethodQesitm!=null && vo.depositMethodQesitm!=''}">
		<div class="form-group">
			<label for="depositMethodQesitm">보관법</label>
			<textarea class="form-control" id="depositMethodQesitm" name="depositMethodQesitm" rows="3" readonly>${vo.depositMethodQesitm}</textarea>
		</div>
		</c:if>
		<div class="text-center">
			<button type="button" id="list" class="btn btn-secondary mr-3">리스트</button>
			<button type="button" id="memoBtn" class="btn btn-secondary" data-toggle="modal" data-target="#MemoModal" onclick=""><i class="fas fa-sign-in-alt fa-lg"></i></button>
		</div>
	</div>
</div> <!-- .container -->

<script type="text/javascript">
	$(document).ready(()=>{
	var moveForm2 = $("#moveForm2");
		$("#list").click(()=>{
			/* location.href="<c:url value='/list.do?viewPage=${param.viewPage}'/>"; */
			/* location.href="<c:url value='/list.do?viewPage=${viewPage}&searchType=${searchType}&keyWord=${keyWord}&totalCnt=${totalCnt}'/>"; */
			moveForm2.submit();
		});
	});
	
	var moveForm = $("#moveForm");
	$("#memoBtn").on("click", function(e){
		if(${sessionScope.sessionUserId==null || sessionScope.sessionUserId==''}) {
			alert("로그인이 필요합니다!!");
			return false;
		}
	});
	
</script>

<%@ include file="../inc/footer.jsp" %>