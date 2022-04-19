package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import static application.Utils.*;

/**
 * @author Team 1H
 *
 * Program that inserts fake data into the tables Tours and Dates in tour.db.
 * All the methods are private since no other program should call and use them.
 * Before running this program it is recommended to run MakeDatabase.java.
 */
public class PopulateDatabase {

    private final HotelAndRoomDB hrdb;
    private final UserDB udb;
    private final String url;
    private final String dbName;

    /**
     * The constructor. It initializes the instance variables.
     */
    private PopulateDatabase() {
        hrdb = new HotelAndRoomDB();
        udb = new UserDB();
        String[] strings = getUrlAndDatabase();
        url = strings[0];
        dbName = strings[1];
    }

    /**
     * Checks whether the file given by the path dbName exists.
     * @return True if file exists, false otherwise.
     */
    private boolean realFile() {
        try {
            File dbFile = new File(dbName);
            if (dbFile.exists()) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * Reads .txt file into BufferedReader.
     *
     * @param fileName Name of .txt file in form of String.
     * @return BufferedReader that has read in the .tct file.
     * @throws IOException If file does not exist.
     */
    private BufferedReader readFile(String fileName) throws IOException {
        String srcPath = getSrcPath();
        fileName = srcPath + "fakeData/" + fileName;
        Path path = Paths.get(fileName);
        return Files.newBufferedReader(path);
    }

    /**
     * Clears all tables within HotelAndRoomDB.
     */
    private void clearTables() {
        Statement stmt;
        try (Connection conn = DriverManager.getConnection(url)) {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            stmt.addBatch("DELETE FROM TOURS");
            stmt.addBatch("DELETE FROM Dates");
            stmt.addBatch("DELETE FROM Reservations");
            stmt.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Populates the Tours table in tour.db with fake data.
     */
    private void makeTours() {
        try {
            BufferedReader br = readFile("tours.txt");
            String line;
            int num=-1;
            hrdb.openConnection();
            while ((line = br.readLine()) != null) {
                String[] stringArray = line.split(";");
                String[] lineArray = Arrays.stream(stringArray).map(String::trim).toArray(String[]::new);
                num = 1;
                /*
                num = hrdb.addRoom(
                        lineArray[0],
                        Integer.parseInt(lineArray[1]),
                        lineArray[2],
                        Integer.parseInt(lineArray[3]),
                        Integer.parseInt(lineArray[4]),
                        Integer.parseInt(lineArray[5]),
                        Integer.parseInt(lineArray[6]),
                        lineArray[7]
                );

                 */
            }
            hrdb.closeConnection();
            if(num>0) {
                System.out.println("--Tours populated--");
            } else System.out.println("--Failed to populate Tours--");
        } catch (IOException e) {
            System.out.println("--Failed to populate Tours--");
        }
    }

    public static void main(String[] args) {
        PopulateDatabase pd = new PopulateDatabase();
        if (pd.realFile()) {
            pd.clearTables();
            pd.makeTours();
        } else System.err.println("Database missing");
    }
}