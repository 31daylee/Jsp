<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String group = request.getParameter("group");
	String cate = request.getParameter("cate");
	
	pageContext.include("./_aside"+group+".jsp");

%>
			<section class="view">
				<h3>글보기</h3>
				<article>
					<table border="1">
						<tbody>
							<tr>
								<td>제목</td>
								<td><input type="text" name="title" value="" readonly></td>
							</tr>
							<tr>
								<td>첨부파일</td>
								<td><a href="#">2020년 상반기 매출자료.xls</a> <span>7회 다운로드</span></td>
							</tr>
							<tr>
								<td>내용</td>
								<td><textarea name="content" readonly></textarea></td>
							</tr>
						</tbody>
					</table>
					<div>
						<a href="#" class="btnDelete">삭제</a> 
						<a href="./modify.jsp?group=<%=group %>&cate=<%=cate %>" class="btnModify">수정</a>
						<a href="./list.jsp?group=<%=group %>&cate=<%=cate %>" class="btnList">목록</a>
					</div>
					<!--  댓글 리스트 -->
				<section class="commentList">
					<h3>댓글목록</h3>
			
					<article class="comment">
						<form action="/Jboard1/proc/commentUpdate.jsp" method="post">
							<input type="hidden" name="no" value=""> <input
								type="hidden" name="parent" value=""> <span> <span></span>
								<span></span>
							</span>
							<textarea name="comment" readonly></textarea>
							<div>
								<a href="#" class="del">삭제</a>
									<!-- id는 중복되면 안되기에 class사용 (현재 for 반복문에 위치) -->
									<a href="#" class="can">취소</a> 
									<a href="" class="mod">수정</a>
								</div>
							</form>
						</article>
						<p class="empty">등록된 댓글이 없습니다.</p>
					</section>
					<section class="commentForm">
						<h3>댓글쓰기</h3>
						<form action="/Jboard1/proc/commentProc.jsp" method="post">
							<input type="hidden" name="parent" value="" /> <input type="hidden"
								name="writer" value="" />
							<textarea name="content"></textarea>
							<div>
								<a href="#" class="btnCancel">취소</a> <input type="submit"
									class="btnWrite" value="작성완료" />
							</div>
						</form>
					</section>
				</article>
			</section>
		</form>
	</article>
</section>
<%@ include file="../_footer.jsp"%>
