<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>exception</title>
		<%--
			날짜 : 2023/07/26
			이름 : 이현정
			내용 : JSP exception 내장객체 실습하기
			
			exception
			- 
		--%>
	</head>
	<body>
		<h3>예외 발생 페이지</h3>
		<%
			int num1 = 10;
			int num2 = 0;
		
			int result = num1 / num2;
		%>
		<p>
			결과 : <%= result %>
		</p>
		
		
		
		
	</body>
</html>