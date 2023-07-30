<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>member::register</title>
	</head>
		<%--
			날짜 : 2023/07/28
			이름 : 이현정
			내용 : JSP 데이터베이스 실습하기_Member
		--%>
	<body>
		<h3>Member 등록</h3>
		<a href="/Ch06/1_JDBC.jsp">처음으로</a>
        <a href="/Ch06/member/list.jsp">Member 목록</a>
		<form action="/Ch06/member/registerProc.jsp" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="uid"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="hp"></td>
			</tr>
			<tr>
				<td>직급</td>
				<td>
				<select name="pos">
					<option>부장</option>
					<option>차장</option>
					<option>과장</option>
					<option>대리</option>
					<option>주임</option>
					<option>사원</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>부서</td>
				<td>
				<select name="dep">
					<option>영업1부</option>
					<option>영업2부</option>
					<option>영업3부</option>
					<option>인사부</option>
					<option>경영지원부</option>
				</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="등록"></td>
			</tr>
		</table>
		</form>
		
		
	</body>
</html>