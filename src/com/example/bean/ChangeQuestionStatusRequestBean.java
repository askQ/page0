package com.example.bean;

public class ChangeQuestionStatusRequestBean extends QuestoinRequestBean {
	
	private String choiceid ;
	private String command ;	
	
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

}
