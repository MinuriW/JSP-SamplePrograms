import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/Update" })
public class Update extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String showName = request.getParameter("showName");
		int type = Integer.parseInt(request.getParameter("type"));
		int numberOfTickets = Integer.parseInt(request.getParameter("numberOfTickets"));
		
		TicketBookingDAO dao = new TicketBookingDAO();
		
		boolean isBooked = dao.bookTicket(type, numberOfTickets);
		RequestDispatcher rd = request.getRequestDispatcher("Index");
		if(isBooked) {
			request.setAttribute("success", true);
		} else {
			request.setAttribute("success", false);
		}
		
		rd.forward(request, response);
		
		
		
	}

}
