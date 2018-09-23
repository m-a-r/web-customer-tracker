package com.mariusz.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = "springstudent";
        String pass = "springstudent";

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";

        try {

            Class.forName(driver);
            connectToJdbc(user, pass, jdbcUrl);
            PrintWriter out = response.getWriter();
            out.println("Connected successfully to " + jdbcUrl);

        } catch (Exception exc) {
            exc.printStackTrace();
            throw new ServletException(exc);
        }
    }

    private void connectToJdbc(String user, String pass, String jdbcUrl) throws ServletException {

        System.out.println("Connecting to " + jdbcUrl);

        try (Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass)) {

            System.out.println("Connected successfully!");

        } catch (Exception exc) {
            exc.printStackTrace();
            throw new ServletException(exc);
        }
    }
}
