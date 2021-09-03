<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Student List::</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    </head>

    <body>
        <div class="container">
            <H3>Student List ::</H3><hr/>
            <div class="row pl-2">
                <c:forEach items="${requestScope.students}" var="student">
                    <div class="col-2 bg-light">
                        <div>Id: ${student.id}</div>
                        <div>Name: ${student.name}</div>
                        <div>gpax: ${student.gpax}</div>
                        <div><hr></div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <a href="index.jsp">
            <button>Back</button>
        </a><br>
    </body>
</html>
