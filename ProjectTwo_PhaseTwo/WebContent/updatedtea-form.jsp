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
<form action="<%=request.getContextPath() %>/teacher?action=updateTeacher">
		<input type="hidden" name="id" value="<c:out value='${teacherDetail.id }' />" />
		<input type="text" name="name" placeholder="Enter Name" 
		value="<c:out value='${teacherDetail.name }' />" />
		<input type="text" name="email" placeholder="Enter Email" 
		value="<c:out value='${teacherDetail.email }' />" />
		<input type="text" name="country" placeholder="Enter Country" 
		value="<c:out value='${teacherDetail.country }' />" />
		<input type="submit" value="Update Teacher" />
	
	</form>
</body>
</html>