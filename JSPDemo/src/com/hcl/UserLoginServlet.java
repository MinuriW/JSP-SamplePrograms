package com.hcl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserLoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String encryptedpass = AES.encrypt(password,"xxxx");
		UserDAO dao = new UserDAO();
		
		User user = dao.checkLogin(email,encryptedpass);
		String page = "";
		
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getFullname()); //user obj
			session.setAttribute("isUserLoggedIn",true);
			page = "home.jsp";
		} else {
			String message = "Invalid email/password";
			request.setAttribute("message", message);
			page="login.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

}
