package com.cinema.prosenium.entity;
/**
 * �û�����
 * @author Administrator
 *
 */
public class User {
	//�û����
	private int userId;
	//�û���
	private String userName;
	//�û�����
	private String userPwd;
	//�û�����
	private int userType;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int userId, String userName, String userPwd, int userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userType = userType;
	}

	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType1(int userType1) {
		this.userType = userType1;
	}
	
	
	

}
