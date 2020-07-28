package com.udemy.springdemo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainClassController {

	List<Message> message = new ArrayList<>();

	@RequestMapping("/")
	public String inputMethod2() {
		return "chat-login";
	}

	@RequestMapping("/welcome")
	public String inputMethod3(HttpServletRequest request,HttpServletResponse response, Model model) {
		response.addCookie(new Cookie("userCookie",request.getParameter("username")));
		return "chat-welcome";
	}

	@RequestMapping("/chat")
	public String inputMethod(HttpServletRequest request, Model model) {
		
		//To generate data:
		DateFormat dateFormat = new SimpleDateFormat("hh:mm aa");
    	String dateString = dateFormat.format(new Date()).toString().toLowerCase();
    	System.out.println(dateString);
    	
		String msg = request.getParameter("message");
		String sender = "";
		Cookie[] cookies = request.getCookies();
		for(int i=0;i<cookies.length;i++){
			System.out.println(cookies[i].getName()+"-"+cookies[i].getValue());
			if(cookies[i].getName().equals("userCookie"))
				sender = cookies[i].getValue();
		}
		if (msg != null) {
			Message m = new Message(sender,msg,dateString);
			message.add(m);
			model.addAttribute("AllMessage", message);
		}
		return "chat-screen";
	}
	
	//Used JQuerry for dynamic message send and recive
	@RequestMapping("/chatWindow")
	@ResponseBody
	public String getMessage() {
		String output="";
		for(Message msg: message){
			output+="<div class='msg_body'><div class='msg_header'><div class='msg_user'>"+msg.getUser()+"</div><div class='msg_time' style='width:15%; float:left'>"+msg.getTime()+"</div></div><div class='msg_content' style='border-width:2px;border-color:green'>"+msg.getBody()+"</div></div>";
		}
		return output;
	}
}






