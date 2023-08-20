<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp"%>
<%
	UserDTO dto = new UserDTO();
	UserDAO.getInstance().updateUser(dto);

%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/Farmstory1/js/zipcode.js"></script>
<!--<script src="/Farmstory1/js/validation.js"></script> 
<script src="/Farmstory1/js/checkUser.js"></script>-->
<main>
	<section id="user" class="register">
		<form id="UserMyPage" action="/Farmstory1/user/myPageProc.jsp" method="post">
			<table border="1">
				<caption>사이트 이용정보 입력</caption>
				<tbody>
					<tr>
						<td>아이디</td>
						<td>
							<input type="text" name="uid" value="<%= sessUser.getUid() %>" readonly/>
						</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="pass1" placeholder="비밀번호 입력"></td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td><input type="password" name="pass2"
							placeholder="비밀번호 확인 입력 "> <span class="resultPass"></span>
						</td>
					</tr>
				</tbody>
			</table>
			<table border="1">
				<caption>개인정보 입력</caption>
				<tbody>
					<tr>
						<td>이름</td>
						<td><input type="text" name="name" value="<%= sessUser.getName()%>"/>
							<span class="resultName"></span></td>
					</tr>
					<tr>
						<td>별명</td>
						<td>
							<p>공백없이 한글, 영문, 숫자만 입력가능</p> <input type="text" name="nick"
							value="<%= sessUser.getNick()%>"> <span class="resultNick"></span>
						</td>
					</tr>
					<tr>
						<td>E-Mail</td>
						<td><input type="text" name="email" value="<%= sessUser.getEmail()%>"/>
							<span id="resultEmail"></span></td>
					</tr>
					<tr>
						<td>휴대폰</td>
						<td>
							<input type="text" name="hp" minlength="13" maxlength="13" value="<%= sessUser.getHp()%>"/>
							<span id="resultHp"></span>
						</td>
					</tr>
					<tr>
						<td>주소</td>

						<td>
							<div>
								<input type="text" name="zip" value="<%= sessUser.getZip()%>"/>
								<button type="button" class="btnZip" onclick="zipcode()">
									<img src="/Farmstory1/images/chk_post.gif" alt="우편번호찾기">
								</button>
							</div>
							<div>
								<input type="text" name="addr1"  value="<%= sessUser.getAddr1()%>"
									readonly>
							</div>
							<div>
								<input type="text" name="addr2"  value="<%= sessUser.getAddr2()%>">
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<div>
				<a href="/Farmstory1/user/login.jsp" class="btnCanel">취소</a> <input
					type="submit" class="btnJoin" value="수정완료" />
			</div>
		</form>
	</section>
</main>
<%@ include file="../_footer.jsp"%>