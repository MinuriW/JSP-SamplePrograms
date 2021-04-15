package com.hcl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserUpdateServlet() {
        super();

    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("fullname");
		String email = request.getParameter("email").toLowerCase();
		String password = request.getParameter("password");
		String encryptedpass = AES.encrypt(password, "xxxx");
		UserDAO dao = new UserDAO();
		
		if(dao.updateUser(id, name, email, encryptedpass))
		{
			response.sendRedirect(request.getContextPath() + "/userlist");
		}
		else 
		{
			response.sendRedirect(request.getContextPath() + "/error.jsp");
		}
	}

}
