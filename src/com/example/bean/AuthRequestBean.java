package com.example.bean ;

public class AuthRequestBean extends RequestBean {
	
	private String account ;
	private String password ;
	private String sessionid ;
	private String type="01" ;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}