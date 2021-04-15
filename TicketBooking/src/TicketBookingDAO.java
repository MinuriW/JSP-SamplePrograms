import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TicketBookingDAO {
	private static final String SELECT_ALL_TICKET_BOOKINGS = "SELECT * FROM seating_section";
	private static final String SELECT_NO_OF_SEATS_BY_SEATING_TYPE ="SELECT number_of_seats FROM seating_section WHERE seating_type = ?";
	private static final String UPDATE_TICKET_BOOKING = "UPDATE seating_section SET number_of_seats = ? WHERE seating_type = ?";

	/*
	 * This method will return a list of SeatingType instances.
	 */
	public List<TicketBooking> getTicketBookingDetails() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<TicketBooking> bookings = null;
		try {
			con = DBConnection.getConnection();
			
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(SELECT_ALL_TICKET_BOOKINGS);
			
			while(rs.next()) {
				int id = rs.getInt(1);
			    String seatingType = rs.getString(2);
			    Double ticketCost = rs.getDouble(3);
			    int numberOfSeats = rs.getInt(4);
			    
			    TicketBooking booking = new TicketBooking(id, seatingType, ticketCost, numberOfSeats);
			    
			    if(bookings == null) {
			    	bookings = new ArrayList<>();
			    }
			    
			    bookings.add(booking);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(rs != null) {
				rs.close();
			}
			
			if(stmt != null) {
				stmt.close();
			}
			
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return bookings;
	}

	/*
	 * This method will return true if ticket booked successfully. If number of
	 * tickets are not available it will return false. After booking, ticket it must
	 * be updated in the database.
	 */
	public boolean bookTicket(int seatingType, int ticketCount) {
		
		Connection con = null;
		PreparedStatement pmt = null;
		PreparedStatement pmt2 = null;
		ResultSet rs = null;
		
		Boolean isBooked = false;
		
		try {
			con = DBConnection.getConnection();
			
			pmt = con.prepareStatement(SELECT_NO_OF_SEATS_BY_SEATING_TYPE);
			String st = getSeatingType(seatingType);
			
			pmt.setString(1,  st);
			
			rs = pmt.executeQuery();
			
			if(rs.next()) {
				int noOfSeats = rs.getInt(1);
				
				if(noOfSeats >= ticketCount) {
					pmt2 = con.prepareStatement(UPDATE_TICKET_BOOKING);
					pmt2.setInt(1,  noOfSeats - ticketCount);
					pmt2.setString(2, st);
					
					int affected = pmt2.executeUpdate();
					
					if(affected > 0) {
						isBooked = true;
					}
				}
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			if(rs != null) {
				rs.close();
			}
			
			if(pmt != null) {
				pmt.close();
			}
			
			if(pmt2 != null) {
				pmt2.close();
			}
			
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
				
		
		return isBooked;
	}
	
	private String getSeatingType(int number) {
		if(number == 1) {
			return "Platinum";
		} else if(number == 2) {
			return "Gold";
		} else {
			return "Silver";
		}
	}

}
