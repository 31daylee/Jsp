package kr.co.Jboard2.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Jboard2.dto.TermsDTO;
import kr.co.Jboard2.service.TermsService;


@WebServlet("/user/terms.do")
public class TermsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TermsService service = new TermsService();
    public TermsController() {

    }

	public void init(ServletConfig config) throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TermsDTO dto = service.selectTerms();
		service.selectTerms();
		request.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user/terms.jsp");
		dispatcher.forward(request, response);
	}


}
