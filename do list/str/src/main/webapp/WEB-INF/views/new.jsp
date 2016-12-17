<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<title>add new task</title>
</head>
<body>

<h2 style="text-align: center; font-family: verdana; color: #00000F">ADD NEW TASK</h2>
 	 <c:url var="addAction" value="toaddnew"></c:url>
	<form:form action="${addAction }" commandName="task" >

		<table align="center">
			<tr>
				<td style=" font-family: verdana; color: #00000F"><form:label path="id">
						<spring:message text="ID"   />
					</form:label></td>
				<c:choose>

					<c:when test="${!empty task.id}">
						<td><form:input path="id" disabled="true" readonly="true" />
						</td>
					</c:when>

					<c:otherwise>
						<td><form:input path="id"  required="true" 
								title="Enter a valid id" /></td>
					</c:otherwise>
				</c:choose>
			</tr>

			<tr>
			    <form:input path="id" hidden ="true"/>
				<td style=" font-family: verdana; color: #00000F"><form:label path="task">
						<spring:message text="task"></spring:message>
					</form:label></td>
				<td><form:input path="task" required="true"></form:input></td>
			</tr>

			<tr>
				<td style=" font-family: verdana; color: #00000F"><form:label path="description">
						<spring:message text="Description"></spring:message>
					</form:label></td>
				<td><form:input path="description" required="true"></form:input></td>
			</tr>

			<tr>
				
				<td colspan="2" align="center"><c:if test="${!empty task.task }">
						<input type="submit"
							value="<spring:message text="Edit"></spring:message>">
					</c:if> <c:if test="${empty task.task}">
						<input type="submit"
							value="<spring:message text="Add"></spring:message>">
					</c:if></td>
			</tr>
		</table>
	</form:form>

	<br>
	

	<h2 style=" font-family: verdana; color: #00000F;text-align: center">LIST OF TASKS</h2>
	
	<c:if test="${!empty taskList}">
		<table align="center">
			<tr>
				<th style=" font-family: verdana; "> ID</th>
				<th style=" font-family: verdana; "> TASK</th>
				<th style=" font-family: verdana; "> DESCRIPTION</th>
				
			</tr>

			<c:forEach items="${taskList }" var="task">
				<tr>
					<td style=" font-family: verdana; ">${task.id}</td>
					<td style=" font-family: verdana; ">${task.task}</td>
					<td style=" font-family: verdana; ">${task.description}</td>
					</tr>
			</c:forEach>
		</table>
	</c:if>
  

</body>
</html>