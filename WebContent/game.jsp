<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="hangman.model.HMWord"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>World's Hardest Hangman!!</title>
</head>
<%HMWord word = (HMWord) session.getAttribute("word");
int i = word.getWrongLettersSize();
%>
<body>
	<img alt="" src="img/<%=i%>.jpg">
	<form action="/Hangman/GameServlet" method="get">
	<%=word.printPlaceholders() %>  <br>
	<%=word.printWrongLetters() %>  <br>
		Please Enter A Letter: <input type="text" name="letter" maxLength="1" width="1em">
		<br>
		<input type="submit" value="Enter">
	</form>
</body>
</html>