package com.tgb.model;

/**
 * 用户
 * @author wang
 *
 */
public class User {

  private int id;
  private String userage;
  private String username;
	 private String password;
  private String phone;
  private String sex;
	public User(){
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
  public User(int id, String age, String userName) {
		super();
		this.id = id;
		this.userage = userage;
		this.username = username;
		this.sex = sex;
		this.phone = phone;
	}
}
