<%--
  Created by IntelliJ IDEA.
  User: ilkin
  Date: 1/15/2020
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Image</title>
</head>
<body>
<% String name = (String) request.getAttribute("image");

%>
<img src="upload/<%=name%>" style="width: 200px ; height: 200px">

</body>
</html>
