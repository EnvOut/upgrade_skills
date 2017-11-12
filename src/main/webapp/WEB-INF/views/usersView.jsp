<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <title>$Title$</title>
    </head>

    <body>
        <div class="col-sm-offset-1 col-sm-10">
            <div>
                <table id="dataTable" class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>firstName</th>
                            <th>lastName</th>
                        </tr>
                    <thead>
                    <tbody>
                        <c:forEach var="person" items="${persons}">
                            <tr>
                                <td>${person.id}</td>
                                <td>${person.firstName}</td>
                                <td>${person.lastName}</td>
                            </tr>
                        </c:forEach>
                        $END$
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
