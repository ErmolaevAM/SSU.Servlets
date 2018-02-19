<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 19.02.2018
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create item</title>
</head>
<body>
<div>
    <a href="/add">Add item</a>
    |
    <a href="/items">Show all items</a>
</div>
<br>
<form action="/add" method="post">
    <table border="1px black">
        <tr>
            <td width="100px">TITLE</td>
            <td width="100px">
                <input type="text" name="title">
            </td>
        </tr>
        <tr>
            <td width="100px">PRICE</td>
            <td width="100px">
                <input type="number" min="5" name="price">
            </td>
        </tr>
        <tr>
            <td width="100px">DESCRIPTION</td>
            <td width="100px">
                <textarea name="description" id="desc" cols="50" rows="5"></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">ADD</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
