package sample.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class Controller {

    private SceneController sceneController;

    //!!!!!!!!!DECLARE VARIABLES BLOCK!!!!!!!!!!!!

    //Scene building variables
    private static Scene scene;
    private static String sceneModel;

    //Lang changing variables
    private final static String langRus = "rus";
    private final static String langEng = "eng";
    private static String lang = langRus;

    //!!!!!!!!!!END OF DECLARE VARIABLES BLOCK!!!!!!!!!!!!

    //!!!!!!!!!!!SETTERS AND GETTERS BLOCK!!!!!!!!!!!!!!!

    //!!!!!!!!!!SETTERS AND GETTERS FOR SCENE BUILDING
    public static void setScene(Scene scene) {
        Controller.scene = scene;
    }

    public static void setSceneModel(String sceneModel) {
        Controller.sceneModel = sceneModel;
    }

    public Scene getScene(){
        return scene;
    }

    public String getSceneModel() {
        return sceneModel;
    }
    //!!!!!!!!!END

    //!!!!!!!SETTERS AND GETTERS FOR CHANGING LANGUAGE
    public static void setLang(String lang) {
        Controller.lang = lang;
    }

    public static String getLang() {
        return lang;
    }

    public static String getLangEng() {
        return langEng;
    }

    public static String getLangRus() {
        return langRus;
    }
    //!!!!!!!!END

    //!!!!!!!!!!END OF SETTERS AND GETTERS FOR BLOCK

    //!!!!!!!!!!SWITCH TO ANOTHER SCENE BLOCK!!!!!!!!!!!!!

    //!!!!!!!!!SWITCH TO EXAMPLES SCENE
    public void switchToExamples() throws Exception{
        loadFXMLScene();
        sceneController.activate("examples");
    }
    //END

    //!!!!!!!!!SWITCH TO GREENBERG MODELS CHART SCENE
    public void switchToGreenbergModelsChart() throws  Exception{
        loadFXMLScene();
        sceneController.activate("interface");
    }
    //END

    //!!!!!!!!!SWITCH TO GREENBERG MODELS THEORY SCENE
    public void switchToGreenbergModelsTheory() throws Exception{
        loadFXMLScene();
        sceneController.activate("theory");
    }
    //END

    //????????????IMPORTANT BLOCK??????????????
    //!!!!!!!!!!!LOAD FXML FOR SHOW SCENE
    private void loadFXMLScene() throws Exception{
        sceneController = new SceneController(scene);
        sceneController.addScene("examples", FXMLLoader.load(getClass().getResource("../screen_interfaces/examples.fxml")));
        sceneController.addScene("theory", FXMLLoader.load(getClass().getResource("../screen_interfaces/theory.fxml")));
        sceneController.addScene("interface", FXMLLoader.load(getClass().getResource("../screen_interfaces/interface.fxml")));

    }
    //END

    //END SWITCH TO ANOTHER SCENE BLOCK



}
