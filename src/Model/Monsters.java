package Model;

public class Monsters {
    private int idMonster;
    private int hpMonster;
    private int manaMonster;
    private int attMonster;
    private int defMonster;
    private String UserId;
    private String EleId1;
    private String EleId2;
    private String nameMonster;
    private String skill1;
    private String skill2;

    public Monsters(int id, String name, int hpmonsters, int mana, int att, int deff, String skill1, String skill2, String owner) {
        this.idMonster = id;
        this.nameMonster = name;
        this.hpMonster = hpmonsters;
        this.manaMonster = mana;
        this.attMonster = att;
        this.defMonster = deff;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.setUserId(owner);
    }

    public  Monsters(){

    }

    public int getIdMonster() {
        return idMonster;
    }

    public void setIdMonster(int idMonster) {
        this.idMonster = idMonster;
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





    public String getNameMonster() {
        return nameMonster;
    }

    public void setNameMonster(String nameMonster) {
        this.nameMonster = nameMonster;
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
        return "Monsters{" +
                "idMonster=" + idMonster +
                ", hpMonster=" + hpMonster +
                ", manaMonster=" + manaMonster +
                ", attMonster=" + attMonster +
                ", defMonster=" + defMonster +
                ", UserId=" + getUserId() +
                ", EleId1=" + getEleId1() +
                ", EleId2=" + getEleId2() +
                ", nameMonster='" + nameMonster + '\'' +
                ", skill1='" + skill1 + '\'' +
                ", skill2='" + skill2 + '\'' +
                '}';
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getEleId1() {
        return EleId1;
    }

    public void setEleId1(String eleId1) {
        EleId1 = eleId1;
    }

    public String getEleId2() {
        return EleId2;
    }

    public void setEleId2(String eleId2) {
        EleId2 = eleId2;
    }
}
