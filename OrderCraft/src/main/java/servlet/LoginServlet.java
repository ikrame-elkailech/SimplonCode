package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.SingletonConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		            PrintWriter out = response.getWriter();
		            response.setContentType("text/html");
		    		Connection con = SingletonConnection.getConnection();
		            try (PreparedStatement ps = con.prepareStatement("SELECT * FROM utilisateur WHERE email = ? AND password = ?")) {
		                String email = request.getParameter("email");
		                String password = request.getParameter("password");
		                ps.setString(1, email);
		                ps.setString(2, password);
		                try (ResultSet rs = ps.executeQuery()) {
		                    if (rs.next()) {
		                        RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		                        rd.forward(request, response);
		                    } else {
		                        out.println("<font color=red size=18>Login Failed!!<br> ");
		                        out.println("<a href=login.jsp> Try Again </a>");
		                    }
		                }
		            }
		        } catch (SQLException e) {
		            // Log the exception using a logging framework like Log4j
		            e.printStackTrace();
		        }
		    }
}
