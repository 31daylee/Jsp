package kr.co.farmstory2.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory2.dao.UserDAO;
import kr.co.farmstory2.dto.UserDTO;

public enum	UserService {
	
	INSTANCE;
	
	UserDAO dao = new UserDAO();
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertUser(UserDTO dto) {}
	
	public UserDTO selectUser(String uid) {
		return null;
	}
	public List<UserDTO> selectUsers() {
		
		return null;
	}
	public void updateUser(UserDTO dto) {}
	
	public void deleteUser(String uid) {}
	
}
