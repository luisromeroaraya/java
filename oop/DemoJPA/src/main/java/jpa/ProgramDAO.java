package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpa.daos.SectionDAO;
import jpa.daos.StudentDAO;
import jpa.entities.Section;
import jpa.entities.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ProgramDAO {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJPA");
        EntityManager manager = emf.createEntityManager();

        ////////////////////////////////////////////////////////////

        SectionDAO sectionDAO = new SectionDAO(manager);
        System.out.println("-------------------------------------");

        // GET ONE
        System.out.println(sectionDAO.get(1010));
        System.out.println("-------------------------------------");


        // GET ALL
        List<Section> sectionList = sectionDAO.getAll();
        sectionList.forEach(System.out::println);
        System.out.println("-------------------------------------");

        // INSERT
        Section newSection = new Section(666, "SS Satanic Studies", null);
        System.out.println(sectionDAO.insert(newSection));
        System.out.println("-------------------------------------");

        // UPDATE
        newSection.setDelegateId(25);
        System.out.println(sectionDAO.update(newSection));
        System.out.println("-------------------------------------");

        // DELETE
        Section sectionToDelete = sectionDAO.get(666);
        System.out.println(sectionDAO.delete(sectionToDelete));
        System.out.println("-------------------------------------");

        ////////////////////////////////////////////////////////////

        StudentDAO studentDAO = new StudentDAO(manager);
        System.out.println("-------------------------------------");

        // GET ONE
        System.out.println(studentDAO.get(1));
        System.out.println("-------------------------------------");


        // GET ALL
        List<Student> studentList = studentDAO.getAll();
        studentList.forEach(System.out::println);
        System.out.println("-------------------------------------");

        // INSERT
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Student newStudent = new Student(100, "Will", "Smith", LocalDate.parse("1979-04-05", formatter), "wsmith" , 1320, 9, "EG2210");
        System.out.println(studentDAO.insert(newStudent));
        System.out.println("-------------------------------------");

        // UPDATE
        newStudent.setSection_id(1020);
        System.out.println(studentDAO.update(newStudent));
        System.out.println("-------------------------------------");

        // DELETE
        Student studentToDelete = studentDAO.get(100);
        System.out.println(studentDAO.delete(studentToDelete));
        System.out.println("-------------------------------------");

        emf.close();
    }
}
