package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jpa.entities.Section;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJPA");
        EntityManager manager = emf.createEntityManager();

        // GET ONE
        Section section = manager.find(Section.class, 1010); // we get a section and find attaches it to the manager
        System.out.println(section);

        // GET ALL
        TypedQuery<Section> query = manager.createQuery("SELECT s FROM Section s", Section.class);
        List<Section> list = query.getResultList();
        list.forEach(System.out::println);

        // INSERT
        Section newSection = new Section(666, "SS Satanic Studies", null);
        manager.getTransaction().begin(); // tell the database that we are going to change something
        manager.persist(newSection); // puts the new element into the manager (attaches it)
        manager.getTransaction().commit(); // changes the database and saves it

        // UPDATE
        System.out.println(newSection);
        manager.getTransaction().begin();
        newSection.setDelegateId(25);
        manager.getTransaction().commit();
        System.out.println(newSection);

        // DELETE
        Section sectionToDelete = manager.find(Section.class, 666); // we get the section to be deleted and find puts it into the manager
        manager.getTransaction().begin();
        manager.remove(sectionToDelete);
        // manager.remove(newSection);
        manager.getTransaction().commit();

        emf.close();
    }

}