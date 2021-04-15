package daopack;

 

import java.sql.*;
import java.util.ArrayList;

 

import bookpack.Book;

 

public class BookDAO {

 

    public Connection getConnection()
    {
        Connection con = null;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","121555");
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return con;
    }
    
    
    public ArrayList<Book> getAllBooks()
    {
        Connection c = getConnection();
        Statement st = null;
        ArrayList<Book> books = new ArrayList<Book>();
        
        
        try {
            st = c.createStatement();
            ResultSet rs = st.executeQuery("select id, name, price,author from books");
            while(rs.next())
            {
                Book b = new Book(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4));
                books.add(b);
            }
                
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        finally
        {
            try {
                st.close();
                c.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
    
        return books;
    }
	public boolean addBook(Book b)
    {
        Connection con = getConnection();
        PreparedStatement pmt = null;
		String query = null;      
        try {
        	query = "insert into book values(?,?,?,?)";
			pmt = con.prepareStatement(query);
			pmt.setInt(1, b.getId());
			pmt.setString(2, b.getName());
			pmt.setDouble(3, b.getPrice());
			pmt.setString(4, b.getAuthor());			
			int n = pmt.executeUpdate();
		    return n>0?true:false;             
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
            	pmt.close();
            	con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }           
        }   
        return false;
    }
	
	public boolean updateBook(Book b,int id)
	{
		Connection con = getConnection();
		PreparedStatement pmt = null;
		String query = null;		
		try {
			query = "UPDATE book SET name=?,price=?,author=? WHERE id=?";
			pmt = con.prepareStatement(query);
			pmt.setString(1, b.getName());
			pmt.setDouble(2, b.getPrice());
			pmt.setString(3, b.getAuthor());
			pmt.setInt(4, id);
			int n = pmt.executeUpdate();
		    return n>0?true:false;
		}catch(SQLException se) {
			se.printStackTrace();
		}		
		return false;
	}
    
}