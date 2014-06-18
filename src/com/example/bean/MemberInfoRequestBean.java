package com.example.bean ;

public class MemberInfoRequestBean extends AuthRequestBean {
	
	private String name ;
	private String sex ;
	private String email ;
	private String birthtime ;
	private String pic ;
	private String extension ;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public void setBirthtime(String brithtime) {
		this.birthtime = brithtime;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}

}
