package com.ssm.dao;

import java.util.List;

import com.ssm.entity.SignInRecord;

public interface ISignInRecordDao {
	/**
	 * 根据id查询签到记录
	 * @param id
	 * @return
	 */
	public List<SignInRecord> queryAllSignInRecordByUserId(int userId);
	
	/**
	 * 根据id查询所有签到记录的总条数
	 * @param userId
	 * @return
	 */
	public int queryTotolOfRecordByUserId(int userId);
	
	/**
	 * 根据id分页查询签到记录
	 * @param userId
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	public List<SignInRecord> queryPagedSignRecordByUserId(int userId, int begin, int pageSize);

}
