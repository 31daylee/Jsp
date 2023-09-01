<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
<script src="/Jboard2/js/authEmail.js"></script>
<script src="/Jboard2/js/validation.js"></script>
<script>
	
		$(function(){
			
			$('.btnNext').click(function(e){
				e.preventDefault();
				
				if(isEmailOk){
					$('#formFindId').submit();
				}else{
					alert('이메일 인증을 수행하셔야 합니다.');
				}
			});
		});
</script>

<main id="user">
    <section class="find findId">
        <form id="formFindId" action="/Jboard2/user/findIdResult.do" method="POST">
        	<input type="hidden" name="type" value="FIND_ID">
            <table border="0">
                <caption>아이디 찾기</caption>
                <tr>
                    <td>이름</td>
                    <td><input type="text" name="name" placeholder="이름 입력"/></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td>
                        <div>
                            <input type="email" name="email" placeholder="이메일 입력"/>
                            <button type="button" id="btnEmailCode" class="btnAuth">인증번호 받기</button>
                            <span class="resultEmailForId"></span>
                        </div>
                        <div>
                            <input type="text" name="auth" disabled placeholder="인증번호 입력"/>
                            <button type="button" id="btnEmailAuth" class="btnConfirm">확인</button>
                        </div>
                    </td>
                </tr>                        
            </table>                                        
        </form>
        
        <p>
            회원가입시 이메일 주소와 입력한 이메일 주소가 같아야, 인증번호를 받을 수 있습니다.<br>
            인증번호를 입력 후 확인 버튼을 누르세요.
        </p>

        <div>
            <a href="/Jboard2/user/login.do" class="btn btnCancel">취소</a>
            <a href="#" class="btn btnNext">다음</a>
        </div>
    </section>
</main>
<%@ include file="./_footer.jsp" %>