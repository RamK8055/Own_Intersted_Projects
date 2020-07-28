package com.udemy.springdemo;

public class Message {
	private String user;
	private String body;
	private String time;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Message(String user, String body, String time) {
		this.user = user;
		this.body = body;
		this.time = time;
	}
	public Message(){}
	@Override
	public String toString(){
		return this.user +" -> "+this.body+" ("+this.time+")<br>";
	}
}


