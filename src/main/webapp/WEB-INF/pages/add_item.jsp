<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Items</title>
</head>
<body>
<div align="left">
    <h2>Enter information:</h2>
    <form:form method="post" action="result">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td><form:label path="name">Name:</form:label></td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <input type="submit" value="Submit">
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>