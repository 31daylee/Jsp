<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp"%>
<div id="sub">
	<div class="bg">
		<img src="/Farmstory1/images/sub_top_tit3.png" alt="CROP TALK">
	</div>
	<section class="croptalk">
		<aside>
			<img src="/Farmstory1/images/sub_aside_cate3_tit.png" alt="팜스토리소개">
			<ol class="lnb">
				<li class="on"><a href="#">농작물이야기</a></li>
				<li><a href="/Farmstory1/croptalk/grow.jsp">텃밭가꾸기</a></li>
				<li><a href="/Farmstory1/croptalk/school.jsp">귀농학교</a></li>
			</ol>
		</aside>
		<article class="content">
			<nav>
				<img src="/Farmstory1/images/sub_nav_tit_cate3_tit1.png"
					alt="농작물이야기">
				<p>
					HOME > 팜스토리소개 > <strong>농작물이야기</strong>
				</p>
			</nav>
			<!-- 컨텐츠 시작-->


			<!--게시물 목록-->
			<%-- <section class="list">
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
								<td><a href="#">&nbsp;연습입니다[3]</a></td>
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
				<a href="/Jboard1/write.jsp" class="btnWrite">글쓰기</a>
			</section>--%>
			<!-- 컨텐츠 끝-->
			<section class="write">
				<h3>글쓰기</h3>
				<article>
					<form action="/Jboard1/proc/writeProc.jsp" method="post">
						<input type="hidden" name="writer" readonly value="" />
						<table border="1">
							<tbody>
								<tr>
									<td>제목</td>
									<td><input type="text" name="title" required="required"
										placeholder="제목을 입력하세요."></td>
								</tr>
								<tr>
									<td>내용</td>
									<td><textarea name="content" required="required"></textarea></td>
								</tr>
								<tr>
									<td>첨부</td>
									<td><input type="file" name="file"></td>
								</tr>
							</tbody>
						</table>
						<div>
							<a href="./list.jsp" class="btnCancel">취소</a> <input
								type="submit" class="btnWrite" value="작성완료">
						</div>
					</form>
				</article>
			</section>
			<!-- 내용 끝 -->
		</article>
	</section>
</div>
<%@ include file="../_footer.jsp"%>