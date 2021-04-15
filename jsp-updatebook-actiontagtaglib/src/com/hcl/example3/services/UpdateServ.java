package com.hcl.example3.services;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.example3.dao.BookDAO;
import com.hcl.example3.entities.Book;
@WebServlet("/UpdateServ")
public class UpdateServ extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		String author = request.getParameter("author");
		BookDAO dao = new BookDAO();
		Book b = new Book(id, name, price, author);
		out.println("<html><body><center>");
		if(dao.updateBook(b, id))
		{
			out.println("<font color='green' size='4'>Employee record has been updated successfully!</font><br>");
		}
		else
		{
			out.println("<font color='red' size='4'>Error in updating employee.Pls try later!</font>");
		}		
		out.println("</center></body></html>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
