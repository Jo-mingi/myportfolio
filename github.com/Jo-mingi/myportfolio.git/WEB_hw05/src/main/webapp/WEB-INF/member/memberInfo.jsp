<%@page import="mr.web.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../inc/header.jsp" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>
</head>
<body>
	<div class="container">
		<form class="form-inline" action="${ctx}/memberUpdate.do" method="post">
		<input type="hidden" name="num" value="${dto.num}"/>
			<table class="table">
				<tr>
					<td colspan="2" class="text-center">${dto.name}회원의 정보</td>
				</tr>
			<c:if test="${dto!=null}">
				<tr>
					<td>번호</td>
					<td>${dto.num}</td>
				</tr>
				<tr>
					<td>아이디</td>
					<td>${dto.id}</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>${dto.pw}</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>${dto.name}</td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="text" name="age" value="${dto.age}"/></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="email" value="${dto.email}"/></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="tel" value="${dto.tel}"/></td>
				</tr>
			</c:if>
				<tr>
					<td colspan="2" class="text-center">
						<input type="submit" value="수정하기" class="btn btn-primary mr-2"/>
						<input type="reset" value="취소" class="btn btn-info mr-2"/>
						<input type="button" value="리스트" class="btn btn-secondary" onclick="location.href='${ctx}/memberList.do'"/>
					</td>
				</tr>
			</table>
		</form>
	</div>


</body>
</html>