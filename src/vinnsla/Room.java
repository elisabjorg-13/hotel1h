package vinnsla;

import java.util.Date;

public class Room {
    private String hotelName;
    private int roomId;
    private int hotelId;
    private int roomRank;
    private int price;
    private Date arrivalTime;
    private int numberOfBeds;
    private boolean booked = false;

    /**
     * Smiður fyrir herbergi
     */
    public Room(String hotelName, int roomId, int hotelId, int roomRank, int price ,Date arrivalTime, int numberOfBeds,boolean booked) {
        this.hotelName = hotelName;
        this.roomId = roomId;
        this.hotelId = hotelId;
        this. roomRank = roomRank;
        this.price = price;
        this.arrivalTime = arrivalTime;
        this.numberOfBeds = numberOfBeds;
        this.booked = booked;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRoomRank(int roomRank) {
        this.roomRank = roomRank;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void bookRoom(){
        booked = true;
    }












}
