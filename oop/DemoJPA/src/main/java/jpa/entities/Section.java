package jpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
// @ToString
public class Section {
    @Id
    @Column(name = "section_id")
    private int sectionId;
    @Column(name = "section_name")
    private String sectionName;
    // @Column(name = "delegate_id")
    // private Integer delegateId; we will replace it for a delegate element
    // the "weak" element in the relation has to add the mappedBy argument
    @OneToMany(mappedBy = "section")
    private List<Student> studentList;

    @ManyToMany
    @JoinTable(
            name = "course_section", // name of our joined table in the DB
            joinColumns = @JoinColumn(name = "section_id"), // ref to the Section table
            inverseJoinColumns = @JoinColumn(name = "course_id") // ref to the Course table
    )
    private List<Course> courseList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delegate_id")
    private Student delegate;

    // methods

    @Override
    public String toString() {
        return "Section{" +
                "sectionId=" + sectionId +
                ", sectionName='" + sectionName + '\'' +
                '}';
    }
}