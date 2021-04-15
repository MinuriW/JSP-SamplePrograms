import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class BookDAO {
    public ArrayList<Book> listBooks() throws ClassNotFoundException, SQLException{
        ArrayList<Book> bookList = new ArrayList<Book>();
        Connection con =  null;
        Statement stmt = null;
        ResultSet rs = null;
        
        
        try {
            con = DBConnection.getConnection();
            stmt = con.createStatement();
            String query = "select * from book";
            rs = stmt.executeQuery(query);
            
            while(rs.next()) {
                bookList.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5)));
            }
        }
        catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        
        return bookList;
    }
    
    public void createBook(Book bookIns) throws ClassNotFoundException, SQLException {
        Connection con =  null;
        PreparedStatement pmt = null;
        try {
            con = DBConnection.getConnection();
            String query = "insert into book(TITLE,CATEGORY,AUTHOR,PRICE) values(?,?,?,?)";
            pmt = con.prepareStatement(query);
            pmt.setString(1,bookIns.getTitle() );
            pmt.setString(2, bookIns.getCategory());
            pmt.setString(3, bookIns.getAuthor());
            pmt.setDouble(4,bookIns.getPrice());
            int j =pmt.executeUpdate();
            
            
        }
        catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }
}