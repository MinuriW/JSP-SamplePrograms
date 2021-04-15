import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/Book" })
public class Book extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("Ticket Booking");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>");
		out.println("Ticket Booking");
		out.println("</h1>");
		out.println("<form action='Book' method='POST'>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Show Name");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='text' name='showName' />");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Seating Type");
		out.println("</td>");
		out.println("<td>");
		out.println("<select name='type'>");
		out.println("<option value='1'>");
		out.println("Platinum");
		out.println("</option>");
		out.println("<option value='2'>");
		out.println("Gold");
		out.println("</option>");
		out.println("<option value='3'>");
		out.println("Silver");
		out.println("</option>");
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Number Of Tickets");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='text' name='numberOfTickets' />");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("<input id='book' name='submit' type='submit' value='Book' />");
		out.println("</td>");
		out.println("<td>");
		out.println("<input id='cancel' name='submit' type='submit' value='Cancel' />");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String submitType = request.getParameter("submit");
		
		System.out.println(submitType);

		if (submitType.equals("Cancel")) {
			System.out.println(submitType);
			RequestDispatcher rd = request.getRequestDispatcher("Index");
			
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("Update");

			rd.forward(request, response);
		}
	}

}
