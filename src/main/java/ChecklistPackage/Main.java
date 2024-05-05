package ChecklistPackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

    public void start(Stage primaryStage){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();
            Controller controller = loader.getController();
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);

            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.setScene(scene);
            controller.setStage(primaryStage);
            primaryStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
