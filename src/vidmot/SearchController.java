package vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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

    private Boolean fjolskylduvaent;
    private Boolean gaeludyr;





    public void searchbuttonHandler(ActionEvent actionEvent) {
        if(familyfriendlyId.isSelected()){
            fjolskylduvaent = true;
        }
        if(familyfriendlyId.isSelected()){
            gaeludyr = true;
        }


    }
}
