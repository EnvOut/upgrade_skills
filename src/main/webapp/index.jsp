<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>$Title$</title>
    </head>

    <body>
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
    </body>
</html>
