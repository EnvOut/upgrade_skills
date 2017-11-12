<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <title>Title</title>
        <script src="<c:url value="/resources/libs/jquery-3.2.1.min.js"/>"></script>
        <script src="<c:url value="/resources/libs/jquery.dynatable.js"/>"></script>
        <link rel="stylesheet" href="<c:url value="/resources/libs/jquery.dynatable.css"/>">

        <script src="<c:url value="/resources/script.js" />"></script>
    </head>
    <body>
        ajax2 reloaded

        <table id="my-final-table">
            <thead>
                <th>ID</th>
                <th>First name</th>
                <th>Last name</th>
            </thead>
        </table>
    </body>
</html>
