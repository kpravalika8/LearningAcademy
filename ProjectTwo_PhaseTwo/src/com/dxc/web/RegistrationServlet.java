package com.dxc.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.dao.UserDAO;
import com.dxc.models.User;



public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 UserDAO userDao;
	    public RegistrationServlet() {
	        super();
	        userDao=new UserDAO();
   
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.sendRedirect("registration.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        User user = new User();
	        user.setFirstName(firstName);
	        user.setLastName(lastName);
	        user.setUsername(username);
	        user.setPassword(password);

	        userDao.saveUser(user);

	        RequestDispatcher dispatcher = request.getRequestDispatcher("register-success.jsp");
	        dispatcher.forward(request, response);
	    }
}
	