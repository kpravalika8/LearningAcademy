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
			<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/about.jsp">About</a></li>
			<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/class"  method="post">Manage Class</a></li>
			<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/subject"  method="post">Manage Subject</a></li>
			<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/student"  method="post">Manage Student</a></li>
			<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/teacher"  method="post">Manage Teacher</a></li>
			<div class="d-flex">
     <li class="nav-item"><a class="btn btn-outline-success my-2 my-sm-0" href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></li>
       </ul>
      </div>
  </nav>