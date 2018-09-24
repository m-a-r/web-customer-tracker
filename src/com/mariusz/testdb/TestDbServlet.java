package com.mariusz.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = "springstudent";
        String pass = "springstudent";

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";

        try {

            Class.forName(driver);
            PrintWriter out = response.getWriter();
            connectToJdbc(user, pass, jdbcUrl, out);

        } catch (Exception exc) {
            exc.printStackTrace();
            throw new ServletException(exc);
        }
    }

    private void connectToJdbc(String user, String pass, String jdbcUrl, PrintWriter out) throws ServletException, IOException {

        System.out.println("Connecting to " + jdbcUrl);

        String sql = "SELECT * FROM customer";

        try (
                Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
                Statement myStmt = myConn.createStatement();
                ResultSet myRs = myStmt.executeQuery(sql)
        ) {

            String customers = getCustomers(myRs);

            out.println(customers);
            System.out.println(customers);

            String connectionConfirmation = "Connected successfully to " + jdbcUrl;
            out.println(connectionConfirmation);
            System.out.println(connectionConfirmation);

        } catch (Exception exc) {
            exc.printStackTrace();
            throw new ServletException(exc);
        }
    }

    private String getCustomers(ResultSet myRs) throws SQLException {

        String customers = "";

        while (myRs.next()) {
            int id = myRs.getInt("id");
            String firstName = myRs.getString("first_name");
            String lastName = myRs.getString("last_name");
            String email = myRs.getString("email");
            customers += (id + ", " + firstName + " " + lastName + ", " + email + "\n");
        }

        return customers;
    }
}
