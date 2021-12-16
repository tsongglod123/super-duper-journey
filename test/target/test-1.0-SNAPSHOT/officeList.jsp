<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br>
<br>
<br>
<div id="office-table">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>City</th>
            <th>Country</th>
            <th>Employee</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.offices}" var="office">
            <tr>
                <td style="text-align: center">${office.id}</td>
                <td>${office.city}</td>
                <td>${office.country}</td>
                <td style="text-align: center">
                    <button id="button-${office.id}" type="button" onclick="showEmpList(${office.id})">show</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>