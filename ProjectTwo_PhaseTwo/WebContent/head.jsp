<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- nav bar Begin -->
<header>
	<!-- Fixed navbar -->
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		<a class="navbar-brand" href="#"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="<%= request.getContextPath()%>/welcome.jsp">Home
						<span class="sr-only">(current)</span>
						</a></li>
			<li class="nav-item"><a class="btn btn-primary" href="<%=request.getContextPath()%>/registration.jsp">Register</a></li>
			<li class="nav-item"><a class="btn btn-info" href="<%=request.getContextPath()%>/login.jsp">Login</a></li>
		 </ul>
      </div>
  </nav>