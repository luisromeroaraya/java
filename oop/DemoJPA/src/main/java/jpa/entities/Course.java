package jpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @Column(name = "course_id")
    private String CourseId;
    @Column(name = "course_name")
    private String CourseName;
    @Column(name = "course_ects", columnDefinition = "decimal(3,1)")
    private double CourseECTS;
    @Column(name = "professor_id")
    private Integer professorId;

    @ManyToMany(mappedBy = "courseList")
    List<Section> sectionList = new ArrayList<>();;

    @Override
    public String toString() {
        return "Course{" +
                "CourseId='" + CourseId + '\'' +
                ", CourseName='" + CourseName + '\'' +
                ", CourseECTS=" + CourseECTS +
                ", professorId=" + professorId +
                '}';
    }
}
