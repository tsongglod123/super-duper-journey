<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Subjects</title>
</head>

<body>
    <h1>TEST</h1>
    <form action="subjects" method="post">
        <div>
            <label for="semester">Select Semester : </label>
            <select name="semester" id="semester">
                <c:forEach items="${requestScope.semesters}" var="semester" varStatus="vs">
                    <option value="${vs.index}" ${vs.index == requestScope.selected ? 'selected':''}>
                            ${semester}
                    </option>
                </c:forEach>
            </select>
            <div>
                <input type="submit">
            </div>
        </div>
    </form>
    <div>
        <input type="hidden" name="semester" value="${requestScope.selected}">
        <c:forEach items="${requestScope.subjects}" var="subject" varStatus="vs">
            <p>${subject}</p>
        </c:forEach>
    </div>
    <div>
        <a href="./index.jsp">
            <button type="button">Back</button>
        </a>
    </div>
</body>
</html>
