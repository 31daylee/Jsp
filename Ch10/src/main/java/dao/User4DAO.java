package dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import db.DBHelper;
import dto.User4DTO;

public class User4DAO extends DBHelper{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertUser4(User4DTO dto) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("INSERT INTO `user4` VALUES (?,?,?,?,?)");
			psmt.setInt(1, dto.getSeq());
			psmt.setString(2, dto.getName());
			psmt.setInt(3, dto.getGender());
			psmt.setInt(4, dto.getAge());
			psmt.setString(5, dto.getAddr());
			
			psmt.executeUpdate();
			
			close();
			
		}catch(Exception e) {
			logger.error("User4_insertUser4... error : "+e.getMessage());
		}
		
		
	}
	public User4DTO selectUser4(String seq) {
	
		User4DTO dto = new User4DTO();
		
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM `user4` WHERE `seq`=?");
			psmt.setString(1, seq);
			rs= psmt.executeQuery();
			
			if(rs.next()) {
				dto.setSeq(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setGender(rs.getInt(3));
				dto.setAge(rs.getInt(4));
				dto.setAddr(rs.getString(5));
			}
			close();
			
			
		}catch(Exception e) {
			logger.error("User4_insertUser4... error : "+e.getMessage());
		}
		
		return dto;
	}
	public List<User4DTO> selectUser4s() {
		
		List<User4DTO> users = new ArrayList<>();
		
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM `user4`");
			rs= psmt.executeQuery();
			
			while(rs.next()) {
				User4DTO dto = new User4DTO();
				
				dto.setSeq(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setGender(rs.getInt(3));
				dto.setAge(rs.getInt(4));
				dto.setAddr(rs.getString(5));
				
				users.add(dto);
			}
			
			close();
			
			
		}catch(Exception e) {
			logger.error("User4_insertUser4... error : "+e.getMessage());
		}
		
		return users;
	}
	
	
	public void updateUser4(User4DTO dto) {
		
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement("UPDATE `user4` SET `name`=?,`gender`=?, `age`=?, `addr`=? WHERE `seq`=?");
			psmt.setString(1, dto.getName());
			psmt.setInt(2, dto.getGender());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getAddr());
			psmt.setInt(5, dto.getSeq());
			
			psmt.executeUpdate();
			
			close();
			
			
		}catch(Exception e) {
			logger.error("User4_insertUser4... error : "+e.getMessage());
		}
		
		
	}
	
	
	public void deleteUser4(String seq) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("DELETE FROM `user4` WHERE `seq`=?");
			psmt.setString(1, seq);
			psmt.executeUpdate();
			close();
			
		}catch(Exception e) {
			logger.error("User4_insertUser4... error : "+e.getMessage());
		}
		
		
	}
	
	
	
	
	
	
}
