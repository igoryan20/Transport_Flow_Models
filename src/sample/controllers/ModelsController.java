package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import sample.StringResourse;
import sample.TheoryText;

public class ModelsController {

    @FXML
    LineChart lwr_model_chart;
    @FXML
    NumberAxis yAxis, xAxis;
    @FXML
    MenuBar menuBar;
    @FXML
    Menu menuModels, menuTheory, menuExamples, menuLanguage;
    @FXML
    MenuItem greenbergItem, greenbergTheory, rusLangItem, enLangItem;

    private Controller controller = new Controller();

    public Scene scene;
    public String sceneModel;


    public static String lang;
    private StringResourse langResourse = new StringResourse();

    private final double maxSpeed = 300;
    private final double maxDensity = 250;



    private double averageVehicleLength;
    private double driverTimeReaction = 0.504;
    private double brakeDistanceCoef = 0.0285;

    ObservableList<XYChart.Series> seriesList;


    @FXML
    private void initialize(){
        scene = controller.getScene();
        sceneModel = controller.getSceneModel();
        lang = controller.getLang();

        if(sceneModel == "GM"){
            buildGreenbergModels();
        }
        if(lang == controller.getLangEng()){
            changeToEng();
        }
    }

    //!!!!!!!!!!!!!!START MODELS BLOCK!!!!!!!!!!!!!!
    //!!!!!!!!!!!BUILDING GREENBERG MODELS BLOCK!!!!!!!!!
    //building Greenberg Models
    @FXML
    public void buildGreenbergModels(){
        Controller.setSceneModel("GM");
        sceneModel = controller.getSceneModel();
        seriesList = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> speedDensityDependency = FXCollections.observableArrayList();
        speedDensityDependency = linearModel();
        seriesList.add(new XYChart.Series(langResourse.getLinearModelTitle(lang), speedDensityDependency));

        speedDensityDependency = nonlinearModel();
        seriesList.add(new XYChart.Series(langResourse.getNonlinearModelTitle(lang), speedDensityDependency));

        xAxis.setLabel(langResourse.getSpeed(lang));
        yAxis.setLabel(langResourse.getDensity(lang));

        lwr_model_chart.setTitle(langResourse.getModelTitle("g", lang));
        lwr_model_chart.setCreateSymbols(false);
        lwr_model_chart.setData(seriesList);

    }

    //getDataForLinearGreenbergModel
    private ObservableList<XYChart.Data> linearModel(){
        ObservableList<XYChart.Data> linearModelList = FXCollections.observableArrayList();
        double dencity = 0;
        double speed = 0;
        for(dencity = 0; dencity <= maxDensity; dencity++){
            if(dencity == 0){
                speed = maxSpeed;
            } else if(dencity == maxDensity){
                speed = 0;
            } else {
                speed = maxSpeed*dencity*( 1-(dencity/maxDensity) );
                if(speed > maxSpeed){
                    speed = maxSpeed;
                }
            }
            linearModelList.add(new XYChart.Data(speed, dencity));
        }

        return linearModelList;
    }

    //getDataForNonlinearGreenbergModel
    private ObservableList<XYChart.Data> nonlinearModel(){

        ObservableList<XYChart.Data> nonlinearModelList = FXCollections.observableArrayList();
        double dencity = 0;
        double speed = 0;
        for(dencity = 0; dencity < maxDensity; dencity++){
            if(dencity == 0){
                nonlinearModelList.add(new XYChart.Data(maxSpeed, dencity));
            } else {
                speed = maxSpeed * Math.log(maxDensity / dencity);
                if(speed > maxSpeed){
                    nonlinearModelList.add(new XYChart.Data(maxSpeed, dencity));
                } else {
                    nonlinearModelList.add(new XYChart.Data(speed, dencity));
                }
            }
        }
        return nonlinearModelList;
    }
    //!!!!!!!!!!!THE END OF BUILDING GREENBERG MODELS BLOCK!!!!!!!!!!!

    //    //LWR model
//    @FXML
//    public void buildLWR(){
//        averageVehicleLength = 5.7;
//
//        ObservableList<XYChart.Data> speedDensityDependency = FXCollections.observableArrayList();
//
//        for (speed = 0; speed < maxSpeed; speed++){
//            if(speed == 0){
//                dencity = 1/averageVehicleLength;
//            } else {
//                dencity = (1 / (averageVehicleLength + driverTimeReaction * speed + brakeDistanceCoef* (Math.pow(speed, 2))));
//            }
//            speedDensityDependency.add(new XYChart.Data(speed, dencity));
//        }
//
//
//        seriesList.add(new XYChart.Series("Speed Density Dependency", speedDensityDependency));
//
//
//        lwr_model_chart.setData(seriesList);
//    }



    //!!!!!!!!!!CHANGING LANGUAGE BLOCK!!!!!!!!!!!
    @FXML
    private void changeToRus(){
        lang = "rus";
        changeLang();
    }

    @FXML
    private void changeToEng(){
        lang = controller.getLangEng();
        changeLang();
    }

    private void changeLang(){

        if(sceneModel == "GM"){
            buildGreenbergModels();
        }

        menuModels.setText(langResourse.getModels(lang));
        menuTheory.setText(langResourse.getTheory(lang));
        menuExamples.setText(langResourse.getExamples(lang));
        menuLanguage.setText(langResourse.getLanguage(lang));
        greenbergItem.setText(langResourse.getModelTitle("g", lang));
        greenbergTheory.setText(langResourse.getModelTitle("g", lang));
        rusLangItem.setText(langResourse.getRusText(lang));
        enLangItem.setText(langResourse.getEngText(lang));
    }
    //THE END OF CHANGING LANGUAGE BLOCK!!!!!!!!!!!!!!


    //!!!!!!!!!!!!!!!SWITCH TO ANOTHER SCENE!!!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!!!!!!!!SWITCH TO MATH THEORY OF MODEL BLOCK!!!!!!!!!!!!!!!!!
    @FXML
    public void swithcToGreenbergModelsTheory() throws Exception {
        Controller.setLang(lang);
        controller.switchToGreenbergModelsTheory();
    }


    //!!!!!!!!!!!!!SWITCH TO MODEL EXAMPLES!!!!!!!!!!!!!!!!!!!
    @FXML
    public void switchToExamples() throws Exception{
        Controller.setLang(lang);
        controller.switchToExamples();
    }

}
