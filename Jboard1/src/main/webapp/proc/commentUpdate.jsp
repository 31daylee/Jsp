<%@page import="kr.co.jboard1.dao.ArticleDAO"%>
<%@page import="kr.co.jboard1.dto.ArticleDTO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String no = request.getParameter("no");
	String content = request.getParameter("content");
	String parent = request.getParameter("parent");
	
	
	ArticleDTO dto = new ArticleDTO();
	dto.setContent(content);
	
	dto.setNo(no);
	
	
	
	ArticleDAO dao = new  ArticleDAO();
	dao.updateComment(dto);
	
	response.sendRedirect("/Jboard1/view.jsp?no="+parent);
	
	
	
	


%>