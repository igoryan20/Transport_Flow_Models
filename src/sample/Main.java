package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controllers.Controller;
import sample.resources.StringResource;

public class Main extends Application {

    StringResource langResourse = new StringResource();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/start_page.fxml"));
        primaryStage.setTitle(langResourse.getTitle(Controller.getLang()));
        Scene scene = new Scene(root);
        Controller.setScene(scene);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
