package exoSection;
import exoSection.models.Section;
import exoSection.models.SectionDAO;

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
        System.out.println("Showing data from section 1010:");
        Section section = dao.getSection(1010);
        System.out.printf("section_id: %s, section_name: %s, delegate_id: %s\n", section.getSectionId(), section.getSectionName(), section.getDelegateId());
    }
}
