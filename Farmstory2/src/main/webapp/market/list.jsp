<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<div id="sub">
    <div><img src="../images/sub_top_tit2.png" alt="MARKET"></div>
    <section class="market">
        <aside>
            <img src="../images/sub_aside_cate2_tit.png" alt="장보기"/>

            <ul class="lnb">
                <li class="on"><a href="./list.do">장보기</a></li>
            </ul>
        </aside>
        <article class="list">
            <nav>
                <img src="../images/sub_nav_tit_cate2_tit1.png" alt="장보기"/>
                <p>
                    HOME > 장보기 > <em>장보기</em>
                </p>
            </nav>

            <!-- 내용 시작 -->
			 <c:choose>
			    <c:when test="${type eq '0'}">
			        <c:set var="totalLabel" value="(${total})" />
			    </c:when>
			    <c:when test="${type eq '1'}">
			        <c:set var="totalLabel" value="(${total})" />
			    </c:when>
			        <c:when test="${type eq '2'}">
			        <c:set var="totalLabel" value="(${total})" />
			    </c:when>
			        <c:when test="${type eq '3'}">
			        <c:set var="totalLabel" value="(${total})" />
			    </c:when>
			</c:choose>
			
			<p class="sort">
			    <c:forEach var="i" begin="0" end="3">
			        <c:set var="typeValue" value="${i}" />
			        <c:set var="isActive" value="${type eq i}" />
			
			        <a href="/Farmstory2/market/list.do?type=${i}" class="${isActive ? 'on' : ''}">
			            <c:choose>
			                <c:when test="${i eq 0}">전체</c:when>
			                <c:when test="${i eq 1}">과일</c:when>
			                <c:when test="${i eq 2}">야채</c:when>
			                <c:when test="${i eq 3}">곡류</c:when>
			            </c:choose>
			            <c:out value="${isActive ? totalLabel : ''}" />
			            <c:if test="${i ne 3}">|</c:if>
			        </a>
			    </c:forEach>
			</p>
            <table border="0">
            <c:forEach var="product" items="${products}" >
                <tr>
                    <td>
                        <a href="/Farmstory2/market/view.do?pNo=${product.pNo}"><img src="/Farmstory2/thumb/${product.thumb1}" alt="사과 500g"></a>
                    </td>
                    <td>
                    <c:choose>
					    <c:when test="${product.type eq 1}">과일</c:when>
					    <c:when test="${product.type eq 2}">야채</c:when>
					    <c:when test="${product.type eq 3}">곡물</c:when>
					    <c:otherwise></c:otherwise>
					</c:choose>
                    </td>
                    <td><a href="#">${product.pName }</a></td>
                    <td><strong>${product.getPriceWithComma()}</strong>원</td>
                </tr>
             </c:forEach> 
            </table>

            <p class="paging">
	             <c:if test="${pageGroupStart > 1}">
			        <a href="/Farmstory2/market/list.do?type=${type}&pg=${pageGroupStart - 1}" class="prev">이전</a>
			    </c:if>
			    
			    <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}" step="1">
			        <c:set var="isCurrent" value="${currentPage == i}"/>
			        <a href="/Farmstory2/market/list.do?type=${type}&pg=${i}" class="num ${isCurrent ? 'current' : ''}"> ${i} </a>
			    </c:forEach>
			    
			    <c:if test="${pageGroupEnd < lastPageNum}">
			        <a href="/Farmstory2/market/list.do?type=${type}&pg=${pageGroupEnd + 1}" class="next">다음</a>
			    </c:if>
            </p>

            <!-- 내용 끝 -->

        </article>
    </section>
</div>
<%@ include file="../_footer.jsp" %>