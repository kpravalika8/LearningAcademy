<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Student List</h2>

	<a href="<%=request.getContextPath()%>/student?action=createStudentForm">Create New Student</a>

	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Country</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="user" items="${studentlist}">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.country}</td>
					<td>
					<a href="deleteUser?id=${user.id}">Delete</a>
					<a href="updateUserForm?id=${user.id}">Update</a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>


</body>
</html>