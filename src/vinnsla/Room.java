package vinnsla;

import javafx.collections.FXCollections;

import java.util.Date;
import java.util.function.BooleanSupplier;

/**
 * @author Team 1H
 * Room object to store necessary room items connected to hotels.
 * This is the most important model class because these are the items we show inside the
 * listView item.
 */
public class Room {
    private String hotelName;
    private int roomId;
    private int hotelId;
    private int roomRank;
    private int price;
    private Date arrivalTime;
    private int numberOfBeds;
    private int booked = 0;
    private String hotelAddress;
    private int petFriendly;
    private int familyFriendly;

    /**
     * Smiður fyrir herbergi
     */
    public Room(int roomId, java.sql.Date arrivalTime,String hotelName , String hotelAddress, int price, int roomRank, int numberOfBeds, int petfriendly, int familyfriendly) {
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


    public String toString(){
        return (getHotelName()+" "+getPrice());

    }







    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getPetfriendly() {
        return petFriendly;
    }

    public int getPrice() {
        return price;
    }

    public int getFamilyfriendly() {
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
        booked = 1;
    }












}
