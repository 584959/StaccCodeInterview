<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<style>
    table, th, td {
        border:1px solid black;
    }
</style>
<head>
    <title>Result</title>
</head>
<body>
    <h2>Matches:</h2>
<%--    <p>${firstRow}</p>--%>
    <table>
        <tr bgcolor="#aaffaa">
            <c:forEach items="${firstRow}" var="element">
                <th>
                    <c:out value="${element}" />
                </th>
            </c:forEach>
        </tr>

        <c:forEach items="${match}" var="category">
            <tr>
            <c:forEach items="${category}" var="elem">
                <td>
                    <c:out value="${elem}" />
                </td>
            </c:forEach>
            </tr>
        </c:forEach>

<%--        <tr>--%>
<%--            <c:forEach items="${match}" var="m">--%>
<%--                <td>--%>
<%--                    <c:out value="${m}" />--%>
<%--                </td>--%>
<%--            </c:forEach>--%>
<%--        </tr>--%>
    </table>
    <p>
        <a href="home">New search</a>
    </p>


<%--    <p>${match}</p>--%>
</body>
</html>
