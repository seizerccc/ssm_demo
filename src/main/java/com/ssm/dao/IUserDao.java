package com.ssm.dao;

import java.util.List;
import java.util.Map;

import com.ssm.entity.User;

public interface IUserDao {


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
	public void setLoginTime(int id);
	
	/**
	 * 根据id修改部门
	 * @param userid
	 * @param newDepartment
	 */
	public void changeDepartmentById(int userid,String newDepartment);
	
	/**
	 * 查询所有用户
	 */
	public List<User> queryAllUser();
}
