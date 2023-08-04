<%@page import="kr.co.jboard1.vo.UserVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 수신
	request.setCharacterEncoding("UTF-8");
	String uid = request.getParameter("uid");
	String pass = request.getParameter("pass");
	
	// 사용자 DB 조회
	UserVO vo = null;
	
	try{
		Context initCtx = new InitialContext();
		Context ctx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)ctx.lookup("jdbc/Jboard");
		
		Connection conn = ds.getConnection();
		PreparedStatement psmt = conn. prepareStatement("SELECT * FROM `User` WHERE `uid`=? AND `pass`=SHA2(?,256)");
		psmt.setString(1, uid);
		psmt.setString(2, pass);
		
		ResultSet rs = psmt.executeQuery();
		
		if(rs.next()){
			
			vo = new UserVO();
			
			vo.setUid(rs.getString(1));
			vo.setPass(rs.getString(2));
			vo.setName(rs.getString(3));
			vo.setNick(rs.getString(4));
			vo.setEmail(rs.getString(5));
			vo.setHp(rs.getString(6));
			vo.setRole(rs.getString(7));
			vo.setZip(rs.getString(8));
			vo.setAddr1(rs.getString(9));
			vo.setAddr2(rs.getString(10));
			vo.setRegip(rs.getString(11));
			vo.setRegDate(rs.getString(12));
			vo.setLeaveDate(rs.getString(13));
			
		}
		rs.close();
		psmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	// 회원 여부 확인
	if(vo != null){
		// 사용자 세션 저장
		session.setAttribute("sessUser", vo);
		
		// 리다이렉트
		response.sendRedirect("/Jboard1/list.jsp");
	}else{
		response.sendRedirect("/Jboard1/user/login.jsp?success=100");
	}
	// 리다이렉트
	










%>