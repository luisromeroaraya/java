package jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    @Id
    @Column(name = "student_id")
    private int student_id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "birth_date")
    private LocalDate birth_date;
    @Column(name = "login")
    private String login;
    @Column(name = "section_id")
    private Integer section_id;
    @Column(name = "year_result")
    private Integer year_result;
    @Column(name = "course_id")
    private String course_id;
}
