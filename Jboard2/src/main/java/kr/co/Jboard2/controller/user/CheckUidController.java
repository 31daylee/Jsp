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

@WebServlet("/user/checkUid.do")
public class CheckUidController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
    private UserService service = UserService.getInstance();   
	
    public CheckUidController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		int result = service.selectCountUid(uid);
		
		logger.info("result : " + result);
		
		// JSON 생성
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		// JSON 출력
		PrintWriter writer = response.getWriter();
		writer.print(json.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
