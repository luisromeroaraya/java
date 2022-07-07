package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpa.daos.*;
import jpa.entities.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ProgramDAO {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJPA");
        EntityManager manager = emf.createEntityManager();
        SectionDAO sectionDAO = new SectionDAO(manager);
        StudentDAO studentDAO = new StudentDAO(manager);
        CourseDAO courseDAO = new CourseDAO(manager);
        ProfessorDAO professorDAO = new ProfessorDAO(manager);
        GradeDAO gradeDAO = new GradeDAO(manager);

        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        ////////////////////////////////////////////////////////////
        // GET ONE
        System.out.println(sectionDAO.get(1010));
        System.out.println("-------------------------------------");

        // GET ALL
        List<Section> sectionList = sectionDAO.getAll();
        sectionList.forEach(System.out::println);
        System.out.println("-------------------------------------");

        // INSERT
        Section newSection = new Section(666, "SS Satanic Studies", List.of(), List.of(), null);
        System.out.println(sectionDAO.insert(newSection));
        System.out.println("-------------------------------------");

        // UPDATE
        newSection.setDelegate(studentDAO.get(25));
        System.out.println(sectionDAO.update(newSection));
        System.out.println("-------------------------------------");

        // DELETE
        Section sectionToDelete = sectionDAO.get(666);
        System.out.println(sectionDAO.delete(sectionToDelete));
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");


        ////////////////////////////////////////////////////////////
        // GET ONE
        System.out.println(studentDAO.get(1));
        System.out.println("-------------------------------------");


        // GET ALL
        List<Student> studentList = studentDAO.getAll();
        studentList.forEach(System.out::println);
        System.out.println("-------------------------------------");

        // INSERT
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Student newStudent = new Student(100, "Will", "Smith", LocalDate.parse("1979-04-05", formatter), "wsmith" , 9, "EG2210", sectionDAO.get(1320), null);
        System.out.println(studentDAO.insert(newStudent));
        System.out.println("-------------------------------------");

        // UPDATE
        newStudent.setLogin("willsmith");
        System.out.println(studentDAO.update(newStudent));
        System.out.println("-------------------------------------");

        // DELETE
        Student studentToDelete = studentDAO.get(100);
        System.out.println(studentDAO.delete(studentToDelete));
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");

        ////////////////////////////////////////////////////////////
        // GET ONE
        System.out.println(courseDAO.get("EG1010"));
        System.out.println("-------------------------------------");

        // GET ALL
        List<Course> courseList = courseDAO.getAll();
        courseList.forEach(System.out::println);
        System.out.println("-------------------------------------");

        // INSERT
        Course newCourse = new Course("EG666", "Satanic rituals", 4.0, 6, List.of());
        System.out.println(courseDAO.insert(newCourse));
        System.out.println("-------------------------------------");

        // UPDATE
        newCourse.setCourseECTS(3.0);
        System.out.println(courseDAO.update(newCourse));
        System.out.println("-------------------------------------");

        // DELETE
        Course courseToDelete = courseDAO.get("EG666");
        System.out.println(courseDAO.delete(courseToDelete));
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");

        ////////////////////////////////////////////////////////////
        // GET ONE
        System.out.println(professorDAO.get(1));
        System.out.println("-------------------------------------");

        // GET ALL
        List<Professor> professorList = professorDAO.getAll();
        professorList.forEach(System.out::println);
        System.out.println("-------------------------------------");

        // INSERT
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Professor newProfessor = new Professor(666, "Lucifer", "Morningstar", 1310, 666, "lucifer", LocalDate.parse("1979-04-05", formatter), 2000);
        System.out.println(professorDAO.insert(newProfessor));
        System.out.println("-------------------------------------");

        // UPDATE
        newProfessor.setSectionId(1020);
        System.out.println(professorDAO.update(newProfessor));
        System.out.println("-------------------------------------");

        // DELETE
        Professor professorToDelete = professorDAO.get(666);
        System.out.println(professorDAO.delete(professorToDelete));
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");

        ////////////////////////////////////////////////////////////
        // GET ONE
        System.out.println(gradeDAO.get("IG"));
        System.out.println("-------------------------------------");

        // GET ALL
        List<Grade> gradeList = gradeDAO.getAll();
        gradeList.forEach(System.out::println);
        System.out.println("-------------------------------------");

        // INSERT
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Grade newGrade = new Grade("X", 21, 30);
        System.out.println(gradeDAO.insert(newGrade));
        System.out.println("-------------------------------------");

        // UPDATE
        newGrade.setUpperBound(40);
        System.out.println(gradeDAO.update(newGrade));
        System.out.println("-------------------------------------");

        // DELETE
        Grade gradeToDelete = gradeDAO.get("X");
        System.out.println(gradeDAO.delete(gradeToDelete));
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");

        ////////////////////////////////////////////////////////////
        Section s = manager.find(Section.class, 1010); // gets section 1010
        Course testCourse = new Course("EG1234", "Test", 4.0, 6, List.of());
        System.out.println(courseDAO.insert(testCourse));

        manager.getTransaction().begin();
        s.setCourseList(List.of(testCourse)); // puts test course into section 1010
        manager.getTransaction().commit();

        manager.getTransaction().begin();
        s.setCourseList(List.of()); // deletes all courses from section 1010
        manager.getTransaction().commit();

        System.out.println(courseDAO.delete(testCourse));

        emf.close();
    }
}
