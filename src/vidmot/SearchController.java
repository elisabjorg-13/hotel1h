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
    private CheckBox petfriendlyId;
    private DatePicker arrivaldateId;
    private Button searchId;
    private ListView listviewId;
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
