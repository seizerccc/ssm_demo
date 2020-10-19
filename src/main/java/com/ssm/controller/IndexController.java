package com.ssm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.entity.SignInRecord;
import com.ssm.service.ISignInRecordService;

@Controller
public class IndexController {
	
	@Resource
	private ISignInRecordService signInRecordService;
	
	
	@RequestMapping("/toTablePage")
	@ResponseBody
	public ModelAndView toTablePage(HttpServletRequest req, ModelAndView mv){
		mv.setViewName("/tablePage");//跳转到table页面
		HttpSession session = req.getSession();
		int userId = (int) session.getAttribute("userId");
		System.out.println(userId);
		List<SignInRecord> list = signInRecordService.queryAllSignInRecordByUserId(userId);
		//System.out.println("签到类型："+list.get(0).getType());
		mv.addObject("list",list);
		
		
		return mv;
	}
	
	@RequestMapping("/pageJump")
	@ResponseBody
	public ModelAndView changeDepartment(HttpServletRequest req, ModelAndView mv){
		mv.setViewName("/index");
		
		
		return mv;
	}
	
	@RequestMapping("/pagedQuery")
	@ResponseBody
	public List<SignInRecord> queryPagedSignRecordByUserId(HttpServletRequest req){
		List<SignInRecord> list = signInRecordService.queryPagedSignRecordByUserId(1, 0, 5);
		System.out.println(list.toString());
		
		
		return list;
	}
	
	
	

}
