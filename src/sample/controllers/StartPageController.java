package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.resources.StringResource;

public class StartPageController {

    private StringResource langResource = new StringResource();
    private Controller controller = new Controller();

    @FXML
    Menu menuModels, menuTheory, menuExamples, menuLanguage;
    @FXML
    MenuItem standardConditions, wetAsphalt, iceCondition,
        greenbergItem, lwrItem, greenbergTheory, lwrTheory, rusLangItem, enLangItem;
    @FXML
    ScrollPane scrollPane;
    @FXML
    ImageView imageView;
    @FXML
    Button nextButton;


    private final String langEng = "eng";
    private final String langRus = "rus";
    private String lang;
    private static int slideNumber;

    @FXML
    private void initialize() throws Exception{

        ChoiceDialog<String> dialog = new ChoiceDialog<>("English", "Russian", "English");
        dialog.setTitle(langResource.getTitle(langEng));
        dialog.setHeaderText("Choose language");
        dialog.showAndWait();
        if(dialog.getSelectedItem() == "Russian"){
            lang = langRus;
            Controller.setLang(lang);
        } else {
            lang = langEng;
            Controller.setLang(lang);
            changeMenuToEngLang();
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(langResource.getTitle(lang));
        alert.setHeaderText(langResource.getWelcome(lang));
        alert.setContentText(langResource.getLearning(lang));
        alert.getButtonTypes().remove(0);
        alert.getButtonTypes().add(langResource.getButtonTypeYes(lang));
        alert.getButtonTypes().add(langResource.getButtonTypeNo(lang));
        alert.showAndWait();

        if(alert.getResult() == langResource.getButtonTypeYes(lang)){
            slideNumber = 1;
            scrollPane.setFitToHeight(true);
            scrollPane.setFitToWidth(true);
            if(lang == langEng){
                imageView.setImage(new Image("sample/resources/learning_eng/l" + (slideNumber) + ".jpg"));
                nextButton.setText("Next slide");
            }
        } else {
            scrollPane.setVisible(false);
            scrollPane.setDisable(true);
            nextButton.setVisible(false);
            nextButton.setDisable(true);
        }

        if(lang == langEng){
            changeMenuToEngLang();
        }

    }

    @FXML
    private void switchToGreenbergModels() throws Exception{
        Controller.setLang(lang);
        Controller.setSceneModel("GM");
        controller.switchToInterface();
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
    private void switchToIceCondition() throws Exception{
        Controller.setLang(lang);
        Controller.setSceneModel("IC");
        controller.switchToInterface();
    }

    @FXML
    private void switchToLWRModel() throws Exception{
        Controller.setLang(lang);
        Controller.setSceneModel("LWR");
        controller.switchToInterface();
    }

    @FXML
    private void switchToGreenbergTheory() throws Exception{
        Controller.setLang(lang);
        controller.switchToTheory();
    }

    @FXML
    private void switchToLWRTheory() throws Exception{
        Controller.setLang(lang);
        Controller.setSceneTheory("LWR");
        controller.switchToTheory();
    }

    @FXML
    private void nextSlide(){
        if(slideNumber > 12){
            scrollPane.setVisible(false);
            scrollPane.setDisable(true);
            nextButton.setVisible(false);
            nextButton.setDisable(true);
        } else {
            if(lang == langEng){
                imageView.setImage(new Image("sample/resources/learning_eng/l" + (slideNumber + 1) + ".jpg"));
                if(slideNumber == 12){
                    nextButton.setText("Go to use");
                }
            } else {
                imageView.setImage(new Image("sample/resources/learning/l" + (slideNumber + 1) + ".jpg"));
                if (slideNumber == 12) {
                    nextButton.setText("Перейти к использованию");
                }
            }
            slideNumber++;
        }
    }

    @FXML
    private void changeMenuToEngLang(){
        lang = langEng;
        changeMenuLang();
    }

    @FXML
    private void changeMenuToRusLang(){
           lang = langRus;
           changeMenuLang();
    }

    private void changeMenuLang(){
        //For menu bar items
        menuModels.setText(langResource.getModels(lang));
        menuTheory.setText(langResource.getTheory(lang));
        menuExamples.setText(langResource.getExamples(lang));
        menuLanguage.setText(langResource.getLanguage(lang));

        //For menu items
        greenbergItem.setText(langResource.getModelTitle("g", lang));
        lwrItem.setText(langResource.getModelTitle("l", lang));

        greenbergTheory.setText(langResource.getModelTitle("g", lang));
        lwrTheory.setText(langResource.getModelTitle("l", lang));

        standardConditions.setText(langResource.getStandardConditionsTitle(lang));
        wetAsphalt.setText(langResource.getWetAsphaltTitle(lang));
        iceCondition.setText(langResource.getIceConditionTitle(lang));

        rusLangItem.setText(langResource.getRusText(lang));
        enLangItem.setText(langResource.getEngText(lang));
    }



}



