package kr.co.farmstory2.controller.board;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

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

import kr.co.farmstory2.dto.ArticleDTO;
import kr.co.farmstory2.dto.FileDTO;
import kr.co.farmstory2.service.ArticleService;
import kr.co.farmstory2.service.FileService;

@WebServlet("/board/fileDownload.do")
public class FileDownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArticleService service = ArticleService.INSTANCE;
    private FileService fService = FileService.INSTANCE;
    
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    public FileDownloadController() {

    }

    public void init(ServletConfig config) throws ServletException {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fno = request.getParameter("fno");
		logger.debug("fno : "+fno);
		
		FileDTO fileDto = fService.selectFile(fno);
		logger.debug(fileDto.toString());
		

		// response 파일 다운로드 헤더 수정
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fileDto.getOriName(), "utf-8"));
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "private");
		
		// response 파일 스트림 작업
		//파일 경로 구하기
		ServletContext ctx = request.getServletContext();
		String path = ctx.getRealPath("/upload");
		
		// 최대 업로드 파일 크기
		int maxSize = 1024 * 1024 * 10;
		
		File file = new File(path+"/"+fileDto.getNewName());
		   //스트림 생성(연결)
        //입력 스트림
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));

        //출력 스트림
        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream()); 

        while(true){

            //파일 읽기(byte 단위의 데이터 이기 때문에 int)
            int data = bis.read();
            if(data == -1){
                break;
            }
            //파일쓰기
            bos.write(data);
        }

        bos.close();
        bis.close();
		
	}

}
