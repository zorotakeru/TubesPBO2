package Model;

import javafx.collections.ObservableList;

public class Characters {
    private int idChar;
    private String nameUser;
    private int level;
    private int totalMonster;

    public Characters(String nameUser, int level, int totalMonster) {
        this.nameUser = nameUser;
        this.level = level;
        this.totalMonster = totalMonster;
    }

    public Characters(int idChar, Characters characters){
        this.setIdChar(idChar);
        this.setNameUser(characters.getNameUser());
        this.setLevel(characters.getLevel());
        this.setTotalMonster(characters.getTotalMonster());
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTotalMonster() {
        return totalMonster;
    }

    public void setTotalMonster(int totalMonster) {
        this.totalMonster = totalMonster;
    }

    @Override
    public String toString() {
        return nameUser;
    }
}
