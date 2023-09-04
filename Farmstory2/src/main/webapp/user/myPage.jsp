<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../_header.jsp" %>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<div id="user">
	<section class="register">
        <form id="formUser" action="/Farmstory2/user/register.do" method="post">
            <table border="1">
                <caption>마이페이지</caption>
                <tr>
                    <td>아이디</td>
                    <td>
                        <input type="text" name="uid" />
                        <button type="button" id="btnCheckUid"><img src="/Farmstory2/images/chk_id.gif" alt=""></button>
                        <span class="resultId"></span>
                    </td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td>
                        <input type="password" name="pass1"/>                            
                    </td>
                </tr>
                <tr>
                    <td>비밀번호 확인</td>
                    <td>
                        <input type="password" name="pass2" />
                        <span class="resultPass"></span>
                    </td>
                </tr>
            </table>
            <table border="1">
                <caption>개인정보 조회</caption>
                <tr>
                    <td>이름</td>
                    <td>
                        <input type="text" name="name" />
                        <span class="resultName"></span>
                    </td>
                </tr>
                <tr>
                    <td>별명</td>
                    <td>
                        <input type="text" name="nick" />
                        <button type="button" id="btnCheckNick"><img src="/Farmstory2/images/chk_id.gif" alt=""></button>
                        <span class="resultNick"></span>                            
                    </td>
                </tr>
                <tr>
                    <td>E-Mail</td>
                    <td>
                        <input type="email" name="email" />
                        <button type="button" id="btnEmailCode"><img src="../images/chk_auth.gif" alt="인증번호 받기"/></button>
                        <span id="resultEmail"></span>
                        <div class="auth">
                            <input type="text" name="auth"/>
                            <button type="button" id="btnEmailAuth"><img src="../images/chk_confirm.gif" alt="확인"/></button>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>휴대폰</td>
                    <td>
                        <input type="text" name="hp"  minlength="13" maxlength="13" />
                        <span id="resultHp"></span>
                    </td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td>
                        <div>
                            <input type="text" name="zip" placeholder="우편번호" readonly/>                                
                            <button type="button" class="btnZip" onclick="zipcode()"><img src="/Farmstory2/images/chk_post.gif" alt=""></button>
                        </div>                            
                        <div>
                            <input type="text" name="addr1" readonly/>
                        </div>
                        <div>
                            <input type="text" name="addr2" />
                        </div>
                    </td>
                </tr>
            </table>

            <div>
                <a href="/Farmstory2/" class="btnCancel">취소</a>
                <input type="submit" class="btnSubmit" value="수정완료"/>
            </div>    
        </form>
    </section>
</div>
<%@ include file="../_footer.jsp" %>