package vidmot;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Date;
import java.time.LocalDate;

/******************************************************************************
 *  Nafn    : Elísa Björg
 *  T-póstur: ebt15@hi.is
 *
 *  Lýsing  : Heilsatveim
 *
 *
 *****************************************************************************/
public class SearchController {

    @FXML
    private CheckBox familyfriendlyId;
    @FXML
    private CheckBox petfriendlyId;
    @FXML
    private DatePicker arrivaldateId;
    @FXML
    private Button searchId;
    @FXML
    private ListView listviewId;
    @FXML
    private  Label valueId;
    @FXML
    Slider sliderValue;

    private Boolean fjolskylduvaent;
    private Boolean gaeludyr;
    private LocalDate komutimi;
    private Boolean submit;
    private double sliderVal;

    public void initialize(){
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





    }
}
