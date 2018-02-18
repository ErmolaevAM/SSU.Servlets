<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Items</title>
</head>
<body>
<table border="1px black">
    <thead>
    <th width="50px"><h3>ID</h3></th>
    <th width="150px"><h3>TITLE</h3></th>
    <th width="150px"><h3>PRICE</h3></th>
    <th width="500px"><h3>DESCRIPTION</h3></th>
    </thead>
    <tbody>
    <tr>
        <td>smpID</td>
        <td>smpTITLE</td>
        <td>smpPRICE</td>
        <td>smpDESC</td>
    </tr>
    <c:forEach var="item" items="${itemList}">
        <tr>
            <td>${item.getId()}</td>
            <td>${item.getTitle()}</td>
            <td>${item.getPrice()}</td>
            <td>${item.getDesc()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
