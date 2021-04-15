import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Index")
public class Index extends HttpServlet {
    private static final long serialVersionUID = 1L;



    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           PrintWriter out = response.getWriter();
           BookDAO bdo = new BookDAO();
            
           ArrayList<Book> bookList = new ArrayList<Book>();
            try {
                
                bookList = bdo.listBooks();
            
            
            out.println("<html><head></head><body>");
            out.println("<h2><center>Book List</center></h2>");
            out.println("<a href='create.jsp' id ='Create'>Create New</a>");
            out.println("<table id ='BookList'>");
            out.println("<tr><th>Id</th><th>Title</th><th>Category</th><th>Author</th><th>Price</th></tr>");
            for(Book b:bookList) {
                out.println("<tr><td>"+b.getId()+"</td><td>"+b.getTitle()+"</td><td>"+b.getCategory()+"</td><td>"+b.getAuthor()+"</td><td>"+b.getPrice()+"</td></tr>");
            }
            out.println("</table></body></html>");
            
            
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }

 

 

 

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         PrintWriter out = response.getWriter();
           BookDAO bdo = new BookDAO();
            
           ArrayList<Book> bookList = new ArrayList<Book>();
            try {
                bdo.createBook(new Book(request.getParameter("Title"),request.getParameter("Category"),request.getParameter("Author"),Double.parseDouble(request.getParameter("Price"))));
                bookList = bdo.listBooks();
            
            
            out.println("<html><head></head><body>");
            out.println("<h2><center>Book List</center></h2>");
            out.println("<a href='create.jsp' id ='Create'>Create New</a>");
            out.println("<table id ='BookList'>");
            out.println("<tr><th>Id</th><th>Title</th><th>Category</th><th>Author</th><th>Price</th></tr>");
            for(Book b:bookList) {
                out.println("<tr><td>"+b.getId()+"</td><td>"+b.getTitle()+"</td><td>"+b.getCategory()+"</td><td>"+b.getAuthor()+"</td><td>"+b.getPrice()+"</td></tr>");
            }
            out.println("</table></body></html>");
            
            
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }

 

 

 

}
 