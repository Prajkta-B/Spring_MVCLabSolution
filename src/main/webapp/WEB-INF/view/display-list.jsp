<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<title>Display List</title>
</head>
<body>
	<h4>
		<i>List of Registered Students</i>
	</h4>
	<hr>
	<div class="container">
		<form class="form-inline">
			<a href="/Lab5-SpringMVC/studentData/showFormForAdd"
				class="btn btn-primary btn-sm mb-3"> Add Student </a>
		</form>

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Department</th>
					<th>Country</th>
					<th>Action</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${StudentDetails}" var="tempStudent">
					<tr>
						<td><c:out value="${tempStudent.firstName}" /></td>
						<td><c:out value="${tempStudent.lastName}" /></td>
						<td><c:out value="${tempStudent.department}" /></td>
						<td><c:out value="${tempStudent.country}" /></td>
						<td>
							<!-- Add "update" button/link -->
							<a
							href="/Lab5-SpringMVC/studentData/showFormForUpdate?studentId=${tempStudent.id}"
							class="btn btn-info btn-sm"> Update </a>
							
							 <!-- Add "delete" button/link -->
							<a
							href="/Lab5-SpringMVC/studentData/delete?studentId=${tempStudent.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this Student?'))) return false">
								Delete </a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<hr>
	<a href="/Lab5-SpringMVC/">Home</a>
</body>
</html>
