package exoSection;
import exoSection.daos.StudentDAO;
import exoSection.models.Section;
import exoSection.daos.SectionDAO;
import exoSection.models.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//        Créez une classe Section représentant des sections comme structurées dans la DB.
//
//        Créez une classe SectionDAO avec une methode permettant de récupérer sous la forme
//        d'une List<Section> toutes les sections de la base de données.
//        Bonus : créez une méthode permettant de récupérer une Section par rapport à son section_id

//        Créez un DAO pour les etudiants
//        permettant de :
//        - faire le crud de base
//        insert renvoie le student ajouté
//        update renvoie un boolean
//        _ delete renvoie le student ajouté
//
//        La classe Student doit posséder une variable
//        Section contenant toutes les infos de sa section
//        plutot que seulement l'id (via un join)
//
//        - Créez une methode permettant de transférer
//        tous les étudiants d'une section dans une
//        autre.
//
//        BONUS
//        -----
//        - Créez une methode appliquant le
//        traitement suivant: Tous les étudiants
//        ayant un résultat au dessus de la moyen
//        se vois accordé le privilège d'un préfixe
//        'winner'au debut de leur login. (il est possible
//        qu'un étudiant ait recu un login de ce type par le
//        passé et que ses résultat ne matche plus. Il
//        perd alors son 'winner')

public class Main {
    public static void main(String[] args) {
        SectionDAO sectionDAO = new SectionDAO();

        // get data from all the sections and show them on console
        System.out.println("Showing data from all the sections:");
        for (Section section : sectionDAO.getList()) {
            System.out.printf("section_id: %s, section_name: %s, delegate_id: %s\n", section.getSectionId(), section.getSectionName(), section.getDelegateId());
        }

        System.out.println("----------------------------------");

        // get data from section_id = 1010 and show it on console
        System.out.println("Showing data from section 1120:");
        Section section = sectionDAO.getSection(1120);
        System.out.printf("section_id: %s, section_name: %s, delegate_id: %s\n", section.getSectionId(), section.getSectionName(), section.getDelegateId());

        System.out.println("----------------------------------");

        // insert a new section
        System.out.println("Inserting new Section into the database:");
        sectionDAO.insertSection(new Section(666, "Satanism", 5));
        section = sectionDAO.getSection(666);
        System.out.printf("section_id: %s, section_name: %s, delegate_id: %s\n", section.getSectionId(), section.getSectionName(), section.getDelegateId());

        System.out.println("----------------------------------");
        System.out.println("Updating data from section 666:");
        section.setSectionName("SS Satanic Studies");
        section.setDelegateId(6);
        System.out.println("New section name = " + section.getSectionName());
        System.out.println("New section delegate id = " + section.getDelegateId());
        section = sectionDAO.updateSection(section);
        System.out.printf("section_id: %s, section_name: %s, delegate_id: %s\n", section.getSectionId(), section.getSectionName(), section.getDelegateId());

        System.out.println("----------------------------------");
        System.out.println("Deleting section 666:");
        try {
            System.out.println(sectionDAO.deleteSection(666).getSectionName() + " section deleted successfully.");
        }
        catch (Exception ex) {
            System.out.println("Error deleting section");
        }

        System.out.println("----------------------------------");
        StudentDAO studentDAO = new StudentDAO();

        // get data from all the students and show them on console
        System.out.println("Showing data from all the students:");
        for (Student student : studentDAO.getList()) {
            System.out.printf("student_id: %s, first_name: %s, last_name: %s, birth_date: %s, login: %s, section_id: %s, section_name: %s, delegate_id: %s, year_result: %s course_id: %s\n", student.getStudentId(), student.getFirstName(), student.getLastName(), student.getBirthDate(), student.getLogin(), student.getSectionId(), student.getSection().getSectionName(), student.getSection().getDelegateId(), student.getYearResult(), student.getCourseId());
        }

        System.out.println("----------------------------------");

        // insert a new student
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Inserting new Student into the database:");
        Student student = studentDAO.insertStudent(new Student(100, "Will", "Smith", LocalDate.parse("1979-04-05", formatter), "wsmith" , 1320, 9, "EG2210", sectionDAO.getSection(1010)));
        System.out.printf("student_id: %s, first_name: %s, last_name: %s, birth_date: %s, login: %s, section_id: %s, section_name: %s, delegate_id: %s, year_result: %s course_id: %s\n", student.getStudentId(), student.getFirstName(), student.getLastName(), student.getBirthDate(), student.getLogin(), student.getSectionId(), student.getSection().getSectionName(), student.getSection().getDelegateId(), student.getYearResult(), student.getCourseId());
    }
}
