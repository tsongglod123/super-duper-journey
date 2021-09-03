<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Student information</title>
    </head>

    <body>
        <h2>Student info</h2>
        <hr>
        Student ID: ${requestScope.student.id} <br>
        Student Name: ${requestScope.student.name} <br>
        Student GPAX: ${requestScope.student.gpax} <br>
        <hr>
        <a href="index.jsp">
            <button>OK</button>
        </a><br>
        <c:forEach begin="1" end="10" varStatus="vs">
            ${vs.count}
        </c:forEach>
    </body>
</html>
