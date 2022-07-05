package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpa.daos.SectionDAO;
import jpa.entities.Section;

import java.util.List;

public class ProgramDAO {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJPA");
        EntityManager manager = emf.createEntityManager();
        SectionDAO sectionDAO = new SectionDAO(manager);
        System.out.println("-------------------------------------");

        // GET ONE
        System.out.println(sectionDAO.get(1010));
        System.out.println("-------------------------------------");


        // GET ALL
        List<Section> list = sectionDAO.getAll();
        list.forEach(System.out::println);
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

        emf.close();
    }
}
