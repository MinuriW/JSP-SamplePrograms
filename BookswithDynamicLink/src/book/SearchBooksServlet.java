package book;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchBooks")
public class SearchBooksServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookName = request.getParameter("bookName");
		
		BookDAO dao = new BookDAO();
		
		List<Book> booksByName = dao.getBooksBySimilarName(bookName);
		
		RequestDispatcher rd = request.getRequestDispatcher("books.jsp");
		request.setAttribute("books", booksByName);
		request.setAttribute("title", "Search result for " + bookName);
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
