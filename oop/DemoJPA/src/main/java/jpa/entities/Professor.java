package jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "professor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    @Id
    @Column(name = "professor_id")
    private int professorId;
    @Column(name = "professor_name")
    private String firstName;
    @Column(name = "professor_surname")
    private String lastName;
    @Column(name = "section_id")
    private Integer sectionId;
    @Column(name = "professor_office")
    private int officeId;
    @Column(name = "professor_email")
    private String email;
    @Column(name = "professor_hire_date", columnDefinition = "datetime")
    private LocalDate hireDate;
    @Column(name = "professor_wage")
    private int wage;

    // methods

    @Override
    public String toString() {
        return "Professor{" +
                "professorId=" + professorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sectionId=" + sectionId +
                ", officeId=" + officeId +
                ", email='" + email + '\'' +
                ", hireDate=" + hireDate +
                ", wage=" + wage +
                '}';
    }
}
