<%@page import="kr.co.jboard1.dao.ArticleDAO"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String no = request.getParameter("no");
	String parent = request.getParameter("parent");

	
	ArticleDAO dao = new ArticleDAO();
	int result = dao.deleteComment(no);
	
	if(result >= 1){
		dao.updateArticleForCommentMinus(parent);
	}
	
	
	response.sendRedirect("/Jboard1/view.jsp?no="+parent);

%> 
