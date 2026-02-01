<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sample JSP Page</title>
</head>
<body>

    <h1>Welcome to JSP</h1>

   <form action="addAlien" method="post">
		Enter your id : <input type="text" name="aid"><br>
		Enter your name : <input type="text" name="aname"><br>
		<input type="submit">
   </form>
   
   <form action="getAlien" method="get">
		Enter your id : <input type="text" name="aid"><br>
		<input type="submit">
   </form>
   
   <form action="getAlienByName" method="get">
		Enter your name : <input type="text" name="aname"><br>
		<input type="submit">
   </form>
	
</body>
</html>
