<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>主页</title>
    <link rel="stylesheet"  type="text/css" href="/css/style.css">
</head>
<body>
<h1>主页</h1>
<c:if test="${user!=null}">
    <p>用户信息: ${user}</p>
</c:if>

<c:if test="${test!=null}">
    <p>测试模型信息: ${test}</p>
</c:if>

<c:if test="${modelUser!=null}">
    <p>测试模型信息: ${modelUser}</p>
</c:if>

<p>当前时间是: ${time}</p>

</body>
</html>
