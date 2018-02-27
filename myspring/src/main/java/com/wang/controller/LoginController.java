package com.wang.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.wang.model.User;
import com.wang.service.UserService;
import com.wang.util.Config;
import com.wang.util.RSA;


@Controller
@RequestMapping("/syslogin")
public class LoginController {

	@Autowired
	private UserService userService;
	
	
	 /**
   * 登录页
   * @param request
   * @return
   */
  @RequestMapping("/beginlogin")
  public ModelAndView beginlogin(HttpServletRequest request){
    ModelAndView mv = new ModelAndView();  
    mv.addObject("message", "Hello World!!!");  
    mv.setViewName("login.html");  
    return mv;
  }
  
  /**
  * 首页
  * @param request
  * @return
  */
 @RequestMapping("/index")
 public String beginindex(HttpServletRequest request){
         
   return "index.html";
 }
	
	/**
	 * 添加用户并重定向
	 * @param User user
	 * @param request
	 * @return
	 */
 @ResponseBody
	@RequestMapping(value="/logincheck",method=RequestMethod.POST)
	public JSONObject logincheck(User user,HttpServletRequest request){
	  String username = user.getUsername();
	  String password = user.getPassword();
	  User userinfo = userService.findByName(username);
	  boolean check = false;
	  if(null!=userinfo){
	     check = RSA.verify(password, userinfo.getPassword(), Config.public_key, Config.input_charset);
	      }
    JSONObject json = new JSONObject();
    if(check){
      json.put("state", 200);
    }else{
      json.put("state", 201);
          }
    return json;
	}
	
	 /* 添加用户并重定向
   * @param User user
   * @param request
   * @return
   */
  @ResponseBody
  @RequestMapping(value="/register",method=RequestMethod.POST)
  public JSONObject register(User user,HttpServletRequest request){
    String username = user.getUsername();
    String password = user.getPassword();
    JSONObject json = new JSONObject();
    if(username!=null&&!username.equals("")&&password!=null&&!password.equals("")){
      String sign = RSA.sign(password, Config.private_key, Config.input_charset);
      user.setPassword(sign);
      userService.save(user);
      json.put("state", 200);
    }else{
      json.put("state", 201);
          }
    return json;  
  }



}