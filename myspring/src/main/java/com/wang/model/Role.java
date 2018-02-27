package com.wang.model;
/**
 *@auth wws
 *@date 2018年2月27日---下午12:52:56
 *
 **/
public class Role {
  
  private int id;
  private String rolename;
  private String rolecode;
  
  public Role(){
  }
  
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getRolename() {
    return rolename;
  }
  public void setRolename(String rolename) {
    this.rolename = rolename;
  }
  public String getRolecode() {
    return rolecode;
  }
  public void setRolecode(String rolecode) {
    this.rolecode = rolecode;
  }


}
