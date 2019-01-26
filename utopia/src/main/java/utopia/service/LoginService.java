package utopia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utopia.dao.TbUserMapper;
import utopia.model.TbUser;

@Service
public class LoginService {
	@Autowired
	TbUserMapper userMapper;
	
	public TbUser findByKeyWord(String username) {
		return userMapper.findByKeyword(username);
	}
}
