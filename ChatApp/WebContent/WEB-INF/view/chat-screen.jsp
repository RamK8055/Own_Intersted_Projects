<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.udemy.springdemo.*"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Message</title>
<style type="text/css">
.html_message {
	height: 100%;
	font-family: 'Roboto', sans-serif;
}

.body_message {
	background: #ddd;
	height: 95%;
}

.left_container {
	background: #ddd;
	height: 98%;
	/*width: 28%;*/
	width: 28%;
	float: left;
	padding: 10px;
	border-radius: 10px;
}

.middle_container {
	width: 2px;
	background: #555555;
	float: left;
	height: 500px;
}

.middle_container2 {
	width: 2%;
	background: #ddd;
	float: left;
	height: 100%;
}

.right_container {
	width: 65%;
	height: 500px;
	/*width: 100%;*/
	max-height:98%;
	background: #ddd;
	float: left;
	/* padding: 10px; */
	border-radius: 10px;
	/* padding: 10px; */
	overflow: auto;
}

.textinput {
	width: 100%;
	padding: 50% 0%;
}

.textarea:focus {
	background-color: white;
	outline: none;
}

.button {
	background-color: #555555;
	/* Green */
	width: 96%;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	border-radius: 5px;
}

.button:hover {
	background-color: rgb(141, 141, 141);
	/* Green */
	color: white;
}

.textarea {
	width: 90%;
	padding: 0px;
	margin: 5px 0 22px 0;
	border: none;
	background: #eee;
	border: 2px solid rgb(156, 156, 156);
	border-radius: 7px;
	resize: none;
	padding: 10px;
	min-height: 50px;
}

.message {
	width: 60%;
	height: 10%;
}

.header {
	width: 100%;
	height: 30%;
}

.message_body {
	background: white;
	border: solid rgb(197, 197, 197) 2px;
	border-radius: 8px;
}

.sender_space {
	width: 2%;
	float: left;
}

.sender {
	width: 68%;
	float: left;
	font-weight: bold;
	font-family: "Comic Sans MS";
}

.time {
	width: 30%;
	float: right;
	/* font-size: 15px; */
	font-style: italic;
	font-family: "Comic Sans MS";
}

.msg_body {
	width: 70%;
	padding: 5px;
	/* background-color: #a496f5; */
	border-radius: 5px;
}

.msg_header {
	width: 100%;
	padding: 2px;
	height: 20px;
}

.msg_user {
	width: 85%;
	float: left;
	/* font-style: italic; */
	font-weight: bold;
}

.msg_content {
	font-family: "Comic Sans MS";
	background-color: azure;
	padding: 5px;
	border-radius: 5px;
	font-size: 14px;
}

.msg_time {
	font-size: 13px;
	font-style: italic;
	font-family: "Comic Sans MS";
}
</style>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js">
	
</script>
<script>
	$(document).ready(function() {
		setInterval(function() {

			$.ajax({
				url : "chatWindow",
				success : function(data) {
					$("#right_cont").html(data);
					$("#right_cont").scrollTop($(document).height()); 
				}
			});

		}, 500);
	});
</script>
<script> 
        $(document).ready(function() { 
            $("#sub").click(function() { 
                $(document).scrollTop($(document).height()); 
            }); 
        }); 
    </script> 

</head>
<body class="body_message">
    <div class="left_container">
        <h4>
            <b>Message:</b><br>
            <br>
            <form method="post" action="/ChatApp/chat">
                <input type="text" name="message" class="textarea" placeholder="Type message.." autocomplete="off" name="msg" required autofocus />
                <br>
                <input type="submit"  id ="sub" value="Send" class="button" />
            </form>
        </h4>
    </div>
    <div class="middle_container">&nbsp;</div>
    <div class="middle_container2">&nbsp;</div>
    <div class="right_container" id="right_cont">
    </div>
</body>

</html>














