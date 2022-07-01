package exoSection.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SectionDAO {
    private final String url = "jdbc:mysql://localhost:3306/dbslide";
    private final String username = "root";
    private final String password = "";
    // constructor
    public SectionDAO() {
    }

    // methods
    public List<Section> getList() {
        List<Section> list = new ArrayList<>();
        String query = "SELECT *" + " FROM section";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected successfully.");
            Statement statement = connection.createStatement();
            statement.executeQuery(query);
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                int section_id = results.getInt("section_id");
                String section_name = results.getString("section_name");
                int delegate_id = results.getInt("delegate_id");
                list.add(new Section(section_id, section_name, delegate_id));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection error.");
        }
        return list;
    }

    public Section getSection(int section_id) {
        Section section = null;
        String query = "SELECT *" + " FROM section" + " WHERE section_id = " + section_id;
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected successfully.");
            Statement statement = connection.createStatement();
            statement.executeQuery(query);
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                String section_name = results.getString("section_name");
                int delegate_id = results.getInt("delegate_id");
                section = new Section(section_id, section_name, delegate_id);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection error.");
        }
        return section;
    }
}
