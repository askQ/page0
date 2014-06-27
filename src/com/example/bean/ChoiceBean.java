package com.example.bean;

public class ChoiceBean {
	
	//request會用到之攔位
	private String title ;
	private String content ;
	private String pic ;
	private String extension ;
	
	//response 會用到之攔位
	private String picurl ;
	private String num_click ;
	private String num_boy ;
	private String num_girl ;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	public String getNum_click() {
		return num_click;
	}
	public void setNum_click(String num_click) {
		this.num_click = num_click;
	}
	public String getNum_boy() {
		return num_boy;
	}
	public void setNum_boy(String num_boy) {
		this.num_boy = num_boy;
	}
	public String getNum_girl() {
		return num_girl;
	}
	public void setNum_girl(String num_girl) {
		this.num_girl = num_girl;
	}
	

}
