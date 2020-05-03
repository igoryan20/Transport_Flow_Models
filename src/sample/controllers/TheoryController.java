package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import sample.resources.StringResource;


public class TheoryController {

    private Controller controller = new Controller();

    private String lang = controller.getLang();
    private String langEng = controller.getLangEng();
    private String langRus = controller.getLangRus();
    private StringResource langResourse = new StringResource();

    @FXML
    Menu menuModels, menuTheory, menuExamples, menuLanguage;
    @FXML
    MenuItem greenbergItem, greenbergTheory, rusLangItem, enLangItem,
        standardConditions, wetAsphalt, iceCondition;
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
        changeLang();
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
        Image img;

        if(controller.getSceneTheory() == "LWR"){
            if(lang == langEng) {
                img = new Image("sample/resources/lwr_eng.jpg");
                image.setFitHeight(1350);
                image.setFitWidth(1350);
            } else {
                img = new Image("sample/resources/LWR_tp.jpg");
                image.setFitWidth(1140);
                image.setFitHeight(1140);
            }
        } else {
            if (lang == langEng) {
                img = new Image("sample/resources/tpEng.jpg");
                image.setFitHeight(1350);
                image.setFitWidth(1350);
            } else {
                img = new Image("sample/resources/tp.jpg");
                image.setFitWidth(1140);
                image.setFitHeight(1140);
            }
        }
        image.setImage(img);

        menuModels.setText(langResourse.getModels(lang));
        menuTheory.setText(langResourse.getTheory(lang));
        menuExamples.setText(langResourse.getExamples(lang));
        menuLanguage.setText(langResourse.getLanguage(lang));

        greenbergItem.setText(langResourse.getModelTitle("g", lang));
        greenbergTheory.setText(langResourse.getModelTitle("g", lang));

        rusLangItem.setText(langResourse.getRusText(lang));
        enLangItem.setText(langResourse.getEngText(lang));

        standardConditions.setText(langResourse.getStandardConditionsTitle(lang));
        wetAsphalt.setText(langResourse.getWetAsphaltTitle(lang));
        iceCondition.setText(langResourse.getIceConditionTitle(lang));
    }
    //!!!!!!!!!!!END OF CHANGING LANG BLOCK!!!!!!!!!!!!!!



    //!!!!!!!!!!!!!!!SWITCH TO ANOTHER SCENE!!!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!!!!!!!!SWITCH TO GREENBERG MODELS CHART!!!!!!!!!!!!
    @FXML
    private void switchToGreenbergModelsChart() throws Exception{
        Controller.setLang(lang);
        Controller.setSceneModel("GM");
        controller.switchToInterface();
    }

    @FXML
    private void switchToLWRChart() throws Exception{
        Controller.setLang(lang);
        Controller.setSceneModel("LWR");
        controller.switchToInterface();
    }

    @FXML
    private void switchToGreenbergTheory() throws Exception{
        Controller.setLang(lang);
        Controller.setSceneTheory("GM");
        controller.switchToTheory();
    }

    @FXML
    private void switchToLWRTheory() throws Exception{
        Controller.setLang(lang);
        Controller.setSceneTheory("LWR");
        controller.switchToTheory();
    }

    @FXML
    private void switchToStandardConditions() throws Exception{
        Controller.setLang(lang);
        Controller.setSceneModel("SC");
        controller.switchToInterface();
    }

    @FXML
    private void switchToWetAsphalt() throws Exception{
        Controller.setLang(lang);
        Controller.setSceneModel("WA");
        controller.switchToInterface();
    }

    @FXML
    private void switchToIceCondition() throws Exception {
        Controller.setLang(lang);
        Controller.setSceneModel("IC");
        controller.switchToInterface();
    }
}
