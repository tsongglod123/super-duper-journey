<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Practice</title>
    <style>
        table, th, td {
            border: 1px solid white;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<script>
    function showOffice() {
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            document.getElementById("office-list").innerHTML = this.responseText;
        }
        xhttp.open("GET", "office");
        xhttp.send();
    }

    function showEmpList(officeCode) {
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            document.getElementById("emp-list").innerHTML = this.responseText;
            let state = document.getElementById("button-" + officeCode).innerHTML;
            let table = document.getElementById("employee-table");
            if (state.includes("show") && xhttp.status === 200) {
                document.getElementById("button-" + officeCode).innerHTML = "close";
                if (table.style.display === "none") {
                    table.style.display = "block";
                }
            } else {
                document.getElementById("button-" + officeCode).innerHTML = "show";
                if (table.style.display === "block") {
                    table.style.display = "none";
                }
            }
        }
        xhttp.open("GET", "employee-list?officeCode=" + officeCode);
        xhttp.send();
    }
</script>
<c:if test="${cookie.currentContents.value != null}">
    <script>
        window.onload = (ev) => {
            ${cookie.currentContents.value == "office" ? "showOffice()" : ""}
        };
    </script>
</c:if>
<h1 style="font-size: 100px">Welcome</h1>
<button type="button" onclick="showOffice()">Office</button>
<div id="office-list"></div>
<div id="emp-list"></div>
</body>
</html>