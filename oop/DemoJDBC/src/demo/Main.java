package demo;

import java.sql.*;

//        https://github.com/aKimtsPro/DemoJDBC_JavaBxl

public class Main {
    public static void main(String[] args) {
        // Class.forName( "com.mysql.cj.jdbc.Driver"); // If the library is installed it will auto install the Driver from the static block inside the Class
        // input connection info
        String url = "jdbc:mysql://localhost:3306/dbslide";
        String username = "root";
        String password = "";
        // prepare a query
        String query = "SELECT first_name, last_name" + " FROM student"; // be careful with spacing
        try {
            // try to connect
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected successfully.");
            Statement statement = connection.createStatement();
            statement.executeQuery(query);
            ResultSet results = statement.executeQuery(query);

            while (results.next()) { // results.next() gets the next result from the db. if there are no more results it returns false
                // we get the data from the correspondent column using the specific type method (string with getString, int with getInt, etc)
                String first_name = results.getString("first_name"); // we can also specify the column as a number getString(1) will give you the result from the first column
                String last_name = results.getString("last_name");
                System.out.println(first_name + " " + last_name);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection error.");
        }
    }
}