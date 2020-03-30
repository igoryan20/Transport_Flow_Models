package sample;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

public class TheoryText {

    final private String greenbergModelText = "Транспортный поток можно рассматривать как поток одномерной\n" +
            "сжимаемой жидкости, допуская, что поток сохраняется и существует вза" +
            "имнооднозначная \n зависимость между скоростью и плотностью транспорт" +
            "ного \n потока. Первое допущение выражается уравнением неразрывности," +
            "\n второе – функциональной зависимостью между скоростью и плотностью" +
            "\n для учета уменьшения скорости движения автомобилей с ростом плотно" +
            "сти потока.\n" +
            "Плотность автомобилей \uF072(x, t), x \uF0CE R в момент времени t \uF0B3 0. Число ав" +
            "томобилей в интервале (x1, x2) в момент времени t равно:";

    TeXFormula formula = new TeXFormula();
    TeXIcon teXIcon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 20);



    public String getGreenbergModelText() {


        return greenbergModelText;
    }
}
