<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>cookieProc</title>
	</head>
	<body>
		<h3>쿠키생성</h3>
		<%
		// 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		
		// 전송 데이터 수신
		String id = request.getParameter("id"); //getter니깐 무언가가 반환이 된다 => 변수 선언 필요
		String pw = request.getParameter("pw"); //파라미터는 1_Cookie에서 pw
		
		// 쿠키 생성
		Cookie c1 = new Cookie("cid",id);
		Cookie c2 = new Cookie("cpw",id);
		
		// 쿠키 전송- 쿠키를 실어서 보낸다
		response.addCookie(c1);
		response.addCookie(c2);
		
		%>
		
		<a href="./cookieConfirm.jsp">쿠키확인</a>
		
		
		
	</body>
</html>