package vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader1.load();
        primaryStage.setTitle("Adalgluggi");


        Scene s = new Scene(root, 600, 450);
        primaryStage.setScene(s);

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
