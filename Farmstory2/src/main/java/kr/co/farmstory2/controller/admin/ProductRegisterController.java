package kr.co.farmstory2.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.farmstory2.dto.ProductDTO;
import kr.co.farmstory2.service.ProductService;

@WebServlet("/admin/productRegister.do")
public class ProductRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductService service = ProductService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
       
    public ProductRegisterController() {

    }

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/productRegister.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//파일 경로 구하기
		ServletContext ctx = request.getServletContext();
		String path = ctx.getRealPath("/thumb"); // 실제 시스템 경로를 잡기 
		int maxSize = 1024 * 1024 * 10;

		MultipartRequest mr = new MultipartRequest(request, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		
		String pName = mr.getParameter("productName");
		String type = mr.getParameter("type");
		String price = mr.getParameter("price");
		String delivery = mr.getParameter("delivery");
		String stock = mr.getParameter("stock");
		String thumb1 = mr.getOriginalFileName("thumb1");
		String thumb2 = mr.getOriginalFileName("thumb2");
		String thumb3 = mr.getOriginalFileName("thumb3");
		String seller = mr.getParameter("seller");
		String etc = mr.getParameter("etc");
	
		// 파일명 수정 => productDTO 에서 진행 
		
		
		
		logger.debug("type..."+type);
		logger.debug("thumb1..."+thumb1);
		
		ProductDTO dto = new ProductDTO(path);
		dto.setpName(pName);
		dto.setType(type);
		dto.setPrice(price);
		dto.setDelivery(delivery);
		dto.setStock(stock);
		dto.setThumb1ForRename(thumb1);
		dto.setThumb2ForRename(thumb2);
		dto.setThumb3ForRename(thumb3);
		dto.setSeller(seller);
		dto.setEtc(etc);
		
		logger.debug("RegisterProduct dto... "+ dto);
		
		service.insertProduct(dto);
		response.sendRedirect("/Farmstory2/admin/productList.do");
		
		
		
		
		
		
	}

}
