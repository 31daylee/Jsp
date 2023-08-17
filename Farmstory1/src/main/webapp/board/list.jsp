<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String group = request.getParameter("group");
	String cate = request.getParameter("cate");
	
	pageContext.include("./_aside"+group+".jsp");

%>

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
							<tr>
								<td>1</td>
								<td><a href="./view.jsp?group=<%= group %>&cate=<%=cate %>">연습입니다. &nbsp;[3]</a></td>
								<td>김사과</td>
								<td>20-12-15</td>
								<td>3</td>
							</tr>
						</tbody>
					</table>
				</article>
				<!-- 페이지 내비게이션 -->
				<div class="paging">
					<a href="#" class="prev">이전</a>
					<a href="#" class="num current">1</a>
					<a href="#" class="next">다음</a>
				</div>
				<!-- 글쓰기 버튼 -->
				<a href="./write.jsp?group=<%= group %>&cate=<%=cate %>" class="btnWrite">글쓰기</a>
			</section>
			<!-- 컨텐츠 끝 -->
		</article>
	</section>
</div>
<%@ include file="../_footer.jsp"%>