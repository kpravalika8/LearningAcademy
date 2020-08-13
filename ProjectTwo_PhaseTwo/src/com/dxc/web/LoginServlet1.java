package com.dxc.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.dao.UserDAO;
import com.dxc.models.HibernateUtil;
import com.dxc.models.User;
//@WebServlet("/login")
public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserDAO userdao;
    public LoginServlet1() {
        super();
        userdao=new UserDAO();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	        response.sendRedirect("login.jsp");
    	    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
            authenticate(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	 private void authenticate(HttpServletRequest request, HttpServletResponse response)
			    throws Exception {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter writer=response.getWriter();
        
       if (userdao.validate(username, password)) {
           RequestDispatcher  dispatcher = request.getRequestDispatcher("welcome1.jsp");
            dispatcher.forward(request, response);
		}else {
		  writer.println("Invalid Credentials...Try Again");
          RequestDispatcher  dispatcher = request.getRequestDispatcher("login.jsp");
             dispatcher.forward(request, response);
		}
	}

}
