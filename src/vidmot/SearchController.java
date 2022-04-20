package vidmot;

import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import vinnsla.Room;
import vinnsla.hotelHardCode;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

/******************************************************************************
 * @author Team 1H
 *
 * The controller responsible for all the work inside the search window.
 *****************************************************************************/
public class SearchController {
    @FXML
    private Label booklabel;
    @FXML
    private Button Bookbutton;
    @FXML
    private CheckBox familyfriendlyId;
    @FXML
    private CheckBox petfriendlyId;
    @FXML
    private DatePicker arrivaldateId;
    @FXML
    private Button searchId;
    @FXML
    private ListView<Room> listviewId;
    @FXML
    private  Label valueId;
    @FXML
    Slider sliderValue;

    private Boolean fjolskylduvaent;
    private Boolean gaeludyr;
    private LocalDate komutimi;
    private Boolean submit;
    private double sliderVal;
    private hotelHardCode hotelskra = new hotelHardCode();
    private int virkurIndex = 0;

    private Alertgluggi alert = new Alertgluggi();//upphafsstilli nyjan alert glugga
    private static final String ILAGI ="Í lagi";//takki fyrir alert gluggann
    ButtonType bType = new ButtonType(ILAGI, ButtonBar.ButtonData.OK_DONE);//hnappar fyrir alert glugganna





    public void initialize() {
        valueId.textProperty().bind(Bindings.format("%.2f", sliderValue.valueProperty()));






    }


    public void searchbuttonHandler(ActionEvent actionEvent) {
        if(familyfriendlyId.isSelected()){
            fjolskylduvaent = true;
        }
        if(petfriendlyId.isSelected()){
            gaeludyr = true;
        }
        komutimi = arrivaldateId.getValue();
        sliderVal = sliderValue.getValue();

        ObservableList<Room> listilesinn = hotelskra.lesa("");
        listviewId.setItems(listilesinn);

    }



    public void Bookhandler(ActionEvent actionEvent) {
        virkurIndex = listviewId.getSelectionModel().getSelectedIndex();

        if(virkurIndex == -1){
            booklabel.setText("Vinsamlegast veldu herbergi");

        }
        Alert a = alert.stofnaAlert("Bóka herbergi","Ertu viss um að þú viljir bóka herbergi" + hotelskra.getroom(virkurIndex),
                "Tilkynning", bType);
        Optional<ButtonType> svar = a.showAndWait();

        if (svar.isPresent() && svar.get() == bType) {
            if (virkurIndex != -1){
                hotelskra.eydaroom(virkurIndex);
                booklabel.setText("Takk fyrir að velja herbergi");


            }

        }


    }
}
