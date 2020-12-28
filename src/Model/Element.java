package Model;

public class Element {
    private int idElement;
    private String nameElement;

    public Element(int idElement, String nameElement){
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
