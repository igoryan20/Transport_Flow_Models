package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import sample.StringResourse;

public class ExamplesController {

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
    void initialize() {
        if(lang == langEng){
            changeToEng();
        }
    }

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


    @FXML
    private void switchToGreenbergModelsChart() throws Exception{
        Controller.setLang(lang);
        Controller.setSceneModel("GM");
        controller.switchToGreenbergModelsChart();
    }

    @FXML
    private void switchToGreenbergModelsTheory() throws Exception{
        Controller.setLang(lang);
        controller.switchToGreenbergModelsTheory();
    }


}
