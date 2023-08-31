package kr.co.Jboard2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Jboard2.dto.ArticleDTO;
import kr.co.Jboard2.service.ArticleService;

@WebServlet("/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArticleService service = ArticleService.INSTANCE;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
       
    public ModifyController() {

    }
    // 수정시 원글을 modfiy.do에 출력하기 위한 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Article의 no 파라미터 가져오기 
		String no = request.getParameter("no");
		
		// service 호출 
		ArticleDTO dto = service.selectArticle(no);
		request.setAttribute("dto", dto);
		
		// 로깅을 통한 dto 여부 확인
		logger.debug("dto..." + dto);
		
		// JSP 페이지로 포워드
		RequestDispatcher dispatcher = request.getRequestDispatcher("modify.jsp");
		dispatcher.forward(request, response);
	}
	// 클라이언트의 수정된 글을 적용하기 위한 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 수정 데이터 수신
		String no = request.getParameter("no");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String file = request.getParameter("file");
		
		// ArticleDTO 객체 생성 및 저장
		ArticleDTO dto = new ArticleDTO();
		dto.setNo(no);
		dto.setTitle(title);
		dto.setContent(content);
		
		// service 호출 및 DB에 수정된 정보 업데이트
		service.updateArticle(dto);
		
		// view.do로 리다이렉트
		response.sendRedirect("/Jboard2/view.do?no="+no);
	
	}

}
