package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import daopack.BookDAO;
import daopack.Book;
import java.util.*;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        BookDAO dao = new BookDAO();
        ArrayList<Book> books = dao.getAllBooks();
        request.setAttribute("bookslist", books);
        
        RequestDispatcher rd = request.getRequestDispatcher("getAllBooks.jsp");
        rd.forward(request, response);
    }
		
	


}
