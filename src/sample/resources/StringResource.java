package sample.resources;

import javafx.scene.control.ButtonType;

public class StringResource {

    final private String ENG = "eng";
    final private String RUS = "rus";

    final private String LinearModelTitleEng = "Linear Model";
    final private String LinearModelTitleRus = "Линейная модель";

    final private String nonlinearModelTitleEng = "Nonlinear Model";
    final private String nonlinearModelTitleRus = "Нелинейная модель";

    final private String speedEng = "Speed";
    final private String speedRus = "Скорость";

    final private String densityEng = "Density";
    final private String densityRus = "Плотность";

    final private String greenbergModelsEng = "Greenberg Models";
    final private String greenbergModelsRus = "Модели Гринберга";

    final private String lwrModelEng = "LWR Model";
    final private String lwrModelRus = "LWR Модель";

    final private String modelsEng = "Models";
    final private String modelsRus = "Модели";

    final private String theoryEng = "Math Theory";
    final private String theoryRus = "Теория";

    final private String examplesEng = "Examples";
    final private String examplesRus = "Примеры";

    final private String languageEng = "Language";
    final private String languageRus = "Язык";

    final private String rusTextEng = "Russian";
    final private String rusTextRus = "Русский";

    final private String engTextEng = "English";
    final private String engTextRus = "Английский";

    final private String titleEng = "Transport Flow Models";
    final private String titleRus = "Модели транспортных потоков";

    final private ButtonType buttonTypeYesRus = new ButtonType("Да");
    final private ButtonType buttonTypeYesEng = ButtonType.YES;
    final private ButtonType buttonTypeNoRus = new ButtonType("Нет");
    final private ButtonType buttonTypeNoEng = ButtonType.NO;

    final private String vehicleLengthRus = "Длина автомобилей: ";
    final private String vehicleLengthEng = "Vehicles length: ";

    final private String driverTimeReactionRus = "Время реакции водителя: ";
    final private String driverTimeReactionEng = "Driver Time Reaction: ";

    final private String brakeDistanceCoefRus = "Коэффицент тормозного пути: ";
    final private String brakeDistanceCoefEng = "Brake Distance Coefficient: ";

    final private String standardConditionsTitleRus = "LWR Модель: Нормальные Условия";
    final private String standardConditionsTitleEng = "LWR Model: Standard Conditions";

    final private String wetAsphaltTitleEng = "LWR Model: Wet Asphalt";
    final private String wetAsphaltTitleRus = "LWR Модель: Мокрый Асфальт";

    final private String iceConditionTitleEng = "LWR Model: Ice Condition";
    final private String iceConditionTitleRus = "LWR Модель: Гололёд";

    final private String welcomeEng = "Welcome!";
    final private String welcomeRus = "Добро пожаловать!";

    final private String learningEng = "Would you like to pass the learning?";
    final private String learningRus = "Хотите ли вы пройти обучение?";

    final private String intensityEng = "Intensity";
    final private String intensityRus = "Интенсивность";

    public String getLinearModelTitle(String language) {
        if(language == ENG){
            return LinearModelTitleEng;
        } else if(language == RUS){
            return LinearModelTitleRus;
        } else {
            return null;
        }
    }

    public String getNonlinearModelTitle(String language) {
        if(language == ENG){
            return nonlinearModelTitleEng;
        } else if(language == RUS){
            return nonlinearModelTitleRus;
        } else {
            return null;
        }
    }

    public String getSpeed(String lang) {
        if(lang == ENG){
            return speedEng;
        } else if(lang == RUS){
            return speedRus;
        } else {
            return null;
        }
    }

    public String getDensity(String lang){
        if(lang == ENG){
            return densityEng;
        } else if(lang == RUS){
            return densityRus;
        } else {
            return null;
        }
    }

    public String getModelTitle(String model, String lang){
        if(model == "g") {
            if (lang == ENG) {
                return greenbergModelsEng;
            } else if (lang == RUS) {
                return greenbergModelsRus;
            } else {
                return null;
            }
        }
        if(model == "l"){
            if (lang == ENG) {
                return lwrModelEng;
            } else if (lang == RUS) {
                return lwrModelRus;
            } else {
                return null;
            }
        }
        else{
            return null;
        }
    }

    public String getModels(String lang){
        if(lang == ENG){
            return modelsEng;
        } else if(lang == RUS){
            return modelsRus;
        } else {
            return null;
        }
    }

    public String getTheory(String lang){
        if(lang == ENG){
            return theoryEng;
        } else if(lang == RUS){
            return theoryRus;
        } else {
            return null;
        }
    }

    public String getExamples(String lang){
        if(lang == ENG){
            return examplesEng;
        } else if(lang == RUS){
            return examplesRus;
        } else {
            return null;
        }
    }

    public String getLanguage(String lang){
        if(lang == ENG){
            return languageEng;
        } else if(lang == RUS){
            return languageRus;
        } else {
            return null;
        }
    }

    public String getRusText(String lang){
        if(lang == ENG){
            return rusTextEng;
        } else if(lang == RUS){
            return rusTextRus;
        } else {
            return null;
        }
    }

    public String getEngText(String lang){
        if(lang == ENG){
            return engTextEng;
        } else if(lang == RUS){
            return engTextRus;
        } else {
            return null;
        }
    }

    public String getTitle(String lang) {
        if(lang == ENG){
            return titleEng;
        } else if(lang == RUS){
            return titleRus;
        } else {
            return null;
        }
    }

    public ButtonType getButtonTypeYes(String lang){
        if(lang == ENG){
            return buttonTypeYesEng;
        } else if(lang == RUS){
            return buttonTypeYesRus;
        } else {
            return null;
        }
    }

    public ButtonType getButtonTypeNo(String lang){
        if(lang == ENG){
            return buttonTypeNoEng;
        } else if(lang == RUS){
            return buttonTypeNoRus;
        } else {
            return null;
        }
    }

    public String getVehicleLength(String lang){
        if(lang == ENG){
            return vehicleLengthEng;
        } else if(lang == RUS){
            return vehicleLengthRus;
        } else {
            return null;
        }
    }

    public String getDriverTimeReaction(String lang){
        if(lang == ENG){
            return driverTimeReactionEng;
        } else if(lang == RUS){
            return driverTimeReactionRus;
        } else {
            return null;
        }
    }

    public String getBrakeDistanceCoef(String lang){
        if(lang == ENG){
            return brakeDistanceCoefEng;
        } else if(lang == RUS){
            return brakeDistanceCoefRus;
        } else {
            return null;
        }
    }

    public String getStandardConditionsTitle(String lang){
        if(lang == ENG){
            return standardConditionsTitleEng;
        } else if(lang == RUS){
            return standardConditionsTitleRus;
        } else {
            return null;
        }
    }

    public String getWetAsphaltTitle(String lang){
        if(lang == ENG){
            return wetAsphaltTitleEng;
        } else if(lang == RUS){
            return wetAsphaltTitleRus;
        } else {
            return null;
        }
    }

    public String getIceConditionTitle(String lang){
        if(lang == ENG){
            return iceConditionTitleEng;
        } else if(lang == RUS){
            return iceConditionTitleRus;
        } else {
            return null;
        }
    }

    public String getWelcome(String lang){
        if(lang == ENG){
            return welcomeEng;
        } else if(lang == RUS){
            return welcomeRus;
        } else {
            return null;
        }
    }

    public String getLearning(String lang){
        if(lang == ENG){
            return learningEng;
        } else if(lang == RUS){
            return learningRus;
        } else {
            return null;
        }
    }

    public String getIntensity(String lang){
        if(lang == ENG){
            return intensityEng;
        } else if(lang == RUS){
            return intensityRus;
        } else {
            return null;
        }
    }

}
