package com.hcl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

	public User checkLogin(String email, String password){
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User user = null;
		try
		{
			con = ConnectionUtil.getConnection();
			stmt = con.prepareStatement("select * from test_user where email=? and password=?");
			stmt.setString(1,email);
			stmt.setString(2,password);
			rs=stmt.executeQuery();
			while(rs.next()) {
				user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));	
			}
			return user;
		}
		catch(SQLException se){se.printStackTrace();}
		finally
		{
			try
			{
				if(stmt!=null)
					stmt.close();
				if(rs!=null)
					rs.close();
				if(con!=null)
					con.close();
			}
			catch(SQLException se){se.printStackTrace();}
		}
		return user;
		
	}
	
	public User searchUser(int id){
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User user = null;
		try
		{
			con = ConnectionUtil.getConnection();
			stmt = con.prepareStatement("select * from test_user where id=?");
			stmt.setInt(1,id);
			rs=stmt.executeQuery();
			while(rs.next()) {
				String decryptedpass = AES.decrypt(rs.getString(4),"xxxx");
				user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),decryptedpass);	
			}
			return user;
		}
		catch(SQLException se){se.printStackTrace();}
		finally
		{
			try
			{
				if(stmt!=null)
					stmt.close();
				if(rs!=null)
					rs.close();
				if(con!=null)
					con.close();
			}
			catch(SQLException se){se.printStackTrace();}
		}
		return user;
		
	}

	public List<User> getUserList()
    {
        Connection con =null;
        ResultSet rs = null;
        Statement stmt = null;
        List<User> list = new ArrayList<User>();
        try
        {
            con = ConnectionUtil.getConnection();
            stmt =con.createStatement();
            String query="select * from test_user";
            rs=stmt.executeQuery(query);
            while(rs.next()) {
            	User user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                list.add(user);
            }
        }
        //catch(ClassNotFoundException ce) {ce.printStackTrace();}
        catch(SQLException se) {se.printStackTrace();}
        finally
        {
            try
            {
                if(stmt!=null)
                    stmt.close();
                if(rs!=null)
                    rs.close();
                if(con!=null)
                    con.close();
            }
            catch(SQLException se) {se.printStackTrace();}
        }
        return list;
    }
	
	public boolean deleteUser(int id){
		
		Connection con = null;
		PreparedStatement stmt = null;
		try
		{
			con = ConnectionUtil.getConnection();
			stmt = con.prepareStatement("delete from test_user where id=?");
			stmt.setInt(1,id);
			int n = stmt.executeUpdate();
		    return n>0?true:false;
		}
		catch(SQLException se){se.printStackTrace();}
		finally
		{
			try
			{
				if(stmt!=null)
					stmt.close();
				if(con!=null)
					con.close();
			}
			catch(SQLException se){se.printStackTrace();}
		}
		return false;
		
	}
	
	
	public boolean updateUser(int id, String name, String email, String password){
		
		Connection con = null;
		PreparedStatement stmt = null;
		try
		{
			con = ConnectionUtil.getConnection();
			stmt = con.prepareStatement("update test_user set fullname=?,email=?,password=? where id=?");
			stmt.setString(1,name);
			stmt.setString(2,email);
			stmt.setString(3,password);
			stmt.setInt(4,id);
			int n = stmt.executeUpdate();
		    return n>0?true:false;
		}
		catch(SQLException se){se.printStackTrace();}
		finally
		{
			try
			{
				if(stmt!=null)
					stmt.close();
				if(con!=null)
					con.close();
			}
			catch(SQLException se){se.printStackTrace();}
		}
		return false;
		
	}
	
	public boolean createUser(String name, String email, String password){
		
		Connection con = null;
		PreparedStatement stmt = null;
		try
		{
			con = ConnectionUtil.getConnection();
			stmt = con.prepareStatement("insert into test_user values(user_sequence.nextval,?,?,?)");
			stmt.setString(1,name);
			stmt.setString(2,email);
			stmt.setString(3,password);
			int n = stmt.executeUpdate();
		    return n>0?true:false;
		}
		catch(SQLException se){se.printStackTrace();}
		finally
		{
			try
			{
				if(stmt!=null)
					stmt.close();
				if(con!=null)
					con.close();
			}
			catch(SQLException se){se.printStackTrace();}
		}
		return false;
		
	}
		
	
}
