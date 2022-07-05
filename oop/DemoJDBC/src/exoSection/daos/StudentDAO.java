package exoSection.daos;

import exoSection.models.Section;
import exoSection.models.Student;
import exoSection.utils.ConnectionFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    // constructor
    public StudentDAO() {
    }

    // methods
    public List<Student> getList() {
        String query = "SELECT *" + " FROM student" + " LEFT JOIN section ON student.section_id = section.section_id";
        try (
                Connection connection = ConnectionFactory.createConnection();
                Statement statement = connection.createStatement();
                ResultSet results = statement.executeQuery(query)
        )
        {
            List<Student> list = new ArrayList<>();
            while (results.next()) {
                int student_id = results.getInt("student_id");
                String first_name = results.getString("first_name");
                String last_name = results.getString("last_name");
                LocalDate birth_date = results.getDate("birth_date").toLocalDate();
                String login = results.getString("login");
                Integer year_result = results.getInt("year_result");
                if(results.wasNull()) {
                    year_result = null;
                }
                String course_id = results.getString("course_id");
                Integer section_id = results.getInt("section_id");
                if(!results.wasNull()) {
                    section_id = null;
                }
                String section_name = results.getString("section_name");
                Integer delegate_id = results.getInt("delegate_id");
                if(results.wasNull()) {
                    delegate_id = null;
                }
                if (section_id != null) {
                    list.add(new Student(student_id, first_name, last_name, birth_date, login, year_result, course_id, new Section(section_id, section_name, delegate_id)));
                }
                else {
                    list.add(new Student(student_id, first_name, last_name, birth_date, login, year_result, course_id, null));
                }
            }
            return list;
        }
        catch (SQLException ex) {
            throw new RuntimeException("SQL error - "+ ex.getSQLState() + ": " + ex.getErrorCode() + " - " + ex.getMessage());
        }
    }

    public Student insertStudent(Student student) {
        if (student == null){
            throw new IllegalArgumentException();
        }
        String query = "INSERT INTO student (student_id, first_name, last_name, birth_date, login, section_id, year_result, course_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (
                Connection connection = ConnectionFactory.createConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setInt(1, student.getStudentId());
            statement.setString(2, student.getFirstName());
            statement.setString(3, student.getLastName());
            statement.setDate(4, Date.valueOf(student.getBirthDate()));
            statement.setString(5, student.getLogin());
            if (student.getSectionId() != null) {
                statement.setInt(6, student.getSectionId());
            }
            else {
                statement.setNull(6, Types.INTEGER);
            }
            if (student.getYearResult() != null) {
                statement.setInt(7, student.getYearResult());
            }
            else {
                statement.setNull(7, Types.INTEGER);
            }
            statement.setString(8, student.getCourseId());
            if (statement.executeUpdate() != 1) {
                throw new RuntimeException("Insertion failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Insertion failed");
        }
        return student;
    }
}
