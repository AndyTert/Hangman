<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="hangman.model.HMWord"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% HMWord word = (HMWord) session.getAttribute("word");
int i = word.getWrongLettersSize();%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=word.printWinOrLose()%></title>
</head>
<body>
<H1><%=word.printWinOrLose()%></H1>

<img alt="" src="img/<%=i%>.jpg">

<br>

<a href="http://localhost:8080/Hangman/">PLAY AGAIN</a>
</body>
</html>