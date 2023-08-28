package kr.co.Jboard2.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

import kr.co.Jboard2.service.UserService;

@WebServlet("/user/authEmail.do")
public class AuthEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private UserService service = UserService.getInstance();
       
    public AuthEmailController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		int status = service.sendCodeByEmail(email);
		
		// JSON 생성
		JsonObject json = new JsonObject();
		json.addProperty("status", status);
		
		// JSON 출력
		PrintWriter writer = response.getWriter();
		writer.print(json.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		logger.info("code : " + code);
		
		int result = service.cofirmCodeByEmail(code);
		logger.info("result : " + result);
		
		// JSON 생성
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		// JSON 출력
		PrintWriter writer = response.getWriter();
		writer.print(json.toString());
	}

}
