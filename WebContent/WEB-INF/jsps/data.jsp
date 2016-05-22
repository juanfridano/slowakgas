<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
	<thead><tr><th>Point</th><th>Value</th></tr></thead>
	<tbody>
	<c:forEach items="${data}" var="data">
    <tr><td><c:out value="${data.key}"></c:out></td><td><c:out value="${data.value}"></c:out></td></tr>
	</c:forEach>
	</tbody>
</table>

</body>
</html>