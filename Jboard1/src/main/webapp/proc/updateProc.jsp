<%@page import="kr.co.jboard1.dao.ArticleDAO"%>
<%@page import="kr.co.jboard1.dto.ArticleDTO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 게시글 수정 완료
	request.setCharacterEncoding("UTF-8");
	String no = request.getParameter("no");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String file = request.getParameter("file");
	
	ArticleDTO dto = new ArticleDTO();
	dto.setNo(no);
	dto.setTitle(title);
	dto.setContent(content);
	
	ArticleDAO dao = new ArticleDAO();
	dao.updateArticle(dto);
	
	response.sendRedirect("/Jboard1/view.jsp?no="+no);

%>