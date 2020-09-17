<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/28/2020
  Time: 12:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
</head>
<body>
Hello World!

<form action="/testServlet" method="post">
  <input type="text" name="username" />
  <input type="submit" value="Send name" />
</form>

<a href="/testServlet?username=c0505">Click to servlet</a>
<a href="result.jsp">Click to result</a>
</body>
</html>