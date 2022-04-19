package vidmot;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;


public class AddHotelController {

    @FXML
    private javafx.scene.control.TextField userId;
    @FXML
    private javafx.scene.control.TextField roompriceId;
    @FXML
    private CheckBox petfriendlyId;
    @FXML
    private CheckBox familyfriendlyId;
    @FXML
    private javafx.scene.control.TextField hotelnameId;
    @FXML
    private Button AddId;


    private String notandi;
    private int roomVerd;
    private Boolean fjolskylduvaent;
    private Boolean gaeludyr;
    private String hotelNafn;

    public void addHotelHandler(ActionEvent actionEvent) {
        String verd = roompriceId.getText();

        notandi = userId.getText();
        roomVerd = Integer.parseInt(verd);
        if(familyfriendlyId.isSelected()){
            fjolskylduvaent = true;
        }
        if(petfriendlyId.isSelected()){
            gaeludyr = true;
        }
        hotelNafn = hotelnameId.getText();

    }


}
