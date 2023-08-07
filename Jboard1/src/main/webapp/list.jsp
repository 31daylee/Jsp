<%@page import="kr.co.jboard1.vo.ArticleVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.jboard1.dao.ArticleDAO"%>
<%@page import="kr.co.jboard1.vo.UserVO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp"%>
<%
	List<ArticleVO> articles = ArticleDAO.getInstance().selectArticles();
%>
<main>
	<section class="list">
		<h3>글목록</h3>
		<article>
			<table border="0">
				<tbody>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>날짜</th>
						<th>조회</th>
					</tr>
					<% for(ArticleVO article : articles){ %>
					<tr>
						<td><%=article.getNo() %></td>
						<td><a href="./view.html"><%=article.getTitle() %>&nbsp;[<%=article.getComment() %>]</a></td>
						<td><%=article.getWriter() %></td>
						<td><%=article.getRdate() %></td>
						<td><%=article.getHit() %></td>
					</tr>
					<% } %>
				</tbody>
			</table>
		</article>
		<div class="paging">
			<a href="#" class="prev">이전</a> <a href="#" class="current">1</a> <a
				href="#" class="num">2</a> <a href="#" class="num">3</a> <a href="#"
				class="next">다음</a>
		</div>
		<a href="/Jboard1/write.jsp" class="btnWrite">글쓰기</a>
	</section>
</main>
<%@ include file="./_footer.jsp"%>
