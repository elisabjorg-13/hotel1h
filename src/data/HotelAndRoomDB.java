package data;

import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vinnsla.Room;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import static application.Utils.*;

/**
 * @author Team 1H
 *
 * Object that can do queries on the Hotels and Rooms tables.
 */
public class HotelAndRoomDB implements MakeConnection {
    Connection conn;
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;
    String url;

    /**
     * Constructor that initializes the instance variable url.
     */
    public HotelAndRoomDB() { url=getUrlAndDatabase()[0]; }

    /**
     * Opens up a connection to the database.
     * Should be called at least once before using the other methods.
     */
    @Override
    public void openConnection() {
        try {
            conn = DriverManager.getConnection(url);
        } catch(SQLException e) {
            throw new IllegalArgumentException("Could not connect to database");
        }
    }

    /**
     * Closes a connection to the database.
     * Should be called when there is no need to query the database any more.
     */
    @Override
    public void closeConnection() {
        try {
            conn.close();
        } catch(SQLException e) {
            throw new IllegalArgumentException("Could not disconnect from database");
        }
    }

    public int addHotel(String hotelName, String country, String hotelAddress){
        String query = "INSERT INTO Hotels"
                +"(hotelName,"
                +"country,"
                +"hotelAddress)"
                +"values(?,?,?);";
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            ps = conn.prepareStatement(query);
            ps.setString(1, hotelName);
            ps.setString(2, country);
            ps.setString(3, hotelAddress);
            ps.executeUpdate();
            ps.close();
            conn.commit();
            rs = stmt.executeQuery("SELECT last_insert_rowid();");
            return rs.getInt(1);
        } catch (SQLException e) {
            return 0;
        }
    }

    public int addRoom(int hotelId, int roomRank, int price, Date arrivalTime, int numberOfBeds, boolean petFriendly, boolean familyFriendly, boolean booked){
        String query = "INSERT INTO Rooms"
                +"(hotelId,"
                +"roomRank,"
                +"price,"
                +"arrivalTime,"
                +"numberOfBeds,"
                +"petFriendly,"
                +"familyFriendly,"
                +"booked)"
                +"values(?,?,?,?,?,?,?,?);";
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            ps = conn.prepareStatement(query);
            ps.setInt(1, hotelId);
            ps.setInt(2, roomRank);
            ps.setInt(3, price);
            ps.setDate(4, arrivalTime);
            //ps.setDate(4, departureTime);
            ps.setInt(5, numberOfBeds);
            ps.setBoolean(6, petFriendly);
            ps.setBoolean(7, familyFriendly);
            ps.setBoolean(8, booked);
            ps.executeUpdate();
            ps.close();
            conn.commit();
            rs = stmt.executeQuery("SELECT last_insert_rowid();");
            return rs.getInt(1);
        } catch (SQLException e) {
            return 0;
        }
    }

    public ObservableList<Room> searchRooms(int priceLow, int priceHigh, java.sql.Date arrivalTime, int numberOfBeds, int petFriendly, int familyFriendly, String country){
        validConnection(conn);
        ObservableList<Room> t = FXCollections.observableArrayList();
        String query = "SELECT Rooms.arrivalTime, Hotels.hotelName, Hotels.hotelAddress, Rooms.price, Rooms.roomRank, Rooms.numberOfBeds, Rooms.petFriendly, Rooms.familyFriendly,"
                +"FROM Rooms, Hotels "
                +"WHERE Rooms.hotelId=Hotel.hotelId "
                +" AND price BETWEEN "
                +priceLow
                +" AND "
                +priceHigh
                +" AND country="
                +country
                +" AND arrivalTime="
                +arrivalTime
                +" AND numberOfBeds="
                +numberOfBeds
                +" AND petFriendly="
                +petFriendly
                +" AND familyFriendly="
                +familyFriendly
                +" AND booked=0"
                +" ORDER BY Rooms.roomId;";
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            //Room currentRoom = new Room();
            int currentId = 0;
            Room currentRoom = null;
            while (rs.next()) {
                int id = rs.getInt("roomId");
                if (id != currentId) {
                    currentId = id;
                    currentRoom = new Room(
                            currentId,
                            rs.getDate("arrivalTime"),
                            rs.getString("hotelName"),
                            rs.getString("hotelAddress"),
                            rs.getInt("price"),
                            rs.getInt("roomRank"),
                            rs.getInt("numberOfBeds"),
                            rs.getInt("petFriendly"),
                            rs.getInt("familyFriendly")
                    );
                }
                LocalDateTime ldt = toLocalDateTime(rs.getLong("tourDate"));
            }
            stmt.close();
            rs.close();
            t.add(currentRoom);
            return t;
        } catch(SQLException e) {
            e.printStackTrace();
            return t;
        }
    }

    public boolean removeRoom(int roomId) {
        validConnection(conn);
        String query = "DELETE FROM Rooms WHERE roomId = ? CASCADE";
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, roomId);
            int result = ps.executeUpdate();
            ps.close();
            conn.commit();
            return result > 0;
        }catch (SQLException e){
            return false;
        }
    }
}