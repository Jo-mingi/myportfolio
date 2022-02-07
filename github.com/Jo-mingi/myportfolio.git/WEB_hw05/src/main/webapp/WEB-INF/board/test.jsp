<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<%@ include file="../inc/header.jsp" %>

<h2>테스트 </h2>

<div>
	<form action="search.do" method="get" id="moveForm">
		<input type="hidden" name="pageNo" value="${pageNo}"/>
		<input type="hidden" name="keyWord" value="${vo.getKeyWord()}"/>
		<input type="hidden" name="searchType" value="${vo.getSearchType()}"/>
		<input type="hidden" name="totalPages" value="${totalPages}"/>
	</form>
	
	<form id="searchForm" action="search.do" method="post">
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
				<input type="text" class="form-control col-md-6" id="keyWord" name="keyWord" placeholder="Search" style="border-radius:4px 0 0 4px" value="${vo.getKeyWord()}"/>
				<button id="searchBtn" class="btn btn-info px-0" style="width:40px; border-radius:0 4px 4px 0"><i class="fas fa-search"></i></button>
			</div>
		</div>
	</form>
	
	<table class="table">
	<div class="d-flex justify-content-start">Total : ${totalCount}</div>
	
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
			<c:set var="bidCnt" value="${intNumOfRows}"></c:set>
			<c:forEach var="list" items="${medicineVOs}">
			<tr>
				<td><c:out value="${bidCnt}"/></td>
				<td>${list.getEntpName()}</td>
				<td>${list.getItemName()}</td>
				<%-- <td><a class="goView" href="<c:out value='${list.bid}'/>">${list.getItemName()}</a></td> --%>
				<td>${list.getEfcyQesitm()}</td>
				<c:if test="${list.getItemImage()!=null && list.getItemImage()!=''}">
					<td><img alt="이미지 없음" src="${list.getItemImage()}" style="height: 70px; width: 130px;"></td>
				</c:if>
			</tr>
			<c:set var="bidCnt" value="${bidCnt-1}"/>
			</c:forEach>
		</tbody>
	</table>

<!-- Page navigation -->
	  <ul class="pagination justify-content-center">
	  
		<li class="page-item ${prevPage <= 0 ? 'disabled' : '' }">
			<a class="page-link" href="${prevPage}">이전</a>
		</li>
	    
	    <c:forEach var="i" begin="${blockStartPage}" end="${blockEndPage}">
			<li class="page-item ${pageNo == i ? 'active':''}">
				<a class="page-link" href="${i}">${i}</a>
			</li>
	    </c:forEach>

	    <li class="page-item ${blockEndPage >= totalPage ? 'disabled':''}">
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
			
			moveForm.find("input[name='pageNo']").val($(this).attr("href"));
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
	});
	
</script>

<%@ include file="../inc/footer.jsp" %>