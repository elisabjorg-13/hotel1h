package vidmot;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

/******************************************************************************
 *  Nafn    : Elísa Björg
 *  T-póstur: ebt15@hi.is
 *
 *  Lýsing  : Heilsatveim
 *
 *
 *****************************************************************************/
public class Alertgluggi {

    private static final String ILAGI ="Í lagi"; // hnappur
    private static final String HAETTAVID = "nei!";// hnappur

    ButtonType bType = new ButtonType(ILAGI, ButtonBar.ButtonData.OK_DONE); // ílagi hnappur
    ButtonType hType = new ButtonType(HAETTAVID, ButtonBar.ButtonData.CANCEL_CLOSE); // hætta við hnappur

    /**
     * Býr til alert sem eg get notað aftur með því að lata alertið taka inn setningu og spurningu og tylkinningu
     * @param NAFNFORRITS nafn gluggans sem alertiðer umm
     * @param SPURNING spurning i alert
     * @param TILKYNNING tilkynning i alert
     * @param bType í lagi hnappur sem eg þarf ehv hluta vegna að taka inn svo alertip virki
     * @return skilar alert glugga
     */
    public Alert stofnaAlert(String NAFNFORRITS, String SPURNING, String TILKYNNING, ButtonType bType) {
        // Væri hægt að segja Alert.AlertType.CONFIRMATION en þá stjórnum við ekki útliti hnappanna
        Alert a = new Alert(Alert.AlertType.NONE,  SPURNING, bType, hType);
        a.setTitle(NAFNFORRITS);
        a.setHeaderText(TILKYNNING);
        return a;
    }
}
