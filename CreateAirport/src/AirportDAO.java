import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AirportDAO {
	private static final String SELECT_ALL_AIRPORTS = "SELECT * FROM airport ORDER BY id ASC";
	private static final String INSERT_AIRPORT = "INSERT INTO airport(iata_airport_code,name,city,country_name) VALUES(?, ?, ?, ?)";
	/*
	 * This method will return the list of airports in the database based on the
	 * ascending order of id
	 */
	public ArrayList<Airport> listAirports() throws ClassNotFoundException, SQLException  {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<Airport> airports = null;

		try {
			con = DBConnection.getConnection();

			stmt = con.createStatement();

			rs = stmt.executeQuery(SELECT_ALL_AIRPORTS);

			while (rs.next()) {
				Integer id = rs.getInt(1);
				String iataAirportCode = rs.getString(2);
				String name = rs.getString(3);
				String city = rs.getString(4);
				String country = rs.getString(5);

				Airport airport = new Airport(id, iataAirportCode, name, city, country);

				if (airports == null) {
					airports = new ArrayList<>();
				}

				airports.add(airport);
			}

		} catch (ClassNotFoundException | SQLException e) {

			throw e;
		}

		try {
			if (rs != null) {
				rs.close();
			}

			if (stmt != null) {
				stmt.close();
			}

			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {

			throw e;
		}

		return airports;
	}

	/* This method will insert the new airport into the database */
	public void createAirport(Airport airport) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pmt = null;


		try {
			con = DBConnection.getConnection();

			pmt = con.prepareStatement(INSERT_AIRPORT);
			pmt.setString(1, airport.getIataAirportCode());
			pmt.setString(2, airport.getName());
			pmt.setString(3, airport.getCity());
			pmt.setString(4, airport.getCountry());
			
			pmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			throw e;
		}

		try {

			if (pmt != null) {
				pmt.close();
			}

			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {

			throw e;
		}

	}
}
