<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<%@ include file="../inc/header.jsp" %>

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
					<td><input type="password" name="pw" value="${dto.pw}" disabled/></td>
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
					<td colspan="3" class="text-center">
						<input type="submit" value="modify" class="btn btn-primary mr-2"/>
						<input type="reset" value="reset" class="btn btn-info mr-2"/>
						<input type="button" value="delete" class="btn btn-danger" onclick="location.href='${ctx}/memberDelete.do?num=${dto.num}'"/>
					</td>
				</tr>
			</table>
		</form>
	</div>

<%@ include file="../inc/footer.jsp" %>