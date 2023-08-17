package kr.farmstory1.dao;

import java.util.ArrayList;
import java.util.List;

import kr.farmstory1.db.DBHelper;
import kr.farmstory1.db.SQL;
import kr.farmstory1.dto.ArticleDTO;

public class ArticleDAO extends DBHelper {
	
	// 글쓰기
	public void insertArticle(ArticleDTO dto) {
		
		try{
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_ARTICLE);
			psmt.setString(1, dto.getCate());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getWriter());
			psmt.setString(4, dto.getContent());
			psmt.setString(5, dto.getRegip());
			psmt.executeUpdate();
			
			close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
