/**
 * 댓글 관리 
 * 
*/
$(function(){
	
	
	
	// 댓글 입력
	$('#btnComment').click(function(e){
		e.preventDefault();
		
		const parent = $('#formComment > input[name=parent]').val();
		const content = $('#formComment > textarea[name=content]').val();
		const writer = $('#formComment > input[name=writer]').val();
		const nick = $('#formComment > input[name=nick]').val();
		
		const jsonData = {
			"parent": parent,	
			"content": content,
			"writer": writer,
			"nick": nick
		};
		
		console.log('jsonData : '+ jsonData);
		
		$.ajax({
			url: '/Farmstory2/board/comment.do',
			type: 'post',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				
				console.log(data);
				if(data.result > 0){
					alert('댓글이 등록되었습니다.');
					
					// 동적 화면 생성
					const dt = new Date();
					const year = dt.getFullYear().toString().substr(2, 2); 
					const month = (dt.getMonth() + 1).toString().padStart(2, '0'); 
					const date = dt.getDate().toString().padStart(2, '0')
					const now = year + "-" + month + "-" + date;
				
					
					
					const article = `<article>
										<span class='nick'>`+nick+`</span>
										<span class='date'>`+now+`</span>
										<p class='content'>`+content+`</span>
										<div>
											<a href="#" class='remove'>삭제</a>
											<a href="#" class='modify'>수정</a>
										<div>
									<article>`;
					
					$('.commentList').append(article);
					
				}else{
					alert('댓글이 등록이 실패했습니다.');
				}
				
				
			}
			
		})
		
	})//btnComment end
	
	// 댓글 삭제하기 
	$(document).on('click', '.del', function(e){
		e.preventDefault();
		
		const no = $(this).data('no');
		const article = $(this).parent().parent();
		
		console.log('no : '+no);
		
		const jsonData = {
				"kind":"REMOVE",
				"no":no
				
		}
		
		$.ajax({
			url: '/Farmstory2/board/comment.do',
			type: 'GET',
			data: jsonData,
			dataType: 'json',
			success:function(data){
				
				if(data.result > 0){
					alert('댓글이 삭제되었습니다.');
					
					article.remove();
					
				}
			}
		})
		
	})
	
	
});