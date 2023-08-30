package kr.co.Jboard2.controller.user;

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

import com.google.gson.JsonObject;

import kr.co.Jboard2.dto.UserDTO;
import kr.co.Jboard2.service.UserService;


@WebServlet("/user/myInfo.do")
public class MyInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private UserService service = UserService.getInstance();
	
    public MyInfoController() {

    }

	public void init(ServletConfig config) throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user/myInfo.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String kind	= request.getParameter("kind");
		String uid	= request.getParameter("uid");
		String pass	= request.getParameter("pass");
		String name	= request.getParameter("name");
		String nick	= request.getParameter("nick");
		String email	= request.getParameter("email");
		String hp	= request.getParameter("hp");
		String zip	= request.getParameter("zip");
		String addr1	= request.getParameter("addr1");
		String addr2	= request.getParameter("addr2");
		
		logger.debug("kind : " + kind);
		logger.debug("uid : " + uid);
		logger.debug("pass : " + pass);
		
		switch(kind){
		case "WITHDRAW" :
			int result1 = service.updateUserForWithdraw(uid);
			
			// JSON 생성
			JsonObject json1 = new JsonObject();
			json1.addProperty("result", result1);
			
			// JSON 출력
			response.getWriter().print(json1); 
			
			// ajax로 요청했기 때문에 redirect를 할 수 없음. json data 로 응답을 해줘야함 
		
		break;
	
		
		case "PASSWORD" :
			
			int result2 = service.updateUserPass(uid, pass);
			
			// JSON 생성
			JsonObject json2 = new JsonObject();
			json2.addProperty("result", result2);
			
			// JSON 출력
			response.getWriter().print(json2); 
			service.updateUserPass(uid, pass);
			
			break;
			
			
		case "MODIFY" :
			
			UserDTO dto = new UserDTO();
			dto.setUid(uid);
			dto.setName(name);
			dto.setNick(nick);
			dto.setEmail(email);
			dto.setHp(hp);
			dto.setZip(zip);
			dto.setAddr1(addr1);
			dto.setAddr2(addr2);
			
			service.updateUser(dto);
			response.sendRedirect("/Jboard2/user/logout.do");
			
			break;
		}
	}

}
