<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<jsp:include page="./_aside${group}.jsp"/>
			<section class="modify">
			    <h3>글수정</h3>
			    <article>
			        <form action="/Farmstory2/board/modify.do?group=${group}&cate=${cate}&no=${dto.no}" method="post">
			         <input type="hidden" name="no" value="${dto.no}">
			            <table>
			                <tr>
			                    <td>제목</td>
			                    <td><input type="text" name="title" value="${dto.title }" placeholder="제목을 입력하세요."/></td>
			                </tr>
			                <tr>
			                    <td>내용</td>
			                    <td>
			                        <textarea name="content">${dto.content }</textarea>
			                    </td>
			                </tr>
			                <tr>
			                    <td>첨부</td>
			                    <td>
			                    <input type="file" name="file" />
			                    	<span>${dto.fileDto.oriName}</span>
			                         <span class="delete-icon">
							            <img src="/Farmstory2/images/delete-key-line-logo.jpg" alt="Delete">
							        </span>
			                    </td>
			                </tr>
			            </table>
			            <div>
			                <a href="./list.do?group=${group}&cate=${cate}" class="btnCancel">취소</a>
			                <input type="submit"  class="btnWrite" value="수정완료">
			            </div>
			        </form>
			    </article>
			</section>
			<!-- 내용 끝 -->
        </article>
    </section>
</div>			
<%@ include file="../_footer.jsp" %>