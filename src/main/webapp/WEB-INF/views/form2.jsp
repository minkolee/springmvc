<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>输入怪物信息2</title>
    <style>
        .errorClass {
            color: red;
        }

    </style>
</head>
<body>
<h1>输入怪物名称</h1>
<form action="/mhwi/add2" method="post">
    <div>
    <c:if test="${monsterNameError!=null}">
        <p class="errorClass">${monsterNameError}</p>
    </c:if>
    <label for="">输入怪物名称 <input name="monsterName" type="text" value="${vel.monsterName}"></label>
    </div>
    <div>
    <c:if test="${sizeError!=null}">
        <p class="errorClass">${sizeError}</p>
    </c:if>
    <label for="">输入怪物大小 <input name="size" type="number" value="${vel.size}"></label>
    </div>
    <div>
        <c:if test="${releaseDateError!=null}">
        <p class="errorClass">${releaseDateError}</p>
    </c:if>
    <label for="">输入参战日期 <input name="releaseDate" type="text" value="${vel.releaseDate}"></label>
    </div>
    <button type="submit">提交</button>
</form>
</body>
</html>
