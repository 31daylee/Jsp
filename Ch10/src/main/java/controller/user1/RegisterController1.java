package controller.user1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User1DAO;
import dto.User1DTO;
import service.User1Service;


@WebServlet("/user1/register.do")
public class RegisterController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private User1Service service = new User1Service();
 
   @Override
   public void init() throws ServletException {

   }
   
   @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/user1/register.jsp");
		dispatcher.forward(request, response);
	}

   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	   
	   String uid = request.getParameter("uid");
	   String name = request.getParameter("name");
	   String hp = request.getParameter("hp");
	   String age = request.getParameter("age");

	   User1DTO dto = new User1DTO();
	   dto.setUid(uid);
	   dto.setName(name);
	   dto.setHp(hp);
	   dto.setAge(age);
	   
	   service.insertUser1(dto);
   
	   response.sendRedirect("/Ch10/user1/list.do");
   }

}
