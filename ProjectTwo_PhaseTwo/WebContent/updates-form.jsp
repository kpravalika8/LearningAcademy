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
<form action="<%=request.getContextPath() %>/student?action=updateStudent">
		<input type="hidden" name="id" value="<c:out value='${studentDetail.id }' />" />
		<input type="text" name="name" placeholder="Enter Name" 
		value="<c:out value='${studentDetail.name }' />" />
		<input type="text" name="email" placeholder="Enter Email" 
		value="<c:out value='${studentDetail.email }' />" />
		<input type="text" name="country" placeholder="Enter Country" 
		value="<c:out value='${studentDetail.country }' />" />
		<input type="submit" value="Update Student" />
	
	</form>

</body>
</html>