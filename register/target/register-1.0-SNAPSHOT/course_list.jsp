<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <link rel="stylesheet" type="text/css" href="assets/bootstrap-4.5/css/bootstrap.min.css"/>
</head>

<body>
<div class="container m-auto bg-light w-50">
    <div class="row w-100 h2">Course List ::</div>
    <div class="row w-100">
        <form class="form-inline" action="course-list" method="post">
            <div class="form-group mx-4">
                <label for="semester" class="mr-4">Select Semester : </label>
                <select name="semester" id="semester" class="px-4">
                    <c:forEach items="${requestScope.semesters}" var="semester" varStatus="vs">
                        <c:if test="${semester != null}">
                            <option value="${vs.index}" ${vs.index == requestScope.selectedSemester ? 'selected':''}>
                                    ${semester}
                            </option>
                        </c:if>
                    </c:forEach>
                </select>
                <div class="px-3">
                    <input type="submit">
                </div>
            </div>
        </form>
    </div>
    <c:if test="${requestScope.subjects != null}">
        <div class="container m-auto h-auto">
            <form action="register-course" method="post">
                <input type="hidden" name="semester" value="${requestScope.selectedSemester}">
                <div class="row bg-white">
                    <div class="col-1">No.</div>
                    <div class="col-1">Code</div>
                    <div class="col-5">Subject</div>
                    <div class="col-1">Unit</div>
                    <div class="col-1">Choose</div>
                </div>
                <c:forEach items="${requestScope.subjects}" var="subject" varStatus="vs">
                    <div class="row bg-transparent">
                        <div class="col-1">${vs.count}</div>
                        <div class="col-1">${subject.subjectId}</div>
                        <div class="col-6">${subject.title}</div>
                        <div class="col-1">${subject.credit}</div>
                        <div class="col-1">
                            <label>
                                <input type="checkbox" name="registeredSubjects" value="${subject.subjectId}">
                            </label>
                        </div>
                    </div>
                </c:forEach>
                <hr>
                <div class="form-group">
                    <input type="submit" value="Register">
                </div>
            </form>
        </div>
    </c:if>
</div>
</body>
</html>
