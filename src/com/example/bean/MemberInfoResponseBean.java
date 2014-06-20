package com.example.bean;

public class MemberInfoResponseBean extends ResponseBean {
	
	private String account ;
	private String name ;
	private String picurl ;
	private String sex ;
	private String email ;
	private String birthtime ;
	
	private QuestionBean [] question ;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	public QuestionBean[] getQuestion() {
		return question;
	}
	public void setQuestion(QuestionBean[] question) {
		this.question = question;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthtime() {
		return birthtime;
	}
	public void setBirthtime(String birthtime) {
		this.birthtime = birthtime;
	}

}
