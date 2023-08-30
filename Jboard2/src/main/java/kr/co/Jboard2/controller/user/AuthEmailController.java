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
		
		String type  = request.getParameter("type");
		String uid  = request.getParameter("uid");
		String name  = request.getParameter("name");
		String email = request.getParameter("email");
		
		int result = 0;
		int status = 0;
		
		if(type.equals("REGISTER")) {
			// 회원가입할 때 이메일 인증
			result = service.selectCountEmail(email);
			
			if(result == 0) {
				status = service.sendCodeByEmail(email);
			}
			
		}else if(type.equals("FIND_ID")){
			// 아이디찾기할 때 이메일 인증
			result = service.selectCountNameAndEmail(name, email);
			
			if(result == 1) {
				status = service.sendCodeByEmail(email);
			}
		}else if(type.equals("FIND_PASS")){
			// 비밀번호 찾기할 때 이메일 인증
			result = service.selectCountUidAndEmail(uid, email);
			
			if(result == 1) {
				status = service.sendCodeByEmail(email);
			}
		}else if(type.equals("MODIFY")){
			// 회원정보 수정할 때 이메일 인증
			result = service.selectCountEmail(email);
			
			if(result == 0) {
				status = service.sendCodeByEmail(email);
			}			
		}
		
		// JSON 생성
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
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
