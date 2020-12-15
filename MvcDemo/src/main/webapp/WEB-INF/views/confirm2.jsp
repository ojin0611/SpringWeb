<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="user" value="${userVO}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>confirm2.jsp</h1>
	<h2>사용자 정보</h2>
	아이디 : ${user.userid}
	<br /> 패스워드 : ${user.passwd}
	<br /> 이름 : ${user.name}
	<br /> 나이 : ${user.age}
	<br /> 성별 : ${user.gender}
	<br /> 취미 : 
		<c:forEach items="${user.hobby}" var="hobby">
			<c:out value="${hobby},"/>
		</c:forEach>
	<br />
</body>
</html>