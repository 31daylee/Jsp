<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
        <main>
        <%@ include file="./_aside.jsp" %>
            <section id="productList">
                <nav>
                    <h3>상품목록</h3>
                </nav>
                <article>
                    <table border="0">
                        <tr>
                            <th><input type="checkbox" name="all"/></th>
                            <th>사진</th>
                            <th>상품번호</th>
                            <th>상품명</th>
                            <th>구분</th>
                            <th>가격</th>
                            <th>재고</th>
                            <th>등록일</th>
                        </tr>
                        <c:forEach var="product" items="${products}">
                        <tr>
                            <td><input type="checkbox" name="products"/></td>
                            <td><img src="/Farmstory2/thumb/${product.thumb1}" class="thumb1" alt="${product.pName}"></td>
                            <td>${product.pNo}</td>
                            <td>${product.pName}</td>
                            <td>${product.type}</td>
                            <td>${product.getPriceWithComma()}원</td>
                            <td>${product.stock}</td>
                            <td>${product.getRdateWithoutTime()}</td>
                        </tr>
                      </c:forEach>
                    </table>

                    <p>
                        <a href="#" class="productDelete">선택삭제</a>
                        <a href="./productRegister.do" class="productRegister">상품등록</a>
                    </p>
                    
                    <p class="paging">
                       <c:if test="${pageGroupStart > 1}">
					        <a href="./productList.do?pg=${pageGroupStart - 1}" class="prev">이전</a>
					    </c:if>
					    <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}" step="1">
					        <c:set var="isOn" value="${currentPage == i}"/>
					        <a href="./productList.do?pg=${i}" class="num ${isOn ? 'on' : ''}"> [${i}] </a>
					    </c:forEach>
					    <c:if test="${pageGroupEnd < lastPageNum}">
					        <a href="./productList.do?pg=${pageGroupEnd + 1}" class="next">다음</a>
					    </c:if>
                    </p>
                </article>
            </section>
        </main>
<%@ include file="./_footer.jsp" %>