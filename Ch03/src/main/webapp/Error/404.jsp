<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>페이지를 찾을 수 없습니다.</title>
		<%--
			날짜 : 2023/07/26
			이름 : 이현정
			내용 : JSP exception 내장객체 실습하기
			
			exception
			- JSP 예외가 발생했을 때 예외를 처리하기 위한 내장객체
			- 간접적으로 exception 객체를 통해 에러코드별 에러 페이지 작성
			
			주요 응답코드
			- 200 : 요청 성공
			- 3xx : 리다이렉트 
			- 404 : 페이지 없음
			- 500 : 서버 내부 에러
		--%>
	</head>
	<body>
		<h3>요청하신 페이지가 없습니다. 다시 확인하시기 바랍니다.</h3>
		<p>

		</p>
		
		<a href="./6_exception.jsp">뒤로가기</a>
	</body>
</html>