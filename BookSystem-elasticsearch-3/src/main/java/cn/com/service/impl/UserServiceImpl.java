package cn.com.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import cn.com.dao.UserDao;
import cn.com.entity.User;
import cn.com.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	public User getByUserName(String userName) {
		System.out.println(userDao.getByUserName(userName));
		return userDao.getByUserName(userName);
	}

	public Set<String> getRoles(String userName) {
		return userDao.getRoles(userName);
	}

	public Set<String> getPermissions(String userName) {
		return userDao.getPermissions(userName);
	}

}
