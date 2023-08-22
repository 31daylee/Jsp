<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.io.File"%>
<%@page import="java.util.UUID"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%

	String path = application.getRealPath("/upload");
	int maxSize = 1024 * 1024 * 10;
	
	// 파일 홈 데이터 수신
	MultipartRequest mr = new MultipartRequest(request, path, maxSize,"UTF-8", new DefaultFileRenamePolicy());
	String uid = mr.getParameter("uid");
	String name = mr.getParameter("name");
	String fName = mr.getOriginalFileName("fName");
	
	// 파일명 수정
	int i = fName.lastIndexOf(".");
	String ext = fName.substring(i);
	
	
	String uuid = UUID.randomUUID().toString();
	String sName = uuid+ext;
	
	File f1 = new File(path+"/"+fName);
	File f2 = new File(path+"/"+sName);
	
	f1.renameTo(f2);
	
	// 원본 파일명 INSERT
	Context ctx = (Context) new InitialContext().lookup("java:comp/env");
	DataSource ds = (DataSource)ctx.lookup("jdbc/Jboard");
	
	
	try{
		Connection conn = ds.getConnection();
		PreparedStatement psmt = conn.prepareStatement("INSERT INTO `FileTest` SET `oName`=?, `sName`=?, `rDate`=NOW()");
		psmt.setString(1, fName);
		psmt.setString(2, sName);
		psmt.executeUpdate();
		psmt.close();
		conn.close();
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
	// 파일 다운로드 이동
	response.sendRedirect("../2_FileDownload.jsp");
	
	
	
%>