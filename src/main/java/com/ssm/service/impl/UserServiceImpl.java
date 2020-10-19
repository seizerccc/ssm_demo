package com.ssm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.IUserDao;
import com.ssm.entity.User;
import com.ssm.service.IUserService;

@Service("UserService")
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDao;

	public User login(Map<String, String> map) {
		return userDao.login(map);
	}

	@Override
	public void setLastLoginTime(int userId) {
		userDao.setLoginTime(userId);
	}

	@Override
	public void changeDepartmentById(int userid,String newDepartment) {
		userDao.changeDepartmentById(userid, newDepartment);
		
	}

	@Override
	public List<User> queryAllUser() {
		return userDao.queryAllUser();
		
	}

}
