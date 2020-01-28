package model;

public class Model {
    int id;
    String value;

    public Model(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public Model() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
