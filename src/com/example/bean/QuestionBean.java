package com.example.bean;

public class QuestionBean {
	
	private String questionid ;
	private String title ;
	private String name  ;
	private String buildtime ;
	private String finishtime ;
	private String num_click ;
	private String num_message ;
	private TypeBean [] type  ;
	
	public String getQuestionid() {
		return questionid;
	}
	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBuildtime() {
		return buildtime;
	}
	public void setBuildtime(String buildtime) {
		this.buildtime = buildtime;
	}
	public String getFinishtime() {
		return finishtime;
	}
	public void setFinishtime(String finishtime) {
		this.finishtime = finishtime;
	}
	public String getNum_click() {
		return num_click;
	}
	public void setNum_click(String num_click) {
		this.num_click = num_click;
	}
	public String getNum_message() {
		return num_message;
	}
	public void setNum_message(String num_message) {
		this.num_message = num_message;
	}
	public TypeBean[] getType() {
		return type;
	}
	public void setType(TypeBean[] type) {
		this.type = type;
	}

}
