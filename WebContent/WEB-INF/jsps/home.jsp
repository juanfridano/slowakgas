<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="sk" lang="sk">

<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

<title>Slovakian Gas Transmissions</title>
<%@ include file="headTags.jsp" %>
</head>
<body>
<%@ include file="navbar.jsp" %>

<div class="container">

<div class="row">
<div class="col-md-8">
<img src="<c:url value="/static/resources/gfx/map_slo.png"/>" alt="..." class="img-responsive">
</div>
<div class="col-md-4">
<h4>Transmissions: </h4>

<!-- Form for the Graphs -->
<button type="button" class="btn btn-success">Lan&#382hot</button><br/>
<button type="button" class="btn btn-success">Baumgarten</button><br/>
<button type="button" class="btn btn-success">Budince</button><br/>
<button type="button" class="btn btn-success">Ve&#314k&#233 Kapu&#353any</button><br/>
<!-- <button type="button" class="btn btn-primary">Send request</button> -->


</div>
</div>

</div>
</body>
</html>