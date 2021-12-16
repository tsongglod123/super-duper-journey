<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer</title>
</head>
<body>
<h1>63130500042 Songglod Petchamras</h1>
<table>
    <tbody>
    <c:forEach items="${requestScope.customers}" var="cus" varStatus="vs">
        <tr>
            <td style="text-align: center">042-${vs.count}</td>
            <td style="text-align: center">${cus.id}</td>
            <td>${cus.customerName}</td>
            <td>${cus.city}</td>
            <td>${cus.country}</td>
            <td>${cus.phone}</td>
            <td>${cus.role}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
