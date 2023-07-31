<%@page import="com.google.gson.Gson"%>
<%@page import="vo.User1VO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.cj.protocol.Resultset"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page contentType="application/json;charset=UTF-8" pageEncoding="UTF-8"%>
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
		conn.close();
		stmt.close();
		
		
	}catch(Exception e){
		e.printStackTrace();
	}

	
	
	// JSON 출력
	Gson gson = new Gson();
	String jsonData = gson.toJson(users); // 위의 문자열을 jsonData로 변환하는 과정 
	
	out.print(jsonData);
	


%>