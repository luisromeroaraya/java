package exoSection.models;

public class Section {
    private int section_id;
    private String section_name;
    private int delegate_id;

    // constructor
    public Section(int section_id, String section_name, int delegate_id) {
        this.section_id = section_id;
        this.section_name = section_name;
        this.delegate_id = delegate_id;
    }

    // getters
    public int getSectionId() {
        return section_id;
    }

    public String getSectionName() {
        return section_name;
    }

    public int getDelegateId() {
        return delegate_id;
    }
}
