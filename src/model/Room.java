package model;

public class Room {
    private String nameRoom;
    private double priceRoom;
    private String statusRoom;
    private int bedroomNumber;
    private int toiletNumber;

    public Room() {
    }

    public Room(String nameRoom, double priceRoom, String statusRoom, int bedroomNumber, int toiletNumber) {
        this.nameRoom = nameRoom;
        this.priceRoom = priceRoom;
        this.statusRoom = statusRoom;
        this.bedroomNumber = bedroomNumber;
        this.toiletNumber = toiletNumber;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public double getPriceRoom() {
        return priceRoom;
    }

    public void setPriceRoom(double priceRoom) {
        this.priceRoom = priceRoom;
    }

    public String getStatusRoom() {
        return statusRoom;
    }

    public void setStatusRoom(String statusRoom) {
        this.statusRoom = statusRoom;
    }

    public int getBedroomNumber() {
        return bedroomNumber;
    }

    public void setBedroomNumber(int bedroomNumber) {
        this.bedroomNumber = bedroomNumber;
    }

    public int getToiletNumber() {
        return toiletNumber;
    }

    public void setToiletNumber(int toiletNumber) {
        this.toiletNumber = toiletNumber;
    }

    @Override
    public String toString() {
        return "Room{" +
                "nameRoom='" + nameRoom + '\'' +
                ", priceRoom=" + priceRoom +
                ", statusRoom='" + statusRoom + '\'' +
                ", bedroomNumber=" + bedroomNumber +
                ", toiletNumber=" + toiletNumber +
                '}';
    }

    public String write() {
        return nameRoom + "," + priceRoom + "," + statusRoom + "," +
                bedroomNumber + "," + toiletNumber;
    }
}
