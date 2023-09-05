<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<script src="/Farmstory2/js/comment.js"></script>
<jsp:include page="./_aside${group}.jsp"/>
			<section class="view">
			    <h3>글보기</h3>
			    <table>
			        <tr>
			            <td>제목</td>
			            <td><input type="text" name="title" value="${dto.title }" readonly/></td>
			        </tr>
			        <c:if test="${dto.getFile() > 0}">
			        <tr>
			            <td>첨부파일</td>
			            <td>
			                <a href="/Farmstory2/board/fileDownload.do?fno=${dto.fileDto.fno}">${dto.fileDto.oriName }</a>
			                <span>[${dto.fileDto.download}]</span>
			            </td>
			        </tr>
			        </c:if>
			        <tr>
			            <td>내용</td>
			            <td>
			                <textarea name="content" readonly>${dto.content}</textarea>
			            </td>
			        </tr>
			    </table>
			    <div>
			        <a href="/Farmstory2/board/delete.do?no=${dto.no }" class="btnDelete">삭제</a>
			        <a href="/Farmstory2/board/modify.do?no=${dto.no }" class="btnModify">수정</a>
			        <a href="/Farmstory2/board/list.do" class="btnList">목록</a>
			    </div>
			    
			    <!-- 댓글리스트 -->
			    <section class="commentList">
			        <h3>댓글목록</h3>
			        <c:forEach var="comment" items="${comments}">
			        <article class="comment">
			        	<input type="hidden" name ="no" value="${comment.no}">
	                	<input type="hidden" name ="parent" value="${comment.parent}">
							<span>
								<span class="nick">${comment.nick}</span>
								<span class="date">${comment.rdate}</span>
							</span>
							<textarea name="content" readonly>${comment.content}</textarea>
			             	<c:if test="${sessUser.uid eq comment.writer}">
							<div>
								<a href="#" class="del" data-no="${comment.no}">삭제</a>
								<a href="./list.do?group=${group}&cate=${cate}" class="can">취소</a>
								<a href="./modify.do?group=${group}&cate=${cate}" class="mod">수정</a>
							</div>
							 </c:if>                
			        </article>
			        </c:forEach>
			        <c:if test="${comments.isEmpty()}">
			        <p class="empty">등록된 댓글이 없습니다.</p>
			        </c:if>
			    </section>
			
			    <!-- 댓글입력폼 -->
			    <section class="commentForm">
			        <h3>댓글쓰기</h3>
			        <form id="formComment"action="#" method="post">
			        	<input type="hidden" name="parent" value="${dto.no}"/>
                		<input type="hidden" name="writer" value="${sessUser.uid}"/>
			            <textarea name="content"></textarea>
			            <div>
			                <a href="#" class="btnCancel">취소</a>
			                <input type="submit" id="btnComment"class="btnWrite" value="작성완료"/>
			            </div>
			        </form>
			    </section>
			</section>
			<!-- 내용 끝 -->
        </article>
    </section>
</div>			
<%@ include file="../_footer.jsp" %>