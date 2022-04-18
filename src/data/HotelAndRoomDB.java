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
 * Object that can do queries on the Tours table.
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

    public int addHotel(String name, String country, String address){
        String query = "INSERT INTO Hotels"
                +"(name,"
                +"country,"
                +"address)"
                +"values(?,?,?);";
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, country);
            ps.setString(3, address);
            ps.executeUpdate();
            ps.close();
            conn.commit();
            rs = stmt.executeQuery("SELECT last_insert_rowid();");
            return rs.getInt(1);
        } catch (SQLException e) {
            return 0;
        }
    }

    public int addRoom(int roomRank, int price, Date arrTime, Date departureTime, int nBeds, boolean petFriendly, boolean familyFriendly){
        String query = "INSERT INTO Rooms"
                +"(,"
                +"country,"
                +"address)"
                +"values(?,?,?);";
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, country);
            ps.setString(3, address);
            ps.executeUpdate();
            ps.close();
            conn.commit();
            rs = stmt.executeQuery("SELECT last_insert_rowid();");
            return rs.getInt(1);
        } catch (SQLException e) {
            return 0;
        }
    }

    public ObservableList<Room> searchRooms()
}