<%--
  Created by IntelliJ IDEA.
  User: lpzh
  Date: 2020/12/14
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<html>
<head>
    <title>index.jsp</title>
</head>
<body>
    <h3> hello webapp </h3>
    <%
        Date now = new Date();
        
    %>
    <span>服务器时间: </span><fmt:formatDate value="<%=now%>" pattern="yyyy-MM-dd HH:mm:ss"/>
</body>
</html>
