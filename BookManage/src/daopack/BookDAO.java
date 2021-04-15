package daopack;

import java.sql.*;

import java.util.*;





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
			Connection con=getConnection();
			PreparedStatement pmt=null;
			String query=null;
			
			try {
				query="insert into books values(?,?,?,?)";
				pmt=con.prepareStatement(query);
				pmt.setInt(1, b.getId());
				pmt.setString(2, b.getName());
				pmt.setDouble(3, b.getPrice());
				pmt.setString(4, b.getAuthor());
				
				int n=pmt.executeUpdate();
			    return n>0?true:false;
			}
			catch(SQLException se) {se.printStackTrace();}
			
			return false;
		}//addBook
	    
		public Boolean deleteBook(String name) {
			Connection con=null;
			ResultSet rs=null;
			PreparedStatement pmt = null;
			
			try {
				con=getConnection();
				String query = "delete  from books where name=?";
				pmt=con.prepareStatement(query);
				pmt.setString(1,name);
				int n= pmt.executeUpdate();
				if(n>0) {
					return true;
				}
				else
					return false;
				
			}
			catch(SQLException e) {e.printStackTrace();}
			finally {
				try {
					if(con!=null)
						con.close();
					if(rs!=null)
						rs.close();
					if(pmt!=null)
						pmt.close();
				}
				catch(SQLException e) {e.printStackTrace();}
			}//finally
			return false;
		
		}//deleteBook
		
		public Book getBook(int id) {
			try {
			Connection con=null;
			PreparedStatement pmt = null;
			ResultSet rs = null;
			
			
				con=getConnection();
				String query = "select * from books where id=? ";
				pmt=con.prepareStatement(query);
				pmt.setInt(1, id);
				rs=pmt.executeQuery();
				while(rs.next()) {
					Book u =new Book(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4));
					return u;
				}
			}
			catch(SQLException e) {e.printStackTrace();}
			//catch(ClassNotFoundException cls) {cls.printStackTrace();}

			return null;
		}//getBook
		
		public boolean updateBook(Book e,int id)
	    {
	        Connection con = getConnection();
	        PreparedStatement pmt = null;
	        String query = null;       
	        try {
	            query = "UPDATE books SET name=?,price=?,author=? WHERE id=?";
	            pmt = con.prepareStatement(query);
	            pmt.setString(1, e.getName());
	            pmt.setDouble(2, e.getPrice());
	            pmt.setString(3, e.getAuthor());
	            pmt.setInt(4, id);
	            int n = pmt.executeUpdate();
	            return n>0?true:false;
	        }catch(SQLException se) {
	            se.printStackTrace();
	        }       
	        return false;
	    }
}
