<%@page import="kr.farmstory1.dao.ArticleDAO"%>
<%@page import="kr.farmstory1.dto.ArticleDTO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String group = request.getParameter("group");
	String cate = request.getParameter("cate");
	String parent = request.getParameter("parent");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	String regip = request.getRemoteAddr();
	
	ArticleDTO dto = new ArticleDTO();
	dto.setParent(parent);
	dto.setContent(content);
	dto.setWriter(writer);
	dto.setRegip(regip);
	
	ArticleDAO dao = new ArticleDAO();
	
	// 댓글 업로드의 개수에 따라 댓글 카운트 변경
	int result = dao.insertComment(dto);
	
	
	
	// 댓글 카운트 수정
	if(result >=1){
		dao.updateArticleForCommentPlus(parent);
	}
	
	response.sendRedirect("/Farmstory1/board/view.jsp?group="+group+"&cate="+cate+"&no="+parent);

%>