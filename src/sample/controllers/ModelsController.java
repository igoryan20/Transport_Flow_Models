package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.resources.StringResource;

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
    MenuItem greenbergItem, greenbergTheory, lwrItem, lwrTheory, rusLangItem, enLangItem,
    standardConditions, wetAsphalt, iceCondition;
    @FXML
    VBox vBox;

    private Controller controller = new Controller();

    public Scene scene;
    public String sceneModel;


    public static String lang;
    private StringResource langResourse = new StringResource();

    private final double maxSpeed = 50;
    private final double maxDensity = 0.3;

    @FXML
    private GridPane gridPane;
    @FXML
    private Slider vehicleLengthSlider;
    @FXML
    private Slider driverTimeReactionSlider;
    @FXML
    private Slider brakeDistanceCoefSlider;
    @FXML
    private Label vehicleLengthLabel;
    @FXML
    private Label driverTimeReactionLabel;
    @FXML
    private Label brakeDistanceCoefLabel;

    private double averageVehicleLength = 4.0;
    private double driverTimeReaction = 0.17;
    private double brakeDistanceCoef = 0.0285;

    ObservableList<XYChart.Series> seriesList;


    @FXML
    private void initialize(){
        scene = controller.getScene();
        sceneModel = controller.getSceneModel();
        lang = controller.getLang();

        if(lang == controller.getLangEng()){
            changeToEng();
        }
        chooseModelScene();
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
        double dencity;
        double speed;
        for(dencity = 0; dencity <= maxDensity; dencity += 0.01){
            if(dencity == 0){
                speed = maxSpeed;
            } else {
                speed = maxSpeed*( 1-(dencity/maxDensity) );
                if(speed > maxSpeed){
                    speed = maxSpeed;
                }
            }
            linearModelList.add(new XYChart.Data(dencity, speed));
        }

        return linearModelList;
    }

    //getDataForNonlinearGreenbergModel
    private ObservableList<XYChart.Data> nonlinearModel(){

        ObservableList<XYChart.Data> nonlinearModelList = FXCollections.observableArrayList();
        double dencity;
        double speed;
        for(dencity = 0; dencity < maxDensity; dencity += 0.01){
            if(dencity == 0){
                nonlinearModelList.add(new XYChart.Data(dencity, maxSpeed));
            } else {
                speed = maxSpeed * Math.log(maxDensity / dencity);
                nonlinearModelList.add(new XYChart.Data(dencity, speed));

            }

        }
        return nonlinearModelList;
    }
    //!!!!!!!!!!!THE END OF BUILDING GREENBERG MODELS BLOCK!!!!!!!!!!!

    //LWR model
    @FXML
    public void buildLWR(boolean visible){
        gridPane.setVisible(visible);

        vehicleLengthLabel.setText(String.format(langResourse.getVehicleLength(lang) + " %.2f", vehicleLengthSlider.getValue()));
        driverTimeReactionLabel.setText(String.format(langResourse.getDriverTimeReaction(lang) + " %.2f",driverTimeReactionSlider.getValue()));
        brakeDistanceCoefLabel.setText(String.format(langResourse.getBrakeDistanceCoef(lang) + " %.2f", brakeDistanceCoefSlider.getValue()));

        seriesList = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> densitySpeedDependency = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> intensitySpeedDependency = FXCollections.observableArrayList();

        densitySpeedDependency = LWRDensity( true);
        intensitySpeedDependency = LWRDensity( false);

        seriesList.add(new XYChart.Series(langResourse.getDensity(lang), densitySpeedDependency));
        seriesList.add(new XYChart.Series(langResourse.getIntensity(lang), intensitySpeedDependency));

        yAxis.setLabel("");
        xAxis.setLabel(langResourse.getSpeed(lang));

        lwr_model_chart.setTitle(langResourse.getModelTitle("l", lang));

        if(sceneModel == "SC") {
            lwr_model_chart.setTitle(langResourse.getStandardConditionsTitle(lang));
        }
        if (sceneModel == "WA"){
            lwr_model_chart.setTitle(langResourse.getWetAsphaltTitle(lang));
        }
        if (sceneModel == "IC"){
            lwr_model_chart.setTitle(langResourse.getIceConditionTitle(lang));
        }
        lwr_model_chart.setCreateSymbols(false);
        lwr_model_chart.setData(seriesList);

        if(sceneModel != "SC" && sceneModel != "WA" && sceneModel != "IC"){
            Controller.setSceneModel("LWR");
        }
        sceneModel = controller.getSceneModel();
    }

    private ObservableList<XYChart.Data> LWRDensity(boolean boolDensity){
        ObservableList<XYChart.Data> LWRList = FXCollections.observableArrayList();
        double density;
        double intensity;
        double speed;
        for(speed = 0; speed < maxSpeed; speed++){
            density = 1 / (averageVehicleLength + driverTimeReaction*speed + brakeDistanceCoef*(Math.pow(speed, 2)));
            if(boolDensity) {
                    LWRList.add(new XYChart.Data(speed, density));
            } else {
                intensity = speed*density;
                LWRList.add(new XYChart.Data(speed, intensity));
            }
        }
        return LWRList;
    }


    @FXML
    private void changeLengthVehicle(){
        averageVehicleLength = vehicleLengthSlider.getValue();
        if(sceneModel == "LWR") {
            buildLWR(true);
        }
//        if(sceneModel == "combine"){
//            buildCombineModel();
//        }
    }

    @FXML
    private void changeDriverReaction(){
        driverTimeReaction = driverTimeReactionSlider.getValue();
        if(sceneModel == "LWR") {
            buildLWR(true);
        }
    }

    @FXML
    private void changeBrakeDistanceCoef(){
        brakeDistanceCoef = brakeDistanceCoefSlider.getValue();
        if(sceneModel == "LWR") {
            buildLWR(true);
        }
    }


    //!!!!!!!!!!CHANGING LANGUAGE BLOCK!!!!!!!!!!!
    @FXML
    private void changeToRus(){
        lang = controller.getLangRus();
        changeLang();
    }

    @FXML
    private void changeToEng(){
        lang = controller.getLangEng();
        changeLang();
    }

    private void changeLang(){
        chooseModelScene();

        ((Stage) scene.getWindow()).setTitle(langResourse.getTitle(lang));
        menuModels.setText(langResourse.getModels(lang));
        menuTheory.setText(langResourse.getTheory(lang));
        menuExamples.setText(langResourse.getExamples(lang));
        menuLanguage.setText(langResourse.getLanguage(lang));

        greenbergItem.setText(langResourse.getModelTitle("g", lang));
        greenbergTheory.setText(langResourse.getModelTitle("g", lang));

        lwrItem.setText(langResourse.getModelTitle("l", lang));
        lwrTheory.setText(langResourse.getModelTitle("l", lang));

        standardConditions.setText(langResourse.getStandardConditionsTitle(lang));
        wetAsphalt.setText(langResourse.getWetAsphaltTitle(lang));
        iceCondition.setText(langResourse.getIceConditionTitle(lang));

        rusLangItem.setText(langResourse.getRusText(lang));
        enLangItem.setText(langResourse.getEngText(lang));
    }
    //THE END OF CHANGING LANGUAGE BLOCK!!!!!!!!!!!!!!


    @FXML
    private void switchToGreenbergModels(){
        Controller.setSceneModel("GM");
        buildGreenbergModels();
    }

    @FXML
    private void switchToLWRModel(){
        Controller.setSceneModel("LWR");
        sceneModel = controller.getSceneModel();
        setMinParameters();
        buildLWRVisible();
    }


    //!!!!!!!!!!!!!!!SWITCH TO ANOTHER SCENE!!!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!!!!!!!!SWITCH TO MATH THEORY OF MODEL BLOCK!!!!!!!!!!!!!!!!!
    @FXML
    private void switchToTheory() throws Exception {
        Controller.setLang(lang);
        Controller.setSceneTheory("GM");
        controller.switchToTheory();
    }


    //!!!!!!!!!!!!!SWITCH TO MODEL EXAMPLES!!!!!!!!!!!!!!!!!!!

    @FXML
    private void switchToLWRTheory() throws Exception{
        Controller.setLang(lang);
        Controller.setSceneTheory("LWR");
        controller.switchToTheory();
    }

    @FXML
    private void switchToStandardConditions() throws Exception{
        Controller.setSceneModel("SC");
        sceneModel = controller.getSceneModel();
        buildStandardConditions();
    }

    @FXML
    private void switchToWetAsphalt() throws Exception{
        Controller.setSceneModel("WA");
        sceneModel = controller.getSceneModel();
        buildWetAsphalt();
    }

    @FXML
     private void switchToIceCondition() throws Exception{
        Controller.setSceneModel("IC");
        sceneModel = controller.getSceneModel();
        buildIceCondition();
    }

    private void buildStandardConditions(){
        averageVehicleLength = 5.7;
        driverTimeReaction = 0.504;
        brakeDistanceCoef = 0.0285;
        buildLWR(false);
    }

    private void buildWetAsphalt(){
        averageVehicleLength = 5.7;
        driverTimeReaction = 0.504;
        brakeDistanceCoef = 0.0570;
        buildLWR(false);
    }

    private void buildIceCondition(){
        averageVehicleLength = 5.7;
        driverTimeReaction = 0.504;
        brakeDistanceCoef = 0.165;
        buildLWR(false);
    }

    @FXML
    private void buildLWRVisible(){
        buildLWR(true);
    }

    private void chooseModelScene() {
        switch (sceneModel) {
            case "GM":
                buildGreenbergModels();
                break;
            case "SC":
                buildStandardConditions();
                break;
            case "WA":
                buildWetAsphalt();
                break;
            case "IC":
                buildIceCondition();
                break;
            case "LWR":
                buildLWRVisible();
                break;
        }
    }

    private void setMinParameters(){
        averageVehicleLength = 4.0;
        driverTimeReaction = 0.17;
        brakeDistanceCoef = 0.03;
    }

}
