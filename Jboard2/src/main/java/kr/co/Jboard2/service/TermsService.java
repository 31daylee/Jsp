package kr.co.Jboard2.service;

import kr.co.Jboard2.dao.TermsDAO;
import kr.co.Jboard2.dto.TermsDTO;

public class TermsService {
	
	private TermsDAO dao = new TermsDAO(); 
	
	public TermsDTO selectTerms() {
		return dao.selectTerms();
	}
}