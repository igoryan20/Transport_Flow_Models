package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.StringResourse;
import sample.TheoryText;

import java.awt.*;


public class TheoryController {

    private Controller controller = new Controller();

    private String lang = controller.getLang();
    private String langEng = controller.getLangEng();
    private String langRus = controller.getLangRus();
    private StringResourse langResourse = new StringResourse();

    @FXML
    Menu menuModels, menuTheory, menuExamples, menuLanguage;
    @FXML
    MenuItem greenbergItem, greenbergTheory, rusLangItem, enLangItem;
    @FXML
    ImageView image;
    @FXML
    MenuBar menuBar;
    @FXML
    VBox vBox;
    @FXML
    ScrollPane scrollPane;

    @FXML
    void initialize() {
        if(lang == langEng){
            changeToEng();
        }
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        image.setFitHeight(scrollPane.getHeight());
        image.setFitWidth(scrollPane.getWidth());
    }


    //!!!!!!!!!!!!CHANGING LANG BLOCK!!!!!!!!!!!!!!!!!!!!
    @FXML
    private void changeToRus(){
        lang = "rus";
        changeLang();
    }

    @FXML
    private void changeToEng(){
        lang = langEng;
        changeLang();
    }

    private void changeLang(){
        menuModels.setText(langResourse.getModels(lang));
        menuTheory.setText(langResourse.getTheory(lang));
        menuExamples.setText(langResourse.getExamples(lang));
        menuLanguage.setText(langResourse.getLanguage(lang));
        greenbergItem.setText(langResourse.getModelTitle("g", lang));
        greenbergTheory.setText(langResourse.getModelTitle("g", lang));
        rusLangItem.setText(langResourse.getRusText(lang));
        enLangItem.setText(langResourse.getEngText(lang));
    }
    //!!!!!!!!!!!END OF CHANGING LANG BLOCK!!!!!!!!!!!!!!



    //!!!!!!!!!!!!!!!SWITCH TO ANOTHER SCENE!!!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!!!!!!!!SWITCH TO GREENBERG MODELS CHART!!!!!!!!!!!!
    @FXML
    private void switchToGreenbergModelsChart() throws Exception{
        Controller.setLang(lang);
        Controller.setSceneModel("GM");
        controller.switchToGreenbergModelsChart();
    }

    @FXML
    private void switchToExamples() throws Exception{
        Controller.setLang(lang);
        controller.switchToExamples();
    }

}
