<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>${pageName}</title>
    <t:importAttribute name="stylesheets"/>
    <c:forEach var="css" items="${stylesheets}">
        <link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
    </c:forEach>
</head>
<body>
<div id="main_container">
    <t:insertAttribute name="header" />
    <div id="div_container" class="inTheLeftPosition">
        <div id="content_container">
            <t:insertAttribute name="body" />
        </div>
    </div>
</div>
<t:insertAttribute name="footer" />
<t:importAttribute name="javascript"/>
<c:forEach var="script" items="${javascript}">
    <script type="text/javascript" src="<c:url value="${script}"/>"></script>
</c:forEach>
</body>
</html>