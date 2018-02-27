package com.wang.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.wang.model.User;
import com.wang.service.UserService;
import com.wang.util.Config;
import com.wang.util.RSA;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	/**
	 * 获取所有用户列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/getAllUser")
	public String getAllUser(Model model){
		
		List<User> findAll = userService.findAll();
  model.addAttribute("userList",findAll);
		return "user/user.index.html";
	}
	
	 /**
   * 获取所有用户列表
   * @param request
   * @return
   */
	 @ResponseBody
  @RequestMapping("/getAllUserJson")
  public JSONObject getAllUserJson(Model model){
    JSONObject json = new JSONObject();
    List<User> findAll = userService.findAll();         
    json.put("data", findAll);
    json.put("state", 200);
    return json;
  }
	
	/**
	 * 跳转到添加用户界面
	 * @param request
	 * @return
	 */
  @RequestMapping("/getAddUserPage")
  public String getAddUserPage(HttpServletRequest request) {

    return "user/user.add.html";
  }
  
	/**
	 * 添加用户并重定向
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/addUser")
	public String addUser(User user,HttpServletRequest request){
		String username = user.getUsername();
		String password = user.getPassword();
  if(username!=null&&!username.equals("")&&password!=null&&!password.equals("")){
      String sign = RSA.sign(password, Config.private_key, Config.input_charset);
      user.setPassword(sign);
      userService.save(user);
    }
		return "redirect:/user/getAllUser";
	}
	
	 /**
   * 跳转到添加用户界面
   * @param request
   * @return
   */
  @RequestMapping("/getEditUserPage")
  public String getEditUserPage(int id,Model model) {
    User user = userService.findById(id);
    model.addAttribute("userinfo",user);
    return "user/user.edit.html";
  }
	
	 /**
   * 添加用户并重定向
   * @param user
   * @param request
   * @return
   */
  @RequestMapping("/editUser")
  public String editUser(User user,HttpServletRequest request){
    String username = user.getUsername();
    if(username!=null&&!username.equals("")){
      userService.update(user);
          }
    return "redirect:/user/getAllUser";
  }

	 /**
   * 删除用户
   * @param id
   * @param request
   * @param response
   */
  @RequestMapping("/delUser")
  public String delUser(int id,HttpServletRequest request){
    userService.delete(id);
    return "redirect:/user/getAllUser";
  }
	
}
