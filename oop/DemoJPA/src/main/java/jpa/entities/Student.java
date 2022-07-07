package jpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// @ToString we can't have ToString in 2 elements in a bidirectional relation because we will have an infinite loop of ToString between each other
public class Student {
    @Id
    @Column(name = "student_id")
    private int studentId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date", columnDefinition = "datetime") // columnDefinition allows us to specify the same type that we have in the DB
    private LocalDate birthDate;
    @Column(name = "login")
    private String login;
    // @Column(name = "section_id")
    // private Integer sectionId; we replaced it with the Section element
    @Column(name = "year_result")
    private Integer yearResult;
    @Column(name = "course_id")
    private String courseId;
    // to associate a section element to the student we have to specify the kind of relation between the elements
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @OneToOne(mappedBy = "delegate")
    private Section delegated;

    // methods
    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", login='" + login + '\'' +
                ", yearResult=" + yearResult +
                ", courseId='" + courseId + '\'' +
                ", sectionId=" + section.getSectionId() +
                '}';
    }
}
