import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HTTPServlet;
import javax.servlet.http.HTTPServletRequest;
import javax.servlet.http.HTTPServletResponse;

public class Data123 extends HttpServlet{
  public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
        try{
      String name = request.getParameter("name");
      String lname = request.getParameter("lname");
	  String phno = request.getParameter("phno");
	  String email = request.getParameter("email");
	  String password = request.getParameter("password");
      out.println(name);
      out.println(lname);
	  out.println(phno);
	  out.println(email);
	  out.println(password);
	  
      Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConection("jdbc:oracle:jdbc-odbc:@localhost:1521:xe","system","sarim");
      PreparedStatement pst = con.prepareStatement("insert into user1 values(?,?,?,?,?)");
      pst.setString(1,name);
      pst.setString(2,lname);
	  pst.setString(3,phno);
	  pst.setString(4,email);
	  pst.setString(5,password);
      int i = pst.executeUpdate();
      if(i!=0){
        out.println("<br>Record has been inserted");
      }
      else{
        out.println("failed to insert the data");
      }
    }
    catch (Exception e){
      out.println(e);
    }
  }
}