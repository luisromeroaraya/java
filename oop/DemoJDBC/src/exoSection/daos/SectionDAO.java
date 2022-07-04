package exoSection.daos;

import exoSection.models.Section;
import exoSection.utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SectionDAO {
    // constructor
    public SectionDAO() {
    }

    // methods
    public List<Section> getList() {
        String query = "SELECT *" + " FROM section";
        try (
                Connection connection = ConnectionFactory.createConnection();
                Statement statement = connection.createStatement();
                ResultSet results = statement.executeQuery(query)
                )
        {
            List<Section> list = new ArrayList<>();
            while (results.next()) {
                int section_id = results.getInt("section_id");
                String section_name = results.getString("section_name");
                Integer delegate_id = results.getInt("delegate_id");
                if(results.wasNull()) {
                    delegate_id = null;
                }
                list.add(new Section(section_id, section_name, delegate_id));
            }
            return list;
        }
        catch (SQLException ex) {
            throw new RuntimeException("SQL error - "+ ex.getSQLState() + ": " + ex.getErrorCode() + " - " + ex.getMessage());
        }
    }

    public Section getSection(int section_id) {
        String query = "SELECT *" + " FROM section" + " WHERE section_id = " + section_id;
        try (
                Connection connection = ConnectionFactory.createConnection();
                Statement statement = connection.createStatement();
                ResultSet results = statement.executeQuery(query)
                )
        {
            if (results.next()) {
                String section_name = results.getString("section_name");
                Integer delegate_id = results.getInt("delegate_id");
                if(results.wasNull()) {
                    delegate_id = null;
                }
                return new Section(section_id, section_name, delegate_id);
            }
            return null;
        }
        catch (SQLException ex) {
            throw new RuntimeException("SQL error - "+ ex.getSQLState() + ": " + ex.getErrorCode() + " - " + ex.getMessage());
        }
    }

    public void insertSection(Section section) {
        if (section == null){
            throw new IllegalArgumentException();
        }
        String query = "INSERT INTO section (section_id, section_name, delegate_id) VALUES (?, ?, ?)"; // to avoid sql injections we use the wild card ? and a PreparedStatement instead of a Statement
        try (
                Connection connection = ConnectionFactory.createConnection();
                PreparedStatement statement = connection.prepareStatement(query)
                ) {
            statement.setInt(1, section.getSectionId());
            statement.setString(2, section.getSectionName());
            if (section.getDelegateId() != null) {
                statement.setInt(3, section.getDelegateId());
            }
            else {
                statement.setNull(3, Types.INTEGER);
            }
            if (statement.executeUpdate() != 1) {
                throw new RuntimeException("Insertion failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Insertion failed");
        }
    }

    public Section updateSection(Section section) {
        if (section == null){
            throw new IllegalArgumentException();
        }
        String query = "UPDATE section SET section_name = ?, delegate_id = ? WHERE section_id = ?"; // to avoid sql injections we use the wild card ? and a PreparedStatement instead of a Statement
        try (
                Connection connection = ConnectionFactory.createConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setString(1, section.getSectionName());
            if (section.getDelegateId() != null) {
                statement.setInt(2, section.getDelegateId());
            }
            else {
                statement.setNull(2, Types.INTEGER);
            }
            statement.setInt(3, section.getSectionId());
            if (statement.executeUpdate() != 1) {
                throw new RuntimeException("Update failed");
            }
            return this.getSection(section.getSectionId());
        } catch (SQLException e) {
            throw new RuntimeException("Update failed");
        }
    }

    public Section deleteSection(int section_id) {
        Section section = this.getSection(section_id);
        if (section == null) {
            return null;
        }
        String query = "DELETE FROM section WHERE section_id = ?";
        try (
                Connection connection = ConnectionFactory.createConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setInt(1, section_id);
            if (statement.executeUpdate() != 1) {
                throw new RuntimeException("Delete failed");
            }
            else {
                return section;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Delete failed");
        }
    }
}