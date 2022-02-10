<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title>Test</title>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>
<script type="text/javascript">
	function checkValidation(){
		if($("#id").val()==''){
			alert("아이디를 입력하세요!!");
			$("#id").focus();
			return false;
		}
		
		if($("#pw").val()==''){
			alert("비밀번호를 입력하세요!!");
			$("#pw").focus();
			return false;
		}
		
		return true;
	}
	function logout(){
		// c:url을 이용하면 ${ctx}를 생략할 수 있다. 
		location.href="<c:url value='/memberLogout.do'/>";
	}
	$(document).ready(function(){
		<c:if test="${!empty msg}">
			alert("${msg}");
			<c:remove var="msg" scope="session"/>
		</c:if>
		
		var moveForm = $("#moveForm");
		$("#goProfile").on("click", function(e){
			e.preventDefault();
			if(${sessionScope.sessionUserId==null || sessionScope.sessionUserId==''}) {
				alert("로그인이 필요합니다!!");
				return false;
			}
			moveForm.append("<input type='hidden' name='id' value='" + $(this).attr("href")+"'/>");
			moveForm.attr("action", "memberInfo.do");
			moveForm.submit();
			
		});
		
	});
</script>
<link rel="stylesheet" href="${ctx}/resources/css/main.css">

</head>
<body class="text-center">
<form id="moveForm" method="post" action="<c:url value='/memberInfo.do'/>">
	
</form>
<!-- Modal -->
<div class="container">
	<div class="modal fade show" id="LoginModal">
	  <div class="modal-dialog">
	    <div class="modal-content ml-5" style="width:400px">
	    <!-- Modal header -->
	      <div class="modal-header border-0">
	      	<h4 class="modal-title">로그인</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button> <!-- X 버튼 -->
	      </div>
	      <!-- Modal body -->
	      <form action="${ctx}/memberLogin.do">
		      <div class="modal-body px-5 pt-0">
		      	<input class="form-control" type="text" placeholder="아이디" id="id" name="id"/><br>
		      	<input class="form-control" type="password" placeholder="비밀번호" id="pw" name="pw"/>
		      </div>
	      <!-- Modal footer -->
		      <div class="modal-footer border-0 d-flex justify-content-center">
		        <button type="submit" class="btn btn-primary" onclick="return checkValidation()"><i class="fas fa-sign-in-alt fa-lg"></i></button>
		        <button type="button" class="btn btn-secondary" onclick="location.href='${ctx}/memberJoin.do'"><i class="fas fa-user-plus fa-lg"></i></button>
		      </div>
	      </form>
	    </div>
	  </div>
	</div>
</div>

<div class="cover-container">
	<header class="masthead">
		<div class="inner">
			<h1 class="masthead-brand">Cover</h1>
			<nav class="nav nav-masthead justify-content-center">
				<a class="nav-link active" href="${ctx}"><i class="fas fa-home fa-lg"></i></a>
				<a class="nav-link" href="${ctx}/list.do"><i class="fas fa-search fa-lg"></i></a>
				<div class="dropdown">
					<button class="btn btn-light dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-expanded="false">
						<span><i class="fas fa-portrait fa-2x"></i></span>
  					</button>
  					<div class="dropdown-menu" aria-labelledby="dropdownMenu2">
  					 	<a class="dropdown-item" id="goProfile" href="<c:out value='${sessionScope.sessionUserId}'/>">Profile</a>
						<a class="dropdown-item" onclick="goRepository()">Repository</a>
					</div>
				</div>
			</nav>
		</div>
		<div class="container" id="login">
			<c:if test="${sessionScope.sessionUserId==null || sessionScope.sessionUserId==''}">
				<div class="d-flex justify-content-end">
					<button type="button" class="btn btn-light" data-toggle="modal" data-target="#LoginModal"><i class="fas fa-sign-in-alt fa-lg"></i></button>
				</div>
			</c:if>
			<c:if test="${sessionScope.sessionUserId !=null && sessionScope.sessionUserId !=''}">
				<div class="d-flex justify-content-end">
					<div class="mr-1 align-self-center" style="color:black">${sessionScope.sessionUserName}님 환영합니다!!</div>
					<button type="button" class="btn btn-secondary" onclick="logout()"><i class="fas fa-sign-out-alt fa-lg"></i></button>
				</div>
			</c:if>
		</div>
	</header>