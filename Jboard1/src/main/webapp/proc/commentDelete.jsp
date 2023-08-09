<%@page import="kr.co.jboard1.dto.ArticleDTO"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.co.jboard1.dao.ArticleDAO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String no = request.getParameter("no");
	String parent = request.getParameter("parent");
	String content = request.getParameter("content");
	String writer = request.getParameter("writer");
	String regip = request.getRemoteAddr();

	
	ArticleDTO dto = new ArticleDTO();
	dto.setParent(parent);
	dto.setContent(content);
	dto.setWriter(writer);
	dto.setRegip(regip);
	
	
	ArticleDAO dao = new ArticleDAO();
	dao.deleteComment(no);
	
	dao.updateArticleForComment(parent);
	response.sendRedirect("/Jboard1/view.jsp?no="+parent);

%> 
<script>
	alert('댓글이 삭제되었습니다.');
</script>