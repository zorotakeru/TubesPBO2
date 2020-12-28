package Model;

public class Monsters {
    private int idMonster;
    private String nameMonster;
    private int hpMonster;
    private int manaMonster;
    private int attMonster;
    private int defMonster;
    private String userName;
    private String elementName1;
    private String elementName2;
    private String skill1;
    private String skill2;

    public Monsters(String nameMonster, int hpMonster, int manaMonster, int attMonster, int defMonster, String userName, String elementName1, String elementName2, String skill1, String skill2) {
        this.nameMonster = nameMonster;
        this.hpMonster = hpMonster;
        this.manaMonster = manaMonster;
        this.attMonster = attMonster;
        this.defMonster = defMonster;
        this.userName = userName;
        this.elementName1 = elementName1;
        this.elementName2 = elementName2;
        this.skill1 = skill1;
        this.skill2 = skill2;
    }

        public Monsters(int idMonster, Monsters monsters) {
        this.setIdMonster(idMonster);
        this.setNameMonster(monsters.getNameMonster());
        this.setHpMonster(monsters.getHpMonster());
        this.setManaMonster(monsters.getManaMonster());
        this.setAttMonster(monsters.getAttMonster());
        this.setDefMonster(monsters.getDefMonster());
        this.setUserName(monsters.getUserName());
        this.setElementName1(monsters.getElementName1());
        this.setElementName2(monsters.getElementName2());
        this.setSkill1(monsters.getSkill1());
        this.setSkill2(monsters.getSkill2());
    }



    public int getIdMonster() {
        return idMonster;
    }

    public void setIdMonster(int idMonster) {
        this.idMonster = idMonster;
    }

    public String getNameMonster() {
        return nameMonster;
    }

    public void setNameMonster(String nameMonster) {
        this.nameMonster = nameMonster;
    }

    public int getHpMonster() {
        return hpMonster;
    }

    public void setHpMonster(int hpMonster) {
        this.hpMonster = hpMonster;
    }

    public int getManaMonster() {
        return manaMonster;
    }

    public void setManaMonster(int manaMonster) {
        this.manaMonster = manaMonster;
    }

    public int getAttMonster() {
        return attMonster;
    }

    public void setAttMonster(int attMonster) {
        this.attMonster = attMonster;
    }

    public int getDefMonster() {
        return defMonster;
    }

    public void setDefMonster(int defMonster) {
        this.defMonster = defMonster;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getElementName1() {
        return elementName1;
    }

    public void setElementName1(String elementName1) {
        this.elementName1 = elementName1;
    }

    public String getElementName2() {
        return elementName2;
    }

    public void setElementName2(String elementName2) {
        this.elementName2 = elementName2;
    }

    public String getSkill1() {
        return skill1;
    }

    public void setSkill1(String skill1) {
        this.skill1 = skill1;
    }

    public String getSkill2() {
        return skill2;
    }

    public void setSkill2(String skill2) {
        this.skill2 = skill2;
    }




}
