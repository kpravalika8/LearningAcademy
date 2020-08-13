<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form action="<%=request.getContextPath() %>/class?action=createClass">
	
	<input type="text" name="name" placeholder="Enter ClassName" />
	<input type="submit" value="Add Class" />
	
	</form>

</body>
</html>