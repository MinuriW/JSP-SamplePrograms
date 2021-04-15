import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class SeatingTypeDAO {
    public Double getTicketCost(int id) 
    {
        Connection con=null;
        PreparedStatement pmt=null;
        ResultSet rs=null;
        double cost=0.0;
        try {
        	con=DBConnection.getConnection();
        	String query="select ticket_cost from seating_section where id=?";
        	pmt =con.prepareStatement(query);
        	pmt.setInt(1, id);
        	rs=pmt.executeQuery();
        	if(rs.next()) {
        		cost=rs.getDouble(3);
        	}
        }catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) con.close();
				if(pmt!=null) pmt.close();
				if(rs!=null) rs.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
        
 
		return cost;
}
}