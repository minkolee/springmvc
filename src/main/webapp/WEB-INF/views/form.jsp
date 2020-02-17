<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>输入怪物信息</title>
    <style>
        .errorClass {
            color: red;
        }

    </style>
</head>
<body>
<h1>输入怪物名称</h1>
<form:form modelAttribute="vel" action="${pageContext.request.contextPath}/mhwi/add">
    <div>
        请输入怪物名称
        <form:errors path="monsterName" cssClass="errorClass"/>
        <form:input path="monsterName" type="text"/>
    </div>
    <div>
        请输入怪物大小
        <form:errors path="size" cssClass="errorClass"/>
        <form:input path="size" type="number"/>
    </div>
    <div>
        请输入怪物参战时间
        <form:errors path="releaseDate" cssClass="errorClass"/>
        <form:input path="releaseDate" type="text"/>
    </div>
    <button type="submit">提交</button>
</form:form>
</body>
</html>
