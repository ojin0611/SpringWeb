<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	아이디 : ${userid}
	<br /> 패스워드 : ${passwd}
	<br /> 사용자 이름 : ${name}
	<br /> 나이 : ${age}
	<br /> 성별 : ${gender}
	<br /> 취미 : 
	<c:forEach items="${hobbies}" var="hobby">
		<c:out value="${hobby}"/>
	</c:forEach>
	<br />
</body>
</html>