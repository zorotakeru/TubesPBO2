package Model;

public class Skills {
    private int idSkills;
    private String skillName;
    private int elementalMastery;
    private String Element;

    public Skills(String skillName, int elementaryMastery, String Element) {
        this.skillName = skillName;
        this.elementalMastery = elementaryMastery;
        this.Element = Element;
    }

    public Skills(int idSkills, Skills skills) {
        this.setIdSkills(idSkills);
        this.setSkillName(skills.getSkillName());
        this.setElementalMastery(skills.getElementalMastery());
        this.setElement(skills.getElement());
    }

    public Skills(int idSkill, String skillname, int elementmastery, int element) {
    }


    public int getIdSkills() {
        return idSkills;
    }

    public void setIdSkills(int idSkills) {
        this.idSkills = idSkills;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getElementalMastery() {
        return elementalMastery;
    }

    public void setElementalMastery(int elementalMastery) {
        this.elementalMastery = elementalMastery;
    }

    public String getElement() {
        return Element;
    }

    public void setElement(String element) {
        Element = element;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "idSkills=" + idSkills +
                ", skillName='" + skillName + '\'' +
                ", elementalMastery=" + elementalMastery +
                ", Element='" + Element + '\'' +
                '}';
    }
}
