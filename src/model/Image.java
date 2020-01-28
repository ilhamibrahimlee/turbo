package model;

public class Image {

    int id ;
    String des;
    int avtoId;

    public Image(int id, String des, int avtoId) {
        this.id = id;
        this.des = des;
        this.avtoId = avtoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getAvtoId() {
        return avtoId;
    }

    public void setAvtoId(int avtoId) {
        this.avtoId = avtoId;
    }
}
