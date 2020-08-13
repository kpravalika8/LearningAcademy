package com.dxc.web;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.dao.StudentDAO;
import com.dxc.models.Student;
import com.dxc.models.User;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       StudentDAO studentDAO;
    public StudentServlet() {
        super();
        studentDAO=new StudentDAO();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {

			case "/list":
				listStudent(request, response);
				break;

			case "/createStudentForm":
				createStudentForm(request, response);
				break;

			case "/createStudent":
				createStudent(request, response);
				break;
				
			case "/deleteStudent":
				deleteStudent(request, response);
				break;
				
			case "/updateStudentForm":
				updateStudentForm(request, response);
				break;
				
			case "/updateStudent":
				updateStudent(request, response);
				break;

			default:
				listStudent(request, response);
				break;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Student user = new Student();
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setCountry(request.getParameter("country"));
		studentDAO.updateStudent(user);
		response.sendRedirect("list");
		
	}

	private void updateStudentForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Student user = studentDAO.selectStudent(id);
		request.setAttribute("studentDetail", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("updates-form.jsp");
		dispatcher.forward(request, response);
		
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		studentDAO.deleteStudent(id);
		response.sendRedirect("list");
		
	}

	private void createStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Student user = new Student();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setCountry(request.getParameter("country"));
		studentDAO.insertStudent(user);
		response.sendRedirect("list");

	}

	private void createStudentForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
		dispatcher.forward(request, response);

	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		List<Student> users = studentDAO.selectAllStudent();
		System.out.println(users);
		request.setAttribute("studentlist", users);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
		dispatcher.forward(request, response);

	}


}
