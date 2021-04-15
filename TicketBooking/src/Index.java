import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Index", urlPatterns = { "/Index" })
public class Index extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		TicketBookingDAO dao = new TicketBookingDAO();
		List<TicketBooking> bookings = dao.getTicketBookingDetails();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("Ticket Booking");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<div>");
		Boolean isSuccess = (Boolean) request.getAttribute("success");
		if(isSuccess != null) {
			if(isSuccess) {
				out.println("Ticket Booked Successfully!!!");
			} else {
				out.println("Requested number of tickets not available");
			}
		}
		
		out.println("</div>");
		out.println("<h1>");
		out.println("Ticket Booking");
		out.println("</h1>");
		out.println("<table id='ticket'>");
		out.println("<tr>");
		out.println("<th>");
		out.println("Seating Type");
		out.println("</th>");
		out.println("<th>");
		out.println("Ticket Cost");
		out.println("</th>");
		out.println("<th>");
		out.println("Number of seats");
		out.println("</th>");
		out.println("</tr>");
		// Loop starts
		if(bookings != null) {
			for(TicketBooking booking : bookings) {
				out.println("<tr>");
				out.println("<td>");
				out.println(booking.getSeatingType());
				out.println("</td>");
				out.println("<td>");
				out.println(booking.getTicketCost());
				out.println("</td>");
				out.println("<td>");
				out.println(booking.getNumberOfSeats());
				out.println("</td>");
				out.println("</tr>");
			}
		}
		
		
		// Loop Ends

		out.println("<tr>");
		out.println("<td>");
		out.println("</td>");
		out.println("<td >");
		out.println("<form action='Book' method='GET'>");
		out.println("<input type='submit' value='Book' />");
		out.println("</form>");
		out.println("</td>");
		out.println("<td>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");

		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
