<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<script>


	$(function(){
		
		$('#btnBuy').click(function(e){
			e.preventDefault();
			$('#formOrder').submit();
		});
		
		$('#btnShopping').click(function(e){
			e.preventDefault();
			if(confirm("주문을 취소하시겠습니까?")){
				location.href='/Farmstory2/market/list.do';
			}
		});
	});
</script>
        <div id="sub">
            <div><img src="../images/sub_top_tit2.png" alt="MARKET"></div>
            <section class="market">
                <aside>
                    <img src="../images/sub_aside_cate2_tit.png" alt="장보기"/>

                    <ul class="lnb">
                        <li class="on"><a href="./list.do">장보기</a></li>
                    </ul>
                </aside>
                <article class="order">
                    <nav>
                        <img src="../images/sub_nav_tit_cate2_tit1.png" alt="장보기"/>
                        <p>
                            HOME > 장보기 > <em>장보기</em>
                        </p>
                    </nav>

                    <!-- 내용 시작 -->
                    <h3>주문상품 확인</h3>
                    <div class="info">
                        <img src="/Farmstory2/thumb/${thumb2}" alt="${pName}">
                        <table border="0">                            
                            <tr>
                                <td>상품명</td>
                                <td>${pName}</td>
                            </tr>
                            <tr>
                                <td>상품코드</td>
                                <td>${pNo}</td>
                            </tr>
                            <tr>
                                <td>배송비</td>
                                <td class="delivery">
	                                <c:choose>
	                                	<c:when test="${total < 30000 }">
	                                		<fmt:formatNumber value="${delivery}" pattern="#,###"/>원
	                                	</c:when>
	                                	<c:otherwise>
				                                <span>0원</span>	
	                                	</c:otherwise>
	                                </c:choose>
                                </td>
                            </tr>
                            <tr>
                                <td>판매가격</td>
                                <td><fmt:formatNumber value="${price}" pattern="#,###"/>원</td>
                            </tr>
                            <tr>
                                <td>구매수량</td>
                                <td class="count">${count}개</td>
                            </tr>
                      			<tr>
								    <td>합계</td>
								    <c:choose>
								        <c:when test="${total >= 30000}">
								            <c:set var="finalPrice" value="${total - delivery}" />
								        </c:when>
								        <c:otherwise>
								            <c:set var="finalPrice" value="${total + delivery}" />
								        </c:otherwise>
								    </c:choose>
								    <td class="total">
								        <fmt:formatNumber value="${finalPrice}" pattern="#,###" var="formattedFinalPrice" />
								        <c:out value="${formattedFinalPrice}원" />
								    </td>
								</tr>
			             </table>
                    </div>
                    <h3>주문정보 입력</h3>
                    <div class="shipping">
                    	<form id="formOrder" action="/Farmstory2/market/orderComplete.do" method="POST">
			                <input type="hidden" name="orderProduct" value="${pNo}"/>
			                <input type="hidden" name="orderCount" value="${count}"/>
			                <input type="hidden" name="orderDelivery" value="${delivery}"/>
			                <input type="hidden" name="orderPrice" value="${price}"/>
			                <input type="hidden" name="orderTotal" value="${finalPrice}"/>
			                <input type="hidden" name="orderUser" value="${sessUser.uid}"/>
	                        <table>
	                        	<tr>
									<td>주문자</td>
									<td><input type="text" readonly value="${sessUser.name }"></td>
								</tr>
	                            <tr>
	                                <td>받는분</td>
	                                <td><input type="text" name="receiver" value="${sessUser.name}"></td>
	                            </tr>
	                            <tr>
	                                <td>휴대폰</td>
	                                <td><input type="text" name="hp" value="${sessUser.hp}"></td>
	                            </tr>
	                            <tr>
	                                <td>배송주소</td>
	                                <td>
	                                    <input type="text" name="zip" readonly value="${sessUser.zip }"><button id="btnZip">우편번호 검색</button>
	                                    <input type="text" name="addr1" value="${sessUser.addr1}">
	                                    <input type="text" name="addr2" value="${sessUser.addr2}">
	                                </td>
	                            </tr>
	                            <tr>
	                                <td>기타</td>
	                                <td>
	                                    <textarea name="etc"></textarea>
	                                </td>
	                            </tr>
	                        </table>
                        </form>
                    </div>

                    <p>
                        <a href="#" id="btnBuy"><img src="../images/market_btn_buy.gif" alt="구매하기"></a>
                        <a href="#" id="btnShopping"><img src="../images/market_btn_shopping.gif"></a>
                    </p>
                    <!-- 내용 끝 -->
                    
                </article>
            </section>

        </div>
<%@ include file="../_footer.jsp" %>