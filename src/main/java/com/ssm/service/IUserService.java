package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.ssm.entity.User;

public interface IUserService {


	/**
	 * 登录
	 * 
	 * @param map
	 * @return
	 */
	public User login(Map<String, String> map);
	
	/**
	 * 记录登录时间
	 * @param loginTime
	 */
	public void setLastLoginTime(int id);
	
	/**
	 * 根据id修改部门
	 * @param newDepartment
	 */
	public void changeDepartmentById(int userid,String newDepartment);
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> queryAllUser();
}