package Model;

public class Monsters {
    private int idMonster;
    private String nameMonster;
    private int hpMonster;
    private int manaMonster;
    private int attMonster;
    private int defMonster;
    private int idUser;
    private int idSkill1;
    private int idSkill2;
    private int idElement1;
    private int idElement2;
    private String userName;
    private String elementName1;
    private String elementName2;
    private String skill1;
    private String skill2;
    private int mastery1;
    private int mastery2;

    public Monsters(String nameMonster, int hpMonster, int manaMonster, int attMonster, int defMonster,int idUser, String userName, String elementName1, String elementName2, String skill1, String skill2, int idSkill1, int idSkill2, int idElement1, int idElement2, int mastery1, int mastery2) {
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
        this.idUser = idUser;
        this.idSkill1 = idSkill1;
        this.idSkill2 = idSkill2;
        this.idElement1 = idElement1;
        this.idElement2 = idElement2;
        this.mastery1 = mastery1;
        this.mastery2 = mastery2;

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
        this.setIdUser(monsters.getIdUser());
        this.setIdSkill1(monsters.getIdSkill1());
        this.setIdSkill2(monsters.getIdSkill2());
        this.setIdElement1(monsters.getIdElement1());
        this.setIdElement2(monsters.getIdElement2());
        this.setMastery1(monsters.getMastery1());
        this.setMastery2(monsters.getMastery2());
    }



    public Monsters(Monsters monsters){
        this.setIdMonster(monsters.getIdMonster());
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
        this.setIdUser(monsters.getIdUser());
        this.setIdSkill1(monsters.getIdSkill1());
        this.setIdSkill2(monsters.getIdSkill2());
        this.setIdElement1(monsters.getIdElement1());
        this.setIdElement2(monsters.getIdElement2());
        this.setMastery1(monsters.getMastery1());
        this.setMastery2(monsters.getMastery2());
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

    @Override
    public String toString() {
        return nameMonster;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }


    public int getIdSkill1() {
        return idSkill1;
    }

    public void setIdSkill1(int idSkill1) {
        this.idSkill1 = idSkill1;
    }

    public int getIdSkill2() {
        return idSkill2;
    }

    public void setIdSkill2(int idSkill2) {
        this.idSkill2 = idSkill2;
    }

    public int getIdElement1() {
        return idElement1;
    }

    public void setIdElement1(int idElement1) {
        this.idElement1 = idElement1;
    }

    public int getIdElement2() {
        return idElement2;
    }

    public void setIdElement2(int idElement2) {
        this.idElement2 = idElement2;
    }

    public int getMastery1() {
        return mastery1;
    }

    public void setMastery1(int mastery1) {
        this.mastery1 = mastery1;
    }

    public int getMastery2() {
        return mastery2;
    }

    public void setMastery2(int mastery2) {
        this.mastery2 = mastery2;
    }
}
