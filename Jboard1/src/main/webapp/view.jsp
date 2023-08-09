<%@page import="java.util.List"%>
<%@page import="kr.co.jboard1.dao.ArticleDAO"%>
<%@page import="kr.co.jboard1.dto.ArticleDTO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "./_header.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	String no = request.getParameter("no");
	
	ArticleDAO dao = new ArticleDAO();
	
	// 원글 조회
	ArticleDTO article = dao.selectArticle(no);
	
	
	// 댓글 조회
	List<ArticleDTO> comments = dao.selectComments(no);
	
	
%>
<script>
	
	$(function(){
	
		$('.del').click(function(){
			
			const result = confirm('정말 삭제 하시겠습니까?');
			
			if(result){
				return true;
			}else{
				return false;
			}
			
		});
	});

</script>
        <main>
            <section class="view">
                <h3>글보기</h3>
                <article>
                        <table border="1">
                            <tbody>
                                <tr>
                               <td>제목</td>
                                    <td><input type="text" name="title" value="<%=article.getTitle() %>"></td>
                                </tr>
                                <% if(article.getFile() > 0) {%>
                                <tr>
                                    <td>첨부파일</td>
                                    <td><input type="text" name="title" value="2020년 상반기 매출자료.xls 7회 다운로드" ></td>
                                </tr>
                                <% } %>
                            
                                <tr>
                                    <td>내용</td>
                                    <td><textarea name="content" readonly><%=article.getContent() %></textarea></td>
                                </tr>
                            </tbody>
                        </table>
                        <div>
                            <a href="#" class="btnDelete">삭제</a>
                            <a href="./modify.jsp" class="btnModify">수정</a>
                            <a href="/Jboard1/list.jsp" class="btnList">목록</a>
                        </div>
                        
                        <!--  댓글 리스트 -->
                        <section class="commentList">
                            <h3>댓글목록</h3>
		                     <% for(ArticleDTO comment : comments){%>       
                            <article class="comment">
                                <span>
                                    <span><%= comment.getNick() %></span>
                                    <span><%= comment.getRdate() %></span>
                                    <span>20-05-13</span>
                                </span>
                                <textarea name="comment" readonly><%= comment.getContent()%></textarea>
                                
                                <% if(sessUser.getUid().equals(comment.getWriter())){ %>
                                <div>
                                    <a href="/Jboard1/proc/commentDelete.jsp?no=<%=comment.getNo() %>" class="del">삭제</a> <!-- id는 중복되면 안되기에 class사용 (현재 for 반복문에 위치) -->
                                    <a href="#" class="mod">수정</a>
                                </div>
                                <% } %>
                            </article>
                            <% } %>
                            
                            <% if(comments.isEmpty()){ %>
                            <p class="empty">등록된 댓글이 없습니다.</p>
                            <% } %>
                        </section>
                        <section class="commentForm">
                            <h3>댓글쓰기</h3>
                            <form action="/Jboard1/proc/commentProc.jsp" method="post">
                            	<input type="hidden" name="parent" value="<%= no %>"/>
                            	<input type="hidden" name="writer" value="<%=sessUser.getUid() %>"/>
                                <textarea name="content"></textarea>
                                <div>
                                    <a href="#" class="btnCancel">취소</a>
                                    <input type="submit" class="btnWrite" value="작성완료">
                                </div>
                            </form>
                        </section>
                </article>
            </section>
        </main>
<%@ include file = "./_footer.jsp" %>