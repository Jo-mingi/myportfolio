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
</script>
<link rel="stylesheet" href="${ctx}/resources/css/main.css">

</head>
<body class="text-center">
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
		        <button type="submit" class="btn btn-primary" onclick="return checkValidation()">Sign in</button>
		        <button type="button" class="btn btn-secondary" onclick="location.href='${ctx}/memberJoin.do'">Sign up</button>
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
				<a class="nav-link active" href="${ctx}">Home</a>
				<a class="nav-link" href="${ctx}/list.do">Search</a>
				<a class="nav-link" href="${ctx}">Contact</a>
			</nav>
		</div>
		<div class="container" id="login">
			<c:if test="${sessionScope.sessionUserId==null || sessionScope.sessionUserId==''}">
				<div class="d-flex justify-content-end">
					<button type="button" class="btn btn-light" data-toggle="modal" data-target="#LoginModal">Login</button>
				</div>
			</c:if>
			<c:if test="${sessionScope.sessionUserId !=null && sessionScope.sessionUserId !=''}">
				<div class="d-flex justify-content-end">
					<div class="mr-1 align-self-center" style="color:white">${sessionScope.sessionUserName}님 환영합니다!!</div>
					<button type="button" class="btn btn-secondary" onclick="logout()">Logout</button>
				</div>
			</c:if>
		</div>
	</header>