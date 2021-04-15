package book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBConnection;

public class BookDAO {

	private static final String SELECT_ALL_BOOKS = "SELECT * FROM books";
	private static final String SELECT_BOOKS_BY_NAME = "SELECT * FROM books WHERE name = ?";
	private static final String SELECT_BOOKS_BY_LIKE_NAME = "SELECT * FROM books WHERE name LIKE ?";
	
	private static final String INSERT_BOOK = "INSERT INTO books VALUES(?, ?, ?, ?)";
	private static final String UPDATE_BOOK = "UPDATE books SET name = ?, price = ?, author = ? WHERE id = ?";
	private static final String DELETE_BOOK = "DELETE FROM books WHERE id = ?";

	List<Book> getAllBooks() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<Book> books = null;

		try {
			con = DBConnection.getConnection();

			stmt = con.createStatement();

			rs = stmt.executeQuery(SELECT_ALL_BOOKS);

			while (rs.next()) {
				Integer id = rs.getInt(1);
				String name = rs.getString(2);
				Double price = rs.getDouble(3);
				String author = rs.getString(4);

				Book book = new Book(id, name, price, author);

				if (books == null) {
					books = new ArrayList<>();
				}

				books.add(book);

			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			e.printStackTrace();
		}

		return books;
	}
	
	List<Book> getBooksByName(String bookName) {
		Connection con = null;
		PreparedStatement pmt = null;
		ResultSet rs = null;

		List<Book> books = null;

		try {
			con = DBConnection.getConnection();

			pmt = con.prepareStatement(SELECT_BOOKS_BY_NAME);
			pmt.setString(1, bookName);

			rs = pmt.executeQuery();

			while (rs.next()) {
				Integer id = rs.getInt(1);
				String name = rs.getString(2);
				Double price = rs.getDouble(3);
				String author = rs.getString(4);

				Book book = new Book(id, name, price, author);

				if (books == null) {
					books = new ArrayList<>();
				}

				books.add(book);

			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if (rs != null) {
				rs.close();
			}

			if (pmt != null) {
				pmt.close();
			}

			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}
	
	List<Book> getBooksBySimilarName(String bookName) {
		Connection con = null;
		PreparedStatement pmt = null;
		ResultSet rs = null;

		List<Book> books = null;

		try {
			con = DBConnection.getConnection();

			pmt = con.prepareStatement(SELECT_BOOKS_BY_LIKE_NAME);
			pmt.setString(1, "%" + bookName + "%");

			rs = pmt.executeQuery();

			while (rs.next()) {
				Integer id = rs.getInt(1);
				String name = rs.getString(2);
				Double price = rs.getDouble(3);
				String author = rs.getString(4);

				Book book = new Book(id, name, price, author);

				if (books == null) {
					books = new ArrayList<>();
				}

				books.add(book);

			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if (rs != null) {
				rs.close();
			}

			if (pmt != null) {
				pmt.close();
			}

			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}
	
	public Boolean updateBook(Book book) {
		Connection con = null;
		PreparedStatement pmt = null;
		
		Boolean isInserted = false;

		try {
			con = DBConnection.getConnection();

			pmt = con.prepareStatement(INSERT_BOOK);
			pmt.setInt(1, book.getId());
			pmt.setString(2, book.getName());
			pmt.setDouble(3, book.getPrice());
			pmt.setString(4, book.getAuthor());

			int affecteRows = pmt.executeUpdate();
			if(affecteRows > 0) {
				isInserted = true;
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			if (pmt != null) {
				pmt.close();
			}

			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isInserted;
	}
	
	public Boolean addBook(Book book) {
		Connection con = null;
		PreparedStatement pmt = null;
		
		Boolean isUpdated = false;

		try {
			con = DBConnection.getConnection();

			pmt = con.prepareStatement(UPDATE_BOOK);
			pmt.setString(1, book.getName());
			pmt.setDouble(2, book.getPrice());
			pmt.setString(3, book.getAuthor());
			pmt.setInt(4, book.getId());

			int affecteRows = pmt.executeUpdate();
			if(affecteRows > 0) {
				isUpdated = true;
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			if (pmt != null) {
				pmt.close();
			}

			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isUpdated;
	}
	
	public Boolean deleteBook(Integer id) {
		Connection con = null;
		PreparedStatement pmt = null;
		
		Boolean isDeleted = false;

		try {
			con = DBConnection.getConnection();

			pmt = con.prepareStatement(DELETE_BOOK);
			pmt.setInt(1, id);

			int affecteRows = pmt.executeUpdate();
			if(affecteRows > 0) {
				isDeleted = true;
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			if (pmt != null) {
				pmt.close();
			}

			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isDeleted;
	}
	

}
