<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Registration-Form</title>
</head>

<body>
	<hr>
	<form action="/Lab5-SpringMVC/studentData/save" method="POST">
	
					
			<input type="hidden" name="id" value="${StudentDetails.id}">

		<div>

			<table>
				<tr>
					<th>FirstName</th>
					<td class="form-inline"><input type="text" name="firstName"
						value="${StudentDetails.firstName}"></td>
				</tr>
				<tr>
					<th>LastName</th>
					<td class="form-inline"><input type="text" name="lastName"
						value="${StudentDetails.lastName}"></td>
				</tr>
				<tr>
					<th>Department</th>
					<td class="form-inline"><input type="text" name="department"
						value="${StudentDetails.department}"></td>
				</tr>
				<tr>
					<th>Country</th>
					<td class="form-inline"><input type="text" name="country"
						value="${StudentDetails.country}"></td>
				</tr>
			</table>
		

		<button type="submit" class="btn btn-info">Save</button>
		
		</div>
	</form>


	<hr>
	<a href="/Lab5-SpringMVC/studentData/list">Back to Students List</a>
</body>

</html>