package exoSection.models;

import java.sql.Date;
import java.time.LocalDate;

public class Student {
    private final int student_id;
    private String first_name;
    private String last_name;
    private LocalDate birth_date;
    private String login;
    private Integer section_id;
    private Integer year_result;
    private String course_id;
    private Section section;
    // constructor
    public Student(int student_id, String first_name, String last_name, LocalDate birth_date, String login, Integer section_id, Integer year_result, String course_id, Section section) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.login = login;
        this.section_id = section_id;
        this.year_result = year_result;
        this.course_id = course_id;
        this.section = section;
    }

    // getters
    public int getStudentId() {
        return student_id;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public LocalDate getBirthDate() {
        return birth_date;
    }

    public String getLogin() {
        return login;
    }

    public Integer getSectionId() {
        return section_id;
    }

    public Integer getYearResult() {
        return year_result;
    }

    public String getCourseId() {
        return course_id;
    }

    public Section getSection() {
        return section;
    }

    // setters
    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public void setBirthDate(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSectionId(Integer section_id) {
        this.section_id = section_id;
    }

    public void setYearResult(Integer year_result) {
        this.year_result = year_result;
    }

    public void setCourseId(String course_id) {
        this.course_id = course_id;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
