package jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "section")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Section {
    @Id
    @Column(name = "section_id")
    private int sectionId;
    @Column(name = "section_name")
    private String sectionName;
    @Column(name = "delegate_id")
    private Integer delegateId;
}