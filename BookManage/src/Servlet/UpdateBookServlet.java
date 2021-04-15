package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daopack.Book;
import daopack.BookDAO;

@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		System.out.println("id = " + request.getParameter("id"));
		System.out.println("name = " + request.getParameter("name"));
		System.out.println("price = " + request.getParameter("price"));
		System.out.println("author = " + request.getParameter("author"));
		out.println("<html><body><center><h2>Enter Book Details To Update</h2>");
		out.println("<form action='UpdateServ' method='get'>");
		out.println("Book id		:<input type='text' name='id' value='" + request.getParameter("id")+ "'><br/><br/>");
		out.println("Book Name		:<input type='text' name='name' value='" + request.getParameter("name")+ "'><br/><br/>");
		out.println("Price		:<input type='text' name='price' value='" + request.getParameter("price")+ "'><br/><br/>");
		out.println("Author		:<input type='text' name='author' value='" + request.getParameter("author")+ "'><br/><br/>");
		out.println("<input type='submit' value='Update Book'>");
		out.println("</form></center></body></html>"); 

	}


}
