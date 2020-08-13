package com.dxc.web;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.dao.TeacherDAO;
import com.dxc.models.Teacher;
import com.dxc.models.User;

@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   TeacherDAO teacherDAO;
    public TeacherServlet() {
        super();
        teacherDAO =new TeacherDAO();
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
				listTeacher(request, response);
				break;

			case "/createTeacherForm":
				createTeacherForm(request, response);
				break;

			case "/createTeacher":
				createTeacher(request, response);
				break;
				
			case "/deleteTeacher":
				deleteTeacher(request, response);
				break;
				
			case "/updateTeacherForm":
				updateTeacherForm(request, response);
				break;
				
			case "/updateTeacher":
				updateTeacher(request, response);
				break;

			default:
				listTeacher(request, response);
				break;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}
       private void updateTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	   Teacher user = new Teacher();
			user.setId(Integer.parseInt(request.getParameter("id")));
			user.setName(request.getParameter("name"));
			user.setEmail(request.getParameter("email"));
			user.setCountry(request.getParameter("country"));
			teacherDAO.updateUser(user);
			response.sendRedirect("list");
			
		}

		private void updateTeacherForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			Teacher user = teacherDAO.selectUser(id);
			request.setAttribute("teaherDetail", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("updatedtea-form.jsp");
			dispatcher.forward(request, response);
			
		}

		private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			teacherDAO.deleteTeacher(id);
			response.sendRedirect("list");
			
		}

		private void createTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {

			Teacher user = new Teacher();
			user.setName(request.getParameter("name"));
			user.setEmail(request.getParameter("email"));
			user.setCountry(request.getParameter("country"));
			teacherDAO.insertTeacher(user);
			response.sendRedirect("list");

		}

		private void createTeacherForm(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-form.jsp");
			dispatcher.forward(request, response);

		}

		private void listTeacher(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {

			List<Teacher> users = teacherDAO.selectAllUser();
			System.out.println(users);
			request.setAttribute("teacherlist", users);
			RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-list.jsp");
			dispatcher.forward(request, response);

		}

	}
