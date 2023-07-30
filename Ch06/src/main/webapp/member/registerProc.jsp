<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 인코딩
	request.setCharacterEncoding("UTF-8");

	// 전송 데이터 수신
	String uid = request.getParameter("uid");
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String pos = request.getParameter("pos");
	String dep = request.getParameter("dep");

	// 데이터베이스 처리
	String host = "jdbc:mysql://127.0.0.1:3306/userdb";
	String user = "root";
	String pass = "1234";
	try{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(host,user,pass);
		PreparedStatement psmt = conn.prepareStatement("INSERT INTO `Member` VALUES (?,?,?,?,?)");
		psmt.setString(1, uid);
		psmt.setString(2, name);
		psmt.setString(3, hp);
		psmt.setString(4, pos); // 전송데이터는 무조건 문자열로 넘어오기 때문에 문자열로 해야함
		psmt.setString(5, dep); // 전송데이터는 무조건 문자열로 넘어오기 때문에 문자열로 해야함
		psmt.executeUpdate();
		psmt.close();
		conn.close();		
	}catch(Exception e){
		e.printStackTrace();
	}

	response.sendRedirect("/Ch06/member/list.jsp");


%>