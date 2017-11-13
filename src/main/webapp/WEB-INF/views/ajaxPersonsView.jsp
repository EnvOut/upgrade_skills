<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <title>Title</title>
        <%----%>
        <link rel="stylesheet"
              href="<c:url value="/resources/libs/dynamic-table-master/css/dynamic-table.jquery.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/libs/dynamic-table-master/css/jquery-ui.css"/>">

        <script src="<c:url value="/resources/libs/dynamic-table-master/js/jquery.js" />"></script>
        <script src="<c:url value="/resources/libs/dynamic-table-master/js/jquery-ui.js" />"></script>
        <%--<script src="<c:url value="/resources/libs/dynamic-table-master/js/moment.js" />"></script>--%>
        <%--<script src="<c:url value="/resources/libs/dynamic-table-master/js/dynamic-table.jquery.js" />"></script>--%>
        <%--<script src="<c:url value="/resources/libs/dynamic-table-master/js/dynamic-table-editor.jquery.js" />"></script>--%>
        <script src="<c:url value="/resources/script.js" />"></script>


        <link href="https://cdnjs.cloudflare.com/ajax/libs/tabulator/3.3.1/css/tabulator.min.css" rel="stylesheet">
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/tabulator/3.3.1/js/tabulator.min.js"></script>
    </head>
    <body>
        <div id="sample-grid">

        </div>

        <div id="selected-data">&nbsp;</div>
        <div id="save-data">&nbsp;</div>

        <div>
            <button id="clear-all-button">Clear All Filters</button>
        </div>
    </body>
</html>
