$(function(){
		
		const inputUid = document.getElementsByName('uid')[0];
		const resultId = document.getElementsByClassName('resultId')[0];
		const btnCheckUid = document.getElementById('btnCheckUid');
		
		if(btnCheckUid != null){
			btnCheckUid.onclick = function(){
				
				const uid = inputUid.value;
				
				// 아이디 유효성 검사
				if(!uid.match(reUid)){
					resultId.innerText = '유효한 아이디가 아닙니다.';
					resultId.style.color = 'red';
					isUidOk = false;
					return;
					
				}
				
				// 서버전송
				const xhr = new XMLHttpRequest();
				xhr.open('GET', '/Farmstory2/user/checkUid.do?uid='+uid);
				xhr.send();
				
				xhr.onreadystatechange = function(){
					
					if(xhr.readyState == XMLHttpRequest.DONE){
						if(xhr.status == 200){
							const data = JSON.parse(xhr.response);
							
							if(data.result > 0){
								resultId.innerText = '이미 사용중인 아이디 입니다.';
								resultId.style.color = 'red';
								isUidOk = false;
							}else{
								resultId.innerText = '사용 가능한 아이디 입니다.';
								resultId.style.color = 'green';
								isUidOk = true;
							}
						}
						
					}// readyState end
				}// onreadystatechange end
			}// btnCheckUid onclick end
		}
		
		// 닉네임 중복체크 
		$('#btnCheckNick').click(function(){
			console.log('nick...1');
			
			const nick = $('input[name=nick]').val();
			
			// 별명 유효성 검사
			if(!nick.match(reNick)){
				$('.resultNick').css('color','red').text('유효한 별명이 아닙니다.');
				isNickOk = false;
				return;
			}
			
			$.ajax({
				url:'/Farmstory2/user/checkNick.do?nick='+nick,
				type:'get',
				dataType:'json',
				success: function(data){
					
					if(data.result > 0){
						$('.resultNick').css('color', 'red').text('이미 사용중인 별명입니다.');
						isNickOk = false;
					}else{
						$('.resultNick').css('color', 'green').text('사용 가능한 별명입니다.');
						isNickOk = true;
					}
				}
			})
			
			
		})// btnCheckNick end
		
		// 휴대폰 중복체크 
		$('input[name=hp]').focusout(function(){
			console.log('hp...1');
			
			const hp = $(this).val();
			
			// 별명 유효성 검사
			if(!hp.match(reHp)){
				$('resultHp').css('color','red').text('전화번호가 유효하지 않습니다.');
				isHpOk = false;
				return;
			}
			const url = '/Farmstory2/user/checkHp.do?hp='+hp;
			
			$.get(url, function(result){
				
				const data = JSON.parse(result);
				
				if(data.result > 0){
					$('#resultHp').css('color', 'red').text('이미 사용중인 휴대폰입니다.');
					isHpOk = false;
				}else{
					$('#resultHp').css('color', 'green').text('사용 가능한 휴대폰입니다.');
					isHpOk = true;
				}
				
			})
			
			
		})// btnCheckNick end
	})

