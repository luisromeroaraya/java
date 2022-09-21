package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try
        {
            // create our database connection
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "pass";

            Connection conn = DriverManager.getConnection(url, user, password);

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM persons";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                // print the results
                System.out.format("id: %s, name: %s\n", id, name);
            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}