package com.tgb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tgb.model.User;
import com.tgb.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserService userService;
	
	/**
	 * 添加用户并重定向
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/loginin")
	public String addUser(User user,HttpServletRequest request){
	  
		return "redirect:/user/getAllUser";
	}



}
