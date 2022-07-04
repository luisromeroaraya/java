package exoSection;
import exoSection.models.Section;
import exoSection.daos.SectionDAO;

//        Créez une classe Section représentant des sections comme structurées dans la DB.
//
//        Créez une classe SectionDAO avec une methode permettant de récupérer sous la forme
//        d'une List<Section> toutes les sections de la base de données.
//        Bonus : créez une méthode permettant de récupérer une Section par rapport à son section_id

public class Main {
    public static void main(String[] args) {
        SectionDAO dao = new SectionDAO();

        // get data from all the sections and show them on console
        System.out.println("Showing data from all the sections:");
        for (Section section : dao.getList()) {
            System.out.printf("section_id: %s, section_name: %s, delegate_id: %s\n", section.getSectionId(), section.getSectionName(), section.getDelegateId());
        }

        System.out.println("----------------------------------");

        // get data from section_id = 1010 and show it on console
        System.out.println("Showing data from section 1120:");
        Section section = dao.getSection(1120);
        System.out.printf("section_id: %s, section_name: %s, delegate_id: %s\n", section.getSectionId(), section.getSectionName(), section.getDelegateId());

        System.out.println("----------------------------------");

        // insert a new section
        System.out.println("Inserting new Section into the database:");
        dao.insertSection(new Section(666, "Satanism", 5));
        section = dao.getSection(666);
        System.out.printf("section_id: %s, section_name: %s, delegate_id: %s\n", section.getSectionId(), section.getSectionName(), section.getDelegateId());

        System.out.println("----------------------------------");
        System.out.println("Updating data from section 666:");
        section.setSectionName("SS Satanic Studies");
        section.setDelegateId(6);
        System.out.println("New section name = " + section.getSectionName());
        System.out.println("New section delegate id = " + section.getDelegateId());
        section = dao.updateSection(section);
        System.out.printf("section_id: %s, section_name: %s, delegate_id: %s\n", section.getSectionId(), section.getSectionName(), section.getDelegateId());

        System.out.println("----------------------------------");
        System.out.println("Deleting section 666:");
        try {
            System.out.println(dao.deleteSection(666).getSectionName() + " section deleted successfully.");
        }
        catch (Exception ex) {
            System.out.println("Error deleting section");
        }
    }
}
