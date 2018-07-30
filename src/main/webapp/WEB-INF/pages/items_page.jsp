<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Item list</title>
</head>
<body>
    <h3>Item List</h3>
    <form:form method="post" action="search">
    <div align="left">
        <input type="search" name="search_request">
        <input type="submit" value="Search">
    </div>
    </form:form>
    <p/>
    <div align="left">
        <table border="1">
            <th>Id</th>
            <th>Name</th>
            <c:forEach var="item" items="${command}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
