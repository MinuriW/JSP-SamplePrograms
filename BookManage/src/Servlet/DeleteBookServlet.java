package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daopack.BookDAO;




@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();

		String name=request.getParameter("name");
		BookDAO dao=new BookDAO();
		
		if(dao.deleteBook(name)) {
			//RequestDispatcher rd = request.getRequestDispatcher("getAllBooks.jsp");
        	//rd.forward(request, response);
			response.sendRedirect("BookServlet");
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("BookServlet");
        	out.println("<p>Faild to Delete</p>");
        	rd.include(request, response);
		}
	}


}
