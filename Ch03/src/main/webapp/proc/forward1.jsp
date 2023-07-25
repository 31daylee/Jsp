<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>forward1</title>
	</head>
	<body>
		<h3>forward1 페이지</h3>
		<%
			pageContext.forward("../1_request.jsp"); // client 가 forward1.를 요청(request)후 요청받은 forward1가 1_request에게 forward(같은 자원(예를 들어 같은 서버)내에서 가능함)함  / 그 후 1_request 가 응답(response)함

		%>
	</body>
</html>