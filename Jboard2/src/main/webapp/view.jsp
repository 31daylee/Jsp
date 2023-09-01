<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./_header.jsp" %>
<script>

	$(function(){
		
		// 댓글 삭제(정적 이벤트 연결로 동적 댓글업로드 시 그 댓글에는 적용이 안되는 에러가 있다)
		/*$('.remove').click(function(e){
			e.preventDefault();
			
			alert('삭제!');
			
			
		})*/
		
		// 댓글 삭제(동적 생성 이벤트 구현_또 다시 서버에 요청하는 게 아니라 클라이언트 화면측에서 모든 처리를 함-> 새로고침같은 재로딩이 없다)
		$(document).on( 'click','.remove', function(e){
			e.preventDefault();
			
			const no = $(this).data('no');
			const article = $(this).parent().parent();
			
			
			
			console.log('no : '+ no);
			
			const jsonData = {
					"kind":"REMOVE",
					"no": no
			}
			
			$.ajax({
				url: '/Jboard2/comment.do', 
				type: 'GET',
				data: jsonData,
				dataType: 'json',
				success: function(data){
					
					if(data.result > 0){
						alert('댓글이 삭제되었습니다.');
					
						// 화면처리
						article.remove();
					
					
					}
					
					
				}
			})
		});
		
		
		// 댓글 입력
		$('#btnComment').click(function(e){
			e.preventDefault();
			
			const parent = $('#formComment > input[name=parent]').val();
			const content = $('#formComment > textarea[name=content]').val();
			const writer = $('#formComment > input[name=writer]').val();
			
			const jsonData = {
				"parent": parent,	
				"content": content,
				"writer": writer
			};
			
			console.log('jsonData : '+ jsonData);
			
			$.ajax({
				url: '/Jboard2/comment.do',
				type: 'post',
				data: jsonData,
				dataType: 'json',
				success: function(data){
					
					console.log(data);
					if(data.result > 0){
						alert('댓글이 등록되었습니다.');
						
						// 동적 화면 생성
						const dt = new Date();
						const year = dt.getFullYear().toString().substr(2, 2); 
						const month = (dt.getMonth() + 1).toString().padStart(2, '0'); 
						const date = dt.getDate().toString().padStart(2, '0')
						const now = year + "-" + month + "-" + date;
					
						
						
						
						const article = `<article>
											<span class='nick'>${sessUser.nick}</span>
											<span class='date'>`+now+`</span>
											<p class='content'>`+content+`</span>
											<div>
												<a href="#" class='remove'>삭제</a>
												<a href="#" class='modify'>수정</a>
											<div>
										<article>`;
						
						$('.commentList').append(article);
						
					}else{
						alert('댓글이 등록이 실패했습니다.');
					}
					
					
				}
				
			})
			
		})
		
	});

</script>
<main id="board">
    <section class="view">
        <table border="0">
            <caption>글보기</caption>
            <tr>
                <th>제목</th>
                <td><input type="text" name="title" value="${dto.getTitle()}" readonly/></td>
            </tr>
			<c:if test="${dto.getFile() > 0}">
			    <tr>
			        <th>파일</th>
			        <td>
			        	<a href="/Jboard2/fileDownload.do?fno=${dto.fileDto.fno}">${dto.fileDto.ofile}</a>&nbsp;
			        	<span>${dto.fileDto.download}</span>회 다운로드
			        </td>
			    </tr>
			</c:if>
            <tr>
                <th>내용</th>
                <td>
                    <textarea name="content" readonly>${dto.content}</textarea>
                </td>
            </tr>                    
        </table>
        
        <div>
            <a href="/Jboard2/delete.do?no=${dto.no}" class="btn btnRemove">삭제</a>
            <a href="/Jboard2/modify.do?no=${dto.no}" class="btn btnModify">수정</a>
            <a href="/Jboard2/list.do" class="btn btnList">목록</a>
        </div>

        <!-- 댓글목록 -->
        <section class="commentList">
            <h3>댓글목록</h3>                   
 			<c:forEach var="comment" items="${comments}">
			    <article>
			    	<input type="hidden" name ="no" value="${comment.no}">
	                <input type="hidden" name ="parent" value="${comment.parent}">
			       	<span>
			        	<span class="nick">${comment.nick}</span>
			        	<span class="date">${comment.rdate}</span>
			        </span>
			        <p class="content">${comment.content}</p>
			                                
			        <c:if test="${sessUser.uid eq comment.writer}">
			            <div>
			                <a href="#" class="remove" data-no="${comment.no}">삭제</a> <!-- a태그는 value 속성이 없기때문에 사용자 정의 속성이 필요하다 -> data-로 시작 -->
			                <a href="#" class="modify">수정</a>
			            </div>
			        </c:if>
			    </article>
			</c:forEach>
			<c:if test="${comments.isEmpty()}">
            <p class="empty">등록된 댓글이 없습니다.</p>
			</c:if>
        </section>

        <!-- 댓글쓰기 -->
        <section class="commentForm">
            <h3>댓글쓰기</h3>
            <form id="formComment" action="#" method="post">
            	<input type="hidden" name="parent" value="${dto.no}"/>
                <input type="hidden" name="writer" value="${sessUser.uid}"/>
                <textarea name="content"></textarea>
                <div>
                    <a href="#" class="btn btnCancel">취소</a>
                    <input type="submit" id="btnComment" value="작성완료" class="btn btnComplete"/>
                </div>
            </form>
        </section>

    </section>
</main>
<%@ include file="./_footer.jsp" %>