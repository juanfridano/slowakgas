<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Get Data from Sites</title>
<%@ include file="headTags.jsp" %>
</head>
<body>

<%@ include file="navbar.jsp" %>

<div class="container">
<!--  1,000,000 m³ = 10,607 MWh -- https://tis.eustream.sk/TIS/#/?nav=rd.flw </p> -->

	<form class="form-inline"  method="post"
		action="${pageContext.request.contextPath}/getOne">
		<div class="form-group">
		<h4> Update one specific Day</h4>
		<p>Date format should be dd.mm.yyy</p>
	
			<label for="date" class="col-sm-2 control-label">Date:</label>
			<div class="col-sm-10">
				<input  name="date" type="text" class="form-control" id="date" placeholder="Date" ></input>
			</div>
			<button type="submit" class="btn btn-default" value="submit">Submit</button>
		</div>
	</form>
	
<br/>
<br/>

	<form class="form-inline"  method="post"
		action="${pageContext.request.contextPath}/getPeriod">
		<div class="form-group">
		<h4> Update a period of Time</h4>
		<p>Date format should be dd.mm.yyy</p>
	
			<label for="startDate" class="col-sm-2 control-label">From:</label>
			<div class="col-sm-10">
				<input  name="startDate" type="text" class="form-control" id="startDate" placeholder="Start Date" ></input>
			</div>
			<label for="endDate" class="col-sm-2 control-label">Until:</label>
			<div class="col-sm-10">
				<input  name="endDate" type="text" class="form-control" id="endDate" placeholder="End Date" ></input>
			</div>
			<button type="submit" class="btn btn-default" value="submit">Submit</button>
		</div>
	</form>
	
<br/>
<br/>
	<form class="form-inline"  method="post"
		action="${pageContext.request.contextPath}/getTen">
		<div class="form-group">
		<h4>Update the last 10 days</h4>
	
			<button type="submit" class="btn btn-default" value="submit">Update 10 Days</button>
	
		</div>
	</form>
	


</div>

</body>
</html>