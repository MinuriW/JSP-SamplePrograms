package com.hcl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class UserCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("fullname");
		String email = request.getParameter("email").toLowerCase();
		
		String password = request.getParameter("password");
		
		String encryptedpass = AES.encrypt(password, "xxxx");
		
		UserDAO dao = new UserDAO();
		
		if(dao.createUser(name, email, encryptedpass))
		{
			response.sendRedirect(request.getContextPath() + "/userlist");
		}
		else 
		{
			response.sendRedirect(request.getContextPath() + "/error.jsp");
		}
	}

}
