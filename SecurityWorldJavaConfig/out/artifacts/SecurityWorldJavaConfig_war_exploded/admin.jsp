<%--
  Created by IntelliJ IDEA.
  User: Technology
  Date: 29.02.16
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
<h1>${title}</h1>
<h1>Status : ${message}</h1>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>Welcome : ${pageContext.request.userPrincipal.name}
        | <a href="<c:url value="/logout" />" > Logout</a></h2>
</c:if>
</body>
</html>
