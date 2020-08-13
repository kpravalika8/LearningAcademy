package com.dxc.web;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.dao.SubjectDAO;
import com.dxc.models.Subject;
import com.dxc.models.User;

@WebServlet("/student")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       SubjectDAO subDAO;
    public SubjectServlet() {
        super();
        subDAO=new SubjectDAO();
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
				listSub(request, response);
				break;

			case "/createSubForm":
				createSubForm(request, response);
				break;

			case "/createSub":
				createSub(request, response);
				break;
				
			case "/deleteSub":
				deleteSub(request, response);
				break;
				
			case "/updateSubForm":
				updateSubForm(request, response);
				break;
				
			case "/updateSub":
				updateSub(request, response);
				break;

			default:
				listSub(request, response);
				break;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	private void updateSub(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Subject user = new Subject();
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setSubjectname(request.getParameter("subjectname"));
		subDAO.updateSub(user);
		response.sendRedirect("list");
		
	}

	private void updateSubForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Subject user = subDAO.selectSub(id);
		request.setAttribute("SubDetail", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("updated-form.jsp");
		dispatcher.forward(request, response);
		
	}

	private void deleteSub(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		subDAO.deleteSub(id);
		response.sendRedirect("list");
		
	}

	private void createSub(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Subject user = new Subject();
		user.setSubjectname(request.getParameter("name"));
		subDAO.insertSub(user);
		response.sendRedirect("list");

	}

	private void createSubForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Sub-form.jsp");
		dispatcher.forward(request, response);

	}

	private void listSub(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		List<Subject> users = subDAO.selectAllSub();
		System.out.println(users);
		request.setAttribute("sublist", users);
		RequestDispatcher dispatcher = request.getRequestDispatcher("sub-list.jsp");
		dispatcher.forward(request, response);

	}

	}

