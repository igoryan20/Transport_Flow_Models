package sample;

public class StringResourse {

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
        if(lang == ENG){
            return greenbergModelsEng;
        } else if(lang == RUS){
            return greenbergModelsRus;
        } else {
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

}
