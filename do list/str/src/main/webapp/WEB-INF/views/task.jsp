<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>task</title>

</head>
<body>

<table width="80%">
<tr>
				<c:choose>
					<c:when test="${empty loggedInUser}">
					</c:when>

					<c:when test="${not empty loggedInUser}">
						<td>Welcome ${loggedInUser},</td>
						<td align="right"><a href="logout"> logout</a></td>
					</c:when>
				</c:choose>
			</tr>
			<tr>
				<c:if test="${loggedOut==true}">
					<td>${logoutMessage}</td>
				</c:if>
			</tr>
</table>
</div>
<div id="login">
			<c:if
				test="${isUserClickedLoginHere==true || invalidCredentials==true}">
				<div id="error">${errorMessage}</div>


			</c:if>
		</div>

<table width="50%">
		<tr>
			<td align="left"><a href="new"
				style="textfont-size: 200%; font-family: verdana; color: #00000F">New Reminder</a></td>
				
			<td align="right"><a href="pending"
				style="textfont-size: 200%; font-family: verdana; color: #00000F">Added Task</a></td>
			<td></td><td align="center"><a href="completed"
				style="textfont-size: 200%; font-family: verdana; color: #00000F">completed
				</a></td>

		</tr>

	</table>


<div id="new">
			<c:if test="${isnew==true }">
				<%@ include file="new.jsp"%>
			</c:if>
		</div>
		
<div id="pending">
			<c:if test="${isnewp==true }">
				<%@ include file="pending.jsp"%>
			</c:if>
		</div>
		
<div id="completed">
			<c:if test="${isnewc==true }">
				<%@ include file="completed.jsp"%>
			</c:if>
		</div>



</body>
</html>