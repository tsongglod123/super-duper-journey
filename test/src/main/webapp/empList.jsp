<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br>
<br>
<br>
<div id="employee-table" style="display: none">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Job title</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.empList}" var="emp">
            <tr>
                <td style="text-align: center">${emp.id}</td>
                <td>${emp.firstName}</td>
                <td>${emp.lastName}</td>
                <td>${emp.jobTitle}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
