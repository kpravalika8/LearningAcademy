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
<h2>Class List</h2>

	<a href="<%=request.getContextPath()%>/class?action=createClassForm" class="btn-btn success">Create New Class</a>

	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="user" items="${classlist}">
				<tr>
					<td>${user.id}</td>
					<td>${user.classname}</td>
					<td>
					<a href="deleteClass?id=${user.id}">Delete</a>
					<a href="updateClassForm?id=${user.id}">Update</a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>


</body>
</html>