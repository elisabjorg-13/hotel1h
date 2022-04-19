package vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;

/******************************************************************************
 *  Nafn    : Elísa Björg
 *  T-póstur: ebt15@hi.is
 *
 *  Lýsing  : Heilsatveim
 *
 *
 *****************************************************************************/
public class hotelHardCode {

    private ObservableList<Room> listi;

    /**
     * Gervigögn til að lesa inn
     * @param s heiti á skrá
     * @return skilar observablelist með gervigögnunum
     */
    public ObservableList<Room> lesa(String s) {
        this.listi = FXCollections.observableArrayList();
        listi.add(new Room(1, Date.valueOf("1980-04-09"),"Hótel Skagafjörður", "Rauðagerði", 150000, 1, 2, 1, 1));
        listi.add(new Room(2, Date.valueOf("1980-04-09"),"Hótel Ísó", "Rauðagerði", 30000, 1, 2, 1, 1));
        listi.add(new Room(3, Date.valueOf("1980-04-09"), "kex hostel", "Rauðagerði", 4500, 1, 2, 1, 1));
        listi.add(new Room(3, Date.valueOf("1980-04-09"), "HÓTEL SKAGI", "Rauðagerði", 45000, 1, 2, 1, 1));
        listi.add(new Room(3, Date.valueOf("1980-04-09"), "Blue lagoon hotel", "Rauðagerði", 100000, 1, 2, 1, 1));
        listi.add(new Room(3, Date.valueOf("1980-04-09"), "Hot Hotel", "Rauðagerði", 3000, 1, 2, 1, 1));
        listi.add(new Room(3, Date.valueOf("1980-04-09"), "Hot Hotel", "Rauðagerði", 10010, 1, 2, 1, 1));
        listi.add(new Room(3, Date.valueOf("1980-04-09"), "Hótel Eiríkur", "Rauðagerði", 390, 1, 2, 1, 1));



        return listi;
    }

    /**
     * skilar nemanda hlut utfrá völdum index
     * @param index
     * @return skilar viðeigandi nemanda hlut
     */
    public Room getroom(int index) {
        return (Room) listi.get(index);
    }

    public void eydaroom(int index){
        listi.remove(index);
    }

}
