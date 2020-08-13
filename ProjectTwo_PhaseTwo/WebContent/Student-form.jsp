<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/student?action=/createStudent">
	
	<input type="text" name="name" placeholder="Enter Name" />
	<input type="text" name="email" placeholder="Enter Email" />
	<input type="text" name="country" placeholder="Enter Country" />
	<input type="submit" value="Add Student" />
	
	</form>


</body>
</html>