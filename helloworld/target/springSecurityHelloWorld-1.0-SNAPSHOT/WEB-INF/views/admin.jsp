<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.Iterator" %>
<%@page session="true" import="java.util.*"%>
<html>
<body>
	<h1>Hello Security World!</h1>
	<h1>Status : <%=(String)request.getAttribute("status")%> </h1>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a></h2>  
	</c:if>

	<form action="secure" method="GET">
		<p><b>User name list:</b></p>
		<p><select required  name="namet" id="namet">
		<option>List of user name</option>
		<%Iterator itr;%>
		<%List data = (List)request.getAttribute("data");
			for(itr=data.iterator();itr.hasNext();) {
		%>
		<option><%=itr.next()%></option>
		<%}%>
	</select></p></form>

</body>
</html>