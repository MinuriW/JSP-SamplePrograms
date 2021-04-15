package book;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		String author = request.getParameter("author");		
		BookDAO dao = new BookDAO();
	       
		Book b = new Book(id, name, price, author);
		out.println("<html><body><center>");
		if(dao.addBook(b))
		{
			out.println("<font color='green' size='4'>Employee record has been added successfully!</font><br>");
			ArrayList<Book> books = dao.getAllBooks();
	        request.setAttribute("bookslist", books);       
	        RequestDispatcher rd = request.getRequestDispatcher("BookServlet.jsp");
	        rd.include(request, response);
		}
		else
		{
			out.println("<font color='red' size='4'>Error in adding employee.Pls try later!</font>");
		}		
		out.println("<a href='Index.html'>Home</a> &nbsp;&nbsp;&nbsp;&nbsp;<a href='SelectServ'>Display All Employees</a>");
		out.println("</center></body></html>");
		out.close();
	}
	}
