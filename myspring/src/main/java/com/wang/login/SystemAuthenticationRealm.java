package com.wang.login;

/**
 *@auth wws
 *@date 2018年3月29日---下午4:46:23
 *
 **/
import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import com.wang.model.User;
import com.wang.service.UserService;

/**
 * 自定义的指定Shiro验证用户登录的类
 * 
 */
public class SystemAuthenticationRealm extends AuthorizingRealm {

  @Autowired
  private UserService userService;
  public static final String SESSION_USER_KEY = "userinfo";
  
  /**
   * 
   *授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    User user = (User) SecurityUtils.getSubject().getSession().getAttribute(SystemAuthenticationRealm.SESSION_USER_KEY);  
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
          // 添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色
    info.addRole("admin");
          // 添加权限
    info.addStringPermission("admin:manage");
    return info; 
  }
  
  /**
   * 验证当前登录的Subject
   * 
   *本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()时
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
          // 获取基于用户名和密码的令牌
          // 实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的
     UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
     User user = userService.findByAccount(token.getUsername());
     if(null!=user){
       AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getAccount(), user.getPassword(),user.getUsername());
       this.setSession(SystemAuthenticationRealm.SESSION_USER_KEY, user);
       return authcInfo;
     }else{
       return null;
           }
          // 没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常
  }

  /**
   * 将一些数据放到ShiroSession中,以便于其它地方使用
   * 
   * @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
   */
  private void setSession(Object key, Object value) {   
    Subject currentUser = SecurityUtils.getSubject();            
    if (null != currentUser) {
      Session session = currentUser.getSession();
//      System.out.println("Session默认超时时间为[" + session.getTimeout()/1000 + "]秒");
      if (null != session) {
        session.setAttribute(key, value);
      }
    }
  }

  public UserService getUserService() {
    return userService;
  }

  public void setUserService(UserService userService) {
    this.userService = userService;
  }


}