<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Spring Security学习</title>
</head>
<body>
<p>欢迎登录</p>
<form:form method="post" action="${pageContext.request.contextPath}/logout">
    <button type="submit">Logout</button>
</form:form>

</body>
</html>
