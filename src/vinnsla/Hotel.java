package vinnsla;

/**
 * @author Team 1H
 * Hotel object to store necessary hotel items for the interface.
 */
public class Hotel {
    private int hotelId;
    private int room;
    private String name;
    private String location;

    public Hotel(int hotelId, int room, String name, String location) {
        this.hotelId = hotelId;
        this.room = room;
        this.name = name;
        this.location = location;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getLocation() {
        return location;
    }

    public int getHotelId() {
        return hotelId;
    }

    public int getRoom() {
        return room;
    }

    public String getName() {
        return name;
    }

}
