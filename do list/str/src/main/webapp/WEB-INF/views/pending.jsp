<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="refresh" content="1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>added tasks</title>

</head>
<body>
<h2 style=" font-family: verdana; color: #00000F;text-align: center">LIST OF TASKS</h2>
	
	<c:if test="${!empty taskList}">
		<table align="center">
			<tr>
				<th style=" font-family: verdana; "> ID</th>
				<th style=" font-family: verdana; "> TASK</th>
				<th style=" font-family: verdana; "> DESCRIPTION</th>
				<th style=" font-family: verdana; "> STATUS</th>
				
			</tr>

			<c:forEach items="${taskList }" var="task">
				<tr>
					<td style=" font-family: verdana; ">${task.id}</td>
					<td style=" font-family: verdana; ">${task.task}</td>
					<td style=" font-family: verdana; ">${task.description}</td>
					<td style=" font-family: verdana; ">${task.status}</td>
					<td> <a href="<c:url value='task/delete/${task.id}' />">Delete</a></td>
					<td> <a href="<c:url value='task/update/${task.id}' />">Update</a></td>
					</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>