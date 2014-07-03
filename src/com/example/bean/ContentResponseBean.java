package com.example.bean;

public class ContentResponseBean extends ResponseBean {
	
	private String title ;
	private String content ;
	private String choiceid ;
	private String command ;
	private String buildtime ;
	private String endtime ;
	
	
	private ChoiceBean [] choice ;
	
	private UserMessageBean [] user_message ;
	

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
	public String getChoiceid() {
		return choiceid;
	}
	public void setChoiceid(String choiceid) {
		this.choiceid = choiceid;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public ChoiceBean[] getChoice() {
		return choice;
	}
	public void setChoice(ChoiceBean[] choice) {
		this.choice = choice;
	}
	public String getBuildtime() {
		return buildtime;
	}
	public void setBuildtime(String buildtime) {
		this.buildtime = buildtime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public UserMessageBean[] getUser_message() {
		return user_message;
	}
	public void setUser_message(UserMessageBean[] user_message) {
		this.user_message = user_message;
	}
	
	

}
