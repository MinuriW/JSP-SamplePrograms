
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Index")
public class Index extends HttpServlet {
    private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		AirportDAO dao = new AirportDAO();

		ArrayList<Airport> airports = null;
		try {
			airports = dao.listAirports();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><title>Create Airport</title></head>");
		out.println("<body><center>");
		out.println("<h2>Airport List</h2>");
		out.println("<a href='create.jsp'>Create New</a>");
		out.println("<table id='AirportList'><tr>");
		out.println("<th>Id</th>");
		out.println("<th>IATA Code</th>");
		out.println("<th>Name</th>");
		out.println("<th>City</th>");
		out.println("<th>Country</th></tr>");
		// Loop starts
		if(airports != null) {
			for (Airport a : airports) {
				out.println("<tr><td>"+ a.getId() +"</td>");
				out.println("<td>" + a.getIataAirportCode() + "</td>");
				out.println("<td>"+ a.getName() +"</td>");
				out.println("<td>" + a.getCity() + "</td>");
				out.println("<td>"+ a.getCountry() +"</td></tr>");
			}
		}
		
		// Loop ends
		out.println("</table></center></body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String iataAirportCode = request.getParameter("iataCode");
		String name = request.getParameter("name");
		String city  = request.getParameter("city");
		String country  = request.getParameter("country");
		
		Airport airport = new Airport(iataAirportCode, name, city, country);
		
		AirportDAO dao = new  AirportDAO();
		try {
			dao.createAirport(airport);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		doGet(request, response);
		
	}

}