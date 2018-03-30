package com.wang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.wang.login.SystemAuthenticationRealm;
import com.wang.model.User;
import com.wang.service.UserService;
import com.wang.util.Config;
import com.wang.util.RSA;


@Controller
@RequestMapping("/syslogin")
public class LoginController {

	@Autowired
	private UserService userService;
	
 private static Log log = LogFactory.getLog(LoginController.class);

  
  /**
  * 登录页
  * @param request
  * @return
  */
 @RequestMapping("/beginlogin")
 public ModelAndView beginlogin(HttpServletRequest request){
   ModelAndView mv = new ModelAndView();  
   mv.setViewName("login.html");  
   return mv;
 }
 
 
 /**
 * 退出
 * @param request
 * @return
 */
@RequestMapping("/signout")
public ModelAndView signout(HttpServletRequest request){
//  HttpSession session = request.getSession();
//  session.removeAttribute("userinfo");
  SecurityUtils.getSubject().logout();
  ModelAndView mv = new ModelAndView(); 
  mv.setViewName("login.html");  
  return mv;
}
  
  /**
  * 首页
  * @param request
  * @return
  */
 @RequestMapping(value ="/index")
 public String beginindex(HttpServletRequest request,Model model){
   HttpSession session = request.getSession();
   User userinfo = (User) session.getAttribute(SystemAuthenticationRealm.SESSION_USER_KEY);
   model.addAttribute("userinfo",userinfo);
   model.addAttribute("version","1.1");
   return "index.html";

 }
	
 
 /**
  * 添加用户并重定向
  * @param User user
  * @param request
  * @return
  */
 @RequestMapping(value="/loginin",method=RequestMethod.POST)
 public String loginin(User user,HttpServletRequest request,Model model){
   String username = user.getUsername();
   String password = user.getPassword();
   String sign = RSA.sign(password, Config.private_key, Config.input_charset);
   UsernamePasswordToken token = new UsernamePasswordToken(username, sign);
   token.setRememberMe(true);
         // 获取当前的Subject
   Subject currentUser = SecurityUtils.getSubject();
   String returnurl = "login.html";
   String message = "";
   try {
             // 所以这一步在调用login(token)方法时,它会走到SystemAuthenticationRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
     currentUser.login(token);
     model.addAttribute("userinfo",SecurityUtils.getSubject().getSession().getAttribute(SystemAuthenticationRealm.SESSION_USER_KEY));
     model.addAttribute("version","1.1");
     returnurl = "index.html";
     message = "登录成功";
   } catch (UnknownAccountException uae) {
     log.info("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
     message = "未知账户";
   } catch (IncorrectCredentialsException ice) {
     log.info("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
     message = "密码不正确";
   } catch (LockedAccountException lae) {
     log.info("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
     message = "账户已锁定";
   } catch (ExcessiveAttemptsException eae) {
     log.info("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
     message = "用户名或密码错误次数过多";
   } catch (AuthenticationException ae) {
             // 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
     log.info("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
     ae.printStackTrace();
     message = "用户名或密码不正确";
         }
   model.addAttribute("message",message);
         // 验证是否登录成功
   if (currentUser.isAuthenticated()) {
               //登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)
   } else {
     token.clear();
         }
   return returnurl;
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
     String sign = RSA.sign(password, Config.private_key, Config.input_charset);
     UsernamePasswordToken token = new UsernamePasswordToken(username, sign);
     token.setRememberMe(true);
           // 获取当前的Subject
     Subject currentUser = SecurityUtils.getSubject();
     JSONObject json = new JSONObject();
     int state = 201;
     String message = "";
     try {
               // 所以这一步在调用login(token)方法时,它会走到SystemAuthenticationRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
       currentUser.login(token);
       state = 200;
       message = "登录成功";
     } catch (UnknownAccountException uae) {
       log.info("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
       message = "未知账户";
     } catch (IncorrectCredentialsException ice) {
       log.info("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
       message = "密码不正确";
     } catch (LockedAccountException lae) {
       log.info("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
       message = "账户已锁定";
     } catch (ExcessiveAttemptsException eae) {
       log.info("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
       message = "用户名或密码错误次数过多";
     } catch (AuthenticationException ae) {
               // 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
       log.info("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
       ae.printStackTrace();
       message = "用户名或密码不正确";
           }
           // 验证是否登录成功
     if (currentUser.isAuthenticated()) {
                 //登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)
     } else {
       token.clear();
           }
     json.put("state", state);
     json.put("message", message);
     return json;
   }
 
	/**
	 * 添加用户并重定向
	 * @param User user
	 * @param request
	 * @return
	 */
 @ResponseBody
	@RequestMapping(value="/logincheck1",method=RequestMethod.POST)
	public JSONObject logincheck1(User user,HttpServletRequest request){
	  String username = user.getUsername();
	  String password = user.getPassword();
	  User userinfo = userService.findByAccount(username);
	  boolean check = false;
	  if(null!=userinfo){
	     check = RSA.verify(password, userinfo.getPassword(), Config.public_key, Config.input_charset);
	      }
    JSONObject json = new JSONObject();
    if(check){
      HttpSession session = request.getSession();
      session.setAttribute("userinfo", userinfo);
      session.setMaxInactiveInterval(1800);//单位为秒
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
