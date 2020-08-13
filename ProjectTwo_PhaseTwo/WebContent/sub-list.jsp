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
<a href="<%=request.getContextPath()%>/subject?action=/createSubForm">Create New Subject</a>

	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="sub" items="${sublist}">
				<tr>
					<td>${sub.id}</td>
					<td>${sub.subjectname}</td>
					<td>
					<a href="deleteSub?id=${sub.id}">Delete</a>
					<a href="updateSubForm?id=${sub.id}">Update</a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>



</body>
</html>