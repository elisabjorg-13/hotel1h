package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
    private FXMLLoader loader2;//loaderinn
    private Scene s;//senan
    private Stage stage = new Stage();



    /**
     * Hleður inn leikjagluggann þegar ýtt er á byrja hnappinn, spilar tónlistina
     * og kallar á aðferðina sem tengir örvatakkanna
     * @param actionEvent
     */
    public void searchhotel(ActionEvent actionEvent) {
        try {

            loader2 = new FXMLLoader(getClass().getResource("Search.fxml"));
            Parent root1 = (Parent) loader2.load();
            //Stage stage = new Stage();

            stage.setTitle("Space Invaders");
            s = new Scene(root1, 600, 600);
            stage.setScene(s);


            stage.show();

        }catch (Exception e){
            System.out.println("gat ekki hlaðið glugga");
        }
        SearchController ac = loader2.getController();

    }


    public void addhotel(ActionEvent actionEvent) {


    }





}
