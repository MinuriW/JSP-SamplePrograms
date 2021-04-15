package book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Double price = Double.parseDouble(request.getParameter("price"));;
		String author = request.getParameter("author");
		
		Book book = new Book(id, name, price, author);
		
		BookDAO dao = new BookDAO();
		
		Boolean isUpdated = dao.addBook(book);
		
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		if(isUpdated) {
			
			request.setAttribute("message", "Book is successfully updated.");
			request.setAttribute("title", "Update Book");
			
		} else {
			request.setAttribute("message", "Book was not updated.");
			request.setAttribute("title", "Update Book");
		}
		
		request.setAttribute("link", "books");
		request.setAttribute("linkMessage", "All Books");
		
		rd.forward(request, response);
	}

}
