<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>forward1</title>
		<%--
			날짜 : 2023/07/26
			이름 : 이현정
			내용 : JSP forward 액션태그 실습하기
		--%>
	</head>
	<body>
		<h3>forward1 페이지 입니다.</h3>
		<%
		
			pageContext.forward("./target.jsp");
	
		%>
	</body>
</html>