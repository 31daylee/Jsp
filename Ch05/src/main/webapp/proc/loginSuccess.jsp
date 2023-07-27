<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String sessid = (String)session.getAttribute("sessid");
	
	// proc/loginSuccess 주소값에 해당하는 HTML 웹 브라우저로 바로 접근할 수 없게 만듦 
	if(sessid == null ){
		response.sendRedirect("./loginForm.jsp");
		return;
	}

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>loginSuccess</title>
	</head>
	<body>
		<h3>로그인 성공</h3>
		<p>
			<%= sessid %>님 반갑습니다.<br>
			<a href="./logout.jsp">로그아웃</a>
		</p>
	</body>
</html>