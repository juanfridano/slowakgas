<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Data retrieved</title>
<%@ include file="headTags.jsp"%>
</head>
<body>
	<%@ include file="navbar.jsp"%>

	<div class="container">


		

		<form class="form-inline" method="post"
			action="${pageContext.request.contextPath}/retriever">
			<div class="form-group">
				<h3>Retrieve a period of Time from your Data Base</h3>
				<p>Date format should be dd.mm.yyy</p>

				<label for="startDate" class="col-sm-2 control-label">From:</label>
				<div class="col-sm-10">
					<input name="startDate" type="text" class="form-control"
						id="startDate" placeholder="Start Date"></input>
				</div>
				<label for="endDate" class="col-sm-2 control-label">Until:</label>
				<div class="col-sm-10">
					<input name="endDate" type="text" class="form-control" id="endDate"
						placeholder="End Date"></input>
				</div>
				<button type="submit" class="btn btn-default" value="submit">Submit</button>
			</div>
		</form>

<h6>The data shown is in MWh/day</h6>

		<table class="table">
			<thead>
				<tr>
					<th>Date</th>
					<th>Budince</th>
					<th>Lan&#382hot</th>
					<th>Ve&#314k&#233 Kapu&#353any</th>
					<th>Baumgarten</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${beanSet}" var="data">
					<tr>
						<td><c:out value="${data.date}"></c:out></td>
						<td><c:out value="${data.budince}"></c:out></td>
						<td><c:out value="${data.lanzhot}"></c:out></td>
						<td><c:out value="${data.kapusany}"></c:out></td>
						<td><c:out value="${data.baumgarten}"></c:out></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>

		<br /> <br />
		<p>
			<c:out value="${caption}"></c:out>
		</p>

	</div>
</body>
</html>