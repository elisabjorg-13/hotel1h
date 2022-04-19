package data;

import java.sql.*;
import static application.Utils.*;

/**
 * @author Team 1H
 *
 * Object that can do queries on the Reservations table.
 */
public class UserDB implements MakeConnection {
    Connection conn;
    Statement stmt;
    PreparedStatement ps;
    ResultSet rs;
    String url;

    /**
     * Constructor that initializes the instance variable url.
     */
    public UserDB(){ url = getUrlAndDatabase()[0]; }

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

    public int insertUser(String email, String phone, String username, boolean isAdmin){
        String query = "INSERT INTO Users"
                +"(email,"
                +"phone,"
                +"username,"
                +"isAdmin)"
                +"values(?,?,?,?);";
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, phone);
            ps.setString(3, username);
            ps.setBoolean(4, isAdmin);
            ps.executeUpdate();
            ps.close();
            conn.commit();
            rs = stmt.executeQuery("SELECT last_insert_rowid();");
            return rs.getInt(1);
        } catch (SQLException e) {
            return 0;
        }
    }

    public boolean removeUser(int userId) {
        validConnection(conn);
        String query = "DELETE FROM Users WHERE userId = ? CASCADE";
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            int result = ps.executeUpdate();
            ps.close();
            conn.commit();
            return result > 0;
        }catch (SQLException e){
            return false;
        }
    }
}
