package Model;

public class Elements {
    private int idElement;
    private String nameElement;

    public Elements(int idElement, String nameElement){
        this.idElement = idElement;
        this.nameElement = nameElement;
    }

    public int getIdElement() {
        return idElement;
    }

    public void setIdElement(int idElement) {
        this.idElement = idElement;
    }

    public String getNameElement() {
        return nameElement;
    }

    public void setNameElement(String nameElement) {
        this.nameElement = nameElement;
    }
}
