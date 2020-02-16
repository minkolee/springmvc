<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>输入用户信息</title>
    <link rel="stylesheet"  type="text/css" href="/css/style.css">
</head>
<body>
<h1>用户登录</h1>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    <label for="">
        用户名 <input type="text" name="userName">
    </label>
    <label for="">
        年龄 <input type="number" name="age">
    </label>
    <label for="">
        住址<input type="text" name="address.detail"></label>
    <button type="submit">提交</button>
</form>

</body>
</html>
