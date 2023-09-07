package kr.co.Jboard2.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Jboard2.service.ArticleService;
import kr.co.Jboard2.service.FileService;

@WebServlet("/delete.do")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArticleService aService = ArticleService.INSTANCE;
    private FileService fService = FileService.INSTANCE;
    
    public DeleteController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 글 번호 수신
		String no = request.getParameter("no");
		 
		// 파일 삭제(DB)- 글(Article)삭제보다 먼저 이뤄져야 한다. 
		int result = fService.deleteFile(no);
		
		// 글+댓글 삭제
		aService.deleteArticle(no);
	
		
		// 파일 삭제(Directory)
		if(result > 0) {
			
			String path = aService.getFilePath(request);
			File file = new File(path+"/"+"파일명");
			
			if(file.exists()) {
				file.delete();
			}
		}
		response.sendRedirect("/Jboard2/list.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
