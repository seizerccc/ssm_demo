package com.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.ssm.entity.User;
import com.ssm.service.IUserService;

/**
 * 
 * @author liyongqiang
 *
 */
@Controller
public class UserController {

	@Resource
	private IUserService userService;

	/**
	 * 用户登录
	 *
	 * @param req
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView login(HttpServletRequest req, ModelAndView mv) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", req.getParameter("username"));
		map.put("password", req.getParameter("password"));
		
		//使用modelandview传递信息
		//mv.addObject("current_user_name",req.getParameter("username"));
		//使用request中session存储用户信息
		
		User user = userService.login(map);//查询数据库对象，查询不到则对象为空
		if (user != null) {//登录成功进入首页
			mv.setViewName("index");
			userService.setLastLoginTime(user.getId());//这里顺序有点问题，应该登录验证和时间修改时同步的，这里因为编程问题做成了两步，也就是只显示本次登录之前的登录时间
			HttpSession session = req.getSession();
			System.out.println("登录成功！"+ user.getEmail()+","+user.getLastLoginTime());
			session.setAttribute("currentUser", user.getUsername());
			session.setAttribute("userId", user.getId());
			session.setAttribute("email", user.getEmail());
			session.setAttribute("createTime", user.getCreateTime());
			session.setAttribute("lastLoginTime", user.getLastLoginTime());
			session.setAttribute("department", user.getDepartment());
		} 
		else {//登录失败回到登录页面
			mv.addObject("message", "用户名或密码输入错误,请重新输入");
			mv.setViewName("login");
		}
		
		
		return mv;

	}
	
	@RequestMapping("/changeDepartment")
	@ResponseBody
	public ModelAndView changeDepartment(HttpServletRequest req,ModelAndView mv,HttpSession session){
		//调用session的值需要在参数中传入HttpSession,通过HttpServletRequest.getSession()取到的session不是运行时的session，会报null
		System.out.println(session.getAttribute("userId")+","+(String)req.getParameter("newDepartment"));
		userService.changeDepartmentById((int)session.getAttribute("userId"),(String)req.getParameter("newDepartment"));
		session.setAttribute("department", req.getParameter("newDepartment"));
		mv.setViewName("index");
		
		return mv;
		
	}
	
	@RequestMapping("/queryAllUser")
	@ResponseBody
	public List<User> queryAllUser(){
		List<User> list = userService.queryAllUser();
		System.out.println("First User:"+list.get(0).getUsername());
	    
	    return list;
	}
	
	
	
	
	


}
