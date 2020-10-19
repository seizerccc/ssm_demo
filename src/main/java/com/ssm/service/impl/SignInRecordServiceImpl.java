package com.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.ISignInRecordDao;
import com.ssm.entity.SignInRecord;
import com.ssm.service.ISignInRecordService;

@Service("SignInRecordService")
public class SignInRecordServiceImpl implements ISignInRecordService{
	
	@Resource
	private ISignInRecordDao signInRecordDao;

	@Override
	public List<SignInRecord> queryAllSignInRecordByUserId(int userId) {
		
		return signInRecordDao.queryAllSignInRecordByUserId(userId);
	}

	@Override
	public int queryTotolOfRecordByUserId(int userId) {
		return signInRecordDao.queryTotolOfRecordByUserId(userId);
	}

	@Override
	public List<SignInRecord> queryPagedSignRecordByUserId(int userId, int begin, int pageSize) {
		return signInRecordDao.queryPagedSignRecordByUserId(userId, begin, pageSize);
	}
	
	

}
