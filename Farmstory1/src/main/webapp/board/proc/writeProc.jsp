<%@page import="kr.farmstory1.dao.ArticleDAO"%>
<%@page import="kr.farmstory1.dto.ArticleDTO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("UTF-8");

	String group = request.getParameter("group");
	String cate = request.getParameter("cate");
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	String file = request.getParameter("file");
	String regip = request.getRemoteAddr();

	
	ArticleDTO dto = new ArticleDTO();
	dto.setCate(cate);
	dto.setTitle(title);
	dto.setWriter(writer);
	dto.setContent(content);
	dto.setRegip(regip);
	
	
	ArticleDAO dao = new ArticleDAO();
	dao.insertArticle(dto);
	
	response.sendRedirect("/Farmstory1/board/list.jsp?group="+group+"&cate="+cate);
	
%>