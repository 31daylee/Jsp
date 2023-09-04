package kr.co.farmstory2.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

import kr.co.farmstory2.service.UserService;

@WebServlet("/user/checkHp.do")
public class CheckHpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService serivce = UserService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
       
    public CheckHpController() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String hp = request.getParameter("hp");
		
		int result = serivce.selectCountHp(hp);
		logger.debug("checkHp result...: "+ result);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
				
		PrintWriter writer = response.getWriter();
		writer.print(json.toString());
		
	}


}
