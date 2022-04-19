package vidmot;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;

import java.awt.*;
import java.awt.event.ActionEvent;

public class AddHotelController {

    @FXML
    private TextField userId;
    @FXML
    private TextField roompriceId;
    @FXML
    private CheckBox petfriendlyId;
    @FXML
    private CheckBox familyfriendlyId;
    @FXML
    private TextField hotelnameId;
    @FXML
    private Button AddId;

    private Boolean fjolskylduvaent;
    private Boolean gaeludyr;

    public void addHotelHandler(ActionEvent actionEvent) {
        if(familyfriendlyId.isSelected()){
            fjolskylduvaent = true;
        }
        if(petfriendlyId.isSelected()){
            gaeludyr = true;
        }
    }


}
