<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<div id="user">
<section id="user" class="terms">
		<table>
			<caption>사이트 이용약관</caption>
			<tbody>
				<tr>
					<td>
						<textarea readonly>${dto.terms}</textarea>
						<p>
							<label><input type="checkbox" name="chk1">동의합니다.</label>
						</p>
					</td>
				</tr>
			</tbody>
		</table>
		<table>
			<caption>개인정보 취급방침</caption>
			<tbody>
				<tr>
					<td>
						<textarea readonly>${dto.privacy}</textarea>
						<p>
							<label><input type="checkbox" name="chk2">동의합니다.</label>
						</p>
					</td>
				</tr>
			</tbody>
		</table>
		<div>
			<a href="/Farmstory2/user/login.do" class="btnCancel">취소</a> <a
				href="/Farmstory2/user/register.do" class="btnNext">다음</a>
		</div>
	</section>
</div>
<%@ include file="../_footer.jsp" %>