package com.wang.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wang.model.Role;
import com.wang.service.RoleService;


@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	
	/**
	 * 获取所有用户列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/getAllRole")
	public String getAllRole(Model model){
		
		List<Role> findAll = roleService.findAll();
  model.addAttribute("roleList",findAll);
		return "user/role.index.html";
	}
	
	/**
	 * 跳转到添加用户界面
	 * @param request
	 * @return
	 */
  @RequestMapping("/getAddRolePage")
  public String getAddRolePage(HttpServletRequest request) {

    return "user/role.add.html";
  }
  
	/**
	 * 添加用户并重定向
	 * @param role
	 * @param request
	 * @return
	 */
	@RequestMapping("/addRole")
	public String addRole(Role role,HttpServletRequest request){
	  roleService.save(role);
		return "redirect:/role/getAllRole";
	}
	
	 /**
   * 跳转到添加用户界面
   * @param request
   * @return
   */
  @RequestMapping("/getEditRolePage")
  public String getEditRolePage(int id,Model model) {
    Role role = roleService.findById(id);
    model.addAttribute("roleinfo",role);
    return "user/role.edit.html";
  }
	
	 /**
   * 添加用户并重定向
   * @param role
   * @param request
   * @return
   */
  @RequestMapping("/editRole")
  public String editRole(Role role,HttpServletRequest request){
    String rolename = role.getRolename();
    if(rolename!=null&&!rolename.equals("")){
      roleService.update(role);
          }
    return "redirect:/role/getAllRole";
  }

	 /**
   * 删除用户
   * @param id
   * @param request
   * @param response
   */
  @RequestMapping("/delRole")
  public String delRole(int id,HttpServletRequest request){
    roleService.delete(id);
    return "redirect:/role/getAllRole";
  }
	
}
