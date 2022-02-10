<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<%@ include file="../inc/header.jsp" %>

<h2>검색</h2>

<div>
	<form action="list.do" method="get" id="moveForm">
		<input type="hidden" name="viewPage" value="${viewPage}"/>
		<input type="hidden" name="keyWord" value="${vo.keyWord}"/>
		<input type="hidden" name="searchType" value="${vo.searchType}"/>
		<input type="hidden" name="totalCnt" value="${totalCnt}"/>
	</form>
	
	<form id="searchForm" action="list.do" method="post">
		<div class="d-flex justify-content-end">
			<div class="d-flex col-md-5 px-0 justify-content-end">
				<select class="custom-select col-md-3" name="searchType">
				  	<option value=""
				  		<c:out value="${vo.searchType == null ? 'selected':''}"/>>선택</option>
				  	<option value="I"
				  		<c:out value="${vo.searchType eq 'I' ? 'selected':''}"/>>제품명</option>
				  	<option value="E"
				  		<c:out value="${vo.searchType eq 'E' ? 'selected':''}"/>>업체명</option>
				  	<option value="Q"
				  		<c:out value="${vo.searchType eq 'Q' ? 'selected':''}"/>>효능</option>
				</select>
				<input type="text" class="form-control col-md-6" id="keyWord" name="keyWord" placeholder="Search" style="border-radius:4px 0 0 4px" value="${vo.keyWord}"/>
				<button id="searchBtn" class="btn btn-info px-0" style="width:40px; border-radius:0 4px 4px 0"><i class="fas fa-search"></i></button>
			</div>
		</div>
	</form>
	
	<table class="table">
	<div class="d-flex justify-content-start">Total : ${totalCnt}</div>
	
		<thead class="thead-light">
			<tr>
				<th>번호</th>
				<th>업체명</th>
				<th>제품명</th>
				<th>효능</th>
				<th>약</th>
			</tr>
		</thead>
		<tbody>
			<%-- <c:set var="bidCnt" value="${intNumOfRows}"></c:set> --%>
			<c:forEach var="mList" items="${list}">
			<tr>
				<td>${mList.num}</td>
				<td>${mList.entpName}</td>
				<td><a class="goView" href="<c:out value='${mList.num}'/>">${mList.itemName}</a></td>
				<td>${mList.efcyQesitm}</td>
				<c:choose>
					<c:when test="${mList.itemImage!=null && mList.itemImage!=''}">
						<td><img alt="이미지 없음" src="${mList.itemImage}" style="height: 70px; width: 130px;"></td>
					</c:when>
					<c:otherwise>
						<td></td>
					</c:otherwise>
				</c:choose>
				<%-- <c:if test="${mList.itemImage!=null && mList.itemImage!=''}">
					<td><img alt="이미지 없음" src="${mList.itemImage}" style="height: 70px; width: 130px;"></td>
				</c:if> --%>
			</tr>
			<%-- <c:set var="bidCnt" value="${bidCnt-1}"/> --%>
			</c:forEach>
		</tbody>
	</table>

<!-- Page navigation -->
	  <ul class="pagination justify-content-center">
	  
		<li class="page-item ${prevPage <= 0 ? 'disabled' : '' }">
			<a class="page-link" href="${prevPage}">이전</a>
		</li>
	    
	    <c:forEach var="i" begin="${blockStart}" end="${blockEnd}">
			<li class="page-item ${viewPage == i ? 'active':''}">
				<a class="page-link" href="${i}">${i}</a>
			</li>
	    </c:forEach>

	    <li class="page-item ${blockEnd >= totalPages ? 'disabled':''}">
	      <a class="page-link" href="${nextPage}">다음</a>
	    </li>

	  </ul>
	
</div>

<script type="text/javascript">
	$(document).ready(function(){
		
		/* 페이징 */
		var moveForm = $("#moveForm");
		
		$(".page-item a").on("click", function(e){
			e.preventDefault(); /* a 태그를 눌렀을 때 기본적으로 넘어가는 것을 막아주는 코드 */
			
			moveForm.find("input[name='viewPage']").val($(this).attr("href"));
			moveForm.submit();
		});
		
		/* 검색 */
		var searchForm = $("#searchForm");
		
		$("#searchBtn").on("click", function(e){
			if(!searchForm.find("input[name='keyWord']").val()){
				alert("키워드를 입력하세요!!");
				$("#keyWord").focus();
				return false;
			}
			
			searchForm.submit();
			
		});
		
		$(".goView").on("click", function(e){
			e.preventDefault();
			
			moveForm.append("<input type='hidden' name='num' value='" + $(this).attr("href")+"'/>");
			moveForm.attr("action", "medicineInfo.do");
			moveForm.submit();
		});
	});
	
</script>

<%@ include file="../inc/footer.jsp" %>