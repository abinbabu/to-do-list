<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>home</title>
<link href="<c:url value="/resources/css/navbar-fixed-top.css" />"
	rel="stylesheet">
</head>
<body>
<!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">TO DO !!!</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            
            <li><a href="register">Sign up</a></li>
            <div class="navbar-form navbar-right">

							<button type="submit" class="btn btn-success" data-toggle="modal"
								data-target="#mysignin">Sign in</button>


						</div>
            </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
    <!-- Modal -->
		<div class="modal fade" id="mysignin" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">login here</h4>
					</div>
					<div class="modal-body">
						<c:url var="action" value="/login"></c:url>

						<form:form action="${action}" method="post">
							<table>
								<tr>
									<td>User Id:</td>

									<td><input type="text" name="name"></td>
								</tr>

								<tr>
									<td>Password:</td>
									<td><input type="password" name="password" /></td>
								</tr>

							</table>
					</div>
					<div class="modal-footer">
						<td><input type="submit" value="Login"></td>
					</div>
					</form:form>
				</div>

			</div>
		</div>

	</div>
<div id="login">
			<c:if
				test="${isUserClickedLoginHere==true || invalidCredentials==true}">
				<div id="error">${errorMessage}</div>


			</c:if>
		</div>
		
		<div id="isuser">
			<c:if test="${isuser==true }">
				<%@ include file="task.jsp"%> 
			</c:if>
		</div>
		
</body>
</html>