package book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/deleteBook")
public class DeleteServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		
		BookDAO dao = new BookDAO();
		
		Boolean isDeleted = dao.deleteBook(id);
		
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		if(isDeleted) {
			
			request.setAttribute("message", "Book is successfully deleted.");
			request.setAttribute("title", "Delete Book");
			
		} else {
			request.setAttribute("message", "Book was not deleted.");
			request.setAttribute("title", "Delete Book");
		}
		
		request.setAttribute("link", "books");
		request.setAttribute("linkMessage", "All Books");
		
		rd.forward(request, response);
	}

}
