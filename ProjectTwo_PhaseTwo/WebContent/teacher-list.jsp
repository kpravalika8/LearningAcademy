<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>User List</h2>

	<a href="<%=request.getContextPath()%>/teacher?action=/createTeacherForm">Create New
		User</a>

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

			<c:forEach var="t" items="${teacherlist}">
				<tr>
					<td>${t.id}</td>
					<td>${t.name}</td>
					<td>${t.email}</td>
					<td>${t.country}</td>
					<td>
					<a href="deleteTeacher?id=${t.id}">Delete</a>
					<a href="updateTeacherForm?id=${t.id}">Update</a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>