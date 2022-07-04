package exoSection.models;

public class Section {
    private final int section_id;
    private String section_name;
    private Integer delegate_id;

    // constructor
    public Section(int section_id, String section_name, Integer delegate_id) {
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

    public Integer getDelegateId() {
        return delegate_id;
    }

    // setters
    public void setSectionName(String section_name) {
        this.section_name = section_name;
    }

    public void setDelegateId(Integer delegate_id) {
        this.delegate_id = delegate_id;
    }
}
