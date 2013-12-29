<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style type="text/css">
.ipTable { border-collapse:collapse}
.ipTable td, .ipTable th { padding:5px;border:1px solid #000; }
</style>


<title>IP Address Details</title>
</head>
<body>
	<c:set var="ipBean" value="${requestScope.ipBean}" scope="page" />
	<c:choose>
		<c:when test="${ipBean.isError}">
			<c:out value="${ipBean.errorMsg}"></c:out>
		</c:when>

		<c:otherwise>
			<table class="ipTable">
				<tbody>
					<tr>
						<td>Your Ip</td>
						<td><c:out value="${ipBean.ipAddr}" /></td>
					</tr>
					<tr>
						<td>Country</td>
						<td><c:out value="${ipBean.country}" /></td>
					</tr>
					<tr>
						<td>State</td>
						<td><c:out value="${ipBean.state}" /></td>
					</tr>
					<tr>
						<td>City</td>
						<td><c:out value="${ipBean.city}" /></td>
					</tr>
					<tr>
						<td>Longitude</td>
						<td><c:out value="${ipBean.longitude}" /></td>
					</tr>
					<tr>
						<td>Latitude</td>
						<td><c:out value="${ipBean.latitude}" /></td>
					</tr>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>