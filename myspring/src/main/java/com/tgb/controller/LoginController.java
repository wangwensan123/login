package com.tgb.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tgb.model.User;
import com.tgb.service.UserService;
import com.tgb.util.Config;
import com.tgb.util.RSA;

@Controller
@RequestMapping("/syslogin")
public class LoginController {

	@Autowired
	private UserService userService;
	
	
	 /**
   * 获取所有用户列表
   * @param request
   * @return
   */
  @RequestMapping("/index")
  public String index(HttpServletRequest request){
    
    return "/login";
  }
	
	/**
	 * 添加用户并重定向
	 * @param User user
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/loginin",method=RequestMethod.POST)
	public String loginin(User user,HttpServletRequest request){
	  String username = user.getUsername();
	  String password = user.getPassword();
	  User userinfo = userService.findByName(username);
	  boolean check = false;
	  if(null!=userinfo){
	     check = RSA.verify(password, userinfo.getPassword(), Config.public_key, Config.input_charset);
	      }
   if(check){
     return "redirect:/user/getAllUser";
   }else{
     return "redirect:/syslogin/index";
	    }	    
	}
	
	 /* 添加用户并重定向
   * @param User user
   * @param request
   * @return
   */
  @RequestMapping(value="/register",method=RequestMethod.GET)
  public String register(User user,HttpServletRequest request){
    String username = user.getUsername();
    String password = user.getPassword();
    String sign = RSA.sign(password, Config.private_key, Config.input_charset);
    user.setPassword(sign);
    userService.save(user);
    return "redirect:/syslogin/index";   
  }



}
