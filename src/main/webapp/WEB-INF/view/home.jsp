<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Spring Security学习</title>
</head>
<body>
<p>欢迎登录</p>
<p>
    User: <security:authentication property="principal.username"/>
    <br><br>
    Roles: <security:authentication property="principal.authorities"/>
    <br><br>
</p>
<form:form method="post" action="${pageContext.request.contextPath}/logout">
    <button type="submit">Logout</button>
</form:form>


<security:authorize access="hasRole('MANAGER')">
<p><a href="${pageContext.request.contextPath}/leader">Managers only</a></p>
</security:authorize>

<security:authorize access="hasRole('ADMIN')">
<p><a href="${pageContext.request.contextPath}/system">System only</a></p>
</security:authorize>
</body>
</html>
