package Model;

public class Characters {
    private int idChar;
    private String nameUser;
    private int Point;
    private int Level;
    private int TotalMonster;

    public Characters(int idChar, String nameUser, int Point, int Level, int TotalMonster) {
        this.idChar = idChar;
        this.nameUser = nameUser;
        this.Point = Point;
        this.Level = Level;
        this.TotalMonster = TotalMonster;
    }

    public Characters() {

    }

    public Characters(int idChar, String nameUser, int point, int level) {
        this.idChar = idChar;
        this.nameUser = nameUser;
        this.Point = point;
        this.Level = level;
    }


    public int getIdChar() {
        return idChar;
    }

    public void setIdChar(int idChar) {
        this.idChar = idChar;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public int getPoint() {
        return Point;
    }

    public void setPoint(int point) {
        Point = point;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public int getTotalMonster() {
        return TotalMonster;
    }

    public void setTotalMonster(int totalMonster) {
        TotalMonster = totalMonster;
    }

    @Override
    public String toString() {
        return "Characters{" +
                "idChar=" + idChar +
                ", nameUser='" + nameUser + '\'' +
                ", Point=" + Point +
                ", Level=" + Level +
                ", TotalMonster=" + TotalMonster +
                '}';
    }
}
