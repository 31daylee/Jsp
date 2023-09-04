package kr.co.farmstory2.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory2.dto.TermsDTO;
import kr.co.farmstory2.service.TermsService;

@WebServlet("/user/terms.do")
public class TermsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TermsService serivce = TermsService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
       
    public TermsController() {

    }

	public void init(ServletConfig config) throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		TermsDTO dto = serivce.selectTerms();
		request.setAttribute("dto", dto);
		
	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user/terms.jsp");
		dispatcher.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
