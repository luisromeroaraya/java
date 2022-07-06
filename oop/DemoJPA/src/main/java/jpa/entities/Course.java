package jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course {
    @Id
    @Column(name = "course_id")
    private String CourseId;
    @Column(name = "course_name")
    private String CourseName;
    @Column(name = "course_ects")
    private double CourseECTS;
    @Column(name = "professor_id")
    private Integer professorId;
}
