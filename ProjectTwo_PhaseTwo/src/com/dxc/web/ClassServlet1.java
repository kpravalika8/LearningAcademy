package com.dxc.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.dao.ClassDAO;
import com.dxc.models.Class;
@WebServlet("/class")
public class ClassServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ClassDAO classdao;
    public ClassServlet1() {
        super();
         classdao=new ClassDAO();   
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
			switch (action) {

			case "classlist":
				listClass(request, response);
				break;

			case "createClassForm":
				createClassForm(request, response);
				break;

			case "createClass":
				createClass(request, response);
				break;
				
			case "deleteClass":
				deleteClass(request, response);
				break;
				
			case "updateClassForm":
				updateClassForm(request, response);
				break;
				
			case "updateClass":
				updateClass(request, response);
				break;
             default:
            	    listClass(request,response);
            	    break;
			}
	}	
	private void updateClass(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Class user = new Class();
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setClassname(request.getParameter("classname"));
		classdao.updateClass(user);
		response.sendRedirect("Classlist");
		
	}

	private void updateClassForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Class user = classdao.selectClass(id);
		request.setAttribute("classDetail", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("update-form.jsp");
		dispatcher.forward(request, response);
		
	}

	private void deleteClass(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		classdao.deleteClass(id);
		response.sendRedirect("Classlist");
		
	}

	private void createClass(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Class user = new Class();
		user.setClassname(request.getParameter("classname"));
		classdao.insertClass(user);
		response.sendRedirect("Classlist");

	}

	private void createClassForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("class-form.jsp");
		dispatcher.forward(request, response);

	}

	private void listClass(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		List<Class> users = classdao.selectAllClass();
		System.out.println(users);
		request.setAttribute("classlist", users);
		RequestDispatcher dispatcher = request.getRequestDispatcher("class-list.jsp");
		dispatcher.forward(request, response);

	}
	}

