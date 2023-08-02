<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="vo.User1VO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	
	
	List<User1VO> users = new ArrayList<>();
	
	try{
		Context initctx = new InitialContext();
		Context ctx = (Context)initctx.lookup("java:comp/env");
		DataSource ds = (DataSource)ctx.lookup("jdbc/userdb");
		Connection conn = ds.getConnection();
		
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM `User2`");
		
		while(rs.next()){
			User1VO vo = new User1VO();
			vo.setUid(rs.getString(1));
			vo.setName(rs.getString(2));
			vo.setHp(rs.getString(3));
			vo.setAge(rs.getInt(4));
			
			users.add(vo);
			
		}
		rs.close();
		stmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
			



%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user2::list</title>
	</head>
	<body>
		<h3>User2 목록</h3>
		<a href="/Ch06/1_JDBC.jsp">처음으로</a>
		<a href="/Ch06/user2/register.jsp">처음으로</a>
	
		<table border="1">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>휴대폰</th>
				<th>나이</th>
				<th>관리</th>
			</tr>
			<% for(User1VO vo : users){ %>
			<tr>
				<td><%= vo.getUid() %></td>
				<td><%= vo.getName() %></td>
				<td><%= vo.getHp() %></td>
				<td><%= vo.getAge() %></td>
				<td>
					<a href="/Ch06/user2/modify.jsp?uid=<%=vo.getUid()%>">수정</a>
					<a href="/Ch06/user2/delete.jsp?uid=<%=vo.getUid()%>">삭제</a>
				</td>
			</tr>
			<% } %>
		</table>
	</body>
</html>