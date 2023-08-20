<%@page import="kr.co.jboard1.dao.ArticleDAO"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String no = request.getParameter("no");
	String parent = request.getParameter("parent");

	
	ArticleDAO dao = new ArticleDAO();
	
	// 댓글 삭제의 개수에 따라 댓글 카운트 변경 - '삭제 행위'가 많아진다면 -1 이 될 수도 있음 
	int result = dao.deleteComment(no);
	
	if(result >= 1){
		dao.updateArticleForCommentMinus(parent);
	}
	
	
	response.sendRedirect("/Jboard1/view.jsp?no="+parent);

%> 
