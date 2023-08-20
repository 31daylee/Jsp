<%@page import="kr.farmstory1.dto.UserDTO"%>
<%@page import="kr.farmstory1.dao.UserDAO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String pass1 = request.getParameter("pass1");
	String name = request.getParameter("name");
	String nick = request.getParameter("nick");
	String hp = request.getParameter("hp");
	String zip = request.getParameter("zip");
	String addr1 = request.getParameter("addr1");
	String email = request.getParameter("email");
	String regip = request.getRemoteAddr();
	
	UserDTO dto = new UserDTO();
	UserDAO.getInstance().updateUser(dto);
	
	
	response.sendRedirect("/Farmstory1/user/myPage.jsp");	

%>