package com.wang.model;

/**
 * 用户
 * @author wws
 *
 */
public class User {

  private int id;
  private String account;
  private String userage;
  private String username;
	 private String password;
  private String phone;
  private String sex;
  private int roleid;
  private String rolename;
  private String rolecode;
  
	public User(){

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
    return account;
  }
  public void setAccount(String account) {
    this.account = account;
  }
  public String getUserage() {
    return userage;
  }
  public void setUserage(String userage) {
    this.userage = userage;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public String getSex() {
    return sex;
  }
  public void setSex(String sex) {
    this.sex = sex;
  }
  public int getRoleid() {
    return roleid;
  }
  public void setRoleid(int roleid) {
    this.roleid = roleid;
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
  public User(int id, String userage, String username,String account, String sex, String phone,int roleid, String rolecode, String rolename){
  		this.id = id;
  		this.userage = userage;
  		this.username = username;
  		this.account = account;
  		this.sex = sex;
  		this.phone = phone;
   this.roleid = roleid;
   this.rolecode = rolecode;
   this.rolename = rolename;
	}
}
