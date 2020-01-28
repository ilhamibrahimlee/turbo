package model;

public class Avto {
    int id;
    String marka;
    String model;
    double volume;
    int year;
    int cost;
    String info;
    int userId;

    public Avto() {
    }

    public Avto(int id, String marka, String model, double volume, int year, int cost, String info) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.volume = volume;
        this.year = year;
        this.cost = cost;
        this.info = info;
    }


    public Avto(int id, String marka, String model, double volume, int year, int cost) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.volume = volume;
        this.year = year;
        this.cost = cost;
    }
    public Avto(int id, String marka, String model, double volume, int year) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.volume = volume;
        this.year = year;

    }
    public Avto( String marka, String model, double volume, int year) {

        this.marka = marka;
        this.model = model;
        this.volume = volume;
        this.year = year;

    }

    public Avto(String marka, String model, double volume, int year, int cost,int userId) {
        this.marka = marka;
        this.model = model;
        this.volume = volume;
        this.year = year;
        this.cost = cost;
        this.userId=userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
