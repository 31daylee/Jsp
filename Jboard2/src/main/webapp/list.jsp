<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./_header.jsp" %>
<main id="board">
    <section class="list">                
        <form action="/Jboard2/list.do" method="get">
            <input type="text" name="search" placeholder="제목 키워드 검색">
            <input type="submit" value="검색">
        </form>
        <table border="0">
            <caption>글목록</caption>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>글쓴이</th>
                <th>날짜</th>
                <th>조회</th>
            </tr> 
            <c:forEach var="article" items="${articles}" varStatus="loopStatus">               
            <tr>
                <td>${pageStartNum-loopStatus.index}</td>
              	<td><a href="./view.do?no=${article.no}">${article.getTitle()}[${article.getComment()}]</a></td>
                <td>${article.getNick()}</td>
                <td>${article.getRdate()}</td>
                <td>${article.getHit()}</td>
            </tr>
            </c:forEach>
        </table>
        <div class="page">
        	<c:if test="${pageGroupStart > 1 }">
            <a href="/Jboard2/list.do?pg=${pageGroupStart - 1}" class="prev">이전</a>
            </c:if>
           	<c:forEach begin="${pageGroupStart}" end="${pageGroupEnd}" var="i">
   			<a href="/Jboard2/list.do?pg=${i}" class="num ${currentPage == i ? 'current' : ''}">${i}</a>
			</c:forEach>
			<c:if test="${pageGroupEnd lt lastPageNum }">
            <a href="/Jboard2/list.do?pg=${pageGroupEnd + 1}" class="next">다음</a>
            </c:if>
        </div>
        <a href="./write.do" class="btn btnWrite">글쓰기</a>
    </section>
</main>
<%@ include file="./_footer.jsp" %>
