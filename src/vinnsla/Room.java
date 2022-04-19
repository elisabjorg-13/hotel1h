package vinnsla;

import java.util.Date;
import java.util.function.BooleanSupplier;

public class Room {
    private String hotelName;
    private int roomId;
    private int hotelId;
    private int roomRank;
    private int price;
    private Date arrivalTime;
    private int numberOfBeds;
    private boolean booked = false;
    private String hotelAddress;
    private boolean petFriendly;
    private boolean familyFriendly;

    /**
     * Smiður fyrir herbergi
     */
    public Room(int roomId, java.sql.Date arrivalTime, String hotelName, String hotelAddress, int price, int roomRank, int numberOfBeds, boolean petfriendly, boolean familyfriendly) {
        this.roomId = roomId;
        this.arrivalTime = arrivalTime;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.roomRank = roomRank;
        this.price = price;
        this.numberOfBeds = numberOfBeds;
        this.petFriendly = petfriendly;
        this.familyFriendly = familyfriendly;
    }



    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public Boolean getPetfriendly() {
        return petFriendly;
    }

    public Boolean getFamilyfriendly() {
        return familyFriendly;
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


    public void bookRoom(){
        booked = true;
    }












}
