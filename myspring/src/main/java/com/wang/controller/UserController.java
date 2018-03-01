package com.wang.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.wang.model.Role;
import com.wang.model.User;
import com.wang.model.UserRole;
import com.wang.service.RoleService;
import com.wang.service.UserRoleService;
import com.wang.service.UserService;
import com.wang.util.Config;
import com.wang.util.RSA;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
 @Autowired
 private RoleService roleService;
 
 @Autowired
 private UserRoleService userRoleService;
	
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
  public JSONObject getAllUserJson(Model model,HttpServletRequest request){
    JSONObject json = new JSONObject();
	   HttpSession session = request.getSession();
	   User userinfo = (User) session.getAttribute("userinfo");
    if(userinfo!=null&&userinfo.getRolecode()!=null&&userinfo.getRolecode().equals("administrator")){
      List<User> findAll = userService.findAll();         
      json.put("data", findAll);
      json.put("state", 200);
    }else{
      json.put("message", "您没有权限");
      json.put("state", 201);
	       }
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
	public String addUser(User user,HttpServletRequest request,Model model){
		String account = user.getAccount();
		String password = user.getPassword();
		String password1 = request.getParameter("password1");
		boolean flag = false;
  if(account!=null&&!account.equals("")&&password!=null&&!password.equals("")&&password1!=null&&!password1.equals("")){
      if(!password.equals(password1)){
        model.addAttribute("message","两次设置密码不一样！");
      }else{
        User userinfo = userService.findByAccount(account);
        if(userinfo==null){
          String sign = RSA.sign(password, Config.private_key, Config.input_charset);
          user.setPassword(sign);
          userService.save(user);
          flag = true;
        }else{
          model.addAttribute("message","账号重复！");
                }
              }
  }else{
    model.addAttribute("message","账号或密码为空！");
    }
  if(flag){
    return "redirect:/user/getAllUser";
  }else{
    model.addAttribute("userinfo",user);
    return "user/user.add.html";
    }

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
  * 跳转到添加用户界面
  * @param request
  * @return
  */
 @RequestMapping("/getUserRolePage")
 public String getUserRolePage(int id,Model model) {
   User user = userService.findById(id);
   model.addAttribute("userinfo",user);
   List<Role> findAll = roleService.findAll();
   model.addAttribute("roleList",findAll);
   return "user/user.grantrole.html";
 }
 
 /**
  * 添加用户角色并重定向
  * @param user
  * @param request
  * @return
  */
 @RequestMapping("/grantUserRole")
 public String grantUserRole(UserRole userRole,HttpServletRequest request){
   userRoleService.save(userRole);
   return "redirect:/user/getAllUser";
 }
 
 /**
  * 重置用户密码
  * @param request
  * @return
  */
  @ResponseBody
 @RequestMapping("/resetUser")
 public JSONObject resetUser(int id,Model model,HttpServletRequest request){
   JSONObject json = new JSONObject();
    HttpSession session = request.getSession();
    User userinfo = (User) session.getAttribute("userinfo");
   if(userinfo!=null&&userinfo.getRolecode()!=null&&userinfo.getRolecode().equals("administrator")){
     User user = userService.findById(id);
     String sign = RSA.sign("123456", Config.private_key, Config.input_charset);
     user.setPassword(sign);
     userService.updatePassword(user);
     json.put("message", "重置成功");
     json.put("state", 200);
   }else{
     json.put("message", "您没有权限");
     json.put("state", 201);
        }
   return json;
 }
	
	 /**
   * 修改用户信息并重定向
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
