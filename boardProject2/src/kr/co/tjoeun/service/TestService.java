package kr.co.tjoeun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.tjoeun.dao.TestDAO;

@Service
public class TestService {
	
	//테스트서비스에서 테스트 다오를 사용한다는 의미
	//TestDAO testDAO = new TestDAO();
	//=이걸 간단하게 한게
	@Autowired
	TestDAO testDAO;
	
	public String testServiceMethod() {
		String str1 = testDAO.testDaoMethod();
		return str1;
	}
}
