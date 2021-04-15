import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calculate")
public class Calculate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("seatType"));
		int nuOfTickets=Integer.parseInt(request.getParameter("numberOfTickets"));
		SeatingTypeDAO dao=new SeatingTypeDAO();
		double cost =dao.getTicketCost(id);
	
		double totalcost=nuOfTickets * cost;
		
		
		out.println("");
		out.println("The total ticket cost is "+totalcost+"");
		out.println("");
	}
}