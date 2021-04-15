package book;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Book;
import book.BookDAO;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Double price = Double.parseDouble(request.getParameter("price"));;
		String author = request.getParameter("author");
		
		Book book = new Book(id, name, price, author);
		
		BookDAO dao = new BookDAO();
		
		Boolean isInserted = dao.addBook(book);
		
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		if(isInserted) {
			
			request.setAttribute("message", "Book is successfully added.");
			request.setAttribute("title", "Add Book");
			
		} else {
			request.setAttribute("message", "Book was not added.");
			request.setAttribute("title", "Add Book");
		}
		
		request.setAttribute("link", "books");
		request.setAttribute("linkMessage", "All Books");
		
		rd.forward(request, response);
	}

}
