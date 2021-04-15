package com.hcl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/searchuser")
public class UserSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		UserDAO dao = new UserDAO();
		User user = dao.searchUser(id);
		String page="";
		if (user != null) {
			request.setAttribute("user", user); //user obj
			page = "update.jsp";
		} else {
			String message = "Error Occured at update!";
			request.setAttribute("message", message);
			page="login.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

}
